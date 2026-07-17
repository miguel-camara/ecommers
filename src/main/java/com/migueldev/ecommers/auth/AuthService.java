package com.migueldev.ecommers.auth;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.migueldev.ecommers.jwt.JwtService;
import com.migueldev.ecommers.user.Role;
import com.migueldev.ecommers.user.User;
import com.migueldev.ecommers.user.UserRepository;

import lombok.AllArgsConstructor;
// import lombok.RequiredArgsConstructor;

@Service
// @RequiredArgsConstructor
@AllArgsConstructor
public class AuthService {

  private final UserRepository userRepository;
  private final JwtService jwtService;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  public AuthResponse login(LoginRequest request) {
    authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    Optional<User> user = userRepository.findByUsername(request.getUsername());
    UserDetails userDetails = user.get();
    String token = jwtService.getToken(userDetails);
    if (user.get().getRole() == Role.ADMIN) {
      user.get().setAdmin(true);
    } else {
      user.get().setAdmin(false);
    }

    return AuthResponse.builder()
        .token(token)
        .isAdmin(user.get().isAdmin())
        .build();

  }

  public AuthResponse register(RegisterRequest request) {
    User user = User.builder()
        .username(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .firstname(request.getFirstname())
        .lastname(request.lastname)
        .country(request.getCountry())
        .role(Role.USER)
        .build();

    userRepository.save(user);

    return AuthResponse.builder()
        .token(jwtService.getToken(user))
        .build();

  }

}
