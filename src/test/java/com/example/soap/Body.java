package com.example.soap;

import jakarta.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "itinerary", namespace = "http://travelcompany.example.org/reservation/travel")
public class Body {

  @XmlElement(name = "itinerary")
  Itinerary itinerary;
}
