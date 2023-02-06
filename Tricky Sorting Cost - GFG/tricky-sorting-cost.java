//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.sortingCost(N, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int sortingCost(int N, int arr[]){
        HashMap<Integer, Integer> hm = new HashMap<>();
        ///    number ke corresponding uski length
        int max = 0;
        for(int val : arr) {
            if(hm.containsKey(val - 1)) {
                hm.put(val, hm.get(val - 1) + 1);
            }else {
                hm.put(val, 1);
            }
            max = Math.max(max, hm.get(val));
        }
        return N- max;
    }
}