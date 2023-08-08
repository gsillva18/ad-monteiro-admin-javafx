package com.ad.admonteirojavafx.controller;

import com.ad.admonteirojavafx.core.utils.Validator;
import com.ad.admonteirojavafx.exchanger.ExchangerPages;
import com.ad.admonteirojavafx.service.ADService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ADHomeController implements Initializable {

    private ExchangerPages exchangerPages = new ExchangerPages();
    private ADService adService = new ADService();

    @FXML
    private TextField nameCult;
    @FXML
    private ComboBox<String> dayWeekCult;
    @FXML
    private TextField hourCult;
    @FXML
    private TextField minuteCult;
    @FXML
    private TextField nameEvent;
    @FXML
    private TextField locationEvent;
    @FXML
    private TextField hourEvent;
    @FXML
    private TextField minuteEvent;
    @FXML
    private DatePicker dateEvent;
    @FXML
    private TextArea description;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.dayWeekCult.getItems().addAll("day week","domingo","segunda-feira","terça-feira",
                "quarta-feira","quinta-feira","sexta-feira","sábado");
    }

    @FXML
    public void createCult(){
        try {
            Validator.validateCult(nameCult, dayWeekCult.getSelectionModel().getSelectedIndex(),
                    hourCult, minuteCult);
            adService.createCult(nameCult, hourCult, minuteCult, dayWeekCult);
            clearFields();
        } catch (Exception e) {
            System.out.println("O ERRO FOI: " + e.getMessage());
        }

    }

    @FXML
    public void createEvent(){
        try {
            Validator.validateEvent(nameEvent,locationEvent,hourEvent, minuteEvent, dateEvent, description);
            adService.createEvent(nameEvent, locationEvent, hourEvent, minuteEvent, dateEvent, description);
            clearFields();
        } catch (Exception e) {
            System.out.println("O ERRO FOI: " + e.getMessage());
        }
    }

    @FXML
    public void logoff(ActionEvent event){
        try {
            exchangerPages.exchangePageLogin(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void delete(ActionEvent event){
        try {
            exchangerPages.exchangePageDelete(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void clearFields(){
        try {
            this.nameCult.clear();
            this.dayWeekCult.setValue("day week");
            this.dayWeekCult.commitValue();
            this.hourCult.clear();
            this.minuteCult.clear();
            this.nameEvent.clear();
            this.locationEvent.clear();
            this.hourEvent.clear();
            this.minuteEvent.clear();
            this.dateEvent.setValue(null);
            this.description.clear();
        }catch (Exception e){}

    }

}
