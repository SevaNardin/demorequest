package ru.sber.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import ru.sber.models.users.GetUser;
import ru.sber.models.users.UsersResponse;

import java.nio.file.Paths;
import java.util.List;

/**
 * @author NardinVN
 * <p>
 *     Получение пользователей на кластере
 */
public class UserService {

    private static final String API_URL = "https://tvlds-sdpgp0101.qa.df.sbrf.ru:5443/users";

    /**
     * Метод для получения списка пользователей.
     *
     * @return ответ от сервера
     */
    public List<GetUser> getUsers(int userId) {
        // Настройка Rest Assured для работы с SSL
        RestAssured.useRelaxedHTTPSValidation();

        // Выполнение GET-запроса к API
        Response response = RestAssured.given()
                .header("Application-Username", userId) // Добавление заголовка
                .keyStore(Paths.get("path/to/u_gpts_s_as_ift_demouser.key").toFile(), "passphrase") // Замените на ваш путь и пароль
//                .cert(Paths.get("path/to/u_gpts_s_as_ift_demouser.pem").toFile(), "passphrase") // Замените на ваш путь и пароль
//                .trustStore(Paths.get("path/to/server_root.crt").toFile()) // Укажите путь к CA сертификату
                .when()
                .get(API_URL) // Выполнение GET-запроса
                .then()
                .extract()
                .response(); // Извлечение ответа

        // Проверка на статус код
        if (response.getStatusCode() == 200) {
            UsersResponse usersResponse = response.as(UsersResponse.class);
            return usersResponse.getUsers();
        } else {
            // В случае иных статус кодов можно выбросить исключение или вернуть пустой список (пример 400)
            System.out.println("Ошибка: статус код = " + response.getStatusCode() + ", сообщение: " + response.getStatusLine());
            return List.of(); // Возвращаем пустой список в случае ошибки
        }
    }
}