package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.service.CalcService;

@RestController
@RequestMapping("/calculator")
public class CalcController {
  @Autowired
  private CalcService service;
  
  //ADDiion -RequestRequestParam
  //URL-localhost/calculator/add/?a=5&b=6
  
  @RequestMapping("/add")
  
  public int add (@RequestParam int a, @RequestParam int b) {
    return service.add(a,b);
  }
  
  @RequestMapping("/sub/{a}/{b}")
  
  public int sub(@PathVariable int a,@PathVariable int b) {
    return service.sub(a,b);
  }
  
  @RequestMapping("/mul/{a}/{b}")
  public int mul(@PathVariable int a,@PathVariable int b) {
    return service.mul(a, b);
  }
  
  
  @RequestMapping("/mod/{a}/{b}")
  
  public int mod(@PathVariable int a,@PathVariable int b) {
    return service.mod(a, b);
  }
  
  @RequestMapping("/div")
  
  public double div(@RequestParam int a, @RequestParam int b) {
    return service.div(a, b);
  }
  
  

}