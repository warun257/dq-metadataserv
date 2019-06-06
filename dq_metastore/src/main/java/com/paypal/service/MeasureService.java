package com.paypal.service;

import com.paypal.model.Measure;
import java.util.List;

public interface MeasureService {

    public List<Measure> getMeasureDetails();

    public Measure getMeasureDetailById(Long id);
    
    public Measure postMeasure(Measure measure) ;

	

}
