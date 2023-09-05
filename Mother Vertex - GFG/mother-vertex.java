//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find a Mother Vertex in the Graph.
    private void dfs(boolean[] vis, int curr, ArrayList<ArrayList<Integer>> graph, Stack<Integer> st) {
        vis[curr] = true;
        
        for(int nebr : graph.get(curr)) {
            if(vis[nebr] == false) {
                dfs(vis, nebr, graph, st);
            }
        }
        st.push(curr);
    }
      private void dfs(boolean[] vis, int curr, ArrayList<ArrayList<Integer>> graph) {
        vis[curr] = true;
        count++;
        for(int nebr : graph.get(curr)) {
            if(vis[nebr] == false) {
                dfs(vis, nebr, graph);
            }
        }
    }
    static int count = 0;
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> graph)
    {
        // Code here
        boolean vis[] = new boolean[V];
        Stack<Integer> st =  new Stack<>();
        for(int i = 0; i < V; i++) {
            if(vis[i] == false) {
                dfs(vis, i, graph, st);
            }
        }
        Arrays.fill(vis, false); //// error one
        count = 0;
        int ans = st.pop();
        dfs(vis, ans, graph);
        if(count == V) {
            return ans;
        }else {
            return -1;
        }
    }
}