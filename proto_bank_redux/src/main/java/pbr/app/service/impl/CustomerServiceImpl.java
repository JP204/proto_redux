package pbr.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import pbr.app.model.Customer;
import pbr.app.model.User;
import pbr.app.repositories.CustomerRepository;
import pbr.app.services.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository custRepo;
	@Autowired
	Customer cust;

	@Override
	public Customer getCustomerById(int id) {
		return custRepo.findById(id).get();
	}

	@Override
	public Customer registerCustomer(User user) {
		// TODO Auto-generated method stub
		cust.setId(user.getId());
		cust.setName(user.getName());
		cust.setPassword(user.getPassword());
		return custRepo.save(cust);
	}

	@Override
	public Customer login(User user) {
		// TODO Auto-generated method stub
		cust = custRepo.findById(user.getId()).get();
		if(user.getPassword() != cust.getPassword()) {
			cust = null;
			return cust;
		} else {
			return cust;
		}
	}

}
