//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // code here
        int ans = 0, prev = 0;
        for(int i = str.length() - 1; i >= 0; i--) {
            int curr = find(str.charAt(i));
            if(curr >= prev) {
                ans += curr;
            }else {
                ans -= curr;
            }
            prev = curr;
        }
        return ans;
    }
    int find(Character ch) {
        if(ch == 'L') return 50;
        if(ch == 'V') return 5;
        if(ch == 'X') return 10;
        if(ch == 'C') return 100;
        if(ch == 'D') return 500;
        if(ch == 'M') return 1000;
        return 1;
    }
 }