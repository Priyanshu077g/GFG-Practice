//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to check if brackets are balanced or not.
    
    public static boolean handleClosing(Stack<Character> st, char ch) {
        if(st.size() == 0) {
            return false;
        }else if(st.peek() != ch) {
            return false;
        }else {
            st.pop();
            return true;
        }
    }
    
    static boolean ispar(String s)
    {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }else if(ch == ')') {
                boolean val = handleClosing(st, '(');
                if(val == false) {
                    return val;
                }
            }else if(ch == '}') {
                boolean val = handleClosing(st, '{');
                if(val == false) {
                    return val;
                }
            }else if(ch == ']') {
                boolean val = handleClosing(st, '[');
                if(val == false) {
                    return val;
                }
            }
        }
        return st.size() == 0;
    }
}












