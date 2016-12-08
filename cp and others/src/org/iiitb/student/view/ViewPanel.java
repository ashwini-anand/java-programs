package org.iiitb.student.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import org.iiitb.student.ImagePath;
import org.iiitb.student.WrapLayout;
import org.iiitb.student.Login.Login;
import org.iiitb.student.Login.Registration;
import org.iiitb.student.dl.Student;
import org.iiitb.student.newsfeed.Feed;
import org.iiitb.student.search.Search;

public class ViewPanel extends JPanel implements ActionListener,
		WindowListener, FocusListener {
	JButton logout,searchfriends,viewposts;
	private Container container;
	private Feed feed;
	Student stud;
	public ViewPanel(List<Student> l, Student stud){
		super();
		this.stud = stud;
		setLayout(new WrapLayout(FlowLayout.LEFT,400,20));
		JPanel jl = new JPanel();
		jl.setLayout(new BoxLayout(jl, BoxLayout.Y_AXIS));
		logout=new JButton("Logout");
		searchfriends=new JButton("Search Friends");
		viewposts=new JButton("View Posts");
		logout.addActionListener(this);
		searchfriends.addActionListener(this);
		viewposts.addActionListener(this);
		JPanel fl0 = new JPanel(new WrapLayout(FlowLayout.RIGHT,20,0));
		
		fl0.add(Box.createHorizontalStrut(300));
		fl0.add(viewposts);
		fl0.add(searchfriends);
		fl0.add(logout);
		jl.add(fl0);
		System.out.println(l.size());
//		JPanel hpanel = new JPanel();
//		hpanel.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
//		JLabel imglabel = new JLabel("Image");
//		JLabel namelabel = new JLabel("Name");
//		JLabel clabel = new JLabel("Course");
//		JLabel glabel = new JLabel("Gender");
//		hpanel.add(imglabel); hpanel.add(namelabel); hpanel.add(clabel); hpanel.add(glabel);
//		
//		jl.add(hpanel);
		for (Student student : l) {
			JPanel jp = new JPanel();
			jp.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
			jp.setBackground(Color.decode("#bcc6cc"));
			Border b = BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true);
			jp.setBorder(b);
			System.out.println(getClass().getResource("").getPath());
			System.out.println(student.getProfilePic());
		    ImageIcon img = new ImageIcon((new ImagePath()).getClass().getResource(student.getProfilePic()));
		    JLabel jimg = new JLabel(img);
		    JLabel jname = new JLabel(student.getUserName());
		    jname.setFont(new Font("Algerian", Font.BOLD+Font.ITALIC, 30));
		    JLabel jcourses = new JLabel(student.getCourses());
		    jcourses.setFont(new Font("Algerian", Font.BOLD+Font.ITALIC, 30));
		    JLabel jgender = new JLabel(student.getGender().equals("M") || student.getGender().equals("m")?"Male" : "Female");
		    jgender.setFont(new Font("Algerian", Font.BOLD+Font.ITALIC, 30));
		    jp.add(jimg);
		    jp.add(jname);
		    jp.add(jcourses);
		    jp.add(jgender);
		    jl.add(jp);
		}
		   add(jl);
		
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent i) {
		if(i.getSource()==logout) 
    	{
    		JPanel jp = new JPanel(new FlowLayout());
			JFrame topFrame=(JFrame)SwingUtilities.getWindowAncestor(this);
			Registration r1= new Registration();
			Login r2= new Login();
			setSize(1366,768);
			
			jp.add(r2);
			r2.setPreferredSize(new Dimension(400,700));
			jp.add(r1);
			r1.setPreferredSize(new Dimension(700,700));
			
			topFrame.getContentPane().removeAll();
			topFrame.add(jp);
			topFrame.getContentPane().invalidate();
			topFrame.getContentPane().validate();
			topFrame.getContentPane().repaint();
    	}
		if(i.getSource()==searchfriends) 
    	{
    		Search ss = new Search(this.stud);
			JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
			System.out.println(topFrame.getClass()+", "+this.getClass());
			topFrame.getContentPane().removeAll();
			topFrame.add(ss);
			topFrame.getContentPane().invalidate();
			topFrame.getContentPane().validate();
			topFrame.getContentPane().repaint();
    	}
		if(i.getSource()==viewposts)
		{
			try {
					
				    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
					container=topFrame.getContentPane();
					feed= new Feed(this.stud);
					feed.setBounds(0, 0,1366,768);
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
								
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
		}

	}

}