package org.iiitb.student.newsfeed;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import org.iiitb.student.ImagePath;
import org.iiitb.student.Login.Login;
import org.iiitb.student.Login.Registration;
import org.iiitb.student.dl.ConnectionPool;
import org.iiitb.student.dl.PopulatePosts;
import org.iiitb.student.dl.Post;
import org.iiitb.student.dl.Student;
import org.iiitb.student.search.Search;
import org.iiitb.student.view.ViewPanel;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class Feed extends JPanel 
{   
	Student st;
	public Feed(Student s)
	{  
		try{
			Border loweredborder=BorderFactory.createLineBorder(Color.BLACK);
			setSize(1366,768);
			setLayout(new BorderLayout());
			panelTop pt=new panelTop(s);
			pt.setSize(WIDTH, 60);
			pt.setBorder(BorderFactory.createTitledBorder(loweredborder));
		    add(pt,BorderLayout.NORTH);
		    panelCenter pr=new panelCenter(s);
			add(pr,BorderLayout.CENTER);
			pr.setBorder(BorderFactory.createTitledBorder(loweredborder,""));
			JPanel dummyR=new JPanel();
			dummyR.setPreferredSize(new Dimension(50,700));
			add(dummyR,BorderLayout.EAST);
			panelLeft pl=new panelLeft(s);
			pl.setPreferredSize(new Dimension(280,700));
			add(pl,BorderLayout.WEST);
			pl.setBorder(BorderFactory.createTitledBorder(loweredborder));

			
		   }catch(Exception e){
			System.out.println("Error" + e);
		      }
    }
		
	}
class panelTop extends JPanel implements ActionListener
{
	JButton searchButton;
	JButton logoutButton;
	JButton viewButton;
	Student student;
    public panelTop(Student s)
    {   this.student = s;
    	setLayout(new GridLayout(1,4));
    	setBackground(Color.LIGHT_GRAY);
    	setPreferredSize(new Dimension(1366,50));
    	
		JPanel topmiddle=new JPanel();
		JPanel topright=new JPanel();
		JPanel topCenter=new JPanel();
		
		topmiddle.setPreferredSize(new Dimension(566, 40));
		topmiddle.setBackground(Color.LIGHT_GRAY);
		topright.setPreferredSize(new Dimension(300, 40));
		topright.setBackground(Color.LIGHT_GRAY);
		topCenter.setBackground(Color.LIGHT_GRAY);
		
    	JLabel welcomeLable=new JLabel("WELCOME TO NEWS FEED ..");
    	welcomeLable.setFont(new Font("Serif", Font.BOLD, 16));
    	
    	logoutButton=new JButton("Logout");
    	logoutButton.setPreferredSize(new Dimension(100, 35));
    	logoutButton.setFont(new Font("Serif", Font.BOLD,14));
    	logoutButton.addActionListener(this);
    	topright.add(logoutButton);
    	
    	searchButton=new JButton("Search Friends");
    	searchButton.setPreferredSize(new Dimension(100, 35));
    	searchButton.setFont(new Font("Serif", Font.BOLD,14));
    	searchButton.addActionListener(this);
    	topmiddle.add(searchButton);
    	
    	
    	viewButton=new JButton("View Friends");
    	viewButton.setPreferredSize(new Dimension(150, 35));
    	viewButton.setFont(new Font("Serif", Font.BOLD,14));
    	viewButton.addActionListener(this);
    	topCenter.add(viewButton);
    	
    	add(welcomeLable);
    	add(topmiddle);
    	add(topCenter);
    	add(topright);
    }
     public void actionPerformed(ActionEvent i)
     {
    	if(i.getSource()==searchButton) 
    	{
    		Search ss = new Search(this.student);
			JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
			System.out.println(topFrame.getClass()+", "+this.getClass());
			topFrame.getContentPane().removeAll();
			topFrame.add(ss);
			topFrame.getContentPane().invalidate();
			topFrame.getContentPane().validate();
			topFrame.getContentPane().repaint();
    	}
    	if(i.getSource()==viewButton) 
    	{   List<Student> l= new ArrayList<Student>();
    	  try{
    		PreparedStatement ps1=ConnectionPool.getConnection().prepareStatement("select * from students ,friends where students.roll_no = friends.friendroll_no and friends.roll_no = ?");
			ps1.setString(1, this.student.getRollNo());
    		ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				Student s=new Student();
				String uname=rs.getString("username");
				String pic=rs.getString("pic_id");
				String cour=rs.getString("course");
				String  gen=rs.getString("gender");
				s.setUserName(uname);
				s.setProfilePic(pic);
				s.setCourses(cour);
				s.setGender(gen);
				l.add(s);
			}
    	  }catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			ViewPanel vw=new ViewPanel(l,this.student);
			JScrollPane scrollPane = new JScrollPane(vw);
			scrollPane.setMinimumSize(new Dimension(1366,768));
			scrollPane.setPreferredSize(new Dimension(1366,768));
			
			JFrame topFrame=(JFrame)SwingUtilities.getWindowAncestor(this);
			topFrame.getContentPane().removeAll();
			topFrame.add(scrollPane);
			topFrame.getContentPane().invalidate();
			topFrame.getContentPane().validate();
			topFrame.getContentPane().repaint();
    	}
    	if(i.getSource()==logoutButton) 
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
     }
    
  }
