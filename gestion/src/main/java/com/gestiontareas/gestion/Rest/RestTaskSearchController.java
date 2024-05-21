package com.gestiontareas.gestion.Rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestiontareas.gestion.Requests.TaskSearchRequest;
import com.gestiontareas.gestion.Services.TaskSearchService;
import com.gestiontareas.gestion.model.Task;


/*Controlador de Servicio POST para buscar una tarea */
@RestController
@RequestMapping("/tasks")
public class RestTaskSearchController 
{
    @Autowired
    private TaskSearchService searchservice;

    @PostMapping("/search")
    public ResponseEntity<List<Task>> searchTasks(@RequestBody TaskSearchRequest searchrequest)
    {
        List<Task> tasks = searchservice.searchTasks(searchrequest);
        return ResponseEntity.ok(tasks);
    }
}
