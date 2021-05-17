import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
import java.util.Scanner;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class graph extends Application {
	
	
	
	private double total;
    private String d;
    private int e;
    
    
    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
    
    
    @Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Dashboard");
        stage.setWidth(500);
        stage.setHeight(500);
        
        
        
        
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("How many items in the pie chart?");
        
        int x = sc.nextInt();
        String[] nameArray = new String[x];
        int[] numArray = new int[x];
        
        
        
        for(int i = 0; i<x; i++) 
        {
        	 // array for names
        	 System.out.println("Name of this section in the pie chart:");
        	 d = sc.next();
        	 nameArray[i] = d;
        	 //array for numbers
        	 System.out.println("Number within this item:");
        	 e = sc.nextInt();
        	 numArray[i] = e;
        	 total = total+e;
        }
        
        
        for(int j = 0; j < nameArray.length ; j++) 
        {
        	
        	double pieChartint = numArray[j]/total;
        	
        	pieChartData.add(new PieChart.Data(nameArray[j], pieChartint*100));
        	
        	System.out.println(pieChartint);
        }
       
       
        
  
        //Pie Chart
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Dashboard");
        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
