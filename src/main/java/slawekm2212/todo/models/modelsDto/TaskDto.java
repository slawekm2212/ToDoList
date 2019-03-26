package slawekm2212.todo.models.modelsDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

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

    private Date shouldBeDoneTill;

    private Boolean status;
}
