//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.countTriplet(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countTriplet(int arr[], int n) {
        // code here
        int count = 0;
        Arrays.sort(arr);
        for (int i = n - 1; i >= 0; i--) {
            int l = 0;
            int r = n - 1;
            
            while(r > l) {
                if (arr[r] + arr[l] == arr[i]) {
                    count++;
                    l++;
                    r--;
                }else if(arr[r] + arr[l] > arr[i]){ 
                    r--;
                }else {
                    l++;
                }
            }
        }
        return count;
    }
}