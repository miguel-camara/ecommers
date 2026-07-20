package com.migueldev.ecommers.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
// import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
// @RequiredArgsConstructor
@AllArgsConstructor
public class DemoController {

  @GetMapping("/demo")
  public String welcome() {
    try {
      return "Welcome from secure endpoint";

    } catch (Exception e) {
      return "Ocurrio un error";
    }
  }
}
