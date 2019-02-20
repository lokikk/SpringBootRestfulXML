/* 
 * Author ::. Sivateja Kandula | www.java4s.com 
 *
 */

package com.java4s.app.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.java4s.model.Customer;

@RestController
public class SpringJava4sController {

	@GetMapping(path="/get-cust-info")
	public Customer customerInformation() 
	{
		Customer cust = new Customer();
		
		cust.setCustNo(100);
		cust.setName("Bank of America");
		cust.setCountry("United States");
		
		return cust;
	}
	
	
//	@RequestMapping("/handle")
	@GetMapping(path="/get-cust-info2")
	public ResponseEntity<String> handle() throws URISyntaxException {
	    URI location = new URI("/test/");
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.setLocation(location);
	    responseHeaders.set("Connection", "close");
	    return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
	}
	
	@PostMapping(path="/perform_adrsRegSmry_CEB", consumes = "text/xml", produces = "text/xml")
//	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<String> addMember(@RequestHeader(value="Connection") String header, @RequestBody String xml) throws URISyntaxException {
		System.out.println("Request Header, Connection:" + header);
		System.out.println("Request: " + xml);
//	    URI location = new URI("/test/");
	    HttpHeaders responseHeaders = new HttpHeaders();
//	    responseHeaders.setLocation(location);
	    responseHeaders.set("Connection", "close");
//	    responseHeaders.set("Status", "OK");
	    
	    String responseXML = "<FpsMsg><FpsAdrsRegSmry><Extn><Interface><trancode>1044</trancode></Interface><RespSta>Success</RespSta><RespDtls><Cd>N000000</Cd><Msg>Success</Msg></RespDtls></Extn></FpsAdrsRegSmry></FpsMsg>";
	    System.out.println("Response:" + responseXML);
	    return new ResponseEntity<String>(responseXML, responseHeaders, HttpStatus.OK);
	}
	
	
}

// URL: http://localhost:8080/springbootrestxml/get-cust-info
// URL: http://localhost:8080/springbootrestxml/get-cust-info.json