// The count-and-say sequence is the sequence of integers with the first five terms as following:
//
//
// 1.     1
// 2.     11
// 3.     21
// 4.     1211
// 5.     111221
//
//
// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
//
// Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
//
// Note: Each term of the sequence of integers will be represented as a string.
//
//  
//
// Example 1:
//
//
// Input: 1
// Output: "1"
//
//
// Example 2:
//
//
// Input: 4
// Output: "1211"
//


class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String strBefore = countAndSay(n-1);
        String retStr = "";
        
        int countChar = 1;
        char flagChar = strBefore.charAt(0);
        for(int i = 1; i < strBefore.length(); i++){
            char c = strBefore.charAt(i);
            if (c == flagChar)
                countChar++;
            else {
                retStr = retStr.concat(String.valueOf(countChar));
                retStr = retStr.concat("" +flagChar);
                countChar = 1;
                flagChar = c;
            }
        }
        retStr = retStr.concat(String.valueOf(countChar));
        retStr = retStr.concat("" +flagChar);
        return retStr;
    }
}
