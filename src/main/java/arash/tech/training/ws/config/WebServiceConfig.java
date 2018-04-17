package arash.tech.training.ws.config;


import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;

import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import arash.tech.training.ws.client.EmployeeWSClient;


@Configuration
public class WebServiceConfig {
	@Autowired
	private Bus bus;
	
	@Bean
	public Endpoint endpoint()  {
		Endpoint endpoint = new EndpointImpl(bus, new EmployeeWSClient());

		endpoint.publish("/EmployeeService");
		return endpoint;
		
	}
}

