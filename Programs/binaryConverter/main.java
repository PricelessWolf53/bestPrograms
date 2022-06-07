package binarayConverter;

import javax.swing.JOptionPane;

public class Main {
	public static int[] bits = {128, 64, 32, 16, 8, 4, 2, 1};
	public static String input = "";
	public static void main(String args[]) {
		searchType();
	}
	
	public static void searchType() {
		String[] options = {"Number to binary", "Binary to number" ,"exit"};
		boolean loop = true;
		int opt = 0;
		while(loop) {
			opt = Msg.opt(options, drawMap(), "Binary Converter");
			if(opt == 0) {
				numToBit(Integer.parseInt(JOptionPane.showInputDialog("Select a number between 1 and 255 to convert to binary")));
				
			}
			else if(opt == 1) {
				bitToNum(JOptionPane.showInputDialog("Type an 8 digit set of 1s and 0s. Example: 00110011"));
			}
			else {
				Msg.msg("Closing Converter");
				loop = false;
			}
		}
	}
	public static void numToBit(int num) {

		String print = "";
		if(num >=1 && num <= 255) {
	        String strt = Integer.toBinaryString(num);
	        String ret = "";
	        for(int i = strt.length(); i< 8; i++) {
	            ret += 0;
	
	        }
	        ret += strt;
			for(int i = 1; i <= 8; i++) {
				if(ret.substring(i-1, i).equals("1")) {
					if(i == 1) {print += 128;}
					else if(i == 2) {print += 64;}
					else if(i == 3) {print += 32;}
					else if(i == 4) {print += 16;}
					else if(i == 5) {print += 8;}
					else if (i == 6) {print += 4;}
					else if(i == 7) {print += 2;}
					else if(i == 8) {print += 1;}		
				}
				else if(ret.substring(i-1, i).equals("0")) {
					if(i == 1) {print += 0;}
					else if(i == 2) {print += 0;}
					else if(i == 3) {print += 0;}
					else if(i == 4) {print += 0;}
					else if(i == 5) {print += 0;}
					else if (i == 6) {print += 0;}
					else if(i == 7) {print += 0;}
					else if(i == 8) {print += 0;}
				}
				print += " ";
			}
	        Msg.msg(num + "\n" + print+ "\n" + ret);
		}
		else {
			Msg.msg("I gave you specific instructions");
		}
	}
	
	public static void bitToNum(String yes) {
		String a = yes;
		if(a.length() == 8) {
					String print = "";
					String bi = "";
		for(int i = 1; i <= 8; i++) {
			if(a.substring(i-1, i).equals("1")) {
				if(i == 1) {bi += 128;}
				else if(i == 2) {bi += 64;}
				else if(i == 3) {bi += 32;}
				else if(i == 4) {bi += 16;}
				else if(i == 5) {bi += 8;}
				else if (i == 6) {bi += 4;}
				else if(i == 7) {bi += 2;}
				else if(i == 8) {bi += 1;}		
			}
			else if(a.substring(i-1, i).equals("0")) {
				if(i == 1) {bi += 0;}
				else if(i == 2) {bi += 0;}
				else if(i == 3) {bi += 0;}
				else if(i == 4) {bi += 0;}
				else if(i == 5) {bi += 0;}
				else if (i == 6) {bi += 0;}
				else if(i == 7) {bi += 0;}
				else if(i == 8) {bi += 0;}	
			}
		bi += " ";
		}
		for(int i = 1; i <= 8; i++) {
			if(a.substring(i-1, i).equals("1")) {
				if(i == 1) {print += 128 + " + ";}
				else if(i == 2) {print += 64+ " + ";}
				else if(i == 3) {print += 32+ " + ";}
				else if(i == 4) {print += 16+ " + ";}
				else if(i == 5) {print += 8+ " + ";}
				else if (i == 6) {print += 4+ " + ";}
				else if(i == 7) {print += 2+ " + ";}
				else if(i == 8) {print += 1;}		
			}
			else {
			}
		}
		print += " = ";
		print += Integer.parseInt(a, 2);
		Msg.msg(a + "\n" + bi +"\n" + print);
		}
		else {
			Msg.msg("Only 1s and 0s exactly 8 digits please.");
			Msg.msg("Stupid");
		}
	}
	
	public static String drawMap() {
		String map = "1 1 1 1 1 1 1 1" + "\n" + "128, 64, 32, 16, 8, 4, 2, 1";
		return map;
	}
	
}
