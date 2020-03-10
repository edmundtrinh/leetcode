/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Mar 5, 2020
    Update:     Mar 10, 2020
    Problem:    394. Decode String
    Difficulty: Medium
    Source:     https://leetcode.com/problems/decode-string/
    
    Notes:
        Given an encoded string, return its decoded string.

        The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
            is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
        You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
        Furthermore, you may assume that the original data does not contain any digits and that
            digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
        
    Examples:
    1.
        s = "3[a]2[bc]", return "aaabcbc".
        s = "3[a2[c]]", return "accaccacc".
        s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/

public class Solution {
    public String decodeString(String s) {
        // null, 0 cases
        if (s == null || s.length() == 0) {
            return "";
        }
        
        // StringBuilder to return at end
        StringBuilder sb = new StringBuilder();
        // Stack of characters inside []
        Stack<Character> stack = new Stack<>();
        
        // go through ever character in String s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']') {
                // push everything except ']'
                stack.push(c);
            } else {
                // Step 1:
                // if c == ']', then retrieve the encapsulated String
                // check if c is a letter by peeking stack
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                                
                // String contained inside [ ]
                String insideBrackets = sb.toString();
                // Discard '['
                stack.pop();
                
                // Step 2:
                // get number of times to repeat from stack
                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                // stack.pop();
                // k is the remaining characters converted into an int
                int k = Integer.valueOf(sb.toString());
                
                // Step 3:
                // repeat string within [], k times
                // push it back to the stack
                while (k != 0) {
                    for (int j = 0; j < insideBrackets.length(); j++) {
                        // ******** this was the line that made it work, not sure why I had to check if it's a letter
                        // ******** since the logic should be the same... but it worked somehow
                        if (Character.isLetter(insideBrackets.charAt(j))) {
                            stack.push(insideBrackets.charAt(j));
                        }
                    }
                    k--;
                }
            }
            // stack.pop();
        }
        
        sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
    
    
    /*
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray())
        {
            if(c != ']') 
                stack.push(c); //push everything but ]
            
            else 
            {
                //step 1: 
                    //if you find a closing ] then 
                   //retrieve the string it encapsulates
                
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isLetter(stack.peek()))
                    sb.insert(0, stack.pop());
                
                String sub = sb.toString(); //this is the string contained in [ ]
                stack.pop(); //Discard the '[';
                
                
                //step 2: 
                    //after that get the number of
                  // times it should repeat from stack
                    
                sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek()))
                    sb.insert(0, stack.pop());
                    
                int count = Integer.valueOf(sb.toString()); //this is the number
                
                
                //step 3: 
                    //repeat the string within the [ ] count 
                  //number of times and push it back into stack
                
                while(count > 0)
                {
                    for(char ch : sub.toCharArray())  
                        stack.push(ch);
                    count--;
                }
            }
        }
        
      //final fetching and returning the value in stack 
        StringBuilder retv = new StringBuilder();
        while(!stack.isEmpty())
            retv.insert(0, stack.pop());

        return retv.toString();
    */
    
    /* Try this solution another time:
    
    * Recursive. helper(s) consumes one layer of "[ ]".
 
    int idx;
    public String decodeString(String s) {
        idx = 0;
        return helper(s);
    }
    String helper(String s) {
        StringBuilder ans = new StringBuilder();
        for (int k = 0; idx < s.length(); ++idx) {
            char ch = s.charAt(idx);
            if (ch == '[') {
                ++idx;
                String str = helper(s);
                while (k > 0) {
                    ans.append(str);
                    --k;
                }
            } else if (ch == ']') {
                break;
            } else if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else ans.append(ch);
        }
        return ans.toString();
    }
    */
}