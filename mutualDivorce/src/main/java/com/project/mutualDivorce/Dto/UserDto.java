package com.project.mutualDivorce.Dto;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    private Long id;
    @NotEmpty
    private String surname;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
    @NotEmpty
    private String afm;
    @NotEmpty
    private String amka;
    @NotEmpty
    private String role;
}
