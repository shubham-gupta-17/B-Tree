package oui;

import java.awt.*;
import javax.swing.*;

// JFrame is a class of java with which we can make a window
public class App extends JFrame {
	// structure of window
	JTabbedPane tabPane;  // our window will contains tab which are listed below 
	// objects of my windows
	HomePanel homePanel;
	DataPanel dataPanel;
	IndexPanel indexPanel;
	QueryPanel queryPanel;
	
	public App() {
		tabPane = new JTabbedPane();   // created object of tabpane
		// set the properties of our tabpane
		tabPane.setFont(new Font("Comic Sans MS", 1, 30));   
		tabPane.setBackground(Color.DARK_GRAY);
		tabPane.setForeground(Color.WHITE);
		
		homePanel = new HomePanel(tabPane);
		dataPanel = new DataPanel(tabPane);
		indexPanel = new IndexPanel(tabPane);
		queryPanel = new QueryPanel(tabPane);
		
		// after creating tabPane for our 4 tabs we have to add these tabs in our window also which is done by add function
		super.add(tabPane);
		
		pack();
		
		super.setTitle("RDBMS Index Implementation");  // title to be shown on front
		super.setExtendedState(MAXIMIZED_BOTH); // set the size of window to the max size of computer
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //this is one of the main property as when you close (x) th program the window and task must closed down
		                                                   // if this is not done than even on closing our program will keep on running by JVM and machine got hanged JVM is similar to VLC
		super.setVisible(true);   //means the window must be visible is this is not set to true then window will not show up
		
	}
}
