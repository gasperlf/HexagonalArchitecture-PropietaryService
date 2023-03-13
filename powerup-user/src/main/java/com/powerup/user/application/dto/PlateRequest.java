package com.powerup.user.application.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PlateRequest {

    @NotBlank
    private String name;
    private Long idCategory;
    @NotBlank
    private String description;
    private Long price;
    private Long idRestaurant;
    @NotBlank
    @URL(message = "must be a url")
    private String urlImage;

}
