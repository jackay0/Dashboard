import java.util.Arrays;
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
import java.text.NumberFormat;
import java.text.ParseException;

public class bar extends Application  {
	 File file = new File("/C://Users//0001081009//workspace//Dashboard//src//file.dat");
 	String[] names = new String[10];
 	Scanner ssee = new Scanner(file);
	
	
	public bar() throws FileNotFoundException
	{
		int place = 0;
		while(ssee.hasNextLine()) 
    	{	
			String s = ssee.nextLine();
			names[place] = s;
			
			place++;
    	}
		System.out.print(Arrays.toString(names));
	}
	
	
	
    @Override public void start(Stage stage) {
        stage.setTitle("T&T Subsea");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("T&T Subsea");
        
 
        XYChart.Series series = new XYChart.Series();
        Scanner sc = new Scanner(System.in);
        
        
        for(int i=0;i<names.length;i++) {
        	try {
				series.getData().add(new XYChart.Data(names[i],((Number)NumberFormat.getInstance().parse(names[i])).intValue()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
        
        
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
            reader = new BufferedReader(new FileReader(file));
             
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
             
            writer = new FileWriter(file);
            writer.write(newContent);
            writer.close();
           
           
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    
    public String current(int i ) {
    	
    	String current = names[i];
    	
    	
    	
    	return current;
    }
    
}