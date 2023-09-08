package com.project.mutualDivorce.Dto;

import com.project.mutualDivorce.Entity.Divorce;
import com.project.mutualDivorce.Entity.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Divorce} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DivorceFormDto  {
    private  Long id;
    @NotEmpty
    private  String husbandAfm;
    @NotEmpty
    private  String husbandAmka;
    @NotEmpty
    private  String husbandSurname;
    @NotEmpty
    private  String wifeAmka;
    @NotEmpty
    private  String wifeAfm;
    @NotEmpty
    private  String wifeSurname;
    private  String epimeleiaPaidiwn;
    private  String akinitiPeriousia;
    private  String logariasmoiTrapezwn;
    private  String ix;
   @NotEmpty
    private  String reasonOfDivorce;
   private User user;



}