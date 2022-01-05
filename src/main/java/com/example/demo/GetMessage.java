package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetMessage {

	
@RequestMapping("service")
	@ResponseBody
	public String welcome(@RequestParam(name = "fname") String fname , @RequestParam(name = "lname") String lname ) {
		
		/*return "welcome to IBM india india";*/
	     
	if (fname==null) {
		fname="";
	}if (lname==null) {
		lname="";
	}
	
		return "Welcome to " +fname+" "+lname ;
	}


}
