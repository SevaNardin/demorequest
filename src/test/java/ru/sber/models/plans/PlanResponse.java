package ru.sber.models.plans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author NardinVN
 * <p>
 *     Модель, представляющая ответ от API с массивом планов.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanResponse {
    @JsonProperty("plans")
    private List<PlanRequest> plans;

}
