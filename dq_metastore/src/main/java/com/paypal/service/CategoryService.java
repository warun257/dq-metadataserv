package com.paypal.service;

import java.util.List;
import com.paypal.model.RuleCategory;


public interface CategoryService {

    public List<RuleCategory> getCategoryDetails();

    public RuleCategory getCategoryDetailById(Long id);

    public RuleCategory postCategory(RuleCategory ruleCategory) ;

	

}
