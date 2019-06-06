package com.paypal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.paypal.model.Client;
import com.paypal.model.RuleCategory;
import com.paypal.repository.ClientRepository;
import com.paypal.repository.RuleCategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
	RuleCategoryRepository ruleCategoryRepository ;

    @Override
    public List<RuleCategory> getCategoryDetails()  {
        try {
        	
        	//List<Measure> measure = measureRepository.findAll();
        	List<RuleCategory> ruleCategories = ruleCategoryRepository.ruleCategoryfindAll();
            return ruleCategories;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }
       
    }

	@Override
	public RuleCategory getCategoryDetailById(Long id) {
		try {

			//List<Measure> measure = measureRepository.findAll();
			RuleCategory ruleCategory = ruleCategoryRepository.findById(id).get();
			return ruleCategory;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found by Id:"+id);
		}
	}

	@Override
	public RuleCategory postCategory(RuleCategory ruleCategory) {
		try {
			  ruleCategoryRepository.save(ruleCategory);
			 } catch (DataIntegrityViolationException e) {
			  
			  throw new ResponseStatusException(HttpStatus.BAD_REQUEST); 
			  } catch ( Exception e)  { 
				  throw new ResponseStatusException(HttpStatus.BAD_REQUEST); 
			}
			return	  ruleCategory;
			}
	}

	
	  
	 





