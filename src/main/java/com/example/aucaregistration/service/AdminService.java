package com.example.aucaregistration.service;

import com.example.aucaregistration.domain.Admin;
import com.example.aucaregistration.domain.Client;
import com.example.aucaregistration.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin saveAdmin(Admin admin) throws Exception {
        if (admin != null) {
            return adminRepository.save(admin);
        } else {
            throw new Exception("Unable to save Admin");
        }
    }

    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    public void deleteAdminById(int adminId) throws Exception {
        if (adminRepository.findById(adminId).isPresent()) {
            adminRepository.deleteById(adminId);
        } else {
            throw new Exception("Admin not found");
        }
    }

    public Admin updateAdminById(Admin admin) throws Exception {
        if (adminRepository.findById(admin.getId()).isPresent()) {
            return adminRepository.save(admin);
        } else {
            throw new Exception("Admin with the provided ID was not found.");
        }
    }

    public Admin getAdminByUsername(String username) throws Exception {
        Optional<Admin> optionalAdmin = adminRepository.findByUsername(username);

        if (optionalAdmin.isPresent()) {
            return optionalAdmin.get();
        } else {
            throw new Exception("Client with the provided username was not found.");
        }
    }
}