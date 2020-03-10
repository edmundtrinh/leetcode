/******************************************************************************

                            Online Java Debugger.
                Code, Run and Debug Java program online.
Write your code in this editor and press "Debug" button to debug program.

1c: 3
2stack: [3]
1c: [
2stack: [3, []
1c: a
2stack: [3, [, a]
1c: ]
3sb: a
4stack: [3, []
5insideBrackets: a
6stack: [3]
7sb: 
8sb: 3
9stack: []
10k: 3
11stack: [a]
11stack: [a, a]
11stack: [a, a, a]
1c: 2
2stack: [a, a, a, 2]
1c: [
2stack: [a, a, a, 2, []
1c: b
2stack: [a, a, a, 2, [, b]
1c: c
2stack: [a, a, a, 2, [, b, c]
1c: ]
3sb: c3
4stack: [a, a, a, 2, [, b]
3sb: bc3
4stack: [a, a, a, 2, []
5insideBrackets: bc3
6stack: [a, a, a, 2]
7sb: 
8sb: 2
9stack: [a, a, a]
10k: 2
11stack: [a, a, a, b]
11stack: [a, a, a, b, c]
11stack: [a, a, a, b, c, b]
11stack: [a, a, a, b, c, b, c]
12sb: 
13stack: [a, a, a, b, c, b]
13stack: [a, a, a, b, c]
13stack: [a, a, a, b]
13stack: [a, a, a]
13stack: [a, a]
13stack: [a]
13stack: []
finalsb: aaabcbc
aaabcbc

*******************************************************************************/

import java.util.*;

public class Main
{
	public static void main(String[] args) {
		String s = "3[a]2[bc]";
		System.out.println(decodeString(s));
	}
	
	public static String decodeString(String s) {
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
            System.out.println("1c: " + c);
            if (c != ']') {
                // push everything except ']'
                stack.push(c);
                System.out.println("2stack: " + stack.toString());
            } else {
                // Step 1:
                // if c == ']', then retrieve the encapsulated String
                // check if c is a letter by peeking stack
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                    System.out.println("3sb: " + sb.toString());
                    System.out.println("4stack: " + stack.toString());
                }
                                
                // String contained inside [ ]
                String insideBrackets = sb.toString();
                System.out.println("5insideBrackets: " + insideBrackets);
                // Discard '['
                stack.pop();
                // System.out.println("SB: " + sb.toString());
                System.out.println("6stack: " + stack.toString());
                
                // Step 2:
                // get number of times to repeat from stack
                sb = new StringBuilder();
                System.out.println("7sb: " + sb.toString());
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                    System.out.println("8sb: " + sb.toString());
                    System.out.println("9stack: " + stack.toString());
                }
                // k is the remaining characters converted into an int
                int k = Integer.parseInt(sb.toString());
                System.out.println("10k: " + k);
                
                // Step 3:
                // repeat string within [], k times
                // push it back to the stack
                while (k > 0) {
                    for (int j = 0; j < insideBrackets.length(); j++) {
                        if (Character.isLetter(insideBrackets.charAt(j))) {
                            stack.push(insideBrackets.charAt(j));
                        System.out.println("11stack: " + stack.toString());
                        }
                    }
                    k--;
                }
            }
        }
        
        sb = new StringBuilder();
        System.out.println("12sb: " + sb.toString());
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            System.out.println("13stack: " + stack.toString());
        }
        System.out.println("finalsb: " + sb.toString());
        return sb.toString();
    }
}