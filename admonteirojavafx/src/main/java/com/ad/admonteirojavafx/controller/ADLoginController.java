package com.ad.admonteirojavafx.controller;

import com.ad.admonteirojavafx.exchanger.ExchangerPages;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ADLoginController {

    private ExchangerPages exchangerPages = new ExchangerPages();

    @FXML
    private PasswordField password;

    @FXML
    public void loginButton(ActionEvent event) {

        System.out.println("Senha: "+ password.getText());
        try {
            exchangerPages.exchangePageHome(event);
        } catch (IOException e) {
            System.out.println("deu erro");
            e.printStackTrace();
        }
    }

    @FXML
    public void exit(ActionEvent event){
        exchangerPages.close(event);
    }

}