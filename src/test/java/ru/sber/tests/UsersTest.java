package ru.sber.tests;


import org.junit.jupiter.api.Test;
import ru.sber.api.UserService;
import ru.sber.models.users.GetUser;

import java.util.List;

/**
 * @author NardinVN
 * <p>
 */
public class UsersTest {

    private final UserService userService = new UserService();

    @Test
    void getUsers() {
        // Вызываем сервис для получения списка пользователей
        List<GetUser> listUsers = userService.getUsers(20621210);
        // Выводим список на консоль
        System.out.println(listUsers);
    }

}
