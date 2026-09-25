package BeginnerProblems.basicHashing;

import java.util.HashMap;
import java.util.Map;

/*

Given an array of n integers, find the second most frequent element in it.
If there are multiple elements that appear second most frequent times, find the smallest of them.
If second most frequent element does not exist return -1.

Example 1:
Input: arr = [1, 2, 2, 3, 3, 3]
Output: 2
Explanation:
The number 2 appears the second most (2 times) and number 3 appears the most(3 times).

Example 2:
Input: arr = [4, 4, 5, 5, 6, 7]
Output: 6
Explanation:
Both 6 and 7 appear second most times, but 6 is smaller.

Example 3:
Input: arr = [10, 9 ,7, 7]
Output: 9


Constraints:
1 <= n <= 105
1 <= arr[i] <= 104

EASY
*/

class Solution 
{
    public int secondMostFrequentElement(int[] nums) 
    {
        int highestFrequency=0;
        int secondHighestFrequency=0;
        int mostFrequentElement=-1;
        int secondFrequentElement=-1;
        Map<Integer,Integer> dict=new HashMap<>();
        for(int n : nums)
        {
            dict.put(n,dict.getOrDefault(n,0)+1);
        }
        for(int key: dict.keySet())
        {
            int frequency=dict.get(key);
            if(frequency>highestFrequency)
            {
                secondHighestFrequency=highestFrequency;
                secondFrequentElement=mostFrequentElement;

                highestFrequency=frequency;
                mostFrequentElement=key;
            }
            else if(frequency==highestFrequency)
            {
                if(key<mostFrequentElement)
                {
                    mostFrequentElement=key;
                }
            }
            else if(frequency>secondHighestFrequency)
            {
                secondHighestFrequency=frequency;
                secondFrequentElement=key;
            }
            else if(frequency==secondHighestFrequency)
            {
                if(key<secondFrequentElement)
                {
                    secondFrequentElement=key;
                }
            }
        }
        if(secondHighestFrequency==0)
        {
            return -1;
        }
        return secondFrequentElement;
    }
}