package com.ad.admonteirojavafx.service;

import com.ad.admonteirojavafx.core.enums.TypeInformation;
import com.ad.admonteirojavafx.core.utils.Creator;
import com.ad.admonteirojavafx.model.ChurchEvent;
import com.ad.admonteirojavafx.model.Cult;
import com.ad.admonteirojavafx.repository.ADRepository;
import javafx.scene.control.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ADService {

    private final ADRepository adRepository = new ADRepository();

    public void login(PasswordField UIDUser)throws Exception{
        adRepository.login(UIDUser.getText());
    }

    public void createCult(TextField nameCult,
                           TextField hour,
                           TextField minute,
                           ComboBox<String> dayWeek){

        Cult cult = Creator.createCult(nameCult.getText(),
                dayWeek.getValue(),
                hour.getText(),
                minute.getText());

        adRepository.createCult(nameCult.getText().replaceAll("\\s","").toLowerCase(),cult);
    }

    public void createEvent(TextField nameEvent,
                            TextField locationEvent,
                            TextField hourEvent,
                            TextField minuteEvent,
                            DatePicker dateEvent,
                            TextArea description){

        ChurchEvent churchEvent = Creator.createChurchEvent(nameEvent.getText(),
                dateEvent.getValue(),
                hourEvent.getText(),
                minuteEvent.getText(),
                locationEvent.getText(),
                description.getText());

        adRepository.createEvent(nameEvent.getText().replaceAll("\\s","").toLowerCase(),churchEvent);


    }

    public void deleteCultOrEvent(TextField name, TypeInformation typeInformation){

        if (typeInformation == TypeInformation.CULT){
            adRepository.deleteCult(name.getText());
        }else{
            adRepository.deleteChurchEvent(name.getText());
        }

    }

}
