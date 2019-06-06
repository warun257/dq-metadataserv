package com.paypal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.paypal.model.Client;
import com.paypal.model.RuleCategory;


@Repository
public interface RuleCategoryRepository extends JpaRepository<RuleCategory, Long> {

	 @Query(value = "SELECT * FROM dq_rule_category", nativeQuery = true)
	 List<RuleCategory> ruleCategoryfindAll();

	
}
