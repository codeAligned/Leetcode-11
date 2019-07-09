// Given the coordinates of four points in 2D space, return whether the four points could construct a square.
//
// The coordinate (x,y) of a point is represented by an integer array with two integers.
//
// Example:
//
//
// Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
// Output: True
//
//
//  
//
// Note:
//
//
// 	All the input integers are in the range [-10000, 10000].
// 	A valid square has four equal sides with positive length and four equal angles (90-degree angles).
// 	Input points have no order.
//
//
//  
//


class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p={p1, p2, p3, p4};
        Arrays.sort(p, (l1, l2) -> l2[0] == l1[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
        if (computeVertical(p[0], p[3], p[1], p[2]))
            if (computeVertical(p[0], p[1], p[0], p[2]))
                return true;
        return false;
    }
    
    private boolean computeVertical(int[] p01, int[] p02, int[] p11, int[] p12){
        if (p01[0] == p02[0] && p01[1] == p02[1])
            return false;
        if (p11[0] == p12[0] && p11[1] == p12[1])
            return false;
        
        if (((p01[0]-p02[0])*(p11[0]-p12[0]) + (p01[1]-p02[1])*(p11[1]-p12[1])) == 0)
            return true;
        else return false;
    }
}
