/*
    Author:     Edmund Trinh, edmund.trinh@gmail.com
    Date:       Feb 7, 2020
    Update:     Feb 7, 2020
    Problem:    1221. Defanging an IP Address
    Difficulty: Easy
    Source:     https://leetcode.com/problems/defanging-an-ip-address/
    
    Notes:
        Given a valid (IPv4) IP address, return a defanged version of that IP address.
        A defanged IP address replaces every period "." with "[.]".
        
    Examples:
        1.
            Input: address = "1.1.1.1"
            Output: "1[.]1[.]1[.]1"
            
        2.
            Input: address = "255.100.50.0"
            Output: "255[.]100[.]50[.]0"
        
    Solution:
        Use StringBuilder (faster than StringBuffer apparently)
        https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html
*/

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if (c == '.') {
                sb.append("[.]");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}