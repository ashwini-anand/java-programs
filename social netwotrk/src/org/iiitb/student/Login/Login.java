package org.iiitb.student.Login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.iiitb.student.dl.ConnectionPool;
import org.iiitb.student.dl.Student;
import org.iiitb.student.newsfeed.Feed;

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
		setBackground(Color.decode("#2C3539"));
		setPreferredSize(new Dimension(400,768));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		bGreyLine = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);
	    bTitled1 = BorderFactory.createTitledBorder(bGreyLine, "Roll Number/Email Id", TitledBorder.LEFT, TitledBorder.TOP);
	    bTitled2= BorderFactory.createTitledBorder(bGreyLine, "Password", TitledBorder.LEFT, TitledBorder.TOP);
		
	    

		    JPanel top=new JPanel();   top.setBackground(Color.decode("#2C3539"));
		    JPanel center=new JPanel();   center.setBackground(Color.decode("#2C3539"));
			JPanel bottom=new JPanel();    bottom.setBackground(Color.decode("#2C3539"));
			JPanel lowest=new JPanel();		lowest.setBackground(Color.decode("#2C3539"));
			JPanel blank=new JPanel();		blank.setBackground(Color.decode("#2C3539"));
			blank.setPreferredSize(new Dimension(300,150));
			
		enter=new JLabel("Enter details to login: ");
		enter.setFont(new Font("Serif", Font.BOLD, 18));
	    enter.setForeground(Color.WHITE);
	
		tenter=new JTextField(20);
		tenter.setBorder(bTitled1);
		tenter.setPreferredSize(new Dimension(200,50));
		tenter.setFont(new Font("Serif", Font.ITALIC, 12));
		
		tp1=new JPasswordField(20);
		tp1.setBorder(bTitled2);
		tp1.setPreferredSize(new Dimension(200,50));
		
		
		log=new JButton("Log In");
		log.addActionListener(this);
		log.setFont(new Font("Serif", Font.BOLD, 18));
		log.setPreferredSize(new Dimension(100,40));
		
		top.add(enter);
		center.add(tenter);
		bottom.add(tp1);
		lowest.add(log);
		
		add(Box.createVerticalStrut(20));
		
		try{
			BufferedImage myPicture = ImageIO.read(new File("images/iiitb-logo.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		add(picLabel);  }
		catch (IOException ex) {
            ex.printStackTrace();
       }
		add(Box.createVerticalStrut(20));
		add(top);
		add(center);
		add(bottom);
		add(lowest); 
		add(blank);
						
		setVisible(true);
	}

	
			
	
	public static void main(String[] args) {
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==log)
		{
			
			try {
				if(!(InputValidator.isTextFieldEmpty(this,tenter,"Roll number or email required.",true)))
				{
					if(!(InputValidator.isTextFieldEmpty(this,tp1,"Password required.",true)))
					{
						String i1=tenter.getText();
					    String i2 = new String(tp1.getPassword());
						PreparedStatement ps1=ConnectionPool.getConnection().prepareStatement("select * from students where (roll_no=? or email=?)and password=?");
						ps1.setString(1,i1);
						ps1.setString(2,i1);
						ps1.setString(3,i2);
						ResultSet rs=ps1.executeQuery();
						if(rs.next())
						{
							Student s=new Student();
							String r=rs.getString("roll_no");
							String uname=rs.getString("username");
							String  e=rs.getString("email");
							String  p=rs.getString("password");
							String pic=rs.getString("pic_id");
							String  gen=rs.getString("gender");
							String cour=rs.getString("course");
							String  in=rs.getString("interest");
							String  ph=rs.getString("phone_no");
							
							s.setRollNo(r);
							s.setUserName(uname);
							s.setEmailId(e);
							s.setPassword(p);
							s.setProfilePic(pic);
							s.setGender(gen);
							s.setCourses(cour);
							s.setInterests(in);
							s.setPhoneNo(ph);
						
						
							
					JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
					container=topFrame.getContentPane();
					feed= new Feed(s);
					feed.setBounds(0, 0,1366,768);
					//container.setLayout(null);
				//	container.add(feed);
				   Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
				   topFrame.setSize(1366,768);
				   topFrame.setLocation((int)(dimension.width/2-(getWidth()/2)),(int)(dimension.height/2-(getHeight()/2)));
			   
				    
				   topFrame.setVisible(true);
				   topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			
				   topFrame.getContentPane().removeAll();

					topFrame.add(feed);
					topFrame.getContentPane().invalidate();
					topFrame.getContentPane().validate();
					topFrame.getContentPane().repaint();
					}
						else
						{
							JOptionPane.showMessageDialog(this, "Invalid data entered. Enter correct data.");
							
						}
				}
				}
				
						
								
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

}