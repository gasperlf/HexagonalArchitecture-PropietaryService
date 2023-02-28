package com.powerup.user.domain.config;

public class Routes {
    public static final String USER_PATH = "/users";

    public static final String EDIT_USER_PATH = "/{identification}";
    public static final String FIND_USER_BY_IDENTIFICATION_PATH = "/{identification}";
    public static final String FIND_USER_BY_EMAIL_PATH = "/email";
    public static final String DEACTIVATE_USER_PATH = "/{identification}/deactivate";
    public static final String ACTIVATE_USER_PATH = "/{identification}/activate";
    public static final String LOGIN_PATH = "/login";
    public static final String CREATE_USER = "/{idRole}";

    // External API routes
    public static final String UPDATE_IMAGE_PATH = "/{image_id}";
    public static final String GET_IMAGE_PATH = "/{image_id}";


    private Routes() {
        throw new IllegalStateException("Routes Class");
    }
}
