package com.gestiontareas.gestion.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestiontareas.gestion.Requests.TaskUpdateRequest;
import com.gestiontareas.gestion.Services.TaskUpdatePOSTService;
import com.gestiontareas.gestion.model.Task;

@RestController
@RequestMapping("/tasks")
@CrossOrigin
public class RestTaskUpdatePOSTController 
{
    @Autowired
    private TaskUpdatePOSTService updatepostservice;

    
    @PostMapping("/update/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody TaskUpdateRequest updatetask)
    {
        return updatepostservice.updateTask(id, updatetask);
    }
}
