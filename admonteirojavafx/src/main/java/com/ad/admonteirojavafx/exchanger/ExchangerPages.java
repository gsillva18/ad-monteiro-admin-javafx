package com.ad.admonteirojavafx.exchanger;

import com.ad.admonteirojavafx.ADApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ExchangerPages {

    private Stage stage;
    private Scene scene;
    private Parent parent;

    public void exchangePageLogin(ActionEvent event) throws IOException {
        parent = FXMLLoader.load(ADApplication.class.getResource("login/ad-login.fxml"));
        init(event);
    }

    public void exchangePageHome(ActionEvent event) throws IOException{
        parent = FXMLLoader.load(ADApplication.class.getResource("home/ad-home.fxml"));
        init(event);
    }

    public void exchangePageDelete(ActionEvent event) throws IOException{
        parent = FXMLLoader.load(ADApplication.class.getResource("delete/ad-delete.fxml"));
        init(event);
    }

    private void init(ActionEvent event) throws IOException{
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.centerOnScreen();
    }

    public void close(ActionEvent event){
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
