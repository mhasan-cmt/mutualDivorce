package com.project.mutualDivorce.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(nullable = false,unique = true)
        private String surname;

        @Column(nullable = false)
        private String username;

        @Column(nullable = false)
        private String afm;

        @Column(nullable = false)
        private String amka;

        @Column(nullable = false)
        private String password;

        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(
                name = "user_roles",
                joinColumns = {@JoinColumn(name = "USER_ID",referencedColumnName = "ID")},
                inverseJoinColumns = {@JoinColumn(name = "ROLE_ID",referencedColumnName = "ID")})
        private List<Role> roles = new ArrayList<>();

}

