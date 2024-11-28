package ru.sber.models.plans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author NardinVN
 * <p>
 *     Модель плана, возвращаемого API.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanRequest {
    @JsonProperty("plan")
    private String plan;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("rsg_name")
    private String rsgName;
}
