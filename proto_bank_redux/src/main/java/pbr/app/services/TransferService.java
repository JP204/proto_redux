package pbr.app.services;

import java.util.List;

import pbr.app.model.Transfer;

public interface TransferService {
	
	public List<Transfer> getAllTransfers();
	public Transfer getTransferById(int id);
	public Transfer updateTransfer(Transfer transfer);
	public Transfer createTransfer(Transfer transfer);
	public List<Transfer> findByRid(int rid);

}
