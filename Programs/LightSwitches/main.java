package lightSwitches;

import javax.swing.JOptionPane;
import lightSwitches.Msg;

public class main {
	//instance variables that are used to generate the lightboard
	private static boolean[][] lights;
	private static String s = JOptionPane.showInputDialog("Give me a row?");
	public static int row = Integer.parseInt(s);
	private static String sa =	JOptionPane.showInputDialog("Give me a col?");
	public static int col = Integer.parseInt(s);
	//main method that runs the randomizer method and then runs searchType which handles the rest of the program
	public static void main(String[] args0) {
		randomizer();
		searchType();
	}
	/*allows players to select what they want to do with the light board. Then when one of the buttons is selected, 
	 * its allows the player to type any required specifications and then calls the method in reference to that button
	*/
	public static void searchType() {
		String[] options = {"Select one light", "turn on/off grid", "randomize", "turn all on/off", "turn on/off row or col", "exit"};
		boolean loop = true;
		int opt = 0;
		String talk1 = "";
		String talk2 = "";
		while(loop) {
			JOptionPane.showMessageDialog(null,"", "lights changing", JOptionPane.INFORMATION_MESSAGE);
			opt = Msg.opt(options, drawMap() + "O = On " + "F = Off", "lights are setup");
			if (opt == 0) {
				talk1 = JOptionPane.showInputDialog("on or off");
				if(talk1.equals("on")) {
					singleLight(Integer.parseInt(JOptionPane.showInputDialog("Row Selected")),Integer.parseInt(JOptionPane.showInputDialog("Col selected")), true);
				}
				else if(talk1.equals("off")) {
					singleLight(Integer.parseInt(JOptionPane.showInputDialog("Row Selected")),Integer.parseInt(JOptionPane.showInputDialog("Col selected")), false);
				}
			}
			else if(opt == 1) {
				talk1 = JOptionPane.showInputDialog("on or off");
				if(talk1.equals("on")) {
					grid(Integer.parseInt(JOptionPane.showInputDialog("Row Start")),Integer.parseInt(JOptionPane.showInputDialog("Row end")),Integer.parseInt(JOptionPane.showInputDialog("Col Start")), Integer.parseInt(JOptionPane.showInputDialog("Col end")),true);
				}
				else if(talk1.equals("off")) {
					grid(Integer.parseInt(JOptionPane.showInputDialog("Row Start")),Integer.parseInt(JOptionPane.showInputDialog("Row end")),Integer.parseInt(JOptionPane.showInputDialog("Col Start")), Integer.parseInt(JOptionPane.showInputDialog("Col end")),false);
				}
			}
			else if(opt == 2) {
				randomizer();
			}
			else if(opt == 3) {
				talk1 = JOptionPane.showInputDialog("on or off");
				if(talk1.equals("on")) {
					turnAllOn();
				}
				else if(talk1.equals("off")) {
					turnAllOff();
				}
			}
			else if (opt == 4) {
				talk1 = JOptionPane.showInputDialog("row or col");
				talk2 = JOptionPane.showInputDialog("on or off");
				if(talk1.equals("row")) {
					if(talk2.equals("on")) {
						allRow(Integer.parseInt(JOptionPane.showInputDialog("Row Selected")), true);
					}
					else if(talk2.equals("off")) {
						allRow(Integer.parseInt(JOptionPane.showInputDialog("Row Selected")), false);
					}
				}
				else if(talk1.equals("col")) {
					if(talk2.equals("on")) {
						allCol(Integer.parseInt(JOptionPane.showInputDialog("Col Selected")), true);
					}
					else if(talk2.equals("off")) {
						allCol(Integer.parseInt(JOptionPane.showInputDialog("Col Selected")), false);
					}
				}
			}
			else{
				Msg.msg("Lightboard shutting down");
				loop = false;}
		}
		
	}
	//Draws the light board (determines what a true or false value in the array looks like)
	private static String drawMap() {
		String map = "";
		for(int r = 0; r < lights.length; r++) {
			for(int c = 0; c < lights[0].length; c++) {
				if(lights[r][c]) {
					map+= "O";
					map+= " ";
				}
				else if(!lights[r][c]) {
					map+= "F";
					map+= " ";
				}
			}
			map += "\n";
		}
		return map;
	}
	//randomizes the light board
	public static void randomizer() {
		 lights = new boolean[row][col];
		 for (int r = 0; r < row; r++){
			 for (int c = 0; c < col; c++){
				 double rnd = Math.random();
				 lights[r][c] = rnd < 0.4;
			 }
		 }
	}
	
	//turns a player selected light either on or off
	public static void singleLight(int r, int c, boolean v) {
		if(v) {
			lights[r][c] = true;
		}
		else if(!v) {
			lights[r][c] = false;
		}
	}
	//turns all of lights of the light board off
	public static void turnAllOff() {
		for(int i = 0; i < lights.length; i++){
			  for(int j = 0; j < lights[0].length; j++){
			    lights[i][j] = false;
			  }
		}
	}
	//turns all of lights of the light board on
	public static void turnAllOn() {
		for(int i = 0; i < lights.length; i++){
			  for(int j = 0; j < lights[0].length; j++){
			    lights[i][j] = true;
			  }
		}
	}
	//turns all of lights of a player selected row either on or off
	public static void allRow(int r, boolean c) {
		if(c) {
			for(int i = 0; i < lights.length; i++) {
				lights[r][i] = true;
			}
		}
		else if(!c) {
			for(int i = 0; i < lights.length; i++) {
				lights[r][i] = false;
			}
		}
	}
	//turns all of lights of a player selected col either on or off
	public static void allCol(int c, boolean e) {
		if(e) {
			for(int i = 0; i < lights[0].length; i++) {
				lights[i][c] = true;
			}
		}
		else if(!e) {
			for(int i = 0; i < lights[0].length; i++) {
				lights[i][c] = false;
			}
		}
	}
	//turns all of lights of a player selected grid either on or off
	public static void grid(int r1, int r2, int c1, int c2, boolean h) {
		if(h) {
			for(int i = r1; i < r2; i++) {
				for(int j = c1; j < c2; j++) {
					lights[i][j] = true;
				}
			}
		}
		else if(!h) {
			for(int i = r1; i < r2; i++) {
				for(int j = c1; j < c2; j++) {
					lights[i][j] = false;
				}
			}
		}
	}
}
