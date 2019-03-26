package slawekm2212.todo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import slawekm2212.todo.models.Task;
import slawekm2212.todo.models.modelsDto.TaskDto;
import slawekm2212.todo.repositories.TaskRepository;
import slawekm2212.todo.services.TaskService;

import java.time.LocalDateTime;

@Controller
@CrossOrigin
public class HomeController {


    private TaskService taskService;
    private TaskRepository taskRepository;

    public HomeController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("task", taskService.getTasks()); //
        return "index";
    }

    @GetMapping("/add")
    public String addTask(@ModelAttribute TaskDto taskDto) {
        taskService.addTask(taskDto);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteTask(@RequestParam(value = "task") String taskName) {
        taskService.deleteTask(taskName);
        return "redirect:/";
    }

    @GetMapping("/upd")
    public String updateTask(@ModelAttribute TaskDto taskDto) {
        taskService.updateTask(taskDto);
        return "redirect:/";
    }
    @GetMapping("/update")
    public String updateHome(@RequestParam(value = "task") String taskName, Model model) {
        Task task = taskRepository.findByTaskTitle(taskName).get();
        model.addAttribute("task", task);
        return "update";
    }

}