class panelCenter extends JPanel  implements ActionListener
{   
	private java.util.List<Post> newList;
	GridBagConstraints gc=new GridBagConstraints();
	FlowLayout gt= new FlowLayout();
	JPanel jtop=new JPanel();
	JPanel jmiddle=new JPanel(new GridLayout(1,5));
	JPanel jnewsfeed=new JPanel();
	JButton jb=new JButton("Post");
	JTextArea ta;
	private Student student;
	JLabel title=new JLabel("News Feed ");
	Border loweredborder=BorderFactory.createLineBorder(Color.RED);
	
     public panelCenter(Student s)
     {   
    	 this.student = s;
    	 setPreferredSize(new Dimension(1066,700));
    		setLayout(gt);
    		setBackground(Color.LIGHT_GRAY);
    		 ta=new JTextArea();
    		 ta.setFont(new Font("Arial Black", Font.BOLD + Font.ITALIC,15));
    		ta.setEditable(true);
    		ta.setSize(950,200);
    		
    		JScrollPane scroll = new JScrollPane (ta);
    		scroll.setPreferredSize(new Dimension(950, 100));
    		
    		scroll.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791"),3)); 
    		scroll.getVerticalScrollBar();
    		jtop.add(scroll);
    		jtop.setVisible(true);
    		jtop.setBackground(Color.LIGHT_GRAY);
    		add(jtop);
    		
    		JPanel newstitle=new JPanel(new FlowLayout(FlowLayout.LEFT));
    		JPanel Buttons=new JPanel(new GridBagLayout());
    		JPanel Dummy=new JPanel();
    		JPanel Dummy1=new JPanel();
    		JPanel Dummy2=new JPanel();
    		Dummy.setBackground(Color.LIGHT_GRAY);
    		Dummy1.setBackground(Color.LIGHT_GRAY);
    		Dummy2.setBackground(Color.LIGHT_GRAY);
    		newstitle.setPreferredSize(new Dimension(100,35));
    		Buttons.setPreferredSize(new Dimension(100,35));
    		
    		title.setFont(new Font("Courier New", Font.ITALIC,20));
    		jmiddle.setPreferredSize(new Dimension(950,40));
    		jmiddle.setBackground(Color.LIGHT_GRAY);
    		newstitle.setBackground(Color.LIGHT_GRAY);
    		newstitle.add(title);
    		jmiddle.add(newstitle);
    		jb.setPreferredSize(new Dimension(100,35));
    		jb.addActionListener(this);
    		gc.gridx=1;
    		gc.gridy=1;
    		gc.gridwidth=2;
    		gc.gridheight=2;
    		Buttons.add(jb,gc);
    		Buttons.setBackground(Color.LIGHT_GRAY);
    		
    		Dummy.setVisible(true);
    		Dummy1.setVisible(true);
    		Dummy2.setVisible(true);
    		jmiddle.add(newstitle);
    		jmiddle.add(Dummy);
    		jmiddle.add(Dummy1);
    		jmiddle.add(Dummy2);
    		jmiddle.add(Buttons);	
    		jmiddle.setVisible(true);
    		add(jmiddle);
    		
    		jnewsfeed.setBackground(Color.WHITE);
    		jnewsfeed.setPreferredSize(new Dimension(950,500));
    		populateFeeds();
    		add(jnewsfeed);
     }
     
     public void actionPerformed(ActionEvent aae)
 	{
 		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 		 java.util.Date date = new java.util.Date();
 	     String roll_no=student.getRollNo();
 	     String text;
 		if(aae.getSource()==jb)
 		{ 
 			text=ta.getText();
 			
 			if(text.equals(""))
 			{
 				JOptionPane.showMessageDialog(this,"Please Write Some Post");
 			}
 			else
 			{
 			try
 			{
 				PreparedStatement ps=ConnectionPool.getConnection().prepareStatement("insert into posts(roll_no,content,timestap) values(?,?,?)");
 				ps.setString(1,roll_no);
 				ps.setString(2,text);
 				ps.setTimestamp(3, new java.sql.Timestamp(date.getTime()));
 				ps.executeUpdate();
 				JOptionPane.showMessageDialog(this,"Post Successfully sumbited..");
 				ta.setText("");
 			}
 			catch(Exception e)
 			{
 			    System.out.println("check" +e);	
 			}
 		    }
 		}

 	}

