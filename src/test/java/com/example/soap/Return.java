package com.example.soap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"departing", "arriving", "departureDate", "departureTime", "seatPreference"})
public class Return {

  @XmlElement(name = "departing")
  private String departing;

  @XmlElement(name = "arriving")
  private String arriving;

  @XmlElement(name = "departureDate")
  private String departureDate;

  @XmlElement(name = "departureTime")
  private String departureTime;

  @XmlElement(name = "seatPreference")
  private String seatPreference;

  public String getDeparting() {
    return departing;
  }

  public void setDeparting(String departing) {
    this.departing = departing;

  }

  public String getArriving() {
    return arriving;
  }

  public void setArriving(String arriving) {
    this.arriving = arriving;
  }

  public String getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }
}