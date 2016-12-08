package org.iiitb.student;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Search1 extends JPanel implements ActionListener, FocusListener,
		WindowListener {
	JTextField searchfield;
	JButton search,seeall;
	GridBagConstraints gc;
	public Search1(){
		super();
		//setSize(500,500);
		setLayout(new GridBagLayout());
		gc=new GridBagConstraints();
		searchfield=new JTextField(10);
		search=new JButton("Search1");
		seeall=new JButton("See All1");
		add(searchfield);
		add(search);
		add(seeall);
		search.addActionListener(this);
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
		if(e.getSource()==search)
		{
			//System.out.println("herre");
			Search ss = new Search();
			JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
			topFrame.getContentPane().removeAll();
			topFrame.add(ss);
			topFrame.getContentPane().invalidate();
			topFrame.getContentPane().validate();
			topFrame.getContentPane().repaint();
		//	ss.repaint();
	//		topFrame.pack();
		}	

	}

}
