//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //initially sum is 0 at index =-1
        map.put(0,-1);
        int s1 =0;
        int len = 0;
        for(int i =0;i<N;i++){
            //find the s1
            s1+=A[i];
            //find the s2
            int s2 = s1-K;
            //check s2 is present or not
            if(map.containsKey(s2)){
                //find the max length
                int plen = i-map.get(s2);
                len = Math.max(len,plen);
            }
            //if s1 is not present,put in hashmap 
            if(map.containsKey(s1)==false)
            {
                map.put(s1,i);
            }
        }
        return len;
    }
}


