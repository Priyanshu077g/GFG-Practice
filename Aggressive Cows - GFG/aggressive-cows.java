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

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static boolean ok(int s[], int k, int mid) {
        int noOfCows = 1, last = s[0];
        for(int i = 0; i < s.length; i++) {
            if(s[i] - last >= mid) {
                noOfCows++;
                last = s[i];
            }
            if(noOfCows >= k) return true;
        }
        return false;
    }
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int lo = 0;
        int hi = stalls[n - 1];
        int ans = -1;
        while(hi >= lo) {
            int mid = (lo + hi) >> 1;
            if(ok(stalls, k, mid)) {
                ans = mid;
                lo = mid + 1;
            }else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}