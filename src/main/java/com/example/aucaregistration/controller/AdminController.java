package com.example.aucaregistration.controller;

import com.example.aucaregistration.domain.Admin;
import com.example.aucaregistration.service.AdminService;
import com.example.aucaregistration.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(
        value = "/admin",
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> saveStudent(@RequestBody Admin client) {
        if (client != null) {
            try {

                String passwordToHash = client.getPassword();
                String hashedPassword = encrypt(passwordToHash);
                client.setPassword(hashedPassword);

                Admin saveAdmin = adminService.saveAdmin(client);
                return new ResponseEntity<>(saveAdmin, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Empty data not allowed!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> clients = adminService.getAdmins();
        return ResponseEntity.ok(clients);
    }

    @DeleteMapping(value = "/{clientId}")
    public ResponseEntity<?> deleteAdmin(@PathVariable int clientId) {
        try {
            adminService.deleteAdminById(clientId);
            return new ResponseEntity<>("Admin Deleted", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(value = "/{clientId}")
    public ResponseEntity<?> updateAdmin(@PathVariable int clientId, @RequestBody Admin client) {
        try {
            client.setId(clientId);
            Admin updatedAdmin = adminService.updateAdminById(client);
            return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody com.example.aucaregistration.controller.AdminController.LoginForm loginForm) {
        try {
            String username = loginForm.getUsername();
            String password = loginForm.getPassword();

            if (username.isEmpty() || password.isEmpty()) {
                return null;
            }

            String hashedPassword = encrypt(password);

            Admin existingAdmin = adminService.getAdminByUsername(username);

            if (hashedPassword.equals(existingAdmin.getPassword())) {
                return new ResponseEntity<>(existingAdmin, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Password does not match", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    public static class LoginForm {
        private String username;
        private String password;

        // Getters and setters

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    private static final String secretKey = "8dGaqPlIvBlTJlPZzZq6wg==";

    public static String encrypt(String password) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);

        byte[] encrypted = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String encryptedPassword) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);

        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
        return new String(decrypted);
    }
}