package com.example.wsdl;

import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.transport.http.HttpServletConnection;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class RequestInfoInterceptor implements EndpointInterceptor {

  @Override
  public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
//    if (messageContext.getConnection() instanceof HttpServletConnection) {
//      HttpServletRequest httpServletRequest = ((HttpServletConnection) messageContext.getConnection()).getHttpServletRequest();
//      System.err.println("Request URI from Interceptor: " + httpServletRequest.getRequestURI());
//      // Add other request information as needed
//    }
    System.err.println("handleRequest: " + messageContext.getRequest().toString());
    String[] props = messageContext.getPropertyNames();
    System.err.println("length: " + props.length);
    if (props.length == 0) {
      return true;
    }
    for (int i = 0; i <= props.length; i++) {

      System.err.println("props: " + i + ": " + props[i].toString());
    }
    return true; // Continue processing the request
  }

  // Implement other methods if needed (handleResponse, handleFault, afterCompletion)
  @Override
  public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
    System.err.println("handleResponse: " + messageContext.getRequest().toString());
    return true;
  }

  @Override
  public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
    return true;
  }

  @Override
  public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex)
      throws Exception {

  }
}