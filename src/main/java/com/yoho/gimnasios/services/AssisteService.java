package com.yoho.gimnasios.services;

import com.yoho.gimnasios.models.Assist;
import com.yoho.gimnasios.repositories.AssistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssisteService {
    private final AssistRepository assistRepository;

    @Autowired
    public AssisteService(AssistRepository assistRepository) {
        this.assistRepository = assistRepository;
    }

    public Assist addNewAssist(Long idUser){
        Assist assist = new Assist();
        this.assistRepository.save(assist);
        return assist;
    }

    public List<Assist> getAssistsByDay(int day){
        return this.assistRepository.getAssistsByDay(day);
    }

    public List<Assist> getCurrentDayAssistans(){
        return this.assistRepository.getCurrentDayAssists();
    }
}
