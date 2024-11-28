package ru.sber.tests;

import org.junit.jupiter.api.Test;
import ru.sber.api.PlanService;
import ru.sber.models.plans.PlanRequest;

/**
 * @author NardinVN
 * <p>
 */
public class PlanTest {

    private final PlanService planService = new PlanService();
    private int userId = 20621210;
    private String date = "2023-05-10 17:54:16.562";
    private int pid = 2267626;

    @Test
    void postPlan() {
        // Подставляем в параметры запроса userId, date и pid
        planService.getActionPlan(userId, date, pid);

    }
}
