package pbr.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pbr.app.model.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Integer>{
	
	public List<Transfer> findByRid(int rid);

}
