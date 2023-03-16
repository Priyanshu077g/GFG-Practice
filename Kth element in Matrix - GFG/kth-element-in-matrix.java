//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class KthSmallestElement{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(sc.next());
		while(t>0)
		{
			int n=Integer.parseInt(sc.next());
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
    				a[i][j]=Integer.parseInt(sc.next());
    		
			int k=Integer.parseInt(sc.next());
		    Solution ob = new Solution();
		    System.out.println(ob.kthSmallest(a,n,k));
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
	public static int kthSmallest(int[][]mat,int n,int k)
	{
        //code here.
        return sort(mat,n,n,k);
    }
    static int sort(int [][] mat, int r, int c,int k) {
        int temp[] = new int[r * c];
        int t = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                temp[t++] = mat[i][j];
            }
        }
        Arrays.sort(temp);
        return temp[k - 1];
    }
}