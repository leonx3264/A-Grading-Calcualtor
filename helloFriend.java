package hellofriend;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class helloFriend extends Application
{
	//launch window
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage Window1)
	{
		
		//set window title
		Window1.setTitle("Make Grading Great Again");
		
		//images
		Image title = new Image("file:C:\\Users\\User.GWC-2014-14-PC\\eclipse-workspace\\hellofriend\\pictures\\title.png");
		ImageView titleView = new ImageView(title);
		
		Image slogan = new Image("file:C:\\Users\\User.GWC-2014-14-PC\\eclipse-workspace\\hellofriend\\pictures\\slogan.png");
		ImageView sloganView = new ImageView(slogan);
		
		
		//buttons
		Button startButton = new Button("start");
		startButton.setOnAction(new calcGrade());
		
		//sub containers 
		VBox titlePlace = new VBox(titleView);
		titlePlace.setAlignment(Pos.TOP_CENTER);
		
		VBox sloganPlace = new VBox(sloganView);
		sloganPlace.setAlignment(Pos.BOTTOM_CENTER);
		
		VBox clickButton = new VBox(startButton);
		clickButton.setAlignment(Pos.BOTTOM_CENTER);
		
		//main container 
		VBox vertical = new VBox(25, titlePlace, sloganPlace, clickButton);
		
		//scene
		Scene scene1 = new Scene(vertical, 800, 600);
		Window1.setScene(scene1);
		Window1.show();
	}
	
	//button action
	//calls python function to calculate grade 
	class calcGrade implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent event)
		{
			String usrName;
			int attendanceChoice = 0;
			int attendPercent = 0;
			int attendGrade = 0;
			int attendTotal = 0;
			
			int assignPercent = 0;
			int assignChoice = 0;
			int assignGrade = 0;
			int assignTotal = 0;
			
			int quizChoice = 0;
			int quizPercent = 0;
			int quizGrade = 0;
			int quizTotal = 0;
			 
			int testChoice = 0;
			int testPercent = 0;
			int testGrade = 0;
			int testTotal = 0;
			
			int finalChoice = 0;
			int finalPercent = 0;
			int finalGrade = 0;
			int finalTotal = 0;
			
			String LetterGrade;
			
			//writes to file
			usrName = JOptionPane.showInputDialog("what is your name/name of student?");
			
			
			attendanceChoice = JOptionPane.showConfirmDialog(null, "Does attendance count?");
			if (attendanceChoice == JOptionPane.YES_OPTION)
			{
				attendPercent = Integer.parseInt((JOptionPane.showInputDialog("how much is attendance worth? (percent)")));
				attendGrade = Integer.parseInt((JOptionPane.showInputDialog("what was your grade?")));
				attendTotal = (attendPercent * attendGrade)/100;
			}
			else
			{
				attendPercent = 0;
				attendGrade = 0;
				attendTotal = 0;
			}
			
			assignChoice = JOptionPane.showConfirmDialog(null, "Do assignments count?");
			if (assignChoice == JOptionPane.YES_OPTION)
			{
				assignPercent = Integer.parseInt((JOptionPane.showInputDialog("how much are assignments worth? (overall)")));
				assignGrade = Integer.parseInt((JOptionPane.showInputDialog("what was your grade?")));
				assignTotal = (assignPercent * assignGrade)/100;
			}
			else
			{
				assignPercent = 0;
				assignGrade = 0;
				assignTotal = 0;
			}
			
			quizChoice = JOptionPane.showConfirmDialog(null, "Do quizzes count?");
			if (quizChoice == JOptionPane.YES_OPTION)
			{
				quizPercent = Integer.parseInt((JOptionPane.showInputDialog("how much are quizzes worth? (overall)")));
				quizGrade = Integer.parseInt((JOptionPane.showInputDialog("what was your grade?")));
				quizTotal = (quizPercent * quizGrade)/100;
			}
			else
			{
				quizPercent = 0;
				quizGrade = 0;
				quizTotal = 0;
			}
			
			testChoice = JOptionPane.showConfirmDialog(null, "Do test count?");
			if (testChoice == JOptionPane.YES_OPTION)
			{
				testPercent = Integer.parseInt((JOptionPane.showInputDialog("how much are tests worth? (overall)")));
				testGrade = Integer.parseInt((JOptionPane.showInputDialog("what was your grade?")));
				testTotal = (testPercent * testGrade)/100;
			}
			else
			{
				testPercent = 0;
				testGrade = 0;
				testTotal = 0;
			}
			
			finalChoice = JOptionPane.showConfirmDialog(null, "Does the final count?");
			if (finalChoice == JOptionPane.YES_OPTION)
			{
				finalPercent = Integer.parseInt((JOptionPane.showInputDialog("how much is the final worth? (overall)")));
				finalGrade = Integer.parseInt((JOptionPane.showInputDialog("what was your grade?")));
				finalTotal = (finalPercent * finalGrade)/100;
			}
			else
			{
				finalPercent = 0;
				finalGrade = 0;
				finalTotal = 0;
			}	
			
			
			try
			{
			PrintWriter outputFile = new PrintWriter("values.txt");
			outputFile.println(usrName);
			
			outputFile.println(attendanceChoice);
			outputFile.println(attendPercent);
			outputFile.println(attendGrade);
			outputFile.println(attendTotal);
			
			outputFile.println(assignChoice);
			outputFile.println(assignPercent);
			outputFile.println(assignGrade);
			outputFile.println(assignTotal);
			
			outputFile.println(quizChoice);
			outputFile.println(quizPercent);
			outputFile.println(quizGrade);
			outputFile.println(quizTotal);
			
			outputFile.println(testChoice);
			outputFile.println(testPercent);
			outputFile.println(testGrade);
			outputFile.println(testTotal);
			
			outputFile.println(finalChoice);
			outputFile.println(finalPercent);
			outputFile.println(finalGrade);
			outputFile.println(finalTotal);
			
			outputFile.close();
			}
			catch (IOException e)
			{
				System.out.println("error found");
			}
			//runs python calculation script
			try 
			{
				Process p = Runtime.getRuntime().exec("cmd /c C:\\Users\\User.GWC-2014-14-PC\\eclipse-workspace\\hellofriend\\script.py");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			File finalFile = new File("final.txt");
			try 
			{
				Scanner outputFile = new Scanner(finalFile);
				LetterGrade = outputFile.nextLine();
				String finalMessage = ("The Final Grade is a(n) " + LetterGrade);
				
				JOptionPane.showMessageDialog(null, finalMessage);
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}

			
			
			
			System.exit(0);
			
		}
	}

}
