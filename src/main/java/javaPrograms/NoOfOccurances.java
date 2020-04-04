package javaPrograms;

import java.util.HashMap;
import java.util.Map;

public class NoOfOccurances {

	public static void main(String[] args) {
		NoOfOccurances countWordTest = new NoOfOccurances();
        countWordTest.countWords("find spring tutorial, java tutorial how to java articles spring articles and may more");
    }
 
    public void countWords(String input) {
        Map <String, String> map = new HashMap <String, String> ();
 
        if (input != null) {
            String[] separatedWords = input.split(" ");
            for (String str: separatedWords) {
                if (map.containsKey(str)) {
                    int count = Integer.parseInt(map.get(str));
                    map.put(str, String.valueOf(count + 1));
                } else {
                    map.put(str, "1");
                }
            }
        }
 
        System.out.println("Count :- " + map);
    }
 

}
