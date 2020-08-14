package oui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;

public class DataPanel extends JPanel implements ActionListener {
	private JLabel lblRows;
	private JTextField txtRows;
	private JButton btnCreate;
	private JProgressBar progressBar;

	public DataPanel(JTabbedPane tabPane) {
		tabPane.addTab("Data", this);   // add the tab data in tabPane window
		initComponents();
	}

	private void initComponents() {
		this.setBorder(BorderFactory.createMatteBorder(25, 25, 25, 25, Color.darkGray));
		this.setBackground(new Color(0, 100, 0));

		lblRows = new JLabel();
		lblRows.setFont(new Font("Monospaced", 0, 50)); // NOI18N
		lblRows.setForeground(new Color(255, 255, 255));
		lblRows.setText("Rows:");

		txtRows = new JTextField("");
		txtRows.setColumns(10);
		txtRows.setFont(new Font("Monospaced", 0, 50)); // NOI18N

		btnCreate = new JButton();
		btnCreate.setFont(new Font("Monospaced", 0, 50)); // NOI18N
		btnCreate.setText("Create Test Data");

		btnCreate.addActionListener(this);  // this is important because after clicking this button our code for generating random data will get called


		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setFont(new Font("Monospaced", 0, 50));

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblRows, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtRows, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(
				layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(txtRows, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRows, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
				.addGap(50, 50, 50)
				.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(50, 50, 50)
				.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

	}

	// Whenever button is pressed this action will be performed
	@Override
	public void actionPerformed(ActionEvent e) {
		DataPanel obj = this;   // we are passing this to data manager such that it keep showing the status

	// we  are creating new thread class object, to make an object of thread we need an object which implements a runnable interface
		// class= thread
		// runnable = interface
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					int rows = Integer.parseInt(txtRows.getText());
					DataManager.CreateData(rows, obj);
					JOptionPane.showMessageDialog(obj, "Data created successfully");
					progressBar.setValue(0);
				} catch (Exception ex) {
				}
			}
		});
		t.start(); // start the thread and run function will start
	}
	
	public void updateStatus(int percent){
		progressBar.setValue(percent);
	}
}
