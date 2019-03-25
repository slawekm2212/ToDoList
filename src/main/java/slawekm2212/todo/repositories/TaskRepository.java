package slawekm2212.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import slawekm2212.todo.models.Task;

import java.util.Optional;

public interface TaskRepository extends JpaRepository <Task, Long> {
  //  @Query(value = "delete from Task where task_name=?1")
    @Query(value = "delete from Task p where p.taskTitle=?1")
    @Transactional
    @Modifying
    void deleteByTaskTitle(String taskTitle);

    @Query(value = "select p from Task  p where p.taskTitle=?1")
    Optional<Task> findByTaskTitle(String taskTitle);
}
//@Query(value = "select p from Planet p where p.planetName=?1")
//    Optional<Planet> findByPlanetName(String planetName);