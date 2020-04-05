package pbr.app.services;

import java.util.List;

import pbr.app.model.Account;

public interface AccountService {
	
	public List<Account> getAllAccounts();
	public Account getAccountById(int id);
	public Account registerAccount(Account account);
	public Account updateAccount(Account account);
	public Account getAccountByCid(Account account);
	public Account withdraw(int amount, Account account);
	public Account deposit(int amount, Account account);
	public List<Account> findByCid(int cid);

}
