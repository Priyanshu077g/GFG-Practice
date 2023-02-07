//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            long b[] = new long[(int)(m)];
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(inputLine1[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.minRemove(a, b, n, m));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long minRemove( long a[], long b[], long n, long m)
    {
        HashMap<Long, Integer> hm = new HashMap<>();
        
        for(Long val : a) {
            hm.put(val, hm.getOrDefault(val,0) + 1);
        }
        int count = 0;
        for(Long val : b) {
            if(hm.getOrDefault(val, 0) > 0) {
                count++;
                hm.put(val, hm.get(val) - 1);
            }
        }
        return count;
    }
}