package com.example.co_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ChangePannel {

    public ChangePannel(){

    }

    @FXML
    private Button welcome_button;
    @FXML
    private Button digits;
    @FXML
    private Button backDigits;
    @FXML
    private Button floating;
    @FXML
    private Button caching;
    @FXML
    private Button digitsstart;
    @FXML
    private TextField digitstime;
    @FXML
    private TextField digitsscore;

    public void changePannel(ActionEvent event) throws IOException{
        Pannel();
    }

    private void Pannel() throws IOException {
        Main m = new Main();

        m.changeScene("afterHello.fxml");
    }

    public void changeDigits(ActionEvent event) throws IOException{
        Digits();
    }

    private void Digits() throws IOException {
        Main m = new Main();

        m.changeScene("afterDigits.fxml");
    }

    public void changeFloating(ActionEvent event) throws IOException{
        Floating();
    }

    private void Floating() throws IOException {
        Main m = new Main();

        m.changeScene("afterFloating.fxml");
    }

    public void changeCaching(ActionEvent event) throws IOException{
        Caching();
    }

    private void Caching() throws IOException {
        Main m = new Main();

        m.changeScene("afterCaching.fxml");
    }

    public void printValue(ActionEvent event) throws IOException{
        digitstime.setText(DigitsOfPi.printValueOfPi() + " Miliseconds");
        digitsscore.setText((DigitsOfPi.printScore()));
    }


}