     public void populateFeeds()
 	{
     PopulatePosts pp=new PopulatePosts(this.student);
	 newList=pp.getList();
	 JPanel jta=new JPanel();
	 jta.setLayout(new BoxLayout(jta, BoxLayout.Y_AXIS));
	 for(Post post : newList)
	 {
		 
		 JPanel jp=new  JPanel(new GridLayout(1,3,20,50));
		 JLabel label1=new JLabel(post.getRoll_no());
		 int x=0;
		 String[] a={"","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
		
		 for(int i=0;i<post.getContent().length();i+=30)
		 {
			
			 if(post.getContent().length()-i>30)
			 {
			 a[x]=post.getContent().substring(i,i+30);
			 
			 }
			 else a[x]=" "+post.getContent().substring(i,post.getContent().length());
			 x++;
		 }
		 x--;
		 JPanel stringPanel=new JPanel();
		 stringPanel.setLayout(new BoxLayout(stringPanel, BoxLayout.Y_AXIS));
		 for(int j=0;j<=x;j++)
		 {
			 
			 stringPanel.add(new JLabel(a[j]));
		 }
		 JLabel label3=new JLabel(post.getTimestap().toString());
		 jp.add(label1);
		 jp.add(stringPanel);
		 jp.add(label3);
		 jta.add(jp);
	 }
	
    jnewsfeed.add(jta);	
}
}

class panelLeft extends JPanel
{
    public panelLeft(Student s)
    {   Student student = s;
        setLayout(new GridLayout(8,2));
        setBackground(Color.WHITE);
        BufferedImage myPicture;
        try{
          myPicture= ImageIO.read(new File("images/iiitb.jpeg"));
        JLabel picLabel=new JLabel(new ImageIcon(myPicture));
        picLabel.setPreferredSize(new Dimension(280,700));
        add(picLabel);
        }catch(Exception e)
        {
        	System.out.println("Feed IIITB Logo failed to upload");
        	e.printStackTrace();
        }
       
        JLabel pLabel=new JLabel("Profile");
        pLabel.setPreferredSize(new Dimension(60,30));
        pLabel.setFont(new Font("Serif", Font.ITALIC,25));
        
        ImageIcon img = null; 
        
        java.net.URL imgURL = (new ImagePath()).getClass().getResource(student.getProfilePic());
		 if (imgURL != null) {
			  img = new ImageIcon((new ImagePath()).getClass().getResource(student.getProfilePic()));
		    } else {
		    	img = null;
		        System.err.println("Couldn't find file: " + student.getProfilePic());
		}
        JLabel imageLabel=new JLabel(img);
        imageLabel.setPreferredSize(new Dimension(150,150));
        imageLabel.setBackground(Color.RED);
        
        JLabel userName=new JLabel(student.getUserName().toUpperCase());
        userName.setPreferredSize(new Dimension(60,30));
        userName.setFont(new Font("Arial", Font.ITALIC,18));
        userName.setForeground(Color.BLUE);
        userName.setHorizontalAlignment( SwingConstants.CENTER );
        
        JLabel rollName=new JLabel(student.getRollNo().toUpperCase());
        rollName.setPreferredSize(new Dimension(60,30));
        rollName.setFont(new Font("Arial",Font.ITALIC,18));
        rollName.setForeground(Color.BLUE);
        rollName.setHorizontalAlignment( SwingConstants.CENTER );
        
        JLabel emailId=new JLabel("<HTML><body>"+student.getEmailId().toUpperCase().substring(0, 9)+"</br>"+student.getEmailId().toUpperCase().substring(10,student.getEmailId().length())+"</body></html>");
        emailId.setPreferredSize(new Dimension(60,30));
        emailId.setFont(new Font("Arial",Font.ITALIC,18));
        emailId.setForeground(Color.BLUE);
      //  emailId.setHorizontalAlignment( SwingConstants.CENTER );
        
        JLabel course=new JLabel(student.getCourses().toUpperCase());
        course.setPreferredSize(new Dimension(60,30));
        course.setFont(new Font("Arial",Font.ITALIC,18));
        course.setForeground(Color.BLUE);
        course.setHorizontalAlignment( SwingConstants.CENTER );
        
        JLabel interset=new JLabel(student.getInterests().toUpperCase());
        interset.setPreferredSize(new Dimension(60,30));
        interset.setFont(new Font("Arial",Font.ITALIC,18));
        interset.setForeground(Color.BLUE);
        interset.setHorizontalAlignment( SwingConstants.CENTER );
     
        add(pLabel);
        add(imageLabel);
        add(rollName);
        add(userName);
        add(emailId);
        add(course);
        add(interset);
    }
}