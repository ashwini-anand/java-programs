package org.iiitb.student;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SearchPanel extends JFrame implements ActionListener,
		WindowListener, FocusListener {
	JTextField searchfield;
	JButton search,seeall;
	GridBagConstraints gc;
	JPanel jp;
	JLabel jimg;
	private Container container;
	private Feed feed;
	public SearchPanel(){

		super("Search Panel");
		setSize(1366,768);
		jimg = new JLabel();
		jimg.setPreferredSize(new Dimension(150,150));
		searchfield=new JTextField(10);
		search=new JButton("Login");
		seeall=new JButton("Login2");
		jp = new JPanel();
		jp.setLayout(new GridBagLayout());
		jp.add(searchfield);
		jp.add(jimg);
		jp.add(search);
		jp.add(seeall);
		searchfield.requestFocus();
		search.addActionListener(this);
		seeall.addActionListener(this);
        add(jp);
		addWindowListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
	}
	
	public static void main(String[] a)
	{
		new SearchPanel();
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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==search)
		{

			container=getContentPane();
			feed= new Feed();
			feed.setBounds(0, 0,1366,768);
			//container.setLayout(null);
		//	container.add(feed);
		   Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
		   setSize(1366,768);
		    setLocation((int)(dimension.width/2-(getWidth()/2)),(int)(dimension.height/2-(getHeight()/2)));
	   
		    
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);	
			//Search1 ss = new Search1();
			this.getContentPane().remove(jp);
			jp.setVisible(false);
			this.add(feed);
			this.getContentPane().invalidate();
			this.getContentPane().validate();
			this.getContentPane().repaint();
			
			
//			jp.setVisible(false);
//			ss.setVisible(true);
//			this.remove(jp);
//			this.setVisible(false);
//			this.add(ss);
//			this.setVisible(true);
			
		}else if(e.getSource() == seeall){
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

		    Image dimg = img.getScaledInstance(jimg.getWidth(), jimg.getHeight(), Image.SCALE_SMOOTH);


		    ImageIcon icon = new ImageIcon(dimg);
		    jimg.setText("");
		    jimg.setIcon(icon);
		    
		    Path FROM = Paths.get(filePath);
		    String destnPath = this.getClass().getResource("").getPath() +"images/"+fileName;
		    String savePath = "images/"+fileName;
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
	}

}
