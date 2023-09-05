package com.project.mutualDivorce.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
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

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
               return roles.stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList());
        }

        @Override
        public String getUsername() {
                return this.getSurname();
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }
}

