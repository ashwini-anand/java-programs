package org.iiitb.student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import org.iiitb.student.dl.PopulatePosts;
import org.iiitb.student.dl.Post;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Feed extends JPanel implements ActionListener
{   private java.util.List<Post> newList;
    private JLabel name;
	private JButton post;
	private JButton searchFriend;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JPanel upperPanel,lowerPanel,textareaPanel;
	private String text;
	private String roll_no;
	public Feed()
	{
		try{
			//setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			setLayout(new FlowLayout());
			setSize(900,650);
			setBackground(Color.BLACK);
			
			
			 upperPanel=new JPanel();
			 upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.Y_AXIS));
			 upperPanel.setPreferredSize(new Dimension(900,162));
			 upperPanel.setBackground(Color.GRAY);
			 
			 
			 lowerPanel=new JPanel();
			 lowerPanel.setLayout(new BoxLayout(lowerPanel,BoxLayout.Y_AXIS));
			 lowerPanel.setBackground(Color.WHITE);
			 lowerPanel.setPreferredSize(new Dimension(900,488));
			 
			 
			 textareaPanel=new JPanel();
			 //textareaPanel.setLayout(null);
			 textareaPanel.setPreferredSize(new Dimension(500,140));
			 textareaPanel.setBackground(Color.GRAY);
			 
			 name=new JLabel("Post Feed Form..");
			 name.setFont(new Font("Serif", Font.BOLD, 16));
			 name.setPreferredSize(new Dimension(100,30));
			 
			 
			 textArea=new JTextArea(5,36);
			 textArea.setBackground(Color.LIGHT_GRAY);
			 textArea.setFont(new Font("Arial Black", Font.BOLD + Font.ITALIC,15));
			 scrollPane=new JScrollPane(textArea);
			 scrollPane.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791"),3)); 
			 textareaPanel.add(scrollPane);
						 
			 
			 post=new JButton("Post..");
			 post.setPreferredSize(new Dimension(80,30));
			 post.setFont(new Font("Serif", Font.BOLD, 16));
			 post.addActionListener(this);
			 
			 searchFriend=new JButton("searchFriend..");
			 searchFriend.setPreferredSize(new Dimension(80,30));
			 searchFriend.setFont(new Font("Serif", Font.BOLD, 16));
			 searchFriend.addActionListener(this);
			 
			 upperPanel.add(name);  
			 
			upperPanel.add(textareaPanel);
			 upperPanel.add(post);
			 upperPanel.add(searchFriend);
			  
			 
			 
			
			 
			 // validation for text area...
			 
			 populateFeeds();
			 add(upperPanel);
			 add(lowerPanel);
			 
			 }
		catch(Exception e){
			System.out.println("Error" + e);
		}
    }
	public void actionPerformed(ActionEvent aae)
	{
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 java.util.Date date = new java.util.Date();
	     roll_no="mt2015";
		if(aae.getSource()==post)
		{
			text=textArea.getText();
			if(text.equals(""))
			{
				
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
			}
			catch(Exception e)
			{
			    System.out.println("check" +e);	
			}
			}
		}else if(aae.getSource()==searchFriend){
			Search ss = new Search();
			JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
			System.out.println(topFrame.getClass()+", "+this.getClass());
			topFrame.getContentPane().removeAll();
			topFrame.add(ss);
			topFrame.getContentPane().invalidate();
			topFrame.getContentPane().validate();
			topFrame.getContentPane().repaint();
		}
	}
	public void populateFeeds()
	{
		 PopulatePosts pp=new PopulatePosts();
		 newList=pp.getList();
		 int i=0;
		 JScrollPane newScrollPane=new JScrollPane();
		 for(Post p:newList)
		 {
			JPanel postPanel=new JPanel();
			//postPanel.setLayout(null);
			postPanel.setPreferredSize(new Dimension(500,100));
			//if(i%2==0) postPanel.setBackground(Color.magenta);
			//if(i%2==1) postPanel.setBackground(Color.LIGHT_GRAY);
			i++;
			
			 TextArea textArea1=new TextArea(5,36);
			 textArea1.setBackground(Color.WHITE);
			 textArea1.setEditable(false);
			 textArea1.setText(p.getContent());
			 textArea1.setFont(new Font("Arial Black", Font.BOLD + Font.ITALIC,15));
			  
			 JScrollPane scrollPane1=new JScrollPane(textArea1);
			 scrollPane1.setBorder(BorderFactory.createLineBorder(Color.decode("#2C6791"),3)); 
			 scrollPane1.add(textArea1);
			 postPanel.add(scrollPane1);
			// newScrollPane.add(postPanel);
			 lowerPanel.add(postPanel);
		 }
		
	}
}
