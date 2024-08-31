package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserForm {

    @NotBlank(message = "Invalid Name")
    @Size(min = 3, max = 30, message = "Min 3 letters required!")
    private String name;

    @Email(message = "Enter a valid Email!")
    private String email;

    @NotBlank(message = "Enter a valid Password(4 letters atleast!)")
    @Size(min = 4, message = "Enter 4 letters Atleast!")
    private String password;

    @Size(min = 8, max = 13, message = "Enter a valid Contact Information!")
    private String phoneNumber;
    private String about;

}
