package javaPrograms;

import java.util.HashMap;

public class RomanNum {

	public static void main(String[] args) {
		
	}
	
	public static String Roman(int n) {
	
		String roman = "";
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "I");
		hm.put(5, "V");
		hm.put(10,"X");
		hm.put(50, "L");
		hm.put(100, "C");
		hm.put(500, "D");
		hm.put(1000, "M");
		
		return roman;
		

	}

}
