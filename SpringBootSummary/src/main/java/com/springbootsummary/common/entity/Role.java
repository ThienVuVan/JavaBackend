package com.springbootsummary.common.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Set;

@Entity(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "name")
    @NotNull
    String name;

    public Role(int id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    Set<Account> users;
}
