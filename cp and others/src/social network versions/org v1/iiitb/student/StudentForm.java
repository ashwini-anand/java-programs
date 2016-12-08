package org.iiitb.student;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StudentForm extends JFrame implements ActionListener,FocusListener,WindowListener
{
	private static final long serialVersionUID = -4736770819687709788L;
	Container cc;
	JTextField name,age;
	JRadioButton male,female;
	ButtonGroup gender;
	JComboBox<String> city;
	JList<String> interest;
	JButton sub,res;
	GridBagConstraints gc;
	
	public StudentForm()
	{
		super("Student Form");
		setSize(500,500);
		setLayout(new GridBagLayout());
		cc=getContentPane();
		gc=new GridBagConstraints();
		
		name=new JTextField(10);
		age=new JTextField(10);
		gender=new ButtonGroup();
		male=new JRadioButton("Male");
		female=new JRadioButton("Female");
		String[] items={"Bangalore", "Andhra Pradesh", "Tamilnadu", "Kerela", "Maharashtra"};
		city=new JComboBox<String>(items);
		String[] listData={"Coding","Sports","Drawing","Dancing"};
		interest=new JList<String>(listData);
		sub=new JButton("Submit");
		res=new JButton("Reset");
		
		gender.add(male);
		gender.add(female);
		
		addComp(1,1,2,2,new JLabel("Name"));
		addComp(1,3,1,2,new JLabel(" : "));
		addComp(1,4,2,2,name);
		name.requestFocus();
		name.addFocusListener(this);

		addComp(3,1,2,2,new JLabel("Age"));
		addComp(3,3,1,2,new JLabel(" : "));
		addComp(3,4,2,2,age);	
		age.addFocusListener(this);

		addComp(5,1,2,2,new JLabel("Gender"));
		addComp(5,3,1,2,new JLabel(" : "));
		addComp(5,4,2,2,male);	
		addComp(5,6,2,2,female);

		addComp(7,1,2,2,new JLabel("City"));
		addComp(7,3,1,2,new JLabel(" : "));
		addComp(7,4,2,2,city);	
		
		addComp(9,1,2,2,new JLabel("Interests"));
		addComp(9,3,1,2,new JLabel(" : "));
		addComp(9,4,2,2,interest);	
		
		addComp(11,1,2,2,sub);
		sub.addActionListener(this);
		addComp(11,4,2,2,res);
		
		addWindowListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void addComp(int r, int c, int w, int h, Component comp)
	{
		gc.gridx=c;
		gc.gridy=r;
		gc.gridwidth=w;
		gc.gridheight=h;
		gc.fill=GridBagConstraints.BOTH;
		add(comp,gc);
	}
	
	public static void main(String[] a)
	{
		new StudentForm();
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
	
	}

	@Override
	public void windowClosing(WindowEvent e) {
		ConnectionPool1.closeConnection();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource()==age)
		{
			try
			{
				Integer.parseInt(age.getText().trim());
			}
			catch(NumberFormatException ne)
			{
				JOptionPane.showMessageDialog(null,"Age cannot contain characters","Error",JOptionPane.ERROR_MESSAGE);
				age.setText("");
				age.requestFocus();
			}
		}
		else if(e.getSource()==name)
		{
			if(name.getText()!=null)
			{
				JOptionPane.showMessageDialog(null,"Name field cannot be blank","Warning",JOptionPane.WARNING_MESSAGE);
				name.requestFocus();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sub)
		{
			String sname=name.getText();
			int sage=Integer.parseInt(age.getText().trim());
			try {
				PreparedStatement ps=ConnectionPool1.getConnection().prepareStatement("insert into Student(sname,sage) values(?,?)");
				ps.setString(1, sname);
				ps.setInt(2, sage);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null,"Data Inserted Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
}

class ConnectionPool1 {

	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost/demo";
	final static String USER = "username";
	final static String PASS = "password";
	static Connection con;
	static Connection getConnection()
	{
		if(con==null)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(DB_URL, USER, PASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	static void closeConnection()
	{
		try {
			if(con!=null)
				con.close();
			System.out.println("Connection Closed Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

