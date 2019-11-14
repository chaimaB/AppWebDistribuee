package com.esprit.client.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "client")
public class ClientRestApi {

    @RequestMapping("/hello")
    public String sayHello() {
        return "Salem patron";
    }

    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Client> getAllQuiz(){
        return clientService.getAllClient();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/find/{id}")
    public Client getClientById(@PathVariable int id){
        return clientService.getClientById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteQuiz(@PathVariable int id){
        clientService.deleteClient(id);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public Client updateClient(@PathVariable int id, @RequestBody Client c ){
        return clientService.updateClient(id, c);
    }
}
