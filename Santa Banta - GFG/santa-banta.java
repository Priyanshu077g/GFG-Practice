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
	    Complete obj = new Complete();
		obj.precompute();    	
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [][] = new int[M][2];
		    for(int i = 0;i<M;i++){
	            line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);    
	        }
            int ans = obj.helpSanta(N, M, arr);
            System.out.println(ans);
    	    
		}
	}
}




// } Driver Code Ends


//User function Template for Java


class DisjointSet{
    List<Integer> size=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
            rank.add(0);
        }
    }
    
    public int findUPar(int node){
        if(parent.get(node)==node){
            return node;
        }
        int ulp=findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    
    public void UnionByRank(int u,int v){
        int ulp_v=findUPar(v);
        int ulp_u=findUPar(u);
        if(ulp_v==ulp_u){
            return;
        }
        if(rank.get(ulp_u)>rank.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
        }
        else if(rank.get(ulp_v)>rank.get(ulp_u)){
            parent.set(ulp_u,ulp_v);
        }
        else{
            parent.set(ulp_v,ulp_u);
            int rankU=rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
        }
    }
    public void UnionBySize(int u,int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_v==ulp_u){
            return;
        }
        if(size.get(ulp_v)>size.get(ulp_u)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
} 
class Complete{
    static int MAX_SIZE = 1299722;
	// To store all prime numbers
	static ArrayList<Integer> primes = new ArrayList<Integer>();
    public static void precompute () {
        //Complete the function
        boolean [] IsPrime = new boolean[MAX_SIZE];
		
		for(int i = 0; i < MAX_SIZE; i++)
			IsPrime[i] = true;
		
		for (int p = 2; p * p < MAX_SIZE; p++)
		{
			if (IsPrime[p] == true)
			{
				for (int i = p * p; i < MAX_SIZE; i += p)
					IsPrime[i] = false;
			}
		}
	
		// Store all prime numbers
		for (int p = 2; p < MAX_SIZE; p++)
		if (IsPrime[p] == true)
				primes.add(p);
        
    }
    // Function for finding maximum and value pair
    public static int helpSanta (int n, int m, int g[][]) {
        //Complete the function
        if(m==0){
            return -1;
        }
        DisjointSet dis=new DisjointSet(n);
        for(int i=0;i<m;i++){
            dis.UnionBySize(g[i][0],g[i][1]);
        }
        int max=0;
        for(int i=0;i<=n;i++){
            if(dis.findUPar(i)==i){
                max=Math.max(max,dis.size.get(i));
            }
        }
        return primes.get(max-1);
    }
}