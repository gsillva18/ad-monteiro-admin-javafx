package com.ad.admonteirojavafx.service;

import com.ad.admonteirojavafx.core.enums.TypeInformation;
import com.ad.admonteirojavafx.core.utils.Creator;
import com.ad.admonteirojavafx.model.ADMonteiroModel;
import com.ad.admonteirojavafx.model.ChurchEvent;
import com.ad.admonteirojavafx.model.Cult;
import com.ad.admonteirojavafx.repository.ADRepository;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;

public class ADService {

    private final ADRepository adRepository = new ADRepository();

    public void createCult(TextField nameCult,
                           TextField hour,
                           TextField minute,
                           ComboBox<String> dayWeek){

        ADMonteiroModel adModel = adRepository.findADMonteiroModel();
        List<Cult> cults = adModel.getCults();

        Cult cult = Creator.createCult(nameCult.getText(),
                dayWeek.getValue(),
                hour.getText(),
                minute.getText());

        cults.add(cult);
        adModel.setCults(cults);
        adRepository.saveADMonteiroModel(adModel);
    }

    public void createEvent(TextField nameEvent,
                            TextField locationEvent,
                            TextField hourEvent,
                            TextField minuteEvent,
                            DatePicker dateEvent,
                            TextArea description){

        ADMonteiroModel adModel = adRepository.findADMonteiroModel();
        List<ChurchEvent> churchEvents = adModel.getChurchEvents();

        ChurchEvent churchEvent = Creator.createChurchEvent(nameEvent.getText(),
                dateEvent.getValue(),
                hourEvent.getText(),
                minuteEvent.getText(),
                locationEvent.getText(),
                description.getText());

        churchEvents.add(churchEvent);
        adModel.setChurchEvents(churchEvents);
        adRepository.saveADMonteiroModel(adModel);


    }

    public void deleteCultEvent(TextField name, ComboBox<TypeInformation> typeInformation){

        ADMonteiroModel adModel = adRepository.findADMonteiroModel();

        if (typeInformation.getValue() == TypeInformation.CULT){
            List<Cult> cults = deleteCult(name.getText(), adModel.getCults());
            adModel.setCults(cults);
        }else{
            List<ChurchEvent> churchEvents = deleteEvent(name.getText(), adModel.getChurchEvents());
            adModel.setChurchEvents(churchEvents);
        }

        adRepository.saveADMonteiroModel(adModel);

    }

    private List<Cult> deleteCult(String name, List<Cult> cults){

        cults.removeIf(element->element.getName().equals(name));

        return cults;
    }

    private List<ChurchEvent> deleteEvent(String name, List<ChurchEvent> churchEvents){
        churchEvents.removeIf(element->element.getName().equals(name));
        return churchEvents;
    }

}
