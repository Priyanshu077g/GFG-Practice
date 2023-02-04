//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
class GFG {
    public static void main(String[] args)
    {   Scanner sc = new Scanner(System.in);
    	int t=sc.nextInt();
    	while(t-->0)
    	{
    		String str1=sc.next();
    		String str2=sc.next();
    		int k=sc.nextInt();
            Solution ob = new Solution();
    		if (ob.areKAnagrams(str1, str2, k) == true)
    			System.out.println("1");
    		else
    			System.out.println("0");
    	}
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        if(s1.length() != s2.length()) return false;
        // frequency array banaya phle
        int farr[] = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            farr[ch - 'a']++;
        }
        // ab freq array ko consume karna hai s2 se
        
        for(int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if(farr[ch - 'a'] != 0) {
                farr[ch - 'a']--;
            }
        }
        int diff = 0;
        for(int i = 0; i < 26; i++) {
            diff += farr[i];
        }
        
        if(diff <= k) {
            return true;
        }
        return false;
    }
}