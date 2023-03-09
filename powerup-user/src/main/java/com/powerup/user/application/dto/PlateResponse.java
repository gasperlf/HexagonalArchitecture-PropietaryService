package com.powerup.user.application.dto;
import com.powerup.user.domain.model.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlateResponse {

    private Long id;
    private String name;
    private Category category;
    private String description;
    private Long price;
    private String urlImage;

}
