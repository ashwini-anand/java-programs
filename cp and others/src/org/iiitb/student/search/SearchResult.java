package org.iiitb.student.search;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ButtonUI;

import org.iiitb.student.ImagePath;
import org.iiitb.student.WrapLayout;
import org.iiitb.student.Login.Login;
import org.iiitb.student.Login.Registration;
import org.iiitb.student.dl.ConnectionPool;
import org.iiitb.student.dl.Friend;
import org.iiitb.student.dl.Student;
import org.iiitb.student.newsfeed.Feed;
import org.iiitb.student.view.ViewPanel;

public class SearchResult extends JPanel implements ActionListener,
		FocusListener, WindowListener {
	JTextField searchfield;
	JButton search,seeall,logout,viewfriends,viewposts;
	GridBagConstraints gc;
	private Container container;
	private Feed feed;
	Student stud;
	public SearchResult(List<Student> slist, List<Friend> flist,Student s) {
		
			super();
			this.stud = s;
			//setSize(800,550);
			setLayout(new FlowLayout(FlowLayout.LEFT));
			searchfield=new JTextField(40);
			search=new JButton("Search");
			seeall=new JButton("See All");
			logout=new JButton("Logout");
			viewfriends=new JButton("View Friends");
			viewposts=new JButton("View Posts");
			seeall.addActionListener(this);
			search.addActionListener(this);
			logout.addActionListener(this);
			viewfriends.addActionListener(this);
			viewposts.addActionListener(this);
			JPanel bl = new JPanel();
			bl.setLayout(new BoxLayout(bl, BoxLayout.Y_AXIS));
			JPanel fl0 = new JPanel(new WrapLayout(FlowLayout.RIGHT,60,5));
			JLabel welText = new JLabel("Search your friends");
			welText.setFont(new Font("Algerian", Font.BOLD, 20));
			fl0.add(welText);
			fl0.add(Box.createHorizontalStrut(429));
			fl0.add(viewposts);
			fl0.add(viewfriends);
			fl0.add(logout);
			bl.add(fl0);
			JPanel fl1 = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
			fl1.add(searchfield);
			fl1.add(search);
			fl1.add(seeall);
			//add(newLine);
			bl.add(fl1);
			//JPanel fl2 = new JPanel(new FlowLayout(FlowLayout.LEFT,50,20));
			JPanel fl2 = new JPanel(new WrapLayout(FlowLayout.LEFT,50,20));
			for (final Student student : slist) {
				ImageIcon img;
				final JPanel pl = new JPanel();
				pl.setLayout(new BoxLayout(pl,BoxLayout.Y_AXIS));
				//System.out.println(this.getClass().getResource("").getPath());
				 java.net.URL imgURL = (new ImagePath()).getClass().getResource(student.getProfilePic());
				 if (imgURL != null) {
					  img = new ImageIcon((new ImagePath()).getClass().getResource(student.getProfilePic()));
				    } else {
				    	img = null;
				        System.err.println("Couldn't find file: " + student.getProfilePic());
				    }
				
				Image image = img.getImage(); 
				Image newimg = image.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
				img = new ImageIcon(newimg);
				JLabel jl = new JLabel(img);
				JLabel Jname = new JLabel(student.getUserName());
			//	JButton Jadd = new JButton("Add Friend",img);
				pl.add(jl);
				pl.add(Jname);
				boolean isFriend = false;
				for (Friend friend : flist) {
					if(student.getRollNo().equalsIgnoreCase(friend.getFrieldroll_no())){
						isFriend = true;
						break;
					}
				}
				if(!isFriend){
				final JButton Jadd = new JButton("Add Friend");
				Jadd.setFont(new Font("Arial", Font.PLAIN, 20));
				Jadd.setPreferredSize(new Dimension(50, 25));
				Jadd.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	try {
							PreparedStatement ps=ConnectionPool.getConnection().prepareStatement("insert into friends values(?,?)");
							ps.setString(1, stud.getRollNo());
							ps.setString(2, student.getRollNo());
							ps.executeUpdate();
							PreparedStatement ps1=ConnectionPool.getConnection().prepareStatement("insert into friends values(?,?)");
							ps1.setString(1, student.getRollNo());
							ps1.setString(2, stud.getRollNo());
							ps1.executeUpdate();
							Jadd.setVisible(false);
							pl.add(Box.createVerticalStrut(25));
							//pl.add(Box.createHorizontalStrut(1));
							JOptionPane.showMessageDialog(null,"Added as your friend","Success",JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
			        }
			    });
				pl.add(Jadd);
				}else{
					pl.add(Box.createVerticalStrut(25));
				}
				fl2.add(pl);
			}
			bl.add(fl2);
			add(bl);
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
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("herre");
		PreparedStatement ps;
		ResultSet rs = null;
		List<Student> slist = null;
		List<Friend> flist = null;
		if(e.getSource()==seeall || e.getSource()==search){
		if(e.getSource()==seeall)
		{  
		    slist = new ArrayList<Student>();
			try {
				ps=ConnectionPool.getConnection().prepareStatement("select roll_no,username,pic_id from students where roll_no != ?");
				ps.setString(1, this.stud.getRollNo());
			    rs = ps.executeQuery();
				while (rs.next()) { 
					Student st = new Student();
					String uname = rs.getString("username");
					String pic  = rs.getString("pic_id");
					String roll_no  = rs.getString("roll_no");
					//System.out.println(uname+" "+pic);
					st.setUserName(uname);
					st.setProfilePic(pic);
					st.setRollNo(roll_no);
					slist.add(st);
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		if(e.getSource()==search)
		{  
		    slist = new ArrayList<Student>();
		    String searchString = searchfield.getText();
			try {
				ps=ConnectionPool.getConnection().prepareStatement("select roll_no,username,pic_id from students where roll_no != ? and roll_no LIKE '%"+searchString+"%'");
				ps.setString(1, this.stud.getRollNo());
				rs = ps.executeQuery();
			    if (!rs.isBeforeFirst() ) {    
			    	ps=ConnectionPool.getConnection().prepareStatement("select roll_no,username,pic_id from students where roll_no != ? and username LIKE '%"+searchString+"%'");
			    	ps.setString(1, this.stud.getRollNo());
			    	rs = ps.executeQuery();
			    } 
				while (rs.next()) { 
					Student st = new Student();
					String uname = rs.getString("username");
					String pic  = rs.getString("pic_id");
					String roll_no  = rs.getString("roll_no");
					//System.out.println(uname+" "+pic);
					st.setUserName(uname);
					st.setProfilePic(pic);
					st.setRollNo(roll_no);
					slist.add(st);
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	  try {
		ps=ConnectionPool.getConnection().prepareStatement("select * from friends where roll_no = ?");
		ps.setString(1, this.stud.getRollNo());
	    rs = ps.executeQuery();
	    flist = new ArrayList<Friend>();
	    while (rs.next()) { 
			Friend f = new Friend();
			String friendroll_no = rs.getString("friendroll_no");
			//System.out.println(uname+" "+pic);
			f.setFrieldroll_no(friendroll_no);
			f.setRoll_no("mt2015001");
			flist.add(f);
		  }
	   } catch (SQLException e1) {
			e1.printStackTrace();
		}
	    SearchResult ss = new SearchResult(slist,flist,this.stud);
		JScrollPane scrollPane = new JScrollPane(ss);
		scrollPane.setMinimumSize(new Dimension(1366,768));
		scrollPane.setPreferredSize(new Dimension(1366,768));
		
		JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.getContentPane().removeAll();
		topFrame.add(scrollPane);
		topFrame.getContentPane().invalidate();
		topFrame.getContentPane().validate();
		topFrame.getContentPane().repaint();
	}
		if(e.getSource()==logout) 
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
		if(e.getSource()==viewfriends) 
    	{   
			List<Student> l= new ArrayList<Student>();
    	  try{
    		PreparedStatement ps1=ConnectionPool.getConnection().prepareStatement("select * from students ,friends where students.roll_no = friends.friendroll_no and friends.roll_no = ?");
    		ps1.setString(1, this.stud.getRollNo());
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				Student s=new Student();
				String uname=rs1.getString("username");
				String pic=rs1.getString("pic_id");
				String cour=rs1.getString("course");
				String  gen=rs1.getString("gender");
				s.setUserName(uname);
				s.setProfilePic(pic);
				s.setCourses(cour);
				s.setGender(gen);
				l.add(s);
			}
    	  }catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			ViewPanel vw=new ViewPanel(l,this.stud);
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
		if(e.getSource()==viewposts)
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
