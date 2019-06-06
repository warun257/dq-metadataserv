package com.paypal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.paypal.model.Client;
import com.paypal.model.Measure;
import com.paypal.repository.ClientRepository;
import com.paypal.repository.MeasureRepository;


@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
	ClientRepository clientRepository ;

    @Override
    public List<Client> getMeasureDetails()  {
        try {
        	
        	//List<Measure> measure = measureRepository.findAll();
        	List<Client> clients = clientRepository.clientfindAll();
            return clients;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }
       
    }

	@Override
	public Client getClientDetailById(Long id) {
		try {

			//List<Measure> measure = measureRepository.findAll();
			Client client = clientRepository.findById(id).get();
			return client;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found by Id:"+id);
		}
	}

	@Override
	public Client postClient(Client client) {
		try {
			  clientRepository.save(client);
			 } catch (DataIntegrityViolationException e) {
			  
			  throw new ResponseStatusException(HttpStatus.BAD_REQUEST); 
			  } catch ( Exception e)  { 
				  throw new ResponseStatusException(HttpStatus.BAD_REQUEST); 
			}
			return	  client;
			}
	}

	
	  
	 





