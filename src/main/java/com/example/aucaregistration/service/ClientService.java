package com.example.aucaregistration.service;

import com.example.aucaregistration.domain.Client;
import com.example.aucaregistration.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client saveClient(Client client) throws Exception {
        if (client != null) {
            return clientRepository.save(client);
        } else {
            throw new Exception("Unable to save Client");
        }
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public void deleteClientById(Long clientId) throws Exception {
        if (clientRepository.findById(clientId).isPresent()) {
            clientRepository.deleteById(clientId);
        } else {
            throw new Exception("Client not found");
        }
    }
}