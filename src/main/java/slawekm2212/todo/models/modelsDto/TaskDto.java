package slawekm2212.todo.models.modelsDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TaskDto {

    private Long id;

    private String userName;

    private String taskTitle;

    private String taskDiscp;

    private LocalDateTime taskAddTime;

    private LocalDateTime shouldBeDoneTill;

    private Boolean status;
}
