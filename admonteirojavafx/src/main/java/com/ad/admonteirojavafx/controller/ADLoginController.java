package com.ad.admonteirojavafx.controller;

import com.ad.admonteirojavafx.core.utils.Validator;
import com.ad.admonteirojavafx.exchanger.ExchangerPages;
import com.ad.admonteirojavafx.service.ADService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.shape.Shape;

import java.net.URL;
import java.util.ResourceBundle;

public class ADLoginController implements Initializable {

    private ExchangerPages exchangerPages = new ExchangerPages();
    private ADService adService = new ADService();

    @FXML
    private PasswordField password;

    @FXML
    private Label message;
    @FXML
    private Shape rectangleAlert;
    @FXML
    private Button buttonCloseAlert;

    @FXML
    public void loginButton(ActionEvent event){

        try {
            Validator.validateUIDUser(password);
            adService.login(password);
            exchangerPages.exchangePageHome(event);
        } catch (Exception e) {
            message.setText(e.getMessage());
            setVisible(true);
            password.clear();
        }
    }

    @FXML
    public void  closeAlert(ActionEvent event){
        setVisible(false);
    }

    @FXML
    public void exit(ActionEvent event){
        exchangerPages.close(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setVisible(false);
    }

    private void setVisible(Boolean visible){

        message.setVisible(visible);
        rectangleAlert.setVisible(visible);
        buttonCloseAlert.setVisible(visible);
    }
}