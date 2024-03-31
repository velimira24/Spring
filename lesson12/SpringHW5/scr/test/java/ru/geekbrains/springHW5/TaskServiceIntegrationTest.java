package ru.geekbrains.springHW5;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.geekbrains.springHW5.model.Task;
import ru.geekbrains.springHW5.repository.TaskRepository;
import ru.geekbrains.springHW5.service.TaskService;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static ru.geekbrains.springHW5.model.TaskStatus.IN_PROGRESS;
import static ru.geekbrains.springHW5.model.TaskStatus.NOT_STARTED;


@SpringBootTest
public class TaskServiceIntegrationTest {

    @MockBean
    public TaskRepository taskRepository;

    @Autowired
    public TaskService taskService;

    @Test
    public void updateTaskTest() {
        //pre
        Task task1 = new Task();
        task1.setId(1L);
        task1.setStatus(NOT_STARTED);

        Task task2 = new Task();
        task2.setId(2L);
        task2.setStatus(IN_PROGRESS);

        given(taskRepository.findById(task1.getId())).willReturn(Optional.of(task1));

        // action
        taskService.updateTaskStatus(1L, task2);

        //check
        verify(taskRepository).findById(1L);
        verify(taskRepository).save(task1);
    }

}
