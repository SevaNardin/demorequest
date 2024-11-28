package ru.sber.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import ru.sber.models.plans.PlanRequest;
import ru.sber.models.plans.PlanResponse;

import java.util.List;

/**
 * @author NardinVN
 * <p>
 *     Получение плана отстреленного запроса из истории действий
 */
public class PlanService {

    private static final String API_URL = "https://tvlds-sdpgp0101.qa.df.sbrf.ru:5443/users/actions/query/plan";

    /**
     * Метод для получения плана отстреленного запроса из истории действий.
     *
     * @param userId       ID пользователя
     * @param actionsTime  Время действий в формате "yyyy-MM-dd HH:mm:ss.SSS"
     * @param pid          Идентификатор процесса
     * @return Ответ в виде строки (JSON), или null в случае ошибки
     */
    public List<PlanRequest> getActionPlan(int userId, String actionsTime, int pid) {
        // Настройка Rest Assured для работы с SSL
        RestAssured.useRelaxedHTTPSValidation();

        // Создание JSON-данных для запроса
        String jsonBody = String.format("{\"actions_time\": \"%s\", \"pid\": %d}", actionsTime, pid);

        // Выполнение POST-запроса к API
        Response response = RestAssured.given()
                .header("Application-Username", userId) // Добавление заголовка
//                .cert(Paths.get("path/to/u_gpts_s_as_ift_demouser.pem").toFile(), "passphrase") // Замените на ваш путь и пароль
//                .keyStore(Paths.get("path/to/u_gpts_s_as_ift_demouser.key").toFile(), "passphrase") // Замените на ваш путь и пароль
                .body(jsonBody) // Установка тела запроса
                .when()
                .post(API_URL); // Выполнение POST-запроса

        // Проверка статуса ответа
        if (response.getStatusCode() == 200) {
            PlanResponse planResponse = response.as(PlanResponse.class);
            return planResponse.getPlans(); // Возвращение тела ответа при успешном запросе
        } else {
            System.err.println("Ошибка: " + response.getStatusCode() + " " + response.getStatusLine());
            return null; // Возвращение null в случае ошибки
        }
    }

}
