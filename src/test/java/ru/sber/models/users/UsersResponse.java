package ru.sber.models.users;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Модель, представляющая ответ от API с массивом пользователей.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersResponse {
    @JsonProperty("users")
    private List<GetUser> users;
}
