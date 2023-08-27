//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int l;
            l = sc.nextInt();

            int r;
            r = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.findXOR(l, r);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int compute(int x) {
        int t = x % 4;
        if(t == 0) {
            return x;
        }
        else if(t == 1) {
            return 1;
        }else if(t == 2) {
            return x + 1;
        }else return 0;
    }
    public static int findXOR(int l, int r) {
       return compute(r) ^ compute(l - 1);
    }
}