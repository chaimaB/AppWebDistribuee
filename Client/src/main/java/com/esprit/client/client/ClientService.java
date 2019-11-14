package com.esprit.client.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(int id, Client client){
        Client c = clientRepository.findById(id).orElse(null);
        c.setAdress(client.getAdress());
        c.setType(client.getType());
        clientRepository.save(c);
        return c;
    }

    public void deleteClient(int id){
        clientRepository.deleteById(id);
    }

    public List<Client> getAllClient(){
        return clientRepository.findAll();

    }

    public Client getClientById(int id){
        return clientRepository.findById(id).orElse(null);
    }

}
