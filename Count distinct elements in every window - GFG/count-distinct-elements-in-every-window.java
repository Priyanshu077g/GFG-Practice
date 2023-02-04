//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int a[], int n, int k)
    {
        // code here 
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int j = 0;
        for(int i = 0; i < k; i++) {
            hm.put(a[i],hm.getOrDefault(a[i], 0) + 1);
        }
        ans.add(hm.size());
        for(int i = k; i < n; i++) {
            //accquire
            hm.put(a[i],hm.getOrDefault(a[i],0) + 1);
            if(hm.get(a[j]) == 1) {
                hm.remove(a[j]);
            }else{
                hm.put(a[j], hm.getOrDefault(a[j] , 0) - 1);
            }
           j++;
           ans.add(hm.size());
        }
        
        return ans;
    }
}

