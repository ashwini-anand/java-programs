package org.iiitb.student.Login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.iiitb.student.ImagePath;
import org.iiitb.student.dl.ConnectionPool;

public class Registration extends JPanel implements ActionListener{
	GridBagConstraints gc;
	JLabel l1,roll,name,mail,pass,conf,gen,cour,inter,ph,pic;
	JTextField troll,tname,tmail,tph;
	JPasswordField pass1,pass2;
	JButton sign, upload;
	BufferedImage targetImg;
	JPanel panel;
	ButtonGroup group;
	JComboBox<String> scourse;
	JList<String> sinterests;
	String imagePath;
	public Registration()
	{
		super();
		setPreferredSize(new Dimension(700,768));
		setBackground(Color.LIGHT_GRAY);
		GridBagLayout s=new GridBagLayout();
		setLayout(s);
		gc=new GridBagConstraints();
		
		l1=new JLabel("WELCOME TO IIIT B SOCIAL NETWORK!!!");
		addComp(1,1,500,4,l1);
		l1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		l1.setBounds(1, 1, 540, 50);
		l1.setOpaque(true);
		l1.setBackground(Color.decode("#2C6791"));
		l1.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 22));
		
		roll=new JLabel("Roll Number:");
		troll=new JTextField(15);
		troll.setPreferredSize(new Dimension(20,25));
		addComp(5,15,2,2,roll);
		roll.setFont(new Font("Serif", Font.BOLD+ Font.ITALIC, 15));
		roll.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		addComp(5,17,2,2,troll);
		
		
		name=new JLabel("User Name:");
		tname=new JTextField(15);
		tname.setPreferredSize(new Dimension(20,25));
		addComp(8,15,2,3,name);
		name.setFont(new Font("Serif", Font.BOLD+ Font.ITALIC, 15));
		name.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		addComp(9,17,2,2,tname);
		
		mail=new JLabel("Email Id:");
		tmail=new JTextField(15);
		tmail.setPreferredSize(new Dimension(20,25));
		addComp(11,15,2,3,mail);
		mail.setFont(new Font("Serif", Font.BOLD+ Font.ITALIC, 15));
		mail.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		addComp(12,17,2,2,tmail);
		
		
		try{
			inter=new JLabel("Interests:");
			addComp(14,15,2,3,inter);
			inter.setFont(new Font("Serif", Font.BOLD+ Font.ITALIC, 15));
			inter.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			String[] listdata={"","","","",""}; int i=0;
			PreparedStatement ps1=ConnectionPool.getConnection().prepareStatement("select * from interests");
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				listdata[i++]=rs.getString("interest");
			}
			sinterests = new JList<String>(listdata);
			addComp(14,17,2,2,sinterests);
	
	        }
	        catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		pass=new JLabel("Password:");
		pass1 =new JPasswordField(15);
		pass1.setPreferredSize(new Dimension(20,25));
		addComp(17,15,2,3,pass);
		pass.setFont(new Font("Serif", Font.BOLD+ Font.ITALIC, 15));
		pass.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		addComp(18,17,2,2,pass1);
		
		conf=new JLabel("Confirm Password:");
		pass2=new JPasswordField(15);
		pass2.setPreferredSize(new Dimension(20,25));
		addComp(20,15,2,3,conf);
		conf.setFont(new Font("Serif", Font.BOLD+ Font.ITALIC, 15));
		conf.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		addComp(21,17,2,2,pass2);
		
		ph=new JLabel("Phone Number:");
		tph=new JTextField(15);
		tph.setPreferredSize(new Dimension(20,25));
		addComp(23,15,2,3,ph);
		ph.setFont(new Font("Serif", Font.BOLD+ Font.ITALIC, 15));
		ph.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		addComp(24,17,2,2,tph);
		
		gen=new JLabel("Gender:");
		addComp(26,15,2,3,gen);
		gen.setFont(new Font("Serif", Font.BOLD+ Font.ITALIC, 15));
		gen.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		JRadioButton option1 = new JRadioButton("M",true);
        JRadioButton option2 = new JRadioButton("F");
        group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        addComp(27,17,1,2,option1);
        addComp(27,18,1,2,option2);
        
        try
		{
		cour=new JLabel("Course:");
		addComp(29,15,2,3,cour);
		cour.setFont(new Font("Serif", Font.BOLD+ Font.ITALIC, 15));
		cour.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		String items[]={"","","",""}; int i=0;
		
		PreparedStatement ps1=ConnectionPool.getConnection().prepareStatement("select * from courses");
		ResultSet rs=ps1.executeQuery();
		while(rs.next())
		{
			items[i++]=rs.getString("course");
		}
		
		
		
		scourse=new JComboBox<>(items);
		
		addComp(30,17,2,2,scourse);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
        
		
		sign=new JButton("Sign Up");
		upload=new JButton("Upload");
		upload.addActionListener(this);
		addComp(33,5,2,2,sign);
		addComp(20,3,2,2,upload);
		sign.addActionListener(this);
		sign.setFont(new Font("Serif", Font.BOLD, 18));
		//sign.setPreferredSize(new Dimension(100,40));
		
		ImageIcon img;
		imagePath = "images/defpic.png";
		java.net.URL imgURL = (new ImagePath()).getClass().getResource(imagePath);
		 if (imgURL != null) {
			  img = new ImageIcon((new ImagePath()).getClass().getResource(imagePath));
		    } else {
		    	img = null;
		        System.err.println("Couldn't find file: " + imagePath);
		 }
		
		
		
		pic=new JLabel(img);
		pic.setPreferredSize(new Dimension(150,150));
		addComp(14,3,2,2,pic);
		
		
		setVisible(true);
	}

	
	public  void addComp(int r, int c, int w, int h, Component cc)
	{
		gc.gridx=c;
		gc.gridy=r;
		gc.gridwidth=w;
		gc.gridheight=h;
		add(cc,gc);
	}
	public static void main(String[] args) {
		new Registration();
	}

	
	 public String getSelectedButtonText(ButtonGroup buttonGroup) {
	        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();

	            if (button.isSelected()) {
	                return button.getText();
	            }
	        }

	        return null;
	    }

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		// TODO Auto-generated method stub
		if(ae.getSource() == upload ){


			JFileChooser chooser = new JFileChooser();

		    FileFilter ft = new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg");

		    chooser.addChoosableFileFilter(ft);
		    
		    chooser.showOpenDialog(null);
		    File f = chooser.getSelectedFile();
		    String fileName = chooser.getName(f);
		    String filePath = f.getAbsolutePath().toString();

		    BufferedImage img = null;
		    try {
		        img = ImageIO.read(new File(filePath));
		    } catch (IOException e1) {
		        e1.printStackTrace();
		    }

		    Image dimg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);


		    ImageIcon icon = new ImageIcon(dimg);
		    pic.setText("");
		    pic.setIcon(icon);
		    
		    Path FROM = Paths.get(filePath);
		    //System.out.println(this.getClass().getResource(""));
		    String destnPath = (new ImagePath()).getClass().getResource("").getPath() +"images/"+fileName;
		    imagePath = "images/"+fileName;
		    System.out.println(destnPath);
		    Path TO = Paths.get(destnPath);
		    CopyOption[] options = new CopyOption[]{
		      StandardCopyOption.REPLACE_EXISTING
		    }; 
		    try {
				java.nio.file.Files.copy(FROM, TO, options);
			} catch (IOException e1) {
				System.out.println("Image transfer failed");
				e1.printStackTrace();
			}
		
		
		}
		
		
		if(ae.getSource()==sign)
		{
			
			try {
				if(!(InputValidator.isTextFieldEmpty(this,troll,"Roll number required.",true))){
					if(!(InputValidator.isTextFieldEmpty(this,tname,"Name required.",true)))
					{
						if(!(InputValidator.isTextFieldEmpty(this,tmail,"Email id required.",true)))
						{
							if(!(InputValidator.isEmailFormat(this,tmail,"Email id invalid.",true)))
							{
								if(!(InputValidator.isTextFieldEmpty(this,pass1,"Password required.",true)))
								{
									if(!(InputValidator.isTextFieldEmpty(this,pass2,"Confirm password.",true)))
									{
										if(!(InputValidator.isPasswordandConfPasswordEqual(this,pass1,pass2,"Passwords do not match.",true)))
											{
												if(!(InputValidator.isTextFieldEmpty(this,tph,"Phone number required.",true)))
											{
												if(!(InputValidator.isNotNumber(this,tph,"Phone number invalid.",true)))
												{  
												
												 String roll_no=troll.getText();
												 String username=tname.getText();
												 String email=tmail.getText();
												 String password=new String(pass1.getPassword());
												 String pic_id=imagePath;
												 String gender=getSelectedButtonText(group);
												 String course=scourse.getSelectedItem().toString();
												 String interest=sinterests.getSelectedValue().toString();
												 String phone_no=tph.getText();
												 
												 PreparedStatement ps=ConnectionPool.getConnection().prepareStatement("insert into students(roll_no,username,email,password,pic_id,gender,course,interest,phone_no) values(?,?,?,?,?,?,?,?,?)");
													
												ps.setString(1,roll_no);
												ps.setString(2, username);
												ps.setString(3, email);
												ps.setString(4, password);
												ps.setString(5, pic_id);
												ps.setString(6, gender);
												ps.setString(7, course);
												ps.setString(8, interest);
												ps.setString(9, phone_no);
												
												ps.executeUpdate();
												JOptionPane.showMessageDialog(this, "You have registered successfully. Now you can log in.");
												troll.setText("");
												tname.setText("");
												tmail.setText("");
												pass1.setText("");
												pass2.setText("");
												tph.setText("");
												}
											}
											
										}
									}
								}
							}
						}
					}
				}
							
								
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
}