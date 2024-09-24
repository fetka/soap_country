package com.example.soap;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Header", propOrder = {
    "reservation",
    "passenger"
})
public class Header {

  @XmlElement(namespace = "http://travelcompany.example.org/reservation")
  private Reservation reservation;

  @XmlElement(namespace = "http://mycompany.example.com/employees")
  private Passenger passenger;

  public Reservation getReservation() {
    return reservation;
  }

  public void setReservation(Reservation reservation) {
    this.reservation = reservation;
  }

  public Passenger getPassenger() {
    return passenger;
  }

  public void setPassenger(Passenger passenger) {
    this.passenger = passenger;
  }
}