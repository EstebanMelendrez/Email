package com.gestiontareas.gestion.Rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestiontareas.gestion.Services.TaskService;
import com.gestiontareas.gestion.model.Task;


/*controlador de servicios REST para la obtención y creación de datos de la tabla de datos Task */
@RestController
@RequestMapping("/tasks")
public class RestTaskController 
{
    @Autowired
    private TaskService taskservice;


    @GetMapping
    public List<Task> getAllTasks()
    {
        return taskservice.getAllTasks();
    }

    @GetMapping("{Id}")
    public Optional<Task> getTaskById(@PathVariable int Id)
    {
        return taskservice.getTaskById(Id);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task)
    {
        Task createdtask = taskservice.createTask(task);
        return ResponseEntity.ok(createdtask);
    }
}
