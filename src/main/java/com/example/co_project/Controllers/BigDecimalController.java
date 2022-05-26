package com.example.co_project.Controllers;

import com.example.co_project.Main;
import com.example.co_project.benchmark.CPUDigitsOfPi;
import com.example.co_project.benchmark.IBenchmark;
import com.example.co_project.logging.ConsoleLogger;
import com.example.co_project.logging.ILogger;
import com.example.co_project.logging.TimeUnit;
import com.example.co_project.timing.ITimer;
import com.example.co_project.timing.Timer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.co_project.testbanch.TestCPUFixedVsFloatingPoint.*;
import static com.example.co_project.testbanch.TestCPUFixedVsFloatingPoint.time;

public class BigDecimalController {

    @FXML
    private Label wrongCreate;

    @FXML
    private Button backCaching;

    @FXML
    private TextField nrDigitsBigDecimal; // unde luam scale

    @FXML
    private TextField resultBigDecimal; // pi

    @FXML
    private Button startBigDecimal;

    @FXML
    private TextField scoreBigDecimal; // score

    @FXML
    private TextField timeBigDecimal;   //timp

    public void changePannel(ActionEvent event) throws IOException{
        Pannel();
    }

    private void Pannel() throws IOException {
        Main m = new Main();

        m.changeScene("afterHello.fxml");
    }

    public void printBigDecimal(ActionEvent actionEvent) throws IOException {
        //setWorkload(Integer.parseInt(nrDigitsBigDecimal.getText()));
        checkBigDecimal();

        System.out.println(Integer.parseInt(nrDigitsBigDecimal.getText()));
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        IBenchmark bench = new CPUDigitsOfPi();

        TimeUnit timeUnit = TimeUnit.Milli;

        final long workload = 5000;
        final int scale;
        final int runs = 12;
        double temp2;
        double temp1 = 0;
        bench.initialize(workload,Integer.parseInt(nrDigitsBigDecimal.getText()));

        for (int i = 0; i <runs ; i++) {
            bench.warmUp();
        }

        for (int i = 0; i < runs; i++) {
            temp1 = timer.resume();
            bench.run();
            temp2 = timer.pause();

            log.writeTime("Run " + i + " finished in: ", (long) temp2, timeUnit);
        }
        temp2 = timer.stop();
        double temp = temp2 - temp1;
        System.out.println(((CPUDigitsOfPi)bench).getPi());
        resultBigDecimal.setText(String.valueOf(((CPUDigitsOfPi)bench).getPi()));
        log.writeTime("Finished in ", (long)temp, timeUnit);
        timeBigDecimal.setText(String.valueOf(temp + " " + timeUnit));

        MOPS = Math.pow((runs * (Integer.parseInt(nrDigitsBigDecimal.getText()) * 1000.0 )),2) / temp;
        scoreBigDecimal.setText(String.valueOf(MOPS + " cat paws"));
        System.out.println("Mops " + MOPS);
        log.close();
        bench.clean();

    }

    private void checkBigDecimal()throws IOException {
        String str= ((nrDigitsBigDecimal.getText()));
        wrongCreate.setVisible(true);
        boolean result = str.matches("[0-9]+");
        if (nrDigitsBigDecimal.getText().isEmpty()) {
            wrongCreate.setText("Please fill in the number in workload field");
        } else if (!result) {
            wrongCreate.setText("Only use digits");
        }else wrongCreate.setVisible(false);
    }

}
