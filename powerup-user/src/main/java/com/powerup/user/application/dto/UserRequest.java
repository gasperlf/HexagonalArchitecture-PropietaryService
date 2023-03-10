package com.powerup.user.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RequiredArgsConstructor
@Getter
@Setter
public class UserRequest {
    @NotBlank(message = "The field name is mandatory")
    private String name;
    @NotBlank(message = "The field lastName is mandatory")
    private String lastName;
    @NotBlank(message = "The field idDocument is mandatory")
    @Pattern(regexp = "^[0-9]*$", message = "debe ser numerico")
    @Size(min = 5, max=11, message = "no es valida")
    private String idDocument;
    @NotBlank(message = "The field phone is mandatory")
    @Pattern(regexp = "^(\\+57)?3\\d{9}$")
    private String phone;
    @NotBlank(message = "The field email is mandatory")
    @Email(message = "El correo electrónico no es válido")
    private String email;
    @NotBlank(message = "The field password is mandatory")
    private String password;
}
