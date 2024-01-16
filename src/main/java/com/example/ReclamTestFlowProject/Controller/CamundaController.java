package com.example.ReclamTestFlowProject.Controller;
import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.camunda.bpm.engine.history.HistoricTaskInstance;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/travelplan")
public class CamundaController {
    protected static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CamundaController.class);
    @Autowired
    private TaskService taskService;

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private HistoryService historyService;

    //Lancer un process instance with business key = iduser //
    @PostMapping("/start-process/{idUser}")
    public String startProcess(@PathVariable String idUser) {
        ProcessInstance processInstance = processEngine.getRuntimeService()
                .startProcessInstanceByKey("travelPlan",idUser);

        LOGGER.info("id process "+ processInstance.getId());
        LOGGER.info("Business key"+  processInstance.getBusinessKey());
        return processInstance.getId();
    }

    //Accomplish USER TASK INPUT TEXT PREFERENCE //
    @PostMapping("/complete-task/task1/{idUser}")
    public String completeTaskUserInput(@PathVariable String idUser) {
        Task task = taskService.createTaskQuery()
                .processInstanceBusinessKey(idUser)
                .taskDefinitionKey("userInput")
                .singleResult();
        LOGGER.info("Etape "+task.getName());

        if (task != null) {
            taskService.complete(task.getId());
            return "Task completed";
        } else {
            return "Task not found";
        }
    }
//CHOICE OF COUNTRY AND DATES
    @PostMapping("/complete-task/task3/{idUser}")
    public String completeChoiceTask(@PathVariable String idUser) {
        Task task = taskService.createTaskQuery()
                .processInstanceBusinessKey(idUser)
                .taskDefinitionKey("choice")
                .singleResult();
        LOGGER.info("traitement etape "+task.getName());

        if (task != null) {
            taskService.complete(task.getId());
            return "Task completed";
        } else {
            return "Task not found";
        }
    }
    //CHOICE OF FLIGHT
    @PostMapping("/complete-task/task4/{idUser}")
    public String completeFlightChoice(@PathVariable String idUser) {
        Task task = taskService.createTaskQuery()
                .processInstanceBusinessKey(idUser)
                .taskDefinitionKey("choiceF")
                .singleResult();
        LOGGER.info("traitement etape "+task.getName());

        if (task != null) {
            taskService.complete(task.getId());
            return "Task completed";
        } else {
            return "Task not found";
        }
    }
    //CHOICE OF Hotel
    @PostMapping("/complete-task/task5/{idUser}")
    public String completeActivityTask(@PathVariable String idUser) {
        Task task = taskService.createTaskQuery()
                .processInstanceBusinessKey(idUser)
                .taskDefinitionKey("choiceH")
                .singleResult();
        LOGGER.info("traitement etape "+task.getName());

        if (task != null) {
            taskService.complete(task.getId());
            return "Task completed";
        } else {
            return "Task not found";
        }
    }

    //Accomplish generated itinenary
    @PostMapping("/complete-task/task7/{idUser}/{confirmation}")
    public String completeUserConfirmation(@PathVariable String idUser,@PathVariable String confirmation) {
        Task task = taskService.createTaskQuery()
                .processInstanceBusinessKey(idUser)
                .taskDefinitionKey("generated")
                .singleResult();
        LOGGER.info("traitement etape "+task.getName());

        if (task != null) {
            taskService.complete(task.getId(),Map.of("confirm", confirmation));
            return "Task completed";
        } else {
            return "Task not found";
        }
    }

    @PostMapping("/complete-task/task8/{idUser}")
    public String completeCalculateCost(@PathVariable String idUser) {
        Task task = taskService.createTaskQuery()
                .processInstanceBusinessKey(idUser)
                .taskDefinitionKey("cost")
                .singleResult();
        LOGGER.info("traitement etape "+task.getName());

        if (task != null) {
            taskService.complete(task.getId());
            return "Task completed";
        } else {
            return "Task not found";
        }
    }

    //Accomplish Hotel selection
    @PostMapping("/complete-task/task9/{idUser}")
    public String completeModification(@PathVariable String idUser) {
        Task task = taskService.createTaskQuery()
                .processInstanceBusinessKey(idUser)
                .taskDefinitionKey("modification")
                .singleResult();
        LOGGER.info("traitement etape "+task.getName());

        if (task != null) {
            taskService.complete(task.getId());
            return "Task completed";
        } else {
            return "Task not found";
        }
    }
}