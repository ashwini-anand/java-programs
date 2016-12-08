package org.iiitb.student.Login;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main_class extends JFrame{
	
	public Main_class()
	{
		super("IIIT B Student Portal");
		Registration r1= new Registration();
		JPanel jp = new JPanel(new FlowLayout());
		Login r2= new Login();
		setSize(1366,768);
		
		jp.add(r2);
		r2.setPreferredSize(new Dimension(400,700));
		jp.add(r1);
		r1.setPreferredSize(new Dimension(700,700));
		add(jp);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Main_class();
		
		
	}

}