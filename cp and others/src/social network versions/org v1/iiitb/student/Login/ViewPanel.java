package org.iiitb.student.Login;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.iiitb.student.Student;

public class ViewPanel extends JPanel implements ActionListener,
		WindowListener, FocusListener {
	public ViewPanel(List<Student> l){
		super();
		setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel jl = new JPanel();
		jl.setLayout(new BoxLayout(jl, BoxLayout.Y_AXIS));
		int i=0;
		for (Student student : l) {
			JPanel jp = new JPanel();
			jp.setLayout(new FlowLayout());
			System.out.println(getClass().getResource("").getPath());
			System.out.println(student.getProfilePic());
		    ImageIcon img = new ImageIcon(getClass().getResource(student.getProfilePic()));
		    JLabel jimg = new JLabel(img);
		    JLabel jname = new JLabel(student.getUserName());
		    JLabel jcourses = new JLabel(student.getCourses());
		    JLabel jgender = new JLabel(student.getGender());
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}