package pbr.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pbr.app.model.Account;
import pbr.app.repositories.AccountRepository;
import pbr.app.services.AccountService;

public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository ar;

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

	@Override
	public Account getAccountById(int id) {
		// TODO Auto-generated method stub
		return ar.findById(id).get();
	}

	@Override
	public Account registerAccount(Account account) {
		// TODO Auto-generated method stub
		account.setStatus("pending");
		return ar.save(account);
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		return ar.save(account);
	}

	@Override
	public Account getAccountByCid(Account account) {
		// TODO Auto-generated method stub
		return ar.getOne(account.getCid());
	}

	@Override
	public Account withdraw(int amount, Account account) {
		// TODO Auto-generated method stub
		if((account.getBalance() - amount) < 0) {
			return account;
		} else {
			account.setBalance(account.getBalance() - amount);
			return ar.save(account);
		}
	}

	@Override
	public Account deposit(int amount, Account account) {
		// TODO Auto-generated method stub
		account.setBalance(account.getBalance() + amount);
		return ar.save(account);
	}

	@Override
	public List<Account> findByCid(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

}
