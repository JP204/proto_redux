package pbr.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pbr.app.model.Account;
import pbr.app.model.Transfer;
import pbr.app.repositories.TransferRepository;
import pbr.app.services.AccountService;
import pbr.app.services.TransferService;

public class TransferServiceImpl implements TransferService {
	@Autowired
	private TransferRepository tr;
	@Autowired
	private AccountService as;
	
	private Account account;
	private Transfer tran;

	@Override
	public List<Transfer> getAllTransfers() {
		// TODO Auto-generated method stub
		return tr.findAll();
	}

	@Override
	public Transfer getTransferById(int id) {
		// TODO Auto-generated method stub
		return tr.findById(id).get();
	}

	@Override
	public Transfer updateTransfer(Transfer transfer) {
		// TODO Auto-generated method stub
		if(transfer.getStatus() =="accepted") {
			account = as.getAccountById(tran.getRid());
			account.setBalance(account.getBalance() + tran.getAmount());
			tran.setStatus("accepted");
			as.updateAccount(account);
			return tr.save(tran);
		} else {
			account = as.getAccountById(tran.getSid());
			account.setBalance(account.getBalance() + tran.getAmount());
			tran.setStatus("denied");
			as.updateAccount(account);
			return tr.save(tran);
		}
		
	}

	@Override
	public Transfer createTransfer(Transfer transfer) {
		// TODO Auto-generated method stub
		account = as.getAccountById(transfer.getSid());
		if((account.getBalance() - transfer.getAmount()) < 0) {
			transfer.setStatus("rejected");
			return transfer;
		} else {
			transfer.setStatus("pending");
			account.setBalance(account.getBalance() - transfer.getAmount());
			as.updateAccount(account);
			return tr.save(transfer);
		}
	}

	@Override
	public List<Transfer> findByRid(int rid) {
		// TODO Auto-generated method stub
		return tr.findByRid(rid);
	}

}
