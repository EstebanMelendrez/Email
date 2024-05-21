package com.gestiontareas.gestion.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestiontareas.gestion.Repository.ITaskRepository;
import com.gestiontareas.gestion.Requests.TaskSearchRequest;
import com.gestiontareas.gestion.model.Task;

@Service
public class TaskSearchService 
{
    @Autowired
    private ITaskRepository taskrepository;


    public List<Task> searchTasks(TaskSearchRequest search )
    {
        return taskrepository.findTasksByCriteria(
            search.getTitle(),
            search.getDescription(),
            search.getState(),
            search.getCreationDateFrom(),
            search.getCreationDateUntil(),
            search.getLimitDateFrom(),
            search.getLimitDateUntil(),
            search.getTagIds()
        );
    }
}
