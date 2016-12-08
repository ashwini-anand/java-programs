package org.iiitb.student;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Search extends JPanel implements ActionListener, FocusListener,
		WindowListener {
	JTextField searchfield;
	JButton search,seeall;
	GridBagConstraints gc;
	
	public Search(){
		super();
		//setSize(500,500);
		//setLayout(new GridBagLayout());
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		searchfield=new JTextField(40);
		
		search=new JButton("Search");
		seeall=new JButton("See All");
		seeall.addActionListener(this);
		search.addActionListener(this);
		add(searchfield);
		add(search);
		add(seeall);
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
		if(e.getSource()==seeall)
		{  
		    slist = new ArrayList<Student>();
			try {
				ps=ConnectionPool.getConnection().prepareStatement("select roll_no,username,pic_id from students where roll_no != 'mt2015001'");
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
				ps=ConnectionPool.getConnection().prepareStatement("select roll_no,username,pic_id from students where roll_no != 'mt2015001' and roll_no LIKE '%"+searchString+"%'");
			    rs = ps.executeQuery();
			    if (!rs.isBeforeFirst() ) {    
			    	ps=ConnectionPool.getConnection().prepareStatement("select roll_no,username,pic_id from students where roll_no != 'mt2015001' and username LIKE '%"+searchString+"%'");
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
		ps=ConnectionPool.getConnection().prepareStatement("select * from friends where roll_no = 'mt2015001'");
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
		SearchResult ss = new SearchResult(slist,flist);
		JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.getContentPane().removeAll();
		topFrame.add(ss);
		topFrame.getContentPane().invalidate();
		topFrame.getContentPane().validate();
		topFrame.getContentPane().repaint();
		//topFrame.pack();
	}

}
