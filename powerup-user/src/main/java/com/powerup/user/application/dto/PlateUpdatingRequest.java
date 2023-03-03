package com.powerup.user.application.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PlateUpdatingRequest {
    private Long id;
    @NotBlank
    private String description;
    private Long price;
    private Long idOwner;

}
