package com.example.co_project.Controllers;

import com.example.co_project.Main;
import com.example.co_project.benchmark.PiSpigot;
import com.example.co_project.testbanch.TestCPUFixedVsFloatingPoint;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.NotNull;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
    @FXML
    private TextField mainTextField;
    @FXML
    private TextField digitsvalue;

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

    public void printValue(@NotNull ActionEvent actionEvent) throws IOException {

        digitsscore.setVisible(true);
        digitsvalue.setVisible(true);
        int nb_of_digits = Integer.parseInt(mainTextField.getText());
        PiSpigot spigot = new PiSpigot();
        spigot.digits_requested = nb_of_digits;
        ArrayList<Integer> score = new ArrayList<Integer>();
        for (int i = 0; i <= 10; i++) {
            long start = System.nanoTime();
            spigot.piString = "";
            spigot.run();
            long end = System.nanoTime();
            long elapsedTime = (end - start) / 10000;
            digitstime.setText(String.valueOf(elapsedTime));
            double individualScore = nb_of_digits / Math.sqrt(elapsedTime);
            //System.out.println(individualScore);
            score.add(i, (int) individualScore);
        }
        double sum = 0;
        for (double individualScore : score){
            sum += individualScore;
        }
        double finalScore = sum / 10;
        score.clear();
        digitsscore.setText(String.valueOf(finalScore));
        digitsvalue.setText(spigot.piString);

    }


}
