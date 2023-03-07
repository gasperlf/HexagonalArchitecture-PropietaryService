package com.powerup.user.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlateIsActiveRequest {

    private Long id;
    private Boolean active;

}
