package com.migueldev.ecommers.auth;

import java.util.List;

import com.migueldev.ecommers.user.UserProduct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
// import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
  String token;
  boolean isAdmin;
  List<UserProduct> listProducts;
}
