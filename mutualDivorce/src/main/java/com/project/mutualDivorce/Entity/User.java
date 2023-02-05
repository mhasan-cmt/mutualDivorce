package com.project.mutualDivorce.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surname")
    private String surname;
    @Column(name = "afm")
    private int afm;
    @Column(name = "amka")
    private int amka;

    @Column(name = "role")
    private String role;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Divorce> divorces;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAfm() {
        return afm;
    }

    public void setAfm(int afm) {
        this.afm = afm;
    }

    public int getAmka() {
        return amka;
    }

    public void setAmka(int amka) {
        this.amka = amka;
    }

    public String getRole() {
       return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Divorce> getDivorces() {
        return divorces;
    }

    public void setDivorces(List<Divorce> divorces) {
        this.divorces = divorces;
    }
}
