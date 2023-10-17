package com.jpapractice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "userdetails")
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userDetail")
    private User user;

    public UserDetail(String email, String address) {
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
