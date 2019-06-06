package com.paypal.service;

import com.paypal.model.Measure;
import com.paypal.repository.MeasureRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class MeasureServiceImpl implements MeasureService {


    @Autowired
    MeasureRepository  measureRepository;

    @Override
    public List<Measure> getMeasureDetails()  {
        try {
        	
        	//List<Measure> measure = measureRepository.findAll();
        	List<Measure> measure = measureRepository.measurefindAll();
            return measure;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }
       
    }

	@Override
	public Measure getMeasureDetailById(Long id) {
		try {

			//List<Measure> measure = measureRepository.findAll();
			Measure measure = measureRepository.findById(id).get();
			return measure;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found by Id:"+id);
		}
	}

	@Override
	public Measure postMeasure(Measure measure) {
		try {
			  measureRepository.save(measure); 
			 } catch (DataIntegrityViolationException e) {
			  
			  throw new ResponseStatusException(HttpStatus.BAD_REQUEST); 
			  } catch ( Exception e)  { 
				  throw new ResponseStatusException(HttpStatus.BAD_REQUEST); 
			}
			return	  measure;
			}
	}

	
	  
	 





