package com.example.aucaregistration.service;

import com.example.aucaregistration.domain.Client;
import com.example.aucaregistration.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Client getClient(int clientId) throws  Exception {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            return optionalClient.get();
        } else {
            throw new Exception("User not found");
        }
    }

    public void deleteClientById(int clientId) throws Exception {
        if (clientRepository.findById(clientId).isPresent()) {
            clientRepository.deleteById(clientId);
        } else {
            throw new Exception("Client not found");
        }
    }

    public Client updateClientById(Client client) throws Exception {
        if (clientRepository.findById(client.getId()).isPresent()) {
            return clientRepository.save(client);
        } else {
            throw new Exception("Client with the provided ID was not found.");
        }
    }

    public Client getClientByUsername(String username) throws Exception {
        Optional<Client> optionalClient = clientRepository.findByUsername(username);

        if (optionalClient.isPresent()) {
            return optionalClient.get();
        } else {
            throw new Exception("Client with the provided username was not found.");
        }
    }
}