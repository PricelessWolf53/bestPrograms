package battleship;

import javax.swing.JOptionPane;


public class main {
	//instance variables that are used to generate and play on Battleship
	public static int row = 10;
	public static int col = 10;
	private static boolean[][] board = new boolean[row][col];
	private static boolean[][] board2 = new boolean[row][col];
	private static String _name;
	private static String _name2;
	public static int cpu;
	//
	public static void main(String[] args0) {
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				board[r][c] = true;
				}
			}
		for(int r = 0; r < board2.length; r++) {
			for(int c = 0; c < board2[0].length; c++) {
				board2[r][c] = true;
				}
			}
		ships();
		ships2();
		searchType();
	}

	public static void searchType() {
			Msg.msg("Welcome to battleship!");
			Msg.msg("The rules of this game are simple: " + "\n" + "1. You are given a board with ships" + "\n" + "2. You have 1 small ship, 1 medium ship, and 1 large ship" + "\n" + "3. To play you press fire, then input a row and a column"  + "\n" + "4. If you land a hit on an emeny ship, you get to fire again!" + "\n" + "5. Destroying all the enemy ships means victory" + "\n" + "6. You can fight another player, or a cpu, the same rules apply for both expect that there is a transition screen between player 1 and 2 (so no cheating)");
			Msg.msg("Note if you land a hit, that part of the ship gets removed from the enemy board");
			String[] gameModes = {"Player VS Player", "Player VS CPU"};
			String[] options = {"Fire", "exit"};
			boolean loop = true;
			int opt = 0;
			int opt2 = 0;
			String talk1 = "";
			String talk2 = "";
			Object menuSelection = JOptionPane.showInputDialog(null, "Choose gamemode", "Battleship", 1, null, gameModes, null);
			if(menuSelection == "Player VS Player") {
				_name = JOptionPane.showInputDialog ("Player 1 input your name(If input is rico you can see enemy ships displayed on your board)");
				Msg.msg("Displaying Player 1 ships now" + "\n" + "Player 2 look away");
				Msg.msg("Your ships are at:" + "\n" + "(2,3)(2,4)" + "\n" + "(9,9)(8,9)(7,9)" + "\n" + "(6,0)(7,0)(8,0)(9,0)");
				_name2 = JOptionPane.showInputDialog ("Player 2 input your name(If input is rico you can see enemy ships displayed on your board)");
				Msg.msg("Displaying Player 2 ships now" + "\n" + "Player 1 look away");
				Msg.msg("Your ships are at:" + "\n" + "(3,2)(4,2)" + "\n" + "(7,6)(7,7)(7,8)" + "\n" + "(0,1)(0,2)(0,3)(0,4)");
				while(loop) {
					Msg.msg("Player 1's turn");
					if(_name.equals("Rico") || _name.equals("rico")) {
						JOptionPane.showMessageDialog(null,drawMap2(), "This is Player 2's Board", JOptionPane.INFORMATION_MESSAGE);
					}
					opt = Msg.opt(options, drawMap() + "O = Empty Space " + "X = Ship", "Board is ready");
					if(opt==0) {
						while(fire(Integer.parseInt(JOptionPane.showInputDialog("Select row from 0-9")),Integer.parseInt(JOptionPane.showInputDialog("Select column from 0-9")))) {
							Msg.msg("Hit! You can fire again");
							if(board2[3][2] == true && board2[4][2] == true) {
								Msg.msg("Player 2's Small ship Sunk!");
							}
							if(board2[7][5] == true && board2[7][6] == true && board2[7][7] == true) {
								Msg.msg("Player 2's Medium ship Sunk!");
							}
							if(board2[0][1] == true && board2[0][2] == true && board2[0][3] == true && board2[0][4] == true) {
								Msg.msg("Player 2's Large ship Sunk!");
							}
							if(board2[3][2] == true && board2[4][2] == true && board2[7][5] == true && board2[7][6] == true && board2[7][7] == true && board2[0][1] == true && board2[0][2] == true && board2[0][3] == true && board2[0][4] == true) {
								Msg.msg("All ships are sunk! " + _name + " wins!");
								loop = false;
								break;
							}	
						}
						if(loop == false) {
							break;
						}
						Msg.msg("Miss!");
						Msg.msg("Player 2's turn");
						if(_name2.equals("Rico") || _name2.equals("rico")) {
							JOptionPane.showMessageDialog(null,drawMap(), "This is Player 1's Board", JOptionPane.INFORMATION_MESSAGE);
						}
						opt2 = Msg.opt(options, drawMap2() + "O = Empty Space " + "X = Ship", "Board is ready");
						if(opt2==0) {
							while(fire2(Integer.parseInt(JOptionPane.showInputDialog("Select row from 0-9")),Integer.parseInt(JOptionPane.showInputDialog("Select column from 0-9")))) {
								Msg.msg("Hit! You can fire again");
								if(board[2][3] == true && board[2][4] == true) {
									Msg.msg("Player 1's Small ship Sunk!");
								}
								if(board[9][9] == true && board[8][9] == true && board[7][9] == true) {
									Msg.msg("Player 1's Medium ship Sunk!");
								}
								if(board[6][0] == true && board[7][0] == true && board[8][0] == true && board[9][0] == true) {
									Msg.msg("Player 1's Large ship Sunk!");
								}
								if(board[2][3] == true && board[2][4] == true && board[9][9] == true && board[8][9] == true && board[7][9] == true && board[6][0] == true && board[7][0] == true && board[8][0] == true && board[9][0] == true) {
									Msg.msg("All ships are sunk! " + _name2 + " wins!");
									loop = false;
									break;
								}
							}
							if(loop == false) {
								break;
							}
							Msg.msg("Miss!");
						}
						else {
							Msg.msg("Returning to Player 1 Board");
						}
					}
					else {
						Msg.msg("Closing Battleship");
						loop = false;
					} 
				}
			}
			else if(menuSelection == "Player VS CPU") {
				_name = JOptionPane.showInputDialog("Input your name (If input is rico you can see enemy ships displayed on your board)");
				Msg.msg("Your ships are at:" + "\n" + "(2,3)(2,4)" + "\n" + "(9,9)(8,9)(7,9)" + "\n" + "(6,0)(7,0)(8,0)(9,0)");
				while(loop) {
					if(_name.equals("Rico") || _name.equals("rico")) {
						JOptionPane.showMessageDialog(null,drawMap2(), "This is the CPU's Board", JOptionPane.INFORMATION_MESSAGE);
					}
					opt = Msg.opt(options, drawMap() + "O = Empty Space " + "X = Ship", "board is ready");
					if(opt==0) {
						while(fire(Integer.parseInt(JOptionPane.showInputDialog("Select row from 0-9")),Integer.parseInt(JOptionPane.showInputDialog("Select column from 0-9")))) {
							Msg.msg("Hit! You can fire again");
							if(board2[3][2] == true && board2[4][2] == true) {
								Msg.msg("Cpu Small ship Sunk!");
							}
							if(board2[7][7] == true && board2[7][5] == true && board2[7][6] == true) {
								Msg.msg("Cpu Medium ship Sunk!");
							}
							if(board2[0][1] == true && board2[0][2] == true && board2[0][3] == true && board2[0][4] == true) {
								Msg.msg("Cpu Large ship Sunk!");
							}
							if(board2[3][2] == true && board2[4][2] == true && board2[7][7] == true && board2[7][5] == true && board2[7][6] == true && board2[0][1] == true && board2[0][2] == true && board2[0][3] == true && board2[0][4] == true) {
								Msg.msg("All ships are sunk! " + _name + " wins!");
								loop = false;
								break;
							}
						}
						if(loop == false) {
							break;
						}
						Msg.msg("Miss!");
						while(fire2(setHit(), setHit())) {
						Msg.msg("CPU has hit your Ship! It gets to fire again");
							if(board[2][3] == true && board[2][4] == true) {
								Msg.msg("Player 1's Small ship Sunk!");
							}
							if(board[9][9] == true && board[8][9] == true && board[7][9] == true) {
								Msg.msg("Player 1's Medium ship Sunk!");
							}
							if(board[6][0] == true && board[7][0] == true && board[8][0] == true && board[9][0] == true) {
								Msg.msg("Player 1's Large ship Sunk!");
							}
							if(board[2][3] == true && board[2][4] == true && board[9][9] == true && board[8][9] == true && board[7][9] == true && board[6][0] == true && board[7][0] == true && board[8][0] == true && board[9][0] == true) {
								Msg.msg("All ships are sunk! " + _name2 + " wins!");
								loop = false;
								break;
							}						
						}
						if(loop == false) {
							break;
						}
						Msg.msg("CPU has missed");
					}
					else {
						Msg.msg("Closing Battleship");
						loop = false;
					} 
				}	
			}
			else {
				Msg.msg("Closing Battleship");
			}
	}
	
	private static String drawMap() {
		String map = "";
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				if(board[r][c]) {
					map+= "O";
					map+= " ";
				}
				else if(!board[r][c]) {
						map+= "X";
						map+= " ";
					}
				}
			map += "\n";
			}
		return map;
	}
	
	private static String drawMap2() {
		String map = "";
		for(int r = 0; r < board2.length; r++) {
			for(int c = 0; c < board2[0].length; c++) {
				if(board2[r][c]) {
					map+= "O";
					map+= " ";
				}
				else if(!board2[r][c]) {
					map+= "X";
					map+= " ";
				}
			}
			map += "\n";
		}
		return map;
	}
	
	
	private static String drawMapCPU() {
		String map = "";
		ships();
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				if(board[r][c]) {
					map+= "O";
					map+= " ";
				}
				else if(!board[r][c]) {
						map+= "X";
						map+= " ";
					}
				}
			map += "\n";
			}
		return map;
	}
	
	public static void ships() {
		board[2][3] = false;
		board[2][4] = false;
		
		board[9][9] = false;
		board[8][9] = false;
		board[7][9] = false;
		
		board[6][0] = false;
		board[7][0] = false;
		board[8][0] = false;
		board[9][0] = false;
	}
	
	public static void ships2() {
		board2[3][2] = false;
		board2[4][2] = false;
		
		board2[7][7] = false;
		board2[7][6] = false;
		board2[7][5] = false;
		
		board2[0][1] = false;
		board2[0][2] = false;
		board2[0][3] = false;
		board2[0][4] = false;
	}
	
	public static void ricoCheat() {
		if(_name.equals("Rico") || _name.equals("rico")) {
			board[3][2] = false;
			board[4][2] = false;
			
			board[7][7] = false;
			board[7][6] = false;
			board[7][5] = false;
			
			board[0][1] = false;
			board[0][2] = false;
			board[0][3] = false;
			board[0][4] = false;
		}
	}
	
	public static void ricoCheat2() {
		if(_name2.equals("Rico") || _name2
				.equals("rico")) {
			board2[2][3] = false;
			board2[2][4] = false;
			
			board2[9][9] = false;
			board2[8][9] = false;
			board2[7][9] = false;
			
			board2[6][0] = false;
			board2[7][0] = false;
			board2[8][0] = false;
			board2[9][0] = false;
		}
	}
	public static boolean fire(int r, int c) {
		if(board2[r][c] == true) {
			return false;
		}

		board2[r][c] = true;
		return true;
	}
	
	public static boolean fire2(int rs, int cl) {
		if(board[rs][cl] == true) {
			return false;
		}
		board[rs][cl] = true;
		return true;
	}
	
	public static int setHit() {
		cpu = (int)(Math.random()*board.length);
		return cpu;
	}
}
