package org.iiitb.student;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ButtonUI;

public class SearchResult extends JPanel implements ActionListener,
		FocusListener, WindowListener {
	JTextField searchfield;
	JButton search,seeall;
	GridBagConstraints gc;
	public SearchResult(List<Student> slist, List<Friend> flist) {
		
			super();
			//setSize(800,550);
			setLayout(new FlowLayout(FlowLayout.LEFT));
			searchfield=new JTextField(40);
			search=new JButton("Search");
			seeall=new JButton("See All");
			seeall.addActionListener(this);
			search.addActionListener(this);
			JPanel bl = new JPanel();
			bl.setLayout(new BoxLayout(bl, BoxLayout.Y_AXIS));
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
				Jadd.setFont(new Font("Arial", Font.PLAIN, 10));
				Jadd.setPreferredSize(new Dimension(50, 25));
				Jadd.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	try {
							PreparedStatement ps=ConnectionPool.getConnection().prepareStatement("insert into friends values('mt2015001',?)");
							ps.setString(1, student.getRollNo());
							ps.executeUpdate();
							Jadd.setVisible(false);
							pl.add(Box.createVerticalStrut(25));
							//pl.add(Box.createHorizontalStrut(1));
							JOptionPane.showMessageDialog(null,"Data Inserted Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
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
	}

}
