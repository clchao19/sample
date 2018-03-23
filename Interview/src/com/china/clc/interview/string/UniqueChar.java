package com.china.clc.interview.string;

public class UniqueChar {

	
	public static void main(String[] args) {
		UniqueChar check = new UniqueChar();
	    final String s = "fgtse¸çdch";
		boolean result = check.isUniqueChar3(s);
		System.out.println(result);

	}
	
	/**
	 * ASCII
	 * @param s
	 * @return
	 */
	private boolean isUniqueChar1(String s){
		if(s.length() > 128)
			return false;
		
		boolean[] char_set = new boolean[128];
		for(int index=0; index<s.length(); index++){
			int c = s.charAt(index);
			System.out.println(c);
		    if(char_set[c]){
		    	return false;
		    }
		    char_set[c] = true;
		}
		
		return true;
	}

	/**
	 * bit vector
	 * @param s
	 * @return
	 */
	private boolean isUniqueChar2(String s){
		int checker = 0;
		for(int index=0; index<s.length(); index++){
			int val = s.charAt(index) - 'a';
			System.out.print(s.charAt(index) + ":" + val + "  ");
			System.out.print("  1<<  "+ (1<<val));
			if((checker & (1<<val)) > 0){
				System.out.println(" checker=" + checker);
				System.out.println("checker & (1<<val):" + (checker & (1<<val)));
				return false;
			}
			System.out.println(" checker=" + checker);
			System.out.println("checker & (1<<val):" + (checker & (1<<val)));
			checker |= (1 << val);

		}
		return true;		
	}
	
	/**
	 * compare every character
	 * @param s
	 * @return
	 */
	private boolean isUniqueChar3(String s){
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			for(int index=0; index<s.length(); index++){
				if(i != index){
					if(c == s.charAt(index))
						return false;
				}
			}
		}
		return true;
	}

}
