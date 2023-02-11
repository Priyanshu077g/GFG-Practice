//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java
class Compute {
    
    public long[] printFirstNegativeInteger(long a[], int N, int K)
    {
        long[] ans=new long[N-K+1];
        int i = 0, j = 0;
        Deque<Long> deque = new LinkedList<>();
        
        while(j < N) {
            // calculation
            if(a[j] < 0) {
               deque.add(a[j]); 
            }
            if(j - i + 1 < K) {
                j++;
            }else if(j - i + 1 == K) {
                if(deque.size() == 0) {
                    ans[i] = 0;
                }else {
                    ans[i] = deque.getFirst();
                    if(a[i] < 0) {
                        deque.remove();
                    }
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}