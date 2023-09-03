//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
      static void dfs(int row,int col,int[][] vis,char[][] a,int[] dr,int[] dc){

        vis[row][col]=1;

        int n = a.length;

        int m = a[0].length;

        for(int i=0;i<4;i++){

            int nrow= row+dr[i];

            int ncol=col+dc[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && a[nrow][ncol]=='O' && vis[nrow][ncol]==0){

                dfs(nrow,ncol,vis,a,dr,dc);

            }

        }

    }
   static char[][] fill(int n, int m, char a[][])

    {

        // code here

        int[][] vis= new int[n][m];

        int[] dr={-1,0,1,0};

        int[] dc={0,1,0,-1};

        for(int i=0;i<m;i++){

            //first row;

            if(vis[0][i]==0 && a[0][i]=='O'){

                dfs(0,i,vis,a,dr,dc);

            }

            //last row

            if(vis[n-1][i]==0 && a[n-1][i]=='O'){

                dfs(n-1,i,vis,a,dr,dc);

            }

        }

        for(int i=0;i<n;i++){

            //first column

            if(vis[i][0]==0 && a[i][0]=='O'){

                dfs(i,0,vis,a,dr,dc);

            }

            if(vis[i][m-1]==0&&a[i][m-1]=='O'){

                dfs(i,m-1,vis,a,dr,dc);

            }

        }

        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){

                if(vis[i][j]==0 && a[i][j]=='O'){

                    a[i][j]='X';

                }

            }

        }

        return a;

    }
}