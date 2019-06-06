package com.paypal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.paypal.model.Client;
import com.paypal.model.Measure;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	 @Query(value = "SELECT * FROM dq_client", nativeQuery = true)
	 List<Client> clientfindAll();

	
}
