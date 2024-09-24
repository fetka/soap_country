package com.example.soap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "passenger", namespace = "http://mycompany.example.com/employees")
@XmlType(propOrder = {"name"})
public class Passenger {

  @XmlElement(name = "name")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;

  }
}