//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();

            Solution ob = new Solution();
            int ans  = ob.setBit(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int setBit(int n){
        // code here
        if((n & (n + 1)) == 0) return n; // shows n is odd number
        if(n == 0) return n;
        int mask = ~n;
        int rmbFinder = mask & -mask;
        return rmbFinder | n;
        
    }
}