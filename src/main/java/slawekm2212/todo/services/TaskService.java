package slawekm2212.todo.services;

import org.springframework.stereotype.Service;
import slawekm2212.todo.mappers.TaskMapper;
import slawekm2212.todo.models.Task;
import slawekm2212.todo.models.modelsDto.TaskDto;
import slawekm2212.todo.repositories.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {



    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
    public List<TaskDto> getTasksDto(){
        return taskRepository
                .findAll()
                .stream()
                .map(taskMapper::map)
                .collect(Collectors.toList());
    }
    public Task addTask(TaskDto taskDto){
        return taskRepository.save(taskMapper.revers(taskDto));
    }
    public void deleteTask(String taskTitle){
        taskRepository.deleteByTaskTitle(taskTitle);
    }
    public void updateTask(TaskDto taskDto){
        taskRepository
                .findByTaskTitle(taskDto.getTaskTitle())
                .ifPresent(p -> {
                    p.setTaskDiscp(taskDto.getTaskDiscp());
                    p.setShouldBeDoneTill(taskDto.getShouldBeDoneTill());
                    p.setStatus(taskDto.getStatus());

                    taskRepository.save(p);
                });
    }

}
