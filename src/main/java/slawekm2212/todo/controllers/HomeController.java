package slawekm2212.todo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import slawekm2212.todo.models.Task;
import slawekm2212.todo.models.modelsDto.TaskDto;
import slawekm2212.todo.services.TaskService;


@Controller
@CrossOrigin
public class HomeController {


    private TaskService taskService;

    public HomeController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("todo", taskService.getTasks()); // binduje, przekazuje planetService.get pod parametrem planets
        return "index";
    }

    @GetMapping("/add")
    public String addToDoTask(@ModelAttribute Task task) {
        System.out.println(task.getTaskAddTime());
        taskService.addTask(TaskDto.builder().build());
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteToDo(@RequestParam(value = "todo") String taskName) {
        taskService.deleteTask(taskName);
        return "redirect:/";
    }

    @GetMapping("/upd")
    public String updateTask(@ModelAttribute TaskDto taskDto) {
        taskService.updateTask(taskDto);
        return "redirect:/";
    }

}

