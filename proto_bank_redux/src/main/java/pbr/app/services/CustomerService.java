package pbr.app.services;

import pbr.app.model.Customer;
import pbr.app.model.User;

public interface CustomerService {
	
	public Customer getCustomerById(int id);
	public Customer registerCustomer(User user);
	public Customer login(User user);
	
}
