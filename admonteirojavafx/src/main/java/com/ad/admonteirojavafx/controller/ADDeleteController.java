package com.ad.admonteirojavafx.controller;

import com.ad.admonteirojavafx.core.enums.TypeInformation;
import com.ad.admonteirojavafx.core.utils.Validator;
import com.ad.admonteirojavafx.exchanger.ExchangerPages;
import com.ad.admonteirojavafx.service.ADService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ADDeleteController implements Initializable {

    private ExchangerPages exchangerPages = new ExchangerPages();
    private ADService adService = new ADService();

    @FXML
    private TextField nameId;
    @FXML
    private ComboBox<TypeInformation> typeInformationComboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.typeInformationComboBox.getItems().addAll(TypeInformation.values());
        this.typeInformationComboBox.setValue(TypeInformation.CULT);
    }

    @FXML
    public void deleteInformation(){
        try {
            Validator.validateDelete(nameId);
            adService.deleteCultEvent(nameId, typeInformationComboBox);
            clearFields();
        } catch (Exception e) {
            System.out.println("ESSE FOI O ERRO: " + e.getMessage());
        }

    }

    @FXML
    public void cancel(ActionEvent event){
        try {
            exchangerPages.exchangePageHome(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearFields(){
        try {
            this.nameId.clear();
            this.typeInformationComboBox.setValue(TypeInformation.CULT);
        }catch (Exception e){}
    }
}
