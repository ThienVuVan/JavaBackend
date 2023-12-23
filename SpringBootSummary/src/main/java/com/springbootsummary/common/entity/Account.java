package com.springbootsummary.common.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

@Entity(name = "user")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "username")
    @NotNull
    @Length(max = 255, min = 4)
    String username;

    @Column(name = "age")
    @NotNull
    @Positive
    int age;

    public Account() {
    }

    public Account(@NotNull String username, @NotNull int age) {
        this.username = username;
        this.age = age;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role", referencedColumnName = "id")
    Role role;
}
