package Data;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class vsCom extends JFrame{
	
	Container content;
	JButton[][] board = new JButton[3][3];
	JButton exit,reset,round;
	JPanel[] results = new JPanel[3];
	JLabel xwins,owins,draws,turn;
	int xwin=0,owin=0,draw=0;
	int winnercounter = 0;
	int x=11,o=12;
	int tokenpositions=0;
	Integer [][] pos = new Integer[3][3];
	Font font = new Font("Helvetica", Font.BOLD, 47);
	Font hisfont = new Font("Helvetica", Font.BOLD, 17);
	int comx,comy;
	
	
	public vsCom() {
		this.setBounds(400, 100, 650, 600);
		this.setTitle("TicTac");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		
		content = this.getContentPane();
		content.setBackground(Color.DARK_GRAY);
		content.setForeground(Color.white);
		results[0] = new JPanel();
		content.add(results[0]);
		results[0].setBounds(450, 50, 150, 80);
		xwins = new JLabel("Player wins :"+xwin);
		results[0].setBackground(Color.DARK_GRAY);
		xwins.setForeground(Color.white);
		results[0].add(xwins);
		xwins.setBounds(0, 0, 150, 80);
		xwins.setFont(hisfont);
		results[1] = new JPanel();
		content.add(results[1]);
		results[1].setBounds(450, 150, 150, 80);
		owins = new JLabel("Computer wins :"+owin);
		results[1].setBackground(Color.DARK_GRAY);
		owins.setForeground(Color.white);
		owins.setFont(hisfont);
		results[1].add(owins);
		owins.setBounds(0, 0, 150, 80);
		results[2] = new JPanel();
		content.add(results[2]);
		results[2].setBounds(450, 250, 150, 80);
		draws = new JLabel("Draws :"+draw);
		results[2].setBackground(Color.DARK_GRAY);
		draws.setForeground(Color.white);
		results[2].add(draws);
		draws.setBounds(0, 0, 150, 80);
		draws.setFont(hisfont);
		turn = new JLabel("Player X turn");
		turn.setForeground(Color.WHITE);
		content.add(turn);
		turn.setBounds(450, 450, 150, 80);
		turn.setFont(hisfont);
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j] = new JButton();
				content.add(board[i][j]);
				board[i][j].setBounds(100+i*100, 100+j*100, 100, 100);
				dark(board[i][j]);
			}
		}
		
		
		pos[0][0]=1;
		pos[0][1]=2;
		pos[0][2]=3;
		pos[1][0]=4;
		pos[1][1]=5;
		pos[1][2]=6;
		pos[2][0]=7;
		pos[2][1]=8;
		pos[2][2]=9;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				int k=i,t=j;
				board[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						board[k][t].setText("X");
						pos[k][t]=x;
						board[k][t].setFont(font);
						board[k][t].setEnabled(false);
						//winner();
						comR();
						winner();
					}
				});
			}
		}
		exit = new JButton("EXIT");
		content.add(exit);
		exit.setBounds(200, 420, 100, 50);
		dark(exit);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(JOptionPane.showConfirmDialog(content, "Do you want to exit?\nYou will return ro main menu", "Exit", JOptionPane.YES_NO_CANCEL_OPTION)== JOptionPane.YES_NO_OPTION) {
					visbile(false);
					new mainMenu();
				}
			}
		});
		round = new JButton("NEXT ROUND");
		content.add(round);
		round.setEnabled(false);
		round.setBounds(450, 350, 150, 80);
		dark(round);
		round.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pos[0][0]=1;
				pos[0][1]=2;
				pos[0][2]=3;
				pos[1][0]=4;
				pos[1][1]=5;
				pos[1][2]=6;
				pos[2][0]=7;
				pos[2][1]=8;
				pos[2][2]=9;
				winnercounter = 0;
				tokenpositions = 0;
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						board[i][j].setText("");
						board[i][j].setEnabled(true);
						
					}
				}
				turn.setText("Player X turn");
			}
		});
		reset = new JButton("RESET");
		content.add(reset);
		reset.setBounds(200, 30, 100, 50);
		dark(reset);
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				visbile(false);
				new vsCom();	
			}
		});
	}
	
	
	public void dark(JButton button) {
		button.setBackground(Color.black);
		button.setForeground(Color.white);
	}
	public void winner() {
		winnercounter = 0;
		String player = "";
		if((pos[0][0]==pos[0][1])&&(pos[0][0]==pos[0][2])) {
			winnercounter =2;
			if(pos[0][0]==11) {
				player = "X";
			}else {
				player = "O";
			}
		}
		if((pos[0][0]==pos[1][1])&&(pos[0][0]==pos[2][2])) {
			winnercounter =2;
			if(pos[0][0]==11) {
				player = "X";
			}else {
				player = "O";
			}
		}
		if((pos[0][0]==pos[1][0])&&(pos[0][0]==pos[2][0])) {
			winnercounter =2;
			if(pos[0][0]==11) {
				player = "X";
			}else {
				player = "O";
			}
		}
		if((pos[1][0]==pos[1][1])&&(pos[1][0]==pos[1][2])) {
			winnercounter =2;
			if(pos[1][0]==11) {
				player = "X";
			}else {
				player = "O";
			}
		}
		if((pos[0][1]==pos[1][1])&&(pos[0][1]==pos[2][1])) {
			winnercounter =2;
			if(pos[0][1]==11) {
				player = "X";
			}else {
				player = "O";
			}
		}
		if((pos[2][0]==pos[2][1])&&(pos[2][0]==pos[2][2])) {
			winnercounter =2;
			if(pos[2][0]==11) {
				player = "X";
			}else {
				player = "O";
			}
		}
		if((pos[0][2]==pos[1][2])&&(pos[0][2]==pos[2][2])) {
			winnercounter =2;
			if(pos[1][2]==11) {
				player = "X";
			}else {
				player = "O";
			}
		}
		if((pos[0][2]==pos[1][1])&&(pos[1][1]==pos[2][0])) {
			winnercounter =2;
			if(pos[1][1]==11) {
				player = "X";
			}else {
				player = "O";
			}
		}
		if(winnercounter==2) {
			if(player == "X") {
				xwin++;
				JOptionPane.showMessageDialog(null, "Player Wins.","We have a Winner" , JOptionPane.PLAIN_MESSAGE);
				xwins.setText("Player wins : "+xwin);
			}else {
				owin++;
				JOptionPane.showMessageDialog(null, "Computer Wins.","We have a Winner" , JOptionPane.PLAIN_MESSAGE);
				owins.setText("Computer wins : "+owin);
			}
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					board[i][j].setEnabled(false);
				}
			}
			round.setEnabled(true);
		}
		else if(boardfull()) {
			JOptionPane.showMessageDialog(null, "Tie game.", "TIE", JOptionPane.INFORMATION_MESSAGE);
			draw++;
			draws.setText("Draws : "+draw);
			round.setEnabled(true);
		}
	}

	public boolean boardfull() {
		tokenpositions=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if((pos[i][j]==11)||(pos[i][j]==12)) {
					tokenpositions++;
				}
			}
		}
		if(tokenpositions == 9) {
			return true;
		}else {
		return false;
		}
	}
	public void visbile(boolean set) {
		this.setVisible(set);
	}
	public void comR01() {
		if((pos[0][0]==pos[0][1])&&(pos[0][0]==11)) {
			if(tooken(0, 2)) {
				pos[0][2] = 12;
				board[0][2].setText("O");
				board[0][2].setFont(font);
				board[0][2].setEnabled(false);				
			}else {
				comR02();
			}
		}else {
			comR02();
		}
		//winner();
	}
	public void comR02() {
		if((pos[0][0]==pos[0][2])&&(pos[0][0]==11)) {
			if(tooken(0, 1)) {
				pos[0][1] = 12;
				board[0][1].setText("O");
				board[0][1].setFont(font);
				board[0][1].setEnabled(false);				
			}else {
				comR03();
			}
		}else {
			comR03();
		}
		//winner();
	}
	public void comR03() {
		if((pos[0][2]==pos[0][1])&&(pos[0][1]==11)) {
			if(tooken(0, 0)) {
				pos[0][0] = 12;
				board[0][0].setText("O");
				board[0][0].setFont(font);
				board[0][0].setEnabled(false);	
			}else {
				comR04();
			}
		}else {
			comR04();
		}
		//winner();
	}
	public void comR04() {
		if((pos[0][0]==pos[1][0])&&(pos[0][0]==11)) {
			if(tooken(2, 0)) {
				pos[2][0] = 12;
				board[2][0].setText("O");
				board[2][0].setFont(font);
				board[2][0].setEnabled(false);				
			}else {
				comR05();
			}
		}else {
			comR05();
		}
		//winner();
	}
	public void comR05() {
		if((pos[0][0]==pos[2][0])&&(pos[0][0]==11)) {
			if(tooken(1, 0)) {
				pos[1][0] = 12;
				board[1][0].setText("O");
				board[1][0].setFont(font);
				board[1][0].setEnabled(false);				
			}else {
				comR06();
			}
		}else {
			comR06();
		}
		//winner();
	}
	public void comR06() {
		if((pos[1][0]==pos[2][0])&&(pos[1][0]==11)) {
			if(tooken(0, 0)) {
				pos[0][0] = 12;
				board[0][0].setText("O");
				board[0][0].setFont(font);
				board[0][0].setEnabled(false);	
			}else {
				comR07();
			}
		}else {
			comR07();
		}
		//winner();
	}
	public void comR07() {
		if((pos[1][0]==pos[1][1])&&(pos[1][0]==11)) {
			if(tooken(1, 2)) {
				pos[1][2] = 12;
				board[1][2].setText("O");
				board[1][2].setFont(font);
				board[1][2].setEnabled(false);	
			}else {
				comR08();
			}
		}else {
			comR08();
		}
		//winner();
	}
	public void comR08() {
		if((pos[1][0]==pos[1][2])&&(pos[1][0]==11)) {
			if(tooken(1, 1)) {
				pos[1][1] = 12;
				board[1][1].setText("O");
				board[1][1].setFont(font);
				board[1][1].setEnabled(false);				
			}else {
				comR09();
			}
		}else {
			comR09();
		}
		//winner();
	}
	public void comR09() {
		if((pos[1][2]==pos[1][1])&&(pos[1][1]==11)) {
			if(tooken(1, 0)) {
				pos[1][0] = 12;
				board[1][0].setText("O");
				board[1][0].setFont(font);
				board[1][0].setEnabled(false);	
			}else {
				comR10();
			}
		}else {
			comR10();
		}
		//winner();
	}
	public void comR10() {
		if((pos[1][1]==pos[0][1])&&(pos[0][1]==11)) {
			if(tooken(1, 2)) {
				pos[1][2] = 12;
				board[1][2].setText("O");
				board[1][2].setFont(font);
				board[1][2].setEnabled(false);				
			}else {
				comR11();
			}
		}else {
			comR11();
		}
		//winner();
	}
	public void comR11() {
		if((pos[2][1]==pos[0][1])&&(pos[0][1]==11)) {
			if(tooken(1, 1)) {
				pos[1][1] = 12;
				board[1][1].setText("O");
				board[1][1].setFont(font);
				board[1][1].setEnabled(false);				
			}else {
				comR12();
			}
		}else {
			comR12();
		}
		//winner();
	}
	public void comR12() {
		if((pos[2][1]==pos[1][1])&&(pos[1][1]==11)) {
			if(tooken(0, 1)) {
				pos[0][1] = 12;
				board[0][1].setText("O");
				board[0][1].setFont(font);
				board[0][1].setEnabled(false);				
			}else {
				comR13();
			}
		}else {
			comR13();
		}
		//winner();
	}
	public void comR13() {
		if((pos[2][0]==pos[2][1])&&(pos[2][0]==11)) {
			if(tooken(2, 2)) {
				pos[2][2] = 12;
				board[2][2].setText("O");
				board[2][2].setFont(font);
				board[2][2].setEnabled(false);				
			}else {
				comR14();
			}
		}else {
			comR14();
		}
		//winner();
	}
	public void comR14() {
		if((pos[2][0]==pos[2][2])&&(pos[2][0]==11)) {
			if(tooken(2, 1)) {
				pos[2][1] = 12;
				board[2][1].setText("O");
				board[2][1].setFont(font);
				board[2][1].setEnabled(false);
			}else {
				comR15();
			}
		}else {
			comR15();
		}
		//winner();
	}
	public void comR15() {
		if((pos[2][2]==pos[2][1])&&(pos[2][1]==11)) {
			if(tooken(2, 0)) {
				pos[2][0] = 12;
				board[2][0].setText("O");
				board[2][0].setFont(font);
				board[2][0].setEnabled(false);				
			}else {
				comR16();
			}
		}else {
			comR16();
		}
		//winner();
	}
	public void comR16() {
		if((pos[0][2]==pos[1][2])&&(pos[0][2]==11)) {
			if(tooken(2, 2)) {
				pos[2][2] = 12;
				board[2][2].setText("O");
				board[2][2].setFont(font);
				board[2][2].setEnabled(false);				
			}else {
				comR17();
			}
		}else {
			comR17();
		}
		//winner();
	}
	public void comR17() {
		if((pos[0][2]==pos[2][2])&&(pos[2][2]==11)) {
			if(tooken(1, 2)) {
				pos[1][2] = 12;
				board[1][2].setText("O");
				board[1][2].setFont(font);
				board[1][2].setEnabled(false);				
			}else{
				comR18();
			}
		}else{
			comR18();
		}
		//winner();
	}
	public void comR18(){
		if((pos[2][2]==pos[2][1])&&(pos[2][2]==11)) {
			if(tooken(0, 2)) {
				pos[0][2] = 12;
				board[0][2].setText("O");
				board[0][2].setFont(font);
				board[0][2].setEnabled(false);				
			}else {
				comR19();
			}
		}else {
			comR19();
		}
		//winner();
	}
	public void comR19() {
		if((pos[0][0]==pos[1][1])&&(pos[0][0]==11)) {
			if(tooken(2, 2)) {
				pos[2][2] = 12;
				board[2][2].setText("O");
				board[2][2].setFont(font);
				board[2][2].setEnabled(false);				
			}else{
				comR20();
			}
		}else{
			comR20();
		}
		//winner();
	}
	public void comR20() {
		if((pos[0][0]==pos[2][2])&&(pos[0][0]==11)) {
			if(tooken(1, 1)) {
				pos[1][1] = 12;
				board[1][1].setText("O");
				board[1][1].setFont(font);
				board[1][1].setEnabled(false);
			}else {
				comR21();
			}
			//winner();
		}else {
			comR21();
		}
	}
	public void comR21() {
		if((pos[2][2]==pos[1][1])&&(pos[1][1]==11)) {
			if(tooken(0, 0)) {
				pos[0][0] = 12;
				board[0][0].setText("O");
				board[0][0].setFont(font);
				board[0][0].setEnabled(false);
			}else {
				comR22();
			}
		}else {
			comR22();
		}
		//winner();
	}
	public void comR22() {
		if((pos[0][2]==pos[1][1])&&(pos[0][2]==11)) {
			if(tooken(2, 0)) {
				pos[2][0] = 12;
				board[2][0].setText("O");
				board[2][0].setFont(font);
				board[2][0].setEnabled(false);
			}else {
				comR23();
			}
		}else {
			comR23();
		}
		//winner();
	}
	public void comR23() {
		if((pos[0][2]==pos[2][0])&&(pos[0][2]==11)) {
			if(tooken(1, 1)) {
				pos[1][1] = 12;
				board[1][1].setText("O");
				board[1][1].setFont(font);
				board[1][1].setEnabled(false);
			}else {
				comR24();
			}
		}else {
			comR24();
		}
		//winner();
	}
	public void comR24() {
		if((pos[2][0]==pos[0][1])&&(pos[2][0]==11)) {
			if(tooken(0, 2)) {
				pos[0][2] = 12;
				board[0][2].setText("O");
				board[0][2].setFont(font);
				board[0][2].setEnabled(false);
			}else {
				comR25();
			}
		}else {
			comR25();
		}
		//winner();
	}
	public void comR25() {
		comx = (int)(Math.random() * 3);
		//System.out.println(comx);
		comy = (int)(Math.random() * 3);
		//System.out.println(comy);
		boolean places = false;
		if(!boardfull()) {
			while(!tooken(comx,comy)) {
				comx = (int)(Math.random() * 3);
				//System.out.println(comx);
				comy = (int)(Math.random() * 3);
				//System.out.println(comy);
			}
		}else {
			
		}
		pos[comx][comy]= 12;
		board[comx][comy].setText("O");
		board[comx][comy].setFont(font);
		board[comx][comy].setEnabled(false);
		//winner();
	}
	public boolean tooken(int x,int y) {
		if((pos[x][y] != 11)&&(pos[x][y] != 12)) {
			return true;
		}else {
			return false;
		}
	}
	public void visible(boolean b) {
		this.setVisible(b);
	}
