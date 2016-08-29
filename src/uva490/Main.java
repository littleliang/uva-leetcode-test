package uva490;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> list= new ArrayList<>();
		String line = null;
		int maxLen = 0;
		while(scanner.hasNextLine()){
			line = scanner.nextLine();
			list.add(line);
			if (line.length() > maxLen)
				maxLen = line.length();
		}
		scanner.close();
		
		for ( int i = 0; i < maxLen; i++){
			for( int j = 0; j < list.size(); j++){
				if (list.get(j).length() > i){
					System.out.print(list.get(j).charAt(i));
				}
				else{
					System.out.print(' ');
				}
			}
			System.out.println();
		}

	}

}
