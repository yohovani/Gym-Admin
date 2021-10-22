package com.yoho.gimnasios.controllers;

import com.yoho.gimnasios.models.Assist;
import com.yoho.gimnasios.services.AssisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "assist")
public class AssistController {
    private final AssisteService assisteService;

    @Autowired
    public AssistController(AssisteService assisteService) {
        this.assisteService = assisteService;
    }

    @PostMapping(path = "/addAssistan")
    public Assist addAssistance(){
        return this.assisteService.addNewAssist(1L);
    }

    @GetMapping(path = "/currentDayAssists")
    public List<Assist> getCurrentDayAssists(){
        return this.assisteService.getCurrentDayAssistans();
    }


}
