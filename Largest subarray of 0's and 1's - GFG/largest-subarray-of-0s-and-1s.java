//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.util.HashMap;

class Largest_Subarray
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++) 
                a[i] = sc.nextInt();
            

            Solution g = new Solution();
            int n = g.maxLen(a, a.length);

            System.out.println(n);

            T--;
        }
    }
}

// } Driver Code Ends

class Solution {

    int maxLen(int[] arr, int n)
    {
        // Your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        int sum = 0;
        hm.put(0,-1);
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                arr[i] = -1;
            }else{
                arr[i] = 1;
            }
            sum += arr[i];
            if(hm.containsKey(sum)) {
                int len = i - hm.get(sum);
                ans = Math.max(len,ans);
            }else{
                hm.put(sum, i);
            }
        }
        return ans;
    }
}
