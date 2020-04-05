package pbr.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pbr.app.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
	
	public List<Account> findByCid(int cid);

}
