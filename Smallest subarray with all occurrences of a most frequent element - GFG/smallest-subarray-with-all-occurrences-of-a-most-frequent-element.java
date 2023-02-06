//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution{
    class Pair {
        int fi;
        int freq;
        int li;
        Pair(int freq, int fi, int li) {
            this.freq = freq;
            this.li = li;
            this.fi = fi;
        }
    }
  
    ArrayList<Integer> smallestSubsegment(int a[], int n)
    {
        // Complete the function
        HashMap<Integer, Pair> hm = new HashMap<>();
        int mfi = a[0];
        int mfiKiFreq = 1;
        int mfKiSi = 0;
        int mfiKiLen = 1;
        
        hm.put(a[0],new Pair(1,0,0));
        
        for(int i = 1; i < a.length; i++) {
            int val =a[i];
            if(hm.containsKey(val)) {
                Pair p = hm.get(val);
                p.freq++;
                p.li= i;
                int len = i - p.fi + 1;
                
                if(p.freq > mfiKiFreq) {
                    mfi = val;
                    mfiKiFreq = p.freq;
                    mfKiSi = p.fi;
                    mfiKiLen = len;
                }else if(p.freq == mfiKiFreq && len < mfiKiLen) {
                    mfi = val;
                    mfiKiFreq = p.freq;
                    mfKiSi = p.fi;
                    mfiKiLen = len;
                }else if(p.freq == mfiKiFreq && len == mfiKiLen && p.fi < mfKiSi) {
                    mfi = val;
                    mfiKiFreq = p.freq;
                    mfKiSi = p.fi;
                    mfiKiLen = len;
                }
            }
            else hm.put(val, new Pair(1,i,i));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int en = mfiKiLen + mfKiSi - 1;
        for(int i = mfKiSi; i <= en; i++) {
            ans.add(a[i]);
        }
        return ans;
    }
}
























//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.smallestSubsegment(arr, sizeOfArray);
		    for(int i:res)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


            


// } Driver Code Ends