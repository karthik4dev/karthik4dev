package com.karthikproject.firstspringproject.Controllers;

import com.karthikproject.firstspringproject.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("/taskToDo")
public class TaskController {
    List<Task> tasks= new ArrayList<Task>();
    private int taskID = 0;
    @GetMapping("/")
    public List<Task> getAllTasks(){
        Collections.sort(tasks);
        return tasks;
    }

    @GetMapping("/{id}")
    public Task getTaskbyId(@PathVariable int id){
        for (Task i:tasks){
            if(i.getTaskId()==id) {
                return i;
            }
        }
        return null;
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task){
        task.setTaskId(++taskID);
        tasks.add(task);
        System.out.println("Task is created");
        return task;
    }

    @PutMapping("/Task/{id}")
    public Task updateTaskByID(@PathVariable int id,@RequestBody Task task){
        for(Task i :tasks){
            if(i.getTaskId()==id){
                i.setTaskName(task.getTaskName());
                i.setTaskDescription(task.getTaskDescription());
                i.setTaskStatus(task.getTaskStatus());
                return task;
            }

        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable int id){
        int v = 0;
        for (Task i : tasks){
            if(i.getTaskId()==id){
                v=i.getTaskId();
                tasks.remove(i);
            }

        }
//        return new String("The task " + v +" is deleted");
    }
}