public void comR() {	
		if((pos[0][0]==pos[0][1])&&(pos[0][0]==12)) {
			if(tooken(0, 2)) {
				pos[0][2] = 12;
				board[0][2].setText("O");
				board[0][2].setFont(font);
				board[0][2].setEnabled(false);				
			}else {
				comR01();
			}
		}else if((pos[0][0]==pos[0][2])&&(pos[0][0]==12)) {
			if(tooken(0, 1)) {
				pos[0][1] = 12;
				board[0][1].setText("O");
				board[0][1].setFont(font);
				board[0][1].setEnabled(false);				
			}else {
				comR01();
			}
		}else if((pos[0][2]==pos[0][1])&&(pos[0][1]==12)) {
			if(tooken(0, 0)) {
				pos[0][0] = 12;
				board[0][0].setText("O");
				board[0][0].setFont(font);
				board[0][0].setEnabled(false);	
			}else {
				comR01();
			}
		}else if((pos[0][0]==pos[1][0])&&(pos[0][0]==12)) {
			if(tooken(2, 0)) {
				pos[2][0] = 12;
				board[2][0].setText("O");
				board[2][0].setFont(font);
				board[2][0].setEnabled(false);				
			}else {
				comR01();
			}
		}else if((pos[0][0]==pos[2][0])&&(pos[0][0]==12)) {
			if(tooken(1, 0)) {
				pos[1][0] = 12;
				board[1][0].setText("O");
				board[1][0].setFont(font);
				board[1][0].setEnabled(false);				
			}else {
				comR01();
			}
		}else if((pos[1][0]==pos[2][0])&&(pos[1][0]==12)) {
			if(tooken(0, 0)) {
				pos[0][0] = 12;
				board[0][0].setText("O");
				board[0][0].setFont(font);
				board[0][0].setEnabled(false);	
			}else {
				comR01();
			}
		}else if((pos[1][0]==pos[1][1])&&(pos[1][0]==12)) {
			if(tooken(1, 2)) {
				pos[1][2] = 12;
				board[1][2].setText("O");
				board[1][2].setFont(font);
				board[1][2].setEnabled(false);	
			}else {
				comR01();
			}
		}else if((pos[1][0]==pos[1][2])&&(pos[1][0]==12)) {
			if(tooken(1, 1)) {
				pos[1][1] = 12;
				board[1][1].setText("O");
				board[1][1].setFont(font);
				board[1][1].setEnabled(false);				
			}else {
				comR01();
			}
		}else if((pos[1][2]==pos[1][1])&&(pos[1][1]==12)) {
			if(tooken(1, 0)) {
				pos[1][0] = 12;
				board[1][0].setText("O");
				board[1][0].setFont(font);
				board[1][0].setEnabled(false);	
			}else {
				comR01();
			}
		}else if((pos[1][1]==pos[0][1])&&(pos[0][1]==12)) {
			if(tooken(1, 2)) {
				pos[1][2] = 12;
				board[1][2].setText("O");
				board[1][2].setFont(font);
				board[1][2].setEnabled(false);				
			}else {
				comR01();
			}
		}else if((pos[2][1]==pos[0][1])&&(pos[0][1]==12)) {
			if(tooken(1, 1)) {
				pos[1][1] = 12;
				board[1][1].setText("O");
				board[1][1].setFont(font);
				board[1][1].setEnabled(false);				
			}else {
				comR01();
			}
		}else if((pos[2][1]==pos[1][1])&&(pos[1][1]==12)) {
			if(tooken(0, 1)) {
				pos[0][1] = 12;
				board[0][1].setText("O");
				board[0][1].setFont(font);
				board[0][1].setEnabled(false);				
			}else {
				comR01();
			}
		}else if((pos[2][0]==pos[2][1])&&(pos[2][0]==12)) {
			if(tooken(2, 2)) {
				pos[2][2] = 12;
				board[2][2].setText("O");
				board[2][2].setFont(font);
				board[2][2].setEnabled(false);				
			}else {
				comR01();
			}
		}else if((pos[2][0]==pos[2][2])&&(pos[2][0]==12)) {
			if(tooken(2, 1)) {
				pos[2][1] = 12;
				board[2][1].setText("O");
				board[2][1].setFont(font);
				board[2][1].setEnabled(false);
			}else {
				comR01();
			}
		}else if((pos[2][2]==pos[2][1])&&(pos[2][1]==12)) {
			if(tooken(2, 0)) {
				pos[2][0] = 12;
				board[2][0].setText("O");
				board[2][0].setFont(font);
				board[2][0].setEnabled(false);				
			}else {
				comR01();
			}
		}else if((pos[0][2]==pos[1][2])&&(pos[0][2]==12)) {
			if(tooken(2, 2)) {
				pos[2][2] = 12;
				board[2][2].setText("O");
				board[2][2].setFont(font);
				board[2][2].setEnabled(false);				
			}else {
				comR01();
			}
		}else if((pos[0][2]==pos[2][2])&&(pos[2][2]==12)) {
			if(tooken(1, 2)) {
				pos[1][2] = 12;
				board[1][2].setText("O");
				board[1][2].setFont(font);
				board[1][2].setEnabled(false);				
			}else {
				comR01();
			}
		}else if((pos[2][2]==pos[2][1])&&(pos[2][2]==12)) {
			if(tooken(0,2)) {
				pos[0][2] = 12;
				board[0][2].setText("O");
				board[0][2].setFont(font);
				board[0][2].setEnabled(false);				
			}else {
				comR01();
			}
		}else if((pos[0][0]==pos[1][1])&&(pos[0][0]==12)) {
			if(tooken(2, 2)) {
				pos[2][2] = 12;
				board[2][2].setText("O");
				board[2][2].setFont(font);
				board[2][2].setEnabled(false);				
			}else {
				comR01();
			}
		}else if((pos[0][0]==pos[2][2])&&(pos[0][0]==12)) {
			if(tooken(1, 1)) {
				pos[1][1] = 12;
				board[1][1].setText("O");
				board[1][1].setFont(font);
				board[1][1].setEnabled(false);
			}else {
				comR01();
			}
		}else if((pos[2][2]==pos[1][1])&&(pos[1][1]==12)) {
			if(tooken(0, 0)) {
				pos[0][0] = 12;
				board[0][0].setText("O");
				board[0][0].setFont(font);
				board[0][0].setEnabled(false);
			}else {
				comR01();
			}
		}else if((pos[0][2]==pos[1][1])&&(pos[0][2]==12)) {
			if(tooken(2,0)) {
				pos[2][0] = 12;
				board[2][0].setText("O");
				board[2][0].setFont(font);
				board[2][0].setEnabled(false);
			}else {
				comR01();
			}
		}else if((pos[0][2]==pos[2][0])&&(pos[0][2]==12)) {
			if(tooken(1,1)) {
				pos[1][1] = 12;
				board[1][1].setText("O");
				board[1][1].setFont(font);
				board[1][1].setEnabled(false);
			}else {
				comR01();
			}
		}else if((pos[2][0]==pos[0][1])&&(pos[2][0]==12)) {
			if(tooken(0,2)) {
				pos[0][2] = 12;
				board[0][2].setText("O");
				board[0][2].setFont(font);
				board[0][2].setEnabled(false);
			}else {
				comR01();
			}
		}else {
			comR01();
		}
	}
}
