package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

//import com.gargoylesoftware.htmlunit.javascript.host.Set;
import com.sun.jna.platform.win32.WinDef.CHAR;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

// import utils1.arraylist;

public class arraylist1 {
	
	@Test	
	public static void list() {
		
	/*	HashMap<String,String>  map = new HashMap<String,String>();
		
		map.put("a", "cat");
		map.put("b", "rat");
		map.put("c", "mat");
		map.put("d", "goat");
		
		for(Map.Entry x:map.entrySet())
		{
		System.out.println(x.getKey() + " : " + x.getValue());
		
		}  */
		
		String s = "animalal";
		
		char[] x = s.toCharArray(); 
		
		HashMap<Character,Integer>  map = new HashMap<Character,Integer>();
		
		for(char y:x)
		
		{
		 if(map.containsKey(y)){
	        
			 map.put(y,map.get(y)+1);
			 
		 } else {
			 
			 map.put(y,1);
			 
		 }
		}
			
		 Set<Character> keys = map.keySet();
		 
		for(Character m:keys){
			
			
			if (map.get(m)>1)
			{
				
				System.out.println(map.get(m) + ":" + m);
				
			}
			
				
				
			}
			
			
			
			
		
		
		
	//	System.out.println(x[0]);
		
	}
	

}

