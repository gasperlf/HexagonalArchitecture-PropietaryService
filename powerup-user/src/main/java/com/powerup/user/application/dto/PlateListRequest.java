package com.powerup.user.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlateListRequest {
    private Long page;
    private Long amount;
    private Long idRestaurant;

}
