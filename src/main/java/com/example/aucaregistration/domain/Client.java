package com.example.aucaregistration.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String firstName;

    private String lastName;

    private LocalDate dob;

    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String password;

    @CreationTimestamp
    @Column(name = "joined_date", updatable = false)
    private LocalDateTime joinedDate = LocalDateTime.now();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Client(String username, String firstName, String lastName, LocalDate dob, String phoneNumber, String email, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    //    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<TicketOrder> tickets;



}
