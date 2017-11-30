
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


//
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.indico.api.results.IndicoResult;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
//
import io.indico.Indico;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.utils.IndicoException;




public class JavaFX extends Application {


    private Desktop desktop = Desktop.getDesktop();
    @Override
    public void start(Stage primaryStage)  {

        primaryStage.setTitle("Foto recognize");

        final BorderPane inputBorderPane = new BorderPane();


        FileChooser fileChooser = new FileChooser();
        //fileChooser.setInitialDirectory(new File(System.getProperty("D:")));
        Button openButton = new Button("open picture");

        openButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                File file = fileChooser.showOpenDialog(primaryStage);
                if(file != null){
                    BarChart<String, Number> chart;

                    Image img = new Image("file:"+file.getAbsolutePath());
                    ImageView iv = new ImageView();
                    iv.setImage(img);
                    //openFile(file);

                    chart=makeChart(indicoFoto(file));//tworzenie wykresu na podstawie statystyki indico
                    inputBorderPane.setRight(iv);
                    inputBorderPane.setCenter(chart);
                }
            }
        });

        //File file = new File("D:\\programowanie obiektowe\\lab6\\src\\lab6\\foto\\bocian.jpg");

        inputBorderPane.setTop(openButton);

        primaryStage.setScene(new Scene(inputBorderPane,600,400));
        primaryStage.show();
    }
    // pozniej dodac BarChart<String,Number>
    private BarChart<String,Number> makeChart(Map<String, Double> mapToChart){

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        BarChart<String,Number> chart = new BarChart<String, Number>(xAxis,yAxis);

        chart.setTitle("What is this ??");
        xAxis.setLabel("Object");
        yAxis.setLabel("Value");

        XYChart.Series series= new XYChart.Series();
        series.setName("chance");
        int i =0;

        for (String key:mapToChart.keySet()){
            if(i==5){
                break;
            }
            series.getData().add(new XYChart.Data(key,mapToChart.get(key)));
            i++;
        }
        chart.getData().addAll(series);
        return chart;
    }
    private void openFile(File file){
        try {
           desktop.open(file);
        }catch (IOException e){
            e.printStackTrace();

        }
    }




    public Map<String, Double> indicoFoto(File file){

        Indico indico = null;
        try {
            indico = new Indico("5f72fbd4b516e8c96976b8033fac0515");
        } catch (IndicoException e) {
            e.printStackTrace();
        }
        IndicoResult single = null;
        try {
            single = indico.imageRecognition.predict(
                    file.getAbsolutePath()
            );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IndicoException e) {
            e.printStackTrace();
        }
        Map<String, Double> result = null;
        Map<String, Double> result2 = null;
        try {
            result = single.getImageRecognition();
        } catch (IndicoException e) {
            e.printStackTrace();
        }
        int i=0;
        MapSort sorter = new MapSort();
        result=sorter.sort(result);


        for (String key:result.keySet()){
            if(i==5){
                break;
            }
            //result2.put(key,result.get(key));
            System.out.println(key+"::"+result.get(key));
            i++;
        }

        //System.out.println(result);
        //System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
