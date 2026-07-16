package com.migueldev.ecommers.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
// import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
// @RequiredArgsConstructor
@AllArgsConstructor
public class DemoController {

  @PostMapping(value = "demo")
  public String welcome() {
    return "Welcome from secure endpoint";
  }
}
