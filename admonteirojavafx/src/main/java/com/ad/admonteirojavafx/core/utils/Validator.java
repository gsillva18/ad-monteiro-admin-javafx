package com.ad.admonteirojavafx.core.utils;

import com.ad.admonteirojavafx.core.enums.TypeInformation;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class Validator {

    public static void validateCult(TextField nameCult,
                                    Integer dayWeek,
                                    TextField hourCult,
                                    TextField minuteCult) throws Exception{

        if(nameCult.getText().replaceAll("\\s","").isEmpty()){
            throw new Exception("Name Empty");
        }

        if(dayWeek == 0){
            throw new Exception("Day Week Empty");
        }
        validateHourAndMinute(hourCult, minuteCult);

    }

    public static void validateEvent(TextField nameEvent,
                              TextField locationEvent,
                              TextField hourEvent,
                              TextField minuteEvent,
                              DatePicker dateEvent,
                              TextArea description) throws Exception{

        if(nameEvent.getText().replaceAll("\\s","").isEmpty()){
            throw new Exception("Name Empty");
        }

        if(locationEvent.getText().replaceAll("\\s","").isEmpty()){
            throw new Exception("Location Event Empty");
        }
        validateDate(dateEvent);
        validateHourAndMinute(hourEvent, minuteEvent);

        if(description.getText().replaceAll("\\s","").isEmpty()){
            throw new Exception("Description Empty");
        }
    }

    public static void validateDelete(TextField nameId) throws Exception{

        if(nameId.getText().replaceAll("\\s","").isEmpty()){
            throw new Exception("Name or ID is Empty");
        }
    }

    private static void validateHourAndMinute(TextField hour, TextField minute) throws Exception{

        Integer numberHour = null;
        Integer numberMinute = null;

        try {

            numberHour = Integer.parseInt(hour.getText());
            numberMinute = Integer.parseInt(minute.getText());

        }catch (Exception e){
            throw new Exception("number not provided");
        }

        if (numberHour < 0 || numberHour > 23){
            throw new Exception("non-existent hour");
        }

        if (numberMinute < 0 || numberMinute > 59){
            throw new Exception("non-existent minute");
        }
    }

    private static void validateDate(DatePicker date) throws Exception{

        if(date.getValue() == null){
            throw new Exception("Date is null");
        }

        if(date.getValue().isBefore(LocalDate.now())){
            throw new Exception("Date is before today");
        }
    }
}
