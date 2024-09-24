package com.example.soap;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "itinerary", namespace = "http://travelcompany.example.org/reservation/travel")
public class Itinerary {

  @XmlElement(name = "departure")
  private Departure departure;

  @XmlElement(name = "return")
  private Return returnTrip;

  // Getters and setters for departure and returnTrip
}