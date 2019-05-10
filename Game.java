import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.Math.*;


public class Game{
	Player[] p = new Player[2];
	static int turn = 0;
	boolean gameOver = false;
    ImageIcon X = new ImageIcon("X.png");
	ImageIcon winX = new ImageIcon("winX.png");
	ImageIcon winO = new ImageIcon("winO.png");
	ImageIcon O = new ImageIcon("O.png");
	static Player winner;
	public static void main(String[] args) {
	Game game = new Game();
	game.startGame();

	}//close main method

	
	public void startGame(){
		p[0] = new Player(1,X,winX);
		p[1] = new Player(2,O,winO);
		GUI a = new GUI();
		a.go();

	}//close method
	

	public class GUI{
		Cell[] btns = new Cell[9];
		public void go(){
			JFrame frame = new JFrame("TicTacToe");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel background = new JPanel(new GridLayout(3,3));

			
			for(int i = 0; i < 9; i++){
				btns[i] = new Cell();
				background.add(btns[i]);
			}

			frame.setResizable(false);
			frame.setLocation(500,250);
			frame.setPreferredSize(new Dimension(350,350));
			frame.getContentPane().add(background);
			frame.pack();
			frame.setVisible(true);

		}//close method


		public class Cell extends JButton implements ActionListener{
		    
			boolean used = false;
			Player user;
			public Cell(){
				this.addActionListener(this);
				
				
			}//close constructor 

			
			public void actionPerformed(ActionEvent e){
				int index = this.indexIn(btns);
				this.user = p[turn];
				
				if(!gameOver){
					if(!used){
						setIcon(p[turn].mark);
						used = true;
					}//close if

					//winning logic :

					if(!gameOver && btns[0].used && btns[1].used && btns[2].used && btns[0].user == p[turn] && btns[1].user == p[turn] && btns[2].user == p[turn]){

						winner = p[turn];
						btns[0].setIcon(p[turn].winMark);
						btns[1].setIcon(p[turn].winMark);
						btns[2].setIcon(p[turn].winMark);
						gameOver = true;					

					}else if(!gameOver && btns[3].used && btns[4].used && btns[5].used && btns[3].user == p[turn] && btns[4].user == p[turn] && btns[5].user == p[turn]){

						btns[3].setIcon(p[turn].winMark);
						btns[4].setIcon(p[turn].winMark);
						btns[5].setIcon(p[turn].winMark);
						gameOver = true;	

					}else if(!gameOver && btns[6].used && btns[7].used && btns[8].used && btns[6].user == p[turn] && btns[7].user == p[turn] && btns[8].user == p[turn]){

						btns[6].setIcon(p[turn].winMark);
						btns[7].setIcon(p[turn].winMark);
						btns[8].setIcon(p[turn].winMark);
						gameOver = true;

					}



					if(!gameOver && btns[0].used && btns[3].used && btns[6].used  && btns[0].user == p[turn] && btns[3].user == p[turn] && btns[6].user == p[turn]){

						btns[0].setIcon(p[turn].winMark);
						btns[3].setIcon(p[turn].winMark);
						btns[6].setIcon(p[turn].winMark);
						gameOver = true;

					}else if(!gameOver && btns[1].used && btns[4].used && btns[7].used  && btns[1].user == p[turn] && btns[4].user == p[turn] && btns[7].user == p[turn]){


						btns[1].setIcon(p[turn].winMark);
						btns[4].setIcon(p[turn].winMark);
						btns[7].setIcon(p[turn].winMark);
						gameOver = true;

					}else if(!gameOver && btns[2].used && btns[5].used && btns[8].used && btns[2].user == p[turn] && btns[5].user == p[turn] && btns[8].user == p[turn]){


						btns[2].setIcon(p[turn].winMark);
						btns[5].setIcon(p[turn].winMark);
						btns[8].setIcon(p[turn].winMark);
						gameOver = true;

					}

					if(!gameOver && btns[0].used && btns[4].used && btns[8].used && btns[0].user == p[turn] && btns[4].user == p[turn] && btns[8].user == p[turn]){

						
						btns[0].setIcon(p[turn].winMark);
						btns[4].setIcon(p[turn].winMark);
						btns[8].setIcon(p[turn].winMark);
						gameOver = true;

					}else if(!gameOver && btns[2].used && btns[4].used && btns[6].used && btns[2].user == p[turn] && btns[4].user == p[turn] && btns[6].user == p[turn]){

						
						btns[2].setIcon(p[turn].winMark);
						btns[4].setIcon(p[turn].winMark);
						btns[6].setIcon(p[turn].winMark);
						gameOver = true;

					}


					if(turn > 0){
						turn--;
					}else{
						turn++;
					}//close if

					
									
					
				}//close if 

				



			}//close method
			
			public int indexIn(Cell[] cArr){
			int len = cArr.length;
			if(cArr == null) {
				return -1;
			}

			for(int i = 0; i <len; i++){
				if(cArr[i] == this){
					return i;
				}
			}

			return -1;
		}	
	
	
		}//close class

	}//close main class




	public class Player{
	ImageIcon winMark;
	ImageIcon mark;
	int num;
	
	public Player(int n, ImageIcon s, ImageIcon ws){
		mark = s;
		num = n;
		winMark = ws;
		}//close method


}//close player class


}//close main class

