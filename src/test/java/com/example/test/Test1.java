package com.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriComponentsBuilder;

public class Test1 {


  @Test
  public void test1(){
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://base.com/scanstatus?id=1&name=joe");
    System.err.println(builder.encode().toUriString());

  }
}
