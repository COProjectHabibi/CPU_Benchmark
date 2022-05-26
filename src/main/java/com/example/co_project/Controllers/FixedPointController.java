package com.example.co_project.Controllers;

import com.example.co_project.Main;
import com.example.co_project.benchmark.CPUFixedPoint;
import com.example.co_project.benchmark.IBenchmark;
import com.example.co_project.benchmark.PiSpigot;
import com.example.co_project.logging.ConsoleLogger;
import com.example.co_project.logging.ILogger;
import com.example.co_project.logging.TimeUnit;
import com.example.co_project.testbanch.TestCPUFixedVsFloatingPoint;
import com.example.co_project.timing.ITimer;
import com.example.co_project.timing.Timer;
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

import static com.example.co_project.testbanch.TestCPUFixedVsFloatingPoint.*;

public class FixedPointController implements Initializable{

    public FixedPointController(){

    }

    @FXML
    private TextField scoreTextField;
    @FXML
    private Button backFloating;
    @FXML
    private ChoiceBox<String> optionsChoiceBox;
    @FXML
    private TextField optionsTextField;
    @FXML
    private TextField timeTextField;
    @FXML
    private TextField workloadTextField;
    @FXML
    private Label wrongCreate;
    private String [] opt = {"0","1","2"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        optionsChoiceBox.getItems().addAll(opt);
    }

    public void changePannel(ActionEvent event) throws IOException{
        Pannel();
    }

    private void Pannel() throws IOException {
        Main m = new Main();

        m.changeScene("afterHello.fxml");
    }
/*
    public void changeFloating(ActionEvent event) throws IOException{
        Floating();
    }
*/
    private void Floating() throws IOException {
        Main m = new Main();

        m.changeScene("afterFloating.fxml");
    }


    public void printValueFixed(@NotNull ActionEvent actionEvent) throws IOException {
        setWorkload(Integer.parseInt(workloadTextField.getText()));
        setOption(Integer.parseInt((optionsChoiceBox.getValue())));

        ITimer timer = (ITimer) new Timer();
        ILogger log =  new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.Nano;

        IBenchmark bench= new CPUFixedPoint();
        bench.initialize(Integer.parseInt(workloadTextField.getText()));		//get workload
        bench.warmUp();


        double time1 = timer.start();
        bench.run(Integer.parseInt((optionsChoiceBox.getValue())));	// get option 0 1 2
        bench.getResult();
        double time2 = timer.stop();
        time = time2 - time1;
        log.writeTime("Finished in", (long) time, timeUnit);
        log.write("Result is", bench.getResult());

        int OP = ((CPUFixedPoint) bench).getOP();
        MOPS = (OP * (Integer.parseInt((workloadTextField.getText())) * 1000.0 )) / time  ;
        //System.out.println("workload " + workload + " option " +option+ " Mops "+ MOPS + " time " + time);

        log.write("MOPS: ",MOPS);

        //bench.clean();
        log.close();

        timeTextField.setText(String.valueOf(getTime()));
        scoreTextField.setText(String.valueOf(getMOPS()));
        System.out.println(optionsChoiceBox.getValue());
        System.out.println(workloadTextField.getText());


    }


}
