//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array
{
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(new GfG().max_sum(arr,n));
			
		t--;
		}
	}
	
}

// } Driver Code Ends


class GfG
{
    int max_sum(int A[], int n)
    {
	    int sum = 0;
	    int S0 = 0;
	    for (int i = 0; i < n; i++) {
	        S0 += A[i] * i;
	        sum += A[i];
	    }
	    int max = S0;
	    int Si = S0;
	    for (int i = 0; i < n - 1; i++) {
	        int Sip1 = Si + sum - n * A[n - i - 1];
	        max = Math.max(max, Sip1);
	        Si = Sip1;
	    }
	    return max;
    }	
}
