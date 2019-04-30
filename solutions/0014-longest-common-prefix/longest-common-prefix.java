// Write a function to find the longest common prefix string amongst an array of strings.
//
// If there is no common prefix, return an empty string "".
//
// Example 1:
//
//
// Input: ["flower","flow","flight"]
// Output: "fl"
//
//
// Example 2:
//
//
// Input: ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
//
//
// Note:
//
// All given inputs are in lowercase letters a-z.
//


class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int len = 100000;
        for (int i = 0; i < strs.length; i++) {
            len = Math.min(strs[i].length(), len);
        }
        
        String retStr = "";
        for (int i = 0; i < len; i++) {
            char tmp = strs[0].charAt(i);
            int j = 1;
            for (; j < strs.length; j++)
                if (tmp != strs[j].charAt(i))
                    break;
            if (j == strs.length)
                retStr = retStr.concat("" + tmp);
            else break;
        }
        return retStr;
    }
}
