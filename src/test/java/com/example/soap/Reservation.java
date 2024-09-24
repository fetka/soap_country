package com.example.soap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "reservation", namespace = "http://travelcompany.example.org/reservation")
@XmlType(propOrder = {"reference", "dateAndTime"})
public class Reservation {

  @XmlElement(name = "reference")
  private String reference;

  @XmlElement(name = "dateAndTime")
  private String dateAndTime;

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public String getDateAndTime() {
    return dateAndTime;
  }

  public void setDateAndTime(String dateAndTime) {
    this.dateAndTime = dateAndTime;

  }
}