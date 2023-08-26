//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> hm = new HashMap<>();
        int i = 0, j = 0, ans = -1;
        //i second window
        while(i < s.length()) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            
            if(hm.size() == k) {
                ans = Math.max(ans, i - j + 1);
            }else {
                while(hm.size() > k) {
                    if(hm.get(s.charAt(j)) == 1)hm.remove(s.charAt(j));
                    else {
                    hm.put(s.charAt(j), hm.get(s.charAt(j)) - 1);
                    }
                    j++;
                }
            }
            i++;
        }
        return ans;
    }
}