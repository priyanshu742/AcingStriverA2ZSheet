package LearnTheBasics.LearnBasicHashing;
import java.util.*;



/*

Given an array nums of size n which may contain duplicate elements.
Return a list of pairs where each pair contains a unique element from the array and its frequency in the array.
You may return the result in any order, but each element must appear exactly once in the output.


Example 1
Input: nums = [1, 2, 2, 1, 3]
Output: [[1, 2], [2, 2], [3, 1]]
Explanation:
- 1 appears 2 times
- 2 appears 2 times
- 3 appears 1 time
Order of output can vary.

Example 2
Input: nums = [5, 5, 5, 5]
Output: [[5, 4]]
Explanation: -5 appears 4 times.

Constraints
1 <= nums.length <= 105
-109 <= nums[i] <= 109

HARD
*/


class Solution 
{
    public List<List<Integer>> countFrequencies(int[] nums) 
    {  // Your code goes here
        Map<Integer,Integer> freqMap=new HashMap<>();

        for(int n: nums)
        {
           freqMap.put(n,freqMap.getOrDefault(n,0)+1);
        }

        List<List<Integer>> result= new ArrayList<>();
        for(int key : freqMap.keySet())
        {
            int value=freqMap.get(key);
            
            List<Integer> pair= Arrays.asList(key,value);
            result.add(pair);
        }
        return result;
    }
}
