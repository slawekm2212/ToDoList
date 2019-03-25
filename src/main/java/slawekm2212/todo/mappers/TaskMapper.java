package slawekm2212.todo.mappers;

import org.springframework.stereotype.Component;
import slawekm2212.todo.commons.Mapper;
import slawekm2212.todo.models.Task;
import slawekm2212.todo.models.modelsDto.TaskDto;

@Component
public class TaskMapper implements Mapper<Task, TaskDto> {
    @Override
    public TaskDto map(Task f) {

        return TaskDto
                .builder()
                .taskTitle(f.getTaskTitle())
                .taskDiscp(f.getTaskDiscp())
                .shouldBeDoneTill(f.getShouldBeDoneTill())
                .status(f.getStatus())
                .build();

    }
    @Override
    public Task revers(TaskDto to){
        return Task
                .builder()
                .userName(to.getUserName())
                .taskTitle(to.getTaskTitle())
                .taskDiscp(to.getTaskDiscp())
                .taskAddTime(to.getTaskAddTime())
                .shouldBeDoneTill(to.getShouldBeDoneTill())
                .status(to.getStatus())
                .build();
    }
}


