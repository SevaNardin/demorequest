package ru.sber.models.users;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Модель пользователя, возвращаемого API.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUser {
    @JsonProperty("is_admin")
    private boolean isAdmin;

    @JsonProperty("resgroup")
    private String resgroup;

    @JsonProperty("name")
    private String name;

    @JsonProperty("can_login")
    private boolean canLogin;

    @JsonProperty("connection_limit")
    private int connectionLimit;
}