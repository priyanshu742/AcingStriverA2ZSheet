package ArrayProblems.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Given an array of intervals where intervals[i] = [starti, endi], 
merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the intervals in the input.
You can return the intervals in any order.

Example 1
Input: intervals = [[1,5],[3,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Intervals [1,5] and [3,6] overlap, so they are merged into [1,6].

Example 2
Input: intervals = [[5,7],[1,3],[4,6],[8,10]]
Output: [[1,3],[4,7],[8,10]]
Explanation: Intervals [4,6] and [5,7] overlap and are merged into [4,7].


Constraints
1 <= intervals.length <= 10⁵
0 <= starti <= endi <= 10⁵

MEDIUM
*/

class Solution 
{
    // optimal
    public List<List<Integer>> mergeOverlap(List<List<Integer>> intervals) 
    {
        intervals.sort((a,b) ->
        {
            if(a.get(0).equals(b.get(0)))
            {
                return Integer.compare(a.get(1),b.get(1));
            }
            return Integer.compare(a.get(1),b.get(1));
        });

        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<intervals.size();i++)
        {
            if(result.isEmpty() || intervals.get(i).get(0)>result.get(result.size()-1).get(1))
            {
                result.add(Arrays.asList(intervals.get(i).get(0),intervals.get(i).get(1)));
            }
            else
            {
               int currentMaxEnd=Math.max(intervals.get(i).get(1),result.get(result.size()-1).get(1));
               result.get(result.size()-1).set(1,currentMaxEnd);
            }
        }
        return result;
    }
}