package com.powerup.user.application.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRequest {
    @NotBlank(message = "El campo nombre es obligatorio")
    private String name;
    @NotBlank(message = "El campo apellido es obligatorio")
    private String lastName;
    @NotBlank(message = "El campo documento es obligatorio")
    @Pattern(regexp = "^[0-9]*$", message = "debe ser numerico")
    @Size(min = 5, max=11, message = "no es valida")
    private String idDocument;
    @NotBlank(message = "El campo celular es obligatorio")
    @Pattern(regexp = "^(\\+57)?3\\d{9}$")
    private String phone;
    @NotBlank(message = "El campo correo es obligatorio")
    @Email(message = "El correo electrónico no es válido")
    private String email;
    @NotBlank(message = "El campo contraseña es obligatorio")
    private String password;
}
