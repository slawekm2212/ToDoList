package slawekm2212.todo.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import slawekm2212.todo.models.Task;
import slawekm2212.todo.models.modelsDto.TaskDto;
import slawekm2212.todo.services.TaskService;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class TaskController {



    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }





    @GetMapping("/task")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/dto/tasks")
    public List<TaskDto> getTasksDto() {
        return taskService.getTasksDto();
    }

    @PostMapping("/dto/tasks")
    public Task addTask(@RequestBody TaskDto taskDto){
        return taskService.addTask(taskDto);
    }
    @PutMapping("/dto/tasks")
    public void updateTask(@RequestBody TaskDto taskDto){
        taskService.updateTask(taskDto);
    }
    @DeleteMapping("/dto/tasks/{taskTitle}")
    public void DeleteTask(@PathVariable String taskTitle){
        taskService.deleteTask(taskTitle);
    }
}

