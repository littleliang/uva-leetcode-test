package uva401;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
	public static Map<String, String> MirrorMap = new HashMap<String, String>(){
		private static final long serialVersionUID = 1L;

	{ 
		put("A", "A"); put("E", "3"); put("H", "H"); put("I", "I"); put("J", "L"); put("L", "J");
		put("3", "E"); put("M", "M"); put("O", "O"); put("T", "T"); put("S", "2"); put("X", "X");
		put("U", "U"); put("V", "V"); put("W", "W"); put("Y", "Y"); put("Z", "5"); put("1", "1");
		put("2", "S"); put("5", "Z"); put("8", "8");}};
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean regular = false;
		boolean mirror = false;
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			regular = checkRegular(line);
			mirror = checkMirror(line);
			if ( !mirror && !regular){
				System.out.println(line + " -- is not a palindrome.");
				System.out.println();
			}
			else if ( mirror && !regular){
				System.out.println(line + " -- is a mirrored string.");
				System.out.println();
			}
			else if ( !mirror && regular){
				System.out.println(line + " -- is a regular palindrome.");
				System.out.println();
			}
			else{
				System.out.println(line + " -- is a mirrored palindrome.");
				System.out.println();
			}
			
		}
		scanner.close();

	}

	private static boolean checkMirror(String line) {
		int len = line.length();
		for(int i = 0; i < len; i++){
			if (!MirrorMap.containsKey(line.substring(i, i + 1)))
				return false;
			if (!line.substring(len - 1 - i, len - i).equals(MirrorMap.get(line.substring(i, i + 1))))
				return false;
		}
		return true;
	}

	private static boolean checkRegular(String line) {
		int len = line.length();
		for(int i = 0; i < len; i++){
			if (!line.substring(len - 1 - i, len - i).equals(line.substring(i, i + 1)))
				return false;
		}
		return true;
	}

}
