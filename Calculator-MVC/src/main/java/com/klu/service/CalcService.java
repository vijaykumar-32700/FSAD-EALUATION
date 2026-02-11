package com.klu.service;

import org.springframework.stereotype.Service;

@Service
public class CalcService {
  
  public int add(int a,int b) {
    return a+b;
  }
  
  public int sub(int a, int b) {
    return a-b;
  }
  
  public int mul(int a, int b) {
    return a*b;
  }
  
  public double div (int a, int b) {
    if(b==0)
      throw new ArithmeticException("Denominator is Zero");
    return (double) a/b;
  }
  
  public int  mod(int a, int b) {
    return a%b;
  }

}