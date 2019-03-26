package slawekm2212.todo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "task_title")
    private String taskTitle;
    @Column(name = "task_discription")
    private String taskDiscp;
    @Column(name = "task_add_time")
    private LocalDateTime taskAddTime = LocalDateTime.now();
    @Column(name = "should_be_done_till")
    private Date shouldBeDoneTill;
    @Column(name = "status")
    private Boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDiscp() {
        return taskDiscp;
    }

    public void setTaskDiscp(String taskDiscp) {
        this.taskDiscp = taskDiscp;
    }

    public LocalDateTime getTaskAddTime() {

        return taskAddTime;
    }

    public void setTaskAddTime(LocalDateTime taskAddTime) {
        this.taskAddTime = taskAddTime;
    }

    public Date getShouldBeDoneTill() {
        return shouldBeDoneTill;
    }

    public void setShouldBeDoneTill(Date shouldBeDoneTill) {
        this.shouldBeDoneTill = shouldBeDoneTill;
    }
}

  //  public Boolean isStatus() {
   //     return status;
  //  }

  //  public void setStatus(Boolean status) {
  //      this.status = status;
  //  }

