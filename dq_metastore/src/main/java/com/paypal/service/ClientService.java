package com.paypal.service;

import java.util.List;
import com.paypal.model.Client;
import com.paypal.model.Measure;


public interface ClientService {

    public List<Client> getClientDetails();

    public Client getClientDetailById(Long id);

    public Client postClient(Client client) ;

	

}
