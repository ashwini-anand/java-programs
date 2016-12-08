package org.iiitb.student.Login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.iiitb.student.ConnectionPool;
import org.iiitb.student.Feed;
import org.iiitb.student.Student;

public class Login extends JPanel implements ActionListener
{
	JLabel enter,p1;
	JTextField tenter;
	JPasswordField tp1;
	JButton log;
	Border bGreyLine, bTitled1, bTitled2;
	private Container container;
	private Feed feed;
	public Login()
	{
		super();
		setBackground(Color.PINK);
		setPreferredSize(new Dimension(400,768));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		bGreyLine = BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true);
	    bTitled1 = BorderFactory.createTitledBorder(bGreyLine, "Roll Number/Email Id", TitledBorder.LEFT, TitledBorder.TOP);
	    bTitled2= BorderFactory.createTitledBorder(bGreyLine, "Password", TitledBorder.LEFT, TitledBorder.TOP);
		
		enter=new JLabel("Enter details to login: ");
		enter.setBorder(BorderFactory.createEmptyBorder(20,20,10,10));
		tenter=new JTextField(10);
		tenter.setBorder(bTitled1);
		tenter.setPreferredSize(new Dimension(100,50));
		p1=new JLabel("Password");
		tp1=new JPasswordField(10);
		tp1.setBorder(bTitled2);
		tp1.setPreferredSize(new Dimension(100,50));
		log=new JButton("Log In");
		log.addActionListener(this);
		setAlignmentX(Component.CENTER_ALIGNMENT);
		addComp(enter);
		addComp(tenter);
		addComp(tp1);
		addComp(log);
				
		setVisible(true);
	}

	
	public void addComp(JComponent c)
	{
		add(c);
		//c.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	}
		
	
	public static void main(String[] args) {
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==log)
		{
			List<Student> l=new ArrayList<Student>();
			
			try {
				if(!(InputValidator.isTextFieldEmpty(this,tenter,"Roll number or email required.",true)))
				{
					if(!(InputValidator.isTextFieldEmpty(this,tp1,"Password required.",true)))
					{
				    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
					container=topFrame.getContentPane();
					feed= new Feed();
					feed.setBounds(0, 0,1366,768);
					//container.setLayout(null);
				//	container.add(feed);
				   Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
				   topFrame.setSize(1366,768);
				   topFrame.setLocation((int)(dimension.width/2-(getWidth()/2)),(int)(dimension.height/2-(getHeight()/2)));
			   
				    
				   topFrame.setVisible(true);
				   topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
					//Search1 ss = new Search1();
				   topFrame.getContentPane().removeAll();
					//jp.setVisible(false);
					topFrame.add(feed);
					topFrame.getContentPane().invalidate();
					topFrame.getContentPane().validate();
					topFrame.getContentPane().repaint();
					}
				}
				
						
								
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

}
