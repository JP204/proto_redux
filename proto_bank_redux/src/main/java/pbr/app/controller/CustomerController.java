package pbr.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pbr.app.model.Customer;
import pbr.app.model.User;
import pbr.app.services.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	
	@PostMapping("/login")
	public Customer login(@RequestBody User user) {
		return cs.login(user);
	}
	
	@PostMapping("/register")
	public Customer regsiter(@RequestBody User user) {
		return cs.registerCustomer(user);
	}

}
