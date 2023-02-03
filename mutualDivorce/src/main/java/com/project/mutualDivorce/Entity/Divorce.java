package com.project.mutualDivorce.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "divorces")
public class Divorce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String husbandAfm;
    @Column(name = "HusbandAmka")
    private String husbandAmka;
    @Column(name = "HusbandSurname")
    private String husbandSurname;
    @Column(name = "WifeAmka")
    private String wifeAmka;
    private String wifeAfm;
    @Column(name = "WifeSurname")
    private String wifeSurname;

    @Column(name = "epimeleia_Paidiwn")
    private String epimeleiaPaidiwn;
    @Column(name = "akiniti_Periousia")
    private String akinitiPeriousia;
    @Column(name = "logariasmoi_Trapezwn")
    private String logariasmoiTrapezwn;
    @Column(name = "idiotiki_xrisi")
    private String ix;
    @Column(name = "reason")
    private String reason;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getHusbandAfm() {
        return husbandAfm;
    }

    public void setHusbandAfm(String husbandAfm) {
        this.husbandAfm = husbandAfm;
    }

    public String getHusbandAmka() {
        return husbandAmka;
    }

    public void setHusbandAmka(String husbandAmka) {
        this.husbandAmka = husbandAmka;
    }

    public String getHusbandSurname() {
        return husbandSurname;
    }

    public void setHusbandSurname(String husbandSurname) {
        this.husbandSurname = husbandSurname;
    }

    public String getWifeAmka() {
        return wifeAmka;
    }

    public void setWifeAmka(String wifeAmka) {
        this.wifeAmka = wifeAmka;
    }

    public String getWifeAfm() {
        return wifeAfm;
    }

    public void setWifeAfm(String wifeAfm) {
        this.wifeAfm = wifeAfm;
    }

    public String getWifeSurname() {
        return wifeSurname;
    }

    public void setWifeSurname(String wifeSurname) {
        this.wifeSurname = wifeSurname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEpimeleiaPaidiwn() {
        return epimeleiaPaidiwn;
    }

    public void setEpimeleiaPaidiwn(String epimeleiaPaidiwn) {
        this.epimeleiaPaidiwn = epimeleiaPaidiwn;
    }

    public String getAkinitiPeriousia() {
        return akinitiPeriousia;
    }

    public void setAkinitiPeriousia(String akinitiPeriousia) {
        this.akinitiPeriousia = akinitiPeriousia;
    }

    public String getLogariasmoiTrapezwn() {
        return logariasmoiTrapezwn;
    }

    public void setLogariasmoiTrapezwn(String logariasmoiTrapezwn) {
        this.logariasmoiTrapezwn = logariasmoiTrapezwn;
    }

    public String getIx() {
        return ix;
    }

    public void setIx(String ix) {
        this.ix = ix;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
