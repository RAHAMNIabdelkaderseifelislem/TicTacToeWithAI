package Data;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class mainMenu extends JFrame{

	Container content;
	JButton v1,vcom,exit;
	Font font = new Font("Helvetica", Font.BOLD, 47);
	
	public mainMenu() {
	
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("TicTacToe");
		this.setBounds(400, 200, 350, 270);
		this.setResizable(false);
		
		content = this.getContentPane();
		content.setBackground(Color.BLACK);
		v1 = new JButton("Vs Player");
		content.add(v1);
		v1.setBounds(0, 0, 350, 65);
		v1.setFont(font);
		dark(v1);
		
		v1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vis(false);
				new vsPlayer();
			}
		});
		
		vcom = new JButton("Vs Computer");
		content.add(vcom);
		vcom.setBounds(0, 85, 350, 65);
		vcom.setFont(font);
		dark(vcom);
		
		vcom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vis(false);
				new vsCom();
			}
		});
		exit = new JButton("EXIT");
		content.add(exit);
		exit.setBounds(0, 170, 350, 65);
		exit.setFont(font);
		dark(exit);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(JOptionPane.showConfirmDialog(content, "Do you want to exit?", "Exit", JOptionPane.YES_NO_CANCEL_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
	}
	
	public void dark(JButton button) {
		button.setBackground(Color.black);
		button.setForeground(Color.white);
	}
	
	public void vis(boolean b) {
		this.setVisible(b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new mainMenu();
	}
}
