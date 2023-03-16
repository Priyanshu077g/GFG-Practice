//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        // code here 
        int r = matrix.length;
        int c = matrix[0].length;
        int lo = 0;
        int high = r * c - 1;
        int ans = 0;
        sortMat(matrix, r,c);
        int mid = (lo + high) / 2;
        ans = matrix[mid / c][mid % c];
        return ans;
    }
     void sortMat(int mat[][], int r, int c)
    {
        int temp[] = new int[r * c];
        int k = 0;
     
        for (int i = 0; i <r; i++)
            for (int j = 0; j < c; j++)
                temp[k++] = mat[i][j];
     
        Arrays.sort(temp);
        
        k = 0;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                mat[i][j] = temp[k++];
    }
   
}