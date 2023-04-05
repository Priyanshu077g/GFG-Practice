//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int phy[] = new int[n];
    		int chem[] = new int[n];
    		int math[] = new int[n];
            
            for (int i = 0; i < n; ++i)
                {
                    phy[i]=sc.nextInt();
                    chem[i]=sc.nextInt();
                    math[i]=sc.nextInt();
                }
		    
		    Solution ob = new Solution();
		    
		    ob.customSort (phy, chem, math, n);
    		for (int i = 0; i < n; ++i)
    			System.out.println(phy[i]+" " + chem[i] + " " + math[i]);

        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public class Marks implements Comparable<Marks> {
        int phy, che,math;
        Marks() {
            
        }
        Marks(int phy, int che, int math) {
            this.phy = phy;
            this.che = che;
            this.math = math;
        }
        public int compareTo(Marks o) {
            if(this.phy != o.phy) {
                return this.phy - o.phy;
            }else if(this.che != o.che) {
                return o.che - this.che;
            }else {
                return this.math - o.math;
            }
        }
    }
    public void customSort (int phy[], int chem[], int math[], int n)
    {
        // your code here
        Marks[] arr = new Marks[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new Marks(phy[i], chem[i], math[i]);
        }
        Arrays.sort(arr);
        for(int i = 0; i < n; i++) {
            phy[i] = arr[i].phy;
            chem[i] = arr[i].che;
            math[i] =arr[i].math;
        }
    }
}
