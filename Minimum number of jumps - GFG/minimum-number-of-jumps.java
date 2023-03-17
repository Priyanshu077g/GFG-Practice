//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        // your code here
        if(arr[0] == 0) return -1;
        int n = arr.length;
        int pos = 0, dest = 0, jump = 0;
        for (int i = 0; i < n - 1; i++) {
            
            dest = Math.max(dest, arr[i] + i);
            
            if(pos == i) {
                pos = dest;
                jump++;
            }
        }
        if(pos < n - 1) return -1;
        return jump;
    }
}