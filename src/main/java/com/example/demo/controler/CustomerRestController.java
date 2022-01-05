package com.example.demo.controler;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.IndexField;
import com.cloudant.client.api.model.IndexField.SortOrder;
import com.cloudant.client.api.model.Response;
import com.example.demo.bean.Customerid;


@RestController

public class CustomerRestController {
	@Autowired
	private CloudantClient client;
	private Database db;
    // Create a new customer
	@PostMapping("save")
   // @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String saveReview(@RequestBody Customer cust) {
    	db = client.database("customer", false);
        System.out.println("Save Customer " + cust);
        Response r = null;
        if (cust != null) {
            r = db.post(cust);
        }
        return r.getId();
    }
	/*
	 * @RequestMapping(method = RequestMethod.GET, value="/{id}")
	 * public @ResponseBody Greeting getGreeting(@PathVariable String id) throws
	 * IOException { Greeting greeting = db.find(Greeting.class, id); return
	 * greeting; }
	 */
    
    // Query reviews for all documents or by customerId
	
	
	@GetMapping("all")
	public @ResponseBody List<Customer> getAll() throws IOException {
		db = client.database("customer", false);
		List<Customer> allDocs = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(Customer.class);
		return allDocs;
	}
	
	
 
	@GetMapping("getbyid/{customerId}")
    public @ResponseBody Customerid getByID(@PathVariable String customerId) {
    	
    	Customerid customer=null;
    	System.out.println("customerId=========>"+customerId);
    	db = client.database("customer", false);
    try {
        customer=db.find(Customerid.class, ""+customerId+"");
        
    }catch(Exception err) {
    	err.printStackTrace();
    	
    }
        
        System.out.println("customer========>" +customer);
    
        return customer;
    }
}
