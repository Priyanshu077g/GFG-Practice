//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    class Pair {
        int fi, se;
        Pair(int fi, int se) {
            this.fi = fi;
            this.se = se;
        }
    }
    boolean isCorner(int i, int j, int n, int m) {
        return i == 0 || j == 0 || i == n - 1 || j == m - 1;
    }
    int dx[] = {-1,0,1,0};
    int dy[] = {0,1,0,-1};
    void bfs(boolean vis[][], int mat[][], int i, int j, int n, int m) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(i, j));
        vis[i][j] = true;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.fi;
            int y = p.se;
            
            for(int t = 0; t < 4; t++) {
                int currX = x + dx[t];
                int currY = y + dy[t];
                
                if(currX >= 0 && currY >= 0 && currX < n && currY < m && !vis[currX][currY]
                   && mat[currX][currY] == 1){
                       q.add(new Pair(currX, currY));
                       vis[currX][currY] = true;
                   }
            }
        }
    }
    public int closedIslands(int[][] mat, int n, int m)
    {
        // Code here
        boolean vis[][] = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j]  && mat[i][j] == 1 && isCorner(i, j, n, m)) {
                    bfs(vis, mat, i, j, n, m);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && mat[i][j] == 1) {
                    ans++;
                    bfs(vis, mat, i, j, n , m);
                }
            }
        }
        return ans;
    }
}






