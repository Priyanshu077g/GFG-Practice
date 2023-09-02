//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {
    static List<Integer> nextPermutation(int n, int arr[]) {
        List<Integer> ans = new ArrayList<>();
        
        int[] copyArr = Arrays.copyOf(arr, n);
        
        int idx = -1;
        
        for (int i = n - 2; i >= 0; i--) {
            if (copyArr[i] < copyArr[i + 1]) {
                idx = i;
                break;
            }
        }
        
        if (idx == -1) {
            reverse(copyArr, 0, n - 1);
        } else {
            for (int i = n - 1; i >= 0; i--) {
                if (copyArr[i] > copyArr[idx]) {
                    swap(copyArr, i, idx);
                    break;
                }
            }
            reverse(copyArr, idx + 1, n - 1);
        }
        
        for (int num : copyArr) {
            ans.add(num);
        }
        
        return ans;
    }

    private static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int nums[], int i, int j) {
        int right = j;
        int left = i;
        while (right > left) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            right--;
            left++;
        }
    }
}
