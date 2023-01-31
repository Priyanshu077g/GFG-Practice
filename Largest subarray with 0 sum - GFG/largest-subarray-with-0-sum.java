//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        //       sum -> index
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int maxl = 0;
        // int sum = 0;
        // int i = -1;
        // map.put(sum, i);
        // while(i < arr.length - 1) {
        //     i++;
        //     sum += arr[i];
        //     int templ = 0;
            
        //     if(!map.containsKey(sum)) {
        //         map.put(sum, i);
        //     }else {
        //         templ = i - map.get(sum);
        //     }
        //     if(templ > maxl) {
        //         maxl = templ;
        //     }
        // }
        // return maxl;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        hm.put(0,-1);
        int prefixsum = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            prefixsum += arr[i];
            if(hm.containsKey(prefixsum)) {
                max = Math.max(max, i - hm.get(prefixsum));
            }else{
                hm.put(prefixsum, i);
            }
        }
        return max;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}