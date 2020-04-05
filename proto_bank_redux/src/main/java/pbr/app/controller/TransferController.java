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

import pbr.app.model.Transfer;
import pbr.app.services.TransferService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TransferController {
	
	@Autowired
	private TransferService ts;
	
	@PostMapping("/transfers/MakeTransfer")
	public Transfer makeTransfer(@RequestBody Transfer transfer) {
		return ts.createTransfer(transfer);
	}
	
	@PutMapping("/transfers/DecideTransfer")
	public Transfer decideTransfer(@RequestBody Transfer transfer) {
		return ts.updateTransfer(transfer);
	}
	
	@GetMapping("/transfers/{id}")
	public Transfer getTransferById(@PathVariable("id")int id) {
		return ts.getTransferById(id);
	}
	
	@GetMapping("/transfers/getAll")
	public List<Transfer> getAllTransfers(){
		return ts.getAllTransfers();
	}
	
	@GetMapping("/transfers/getIncomingTransfers/{rid}")
	public List<Transfer> getIncomingTransfers(@PathVariable("rid")int rid){
		return ts.findByRid(rid);
	}

}
