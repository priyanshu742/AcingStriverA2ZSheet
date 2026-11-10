package Recursion.implementationProblems;

import java.util.ArrayList;
import java.util.List;

/*

Given an array of integers nums of unique elements. Return all possible subsets (power set) of the array.
Do not include the duplicates in the answer.

Example 1:
Input : nums = [1, 2, 3]
Output : [ [ ] , [1] , [2] , [1, 2] , [3] , [1, 3] , [2, 3] , [1, 2 ,3] ]

Example 2:
Input : nums = [1, 2]
Output : [ [ ] , [1] , [2] , [1,2] ]


Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10

MEDIUM
*/

class Solution1
{
    public List<List<Integer>> powerSet(int[] nums) 
    {
        // using recursion
        List<Integer> currentSubset=new ArrayList<>();
        List<List<Integer>> powerSet=new ArrayList<>();
        generateSubset(nums,0,currentSubset,powerSet);
        return powerSet;
    }
    public void generateSubset(int[] nums,int index,List<Integer> currentSubset,List<List<Integer>> powerSet)
    {
        // when we have decision for every element in the array
        if(index>=nums.length)
        {
            // add a deep copy of the currentSubset to our final List
            powerSet.add(new ArrayList<> (currentSubset));
            return ;
        }
        // include the current element
        currentSubset.add(nums[index]);
        generateSubset(nums,index+1,currentSubset,powerSet);
        // exclude the current element
        currentSubset.remove(currentSubset.size()-1); // undo the inclusion
        generateSubset(nums,index+1,currentSubset,powerSet);
    } 
}
