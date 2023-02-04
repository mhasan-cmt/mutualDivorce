package com.project.mutualDivorce.Dto;

import com.project.mutualDivorce.Entity.Divorce;
import com.project.mutualDivorce.Entity.User;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Divorce} entity
 */
public class DivorceFormDto implements Serializable {
    private final Long id;
    private final String husbandAfm;
    private final String husbandAmka;
    private final String husbandSurname;
    private final String wifeAmka;
    private final String wifeAfm;
    private final String wifeSurname;
    private final String epimeleiaPaidiwn;
    private final String akinitiPeriousia;
    private final String logariasmoiTrapezwn;
    private final String ix;
    private final String reason;
    private final User user;

    public DivorceFormDto(Long id, String husbandAfm, String husbandAmka, String husbandSurname, String wifeAmka, String wifeAfm, String wifeSurname, String epimeleiaPaidiwn, String akinitiPeriousia, String logariasmoiTrapezwn, String ix, String reason, User user) {
        this.id = id;
        this.husbandAfm = husbandAfm;
        this.husbandAmka = husbandAmka;
        this.husbandSurname = husbandSurname;
        this.wifeAmka = wifeAmka;
        this.wifeAfm = wifeAfm;
        this.wifeSurname = wifeSurname;
        this.epimeleiaPaidiwn = epimeleiaPaidiwn;
        this.akinitiPeriousia = akinitiPeriousia;
        this.logariasmoiTrapezwn = logariasmoiTrapezwn;
        this.ix = ix;
        this.reason = reason;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getHusbandAfm() {
        return husbandAfm;
    }

    public String getHusbandAmka() {
        return husbandAmka;
    }

    public String getHusbandSurname() {
        return husbandSurname;
    }

    public String getWifeAmka() {
        return wifeAmka;
    }

    public String getWifeAfm() {
        return wifeAfm;
    }

    public String getWifeSurname() {
        return wifeSurname;
    }

    public String getEpimeleiaPaidiwn() {
        return epimeleiaPaidiwn;
    }

    public String getAkinitiPeriousia() {
        return akinitiPeriousia;
    }

    public String getLogariasmoiTrapezwn() {
        return logariasmoiTrapezwn;
    }

    public String getIx() {
        return ix;
    }

    public String getReason() {
        return reason;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DivorceFormDto entity = (DivorceFormDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.husbandAfm, entity.husbandAfm) &&
                Objects.equals(this.husbandAmka, entity.husbandAmka) &&
                Objects.equals(this.husbandSurname, entity.husbandSurname) &&
                Objects.equals(this.wifeAmka, entity.wifeAmka) &&
                Objects.equals(this.wifeAfm, entity.wifeAfm) &&
                Objects.equals(this.wifeSurname, entity.wifeSurname) &&
                Objects.equals(this.epimeleiaPaidiwn, entity.epimeleiaPaidiwn) &&
                Objects.equals(this.akinitiPeriousia, entity.akinitiPeriousia) &&
                Objects.equals(this.logariasmoiTrapezwn, entity.logariasmoiTrapezwn) &&
                Objects.equals(this.ix, entity.ix) &&
                Objects.equals(this.reason, entity.reason) &&
                Objects.equals(this.user, entity.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, husbandAfm, husbandAmka, husbandSurname, wifeAmka, wifeAfm, wifeSurname, epimeleiaPaidiwn, akinitiPeriousia, logariasmoiTrapezwn, ix, reason, user);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "husbandAfm = " + husbandAfm + ", " +
                "husbandAmka = " + husbandAmka + ", " +
                "husbandSurname = " + husbandSurname + ", " +
                "wifeAmka = " + wifeAmka + ", " +
                "wifeAfm = " + wifeAfm + ", " +
                "wifeSurname = " + wifeSurname + ", " +
                "epimeleiaPaidiwn = " + epimeleiaPaidiwn + ", " +
                "akinitiPeriousia = " + akinitiPeriousia + ", " +
                "logariasmoiTrapezwn = " + logariasmoiTrapezwn + ", " +
                "ix = " + ix + ", " +
                "reason = " + reason + ", " +
                "user = " + user + ")";
    }
}