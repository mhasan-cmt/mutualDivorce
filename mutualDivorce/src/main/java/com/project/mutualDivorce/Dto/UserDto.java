package com.project.mutualDivorce.Dto;

import com.project.mutualDivorce.Entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link User} entity
 */
public class UserDto implements Serializable {
    private final Long id;
    private final String surname;
    private final int afm;
    private final int amka;
    private final int role;
    private final List<DivorceFormDto> divorces;

    public UserDto(Long id, String surname, int afm, int amka, int role, List<DivorceFormDto> divorces) {
        this.id = id;
        this.surname = surname;
        this.afm = afm;
        this.amka = amka;
        this.role = role;
        this.divorces = divorces;
    }

    public Long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public int getAfm() {
        return afm;
    }

    public int getAmka() {
        return amka;
    }

    public int getRole() {
        return role;
    }

    public List<DivorceFormDto> getDivorces() {
        return divorces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.surname, entity.surname) &&
                Objects.equals(this.afm, entity.afm) &&
                Objects.equals(this.amka, entity.amka) &&
                Objects.equals(this.role, entity.role) &&
                Objects.equals(this.divorces, entity.divorces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, afm, amka, role, divorces);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "surname = " + surname + ", " +
                "afm = " + afm + ", " +
                "amka = " + amka + ", " +
                "role = " + role + ", " +
                "divorces = " + divorces + ")";
    }
}