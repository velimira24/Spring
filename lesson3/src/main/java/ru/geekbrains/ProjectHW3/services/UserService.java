package main.java.ru.geekbrains.ProjectHW3.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.ProjectHW3.domain.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    // @Autowired
    private NotificationService notificationService;

    // Внедрение зависимости через конструктор
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        // Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);

        return user;
    }
}