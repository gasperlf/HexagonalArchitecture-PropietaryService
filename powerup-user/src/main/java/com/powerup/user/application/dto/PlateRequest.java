package com.powerup.user.application.dto;

import lombok.Getter;
import lombok.Setter;

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
    private String urlImage;

}
