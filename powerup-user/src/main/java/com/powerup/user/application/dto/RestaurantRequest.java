package com.powerup.user.application.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class RestaurantRequest {

    @NotBlank(message = "The field name should have data")
    @NotNull(message = "Invalid name: name is NULL")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "The field name shouldn't have numbers")
    private String name;

    @NotNull(message = "Invalid address: address is NULL")
    @NotBlank (message = "The field address is mandatory")
    private String address;
    private Long idOwner;
    @NotBlank (message = "The field phone is mandatory")
    @NotNull(message = "Invalid phone: phone is NULL")
    @Pattern(regexp = "^(\\+57)?3\\d{9}$", message = "The phone must be numeric")
    private String phone;

    @NotNull(message = "Invalid url: url is NULL")
    @NotBlank (message = "The url field is mandatory")
    @URL(message = "must be a url")
    private String urlLogo;

    @NotNull(message = "Invalid nit: nit is NULL")
    @Pattern(regexp = "^[0-9]*$", message = "The NIT must be numeric")
    @NotBlank (message = "The field NIT is mandatory")
    private String nit;

}
