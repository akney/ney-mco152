package ney.math;

import java.util.HashSet;

public class ShowDuplicates {
	
	    public static void main( String args[] ) {

	        String array[] = new String[] {
	            "123","A", "B", "B", "B", "C", "123"
	        };

	        HashSet set = new HashSet<String>();
	        HashSet doubles = new HashSet<String>();
	        for ( String s : array ) {
	           
	            if (set.contains(s) ) {
	               doubles.add(s);
	            }
	            set.add(s); 
	        }
	        System.out.println(doubles);
	    }
	}

