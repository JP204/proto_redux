package pbr.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pbr.app.model.Account;
import pbr.app.services.AccountService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
	
	@Autowired
	private AccountService as;
	
	
	@PostMapping("/accounts/RegisterAccount")
	public Account registerAccount(@RequestBody Account account) {
		return as.registerAccount(account);
	}
	
	@PutMapping("/accounts/withdraw/{amount}")
	public Account withdraw(@RequestBody Account account, @PathVariable("amount") int amount) {
		return as.withdraw(amount, account);
	}
	
	@PutMapping("/accounts/deposit/{amount}")
	public Account deposit(@RequestBody Account account, @PathVariable("amount") int amount ) {
		return as.deposit(amount, account);
	}
	
	@GetMapping("/accounts/getAllAccounts")
	public List<Account> getAll(){
		return as.getAllAccounts();
	}
	
	@GetMapping("accounts/{id}")
	public Account account(@PathVariable("id")int id) {
		return as.getAccountById(id);
	}
	
	@GetMapping("/accounts/getAccounts/{cid}")
	public List<Account> getCustomersAccounts(@PathVariable("cid")int cid){
		return as.findByCid(cid);
	}

}
