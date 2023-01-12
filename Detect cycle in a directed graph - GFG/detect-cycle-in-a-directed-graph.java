//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    boolean dfs(int i, int vis[] ,ArrayList<ArrayList<Integer>> adj, int path[]) {
        vis[i] = 1;
        path[i] = 1;
        
        for(int it : adj.get(i)) {
            if(vis[it] == 0) {
                vis[it] = 1;
                path[it] = 1;
                if(dfs(it,vis,adj,path) == true) return true;
            }else if(path[it] == 1) return true;
        }
        path[i] = 0;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        // int vis[] = new int[V];
        // int path[] = new int[V];
        
        // for(int i = 0; i < V; i++) {
        //     if(vis[i] == 0) {
        //         if(dfs(i,vis,adj,path) == true) return true;
        //     }
        // }
        // return false;
        
        int indegree[] = new int[V];
        for(int i = 0; i < V; i++) {
            for(int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()) {
            int node = q.peek();
            count++;
            q.remove();
            
            for(int it : adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        if(V == count) return false;
        return true;
    }
}




















