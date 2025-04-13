package com.example.wsdl;


import com.baeldung.springsoap.gen.GetCountryRequest;
import com.baeldung.springsoap.gen.GetCountryResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

@Endpoint
public class CountryEndpoint {

  private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

  private CountryRepository countryRepository;
  @Autowired
  ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet;

  @Autowired
  public CountryEndpoint(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
  @ResponsePayload
  public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request,
      MessageContext messageContext) {
    GetCountryResponse response = new GetCountryResponse();
    response.setCountry(countryRepository.findCountry(request.getName()));

    messageDispatcherServlet.getUrlMappings().stream().forEach(string -> {

      System.err.println("Request name: " + string);
    });
    System.err.println("#1");
    System.err.println(messageDispatcherServlet.getServlet().getServletContext().getContextPath());
    System.err.println("#2");
    System.err.println("GetCountryResponse getCountry(@RequestPayload GetCountryRequest request)");

    TransportContext context = TransportContextHolder.getTransportContext();
    if (context != null) {
      HttpServletConnection connection = (HttpServletConnection) context.getConnection();
      if (connection != null) {
        HttpServletRequest httpServletRequest = connection.getHttpServletRequest();
        if (httpServletRequest != null) {
          String requestURL = httpServletRequest.getRequestURL().toString();
          System.err.println("Request URL: " + requestURL);
          String pathInfo = httpServletRequest.getPathInfo();
          System.err.println("pathInfo: " + pathInfo);
          String contextPath = httpServletRequest.getContextPath();
          System.err.println("getContextPath: " + contextPath);
          String servletPath = httpServletRequest.getServletPath();
          System.err.println("servletPath: " + servletPath);
          // Get query parameters
          Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
          while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String[] paramValues = httpServletRequest.getParameterValues(paramName);
            System.err.println(
                "Query Parameter: " + paramName + " = " + String.join(", ", paramValues));
          }

          if (httpServletRequest != null) {
            Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
              String paramName = entry.getKey();
              String[] paramValues = entry.getValue();
              System.err.println(
                  "Parameter: " + paramName + " = " + String.join(", ", paramValues));
            }
          }
          String[] names = httpServletRequest.getParameterValues("name");
          System.err.println(names[0]);
        }
      }
    }
    return response;
  }
}
