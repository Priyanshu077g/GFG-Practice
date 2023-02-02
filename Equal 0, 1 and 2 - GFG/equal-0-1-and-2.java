//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code her
        long ans = 0;
        int c0 = 0, c1 = 0, c2 = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("0#0", 1);
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '0') c0++;
            if(ch == '1') c1++;
            if(ch == '2') c2++;
            
            String key = (c1 - c0) + "#" + (c2 - c1);
            
            if(hm.containsKey(key)) {
                ans += hm.get(key);
                hm.put(key, hm.get(key) + 1);
            }else{
                hm.put(key, 1);
            }
        }
        return ans;
    }
} 