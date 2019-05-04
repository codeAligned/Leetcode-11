// Given a collection of intervals, merge all overlapping intervals.
//
// Example 1:
//
//
// Input: [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//
//
// Example 2:
//
//
// Input: [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
//


class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = new int[2];
            interval[0] = intervals[i][0];
            int max = intervals[i][1];
            while (i < intervals.length - 1 && max >= intervals[i+1][0]) {
                max = Math.max(max, intervals[i+1][1]);
                i++;
            }
            interval[1] = max;
            list.add(interval);
        }
        
        int[][] answer = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    
}
