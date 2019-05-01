// We are given an array A of positive integers, and two positive integers L and R (L <= R).
//
// Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least L and at most R.
//
//
// Example :
// Input: 
// A = [2, 1, 4, 3]
// L = 2
// R = 3
// Output: 3
// Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
//
//
// Note:
//
//
// 	L, R  and A[i] will be an integer in the range [0, 10^9].
// 	The length of A will be in the range of [1, 50000].
//
//


class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int len = A.length;
        int beginIndex = 0;
        int tmpIndex = 0;
        int removeLen = 0;
        int removeNum = 0;
        int retNum = 0;
        
        for (int i = 0; i < len; i++) {
            if (A[i] > R) {
                removeNum += removeLen * (removeLen + 1) / 2;
                removeLen = 0;
                
                retNum += (i - beginIndex) * (i - beginIndex + 1) / 2 - removeNum;
                removeNum = 0;
                beginIndex = i + 1;
            }
            else if (A[i] < L) {
                removeLen++;
            }
            else {
                removeNum += removeLen * (removeLen + 1) / 2;
                removeLen = 0;
            }
        }
        
        removeNum += removeLen * (removeLen + 1) / 2;
        removeLen = 0;
        retNum += (len - beginIndex) * (len - beginIndex + 1) / 2 - removeNum;
        
        return retNum;
    }
}
