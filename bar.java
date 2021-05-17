import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class bar extends Application {
	
    
    @Override public void start(Stage stage) {
        stage.setTitle("T&T Subsea");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("T&T Subsea");
        
 
        XYChart.Series series = new XYChart.Series();
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("");
        sc.next();
        
        
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }

    public void modifyFile(String oldString, String newString) 
    {
        
        
        String oldContent = "";
         
        BufferedReader reader = null;
         
        FileWriter writer = null;
        
        
       
        try
        {
            reader = new BufferedReader(new FileReader(save));
             
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             
            while (line != null) 
           {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
                
            }
             
            //Replacing oldString with newString in the oldContent
             
            String newContent = oldContent.replaceAll(oldString, newString);
            
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(save);
            writer.write(newContent);
            writer.close();
           
           
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}