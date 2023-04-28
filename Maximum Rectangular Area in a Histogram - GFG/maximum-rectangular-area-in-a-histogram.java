//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code 
        int size = hist.length;
        int nsi[] = nextSmaller(hist);
        int psi[] = prevSmaller(hist);
        long ans = 0;
        for(int i = 0; i < size; i++) {
            long area = (long)(nsi[i] - psi[i] - 1) * hist[i];
            ans = Math.max(area, ans);
        }
        // for(int i = 0; i < size; i++) {
        //     System.out.println(hist[i] + "->" + "p" + psi[i] + "->" + "n" + nsi[i]);
        // }
        return ans;
    }
    public static int[] prevSmaller(long a[]) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[a.length];
        Arrays.fill(ans, -1);
        for(int i = 0; i < a.length; i++) {
            while(st.size() > 0 && a[st.peek()] > a[i]) {
                st.pop();
            }
            if(st.size() > 0) {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public static int[] nextSmaller(long a[]) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[a.length];
        Arrays.fill(ans, a.length);
        for(int i = 0; i < a.length; i++) {
            while(st.size() > 0 && a[st.peek()] > a[i]) {
                int top = st.pop();
                ans[top] = i;
            }
            
            st.push(i);
        }
        return ans;
    }
}



