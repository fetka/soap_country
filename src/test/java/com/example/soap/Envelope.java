package com.example.soap;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Envelope", namespace = "http://www.w3.org/2003/05/soap-envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope {

  private static final long serialVersionUID = 1L;
  @XmlElement(name = "Header")
  private Header header;

  @XmlElement(name = "Body")
  private Body body;

  public Header getHeader() {
    return header;
  }

  public void setHeader(Header header) {
    this.header = header;
  }

  public Body getBody() {
    return body;
  }

  public void setBody(Body body) {
    this.body = body;
  }
}