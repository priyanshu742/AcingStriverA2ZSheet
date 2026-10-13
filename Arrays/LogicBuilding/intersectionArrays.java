package Arrays.LogicBuilding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*

Given two sorted arrays, nums1 and nums2, 
return an array containing the intersection of these two arrays. 

Each element in the result must appear as many times as it appears in both arrays; 
that is, if an element appears x times in nums1 and y times in nums2, it should appear min(x, y) times in the result.
The intersection of two arrays is an array where all values are present in both arrays.

Example 1:
Input: nums1 = [1, 2, 2, 3, 5], nums2 = [1, 2, 7]
Output: [1, 2]
Explanation:
The elements 1, 2 are the only elements present in both nums1 and nums2

Example 2:
Input: nums1 = [1, 2, 2, 3, 3, 3], nums2 = [2, 3, 3, 4, 5, 7]
Output: [2, 3, 3]
Explanation:
The element 2 appears in both arrays only one time.
The element 3 appears in both arrays two times so we add element 3 equal to its number of occurrences.


Constraints:
1 <= nums1.length, nums2.length <= 1000
-104 <= nums1[i], nums2[i] <= 104
Both nums1 and nums2 are sorted in non-decreasing order.

EASY
*/

class Solution1
{
    public int[] intersectionArray(int[] nums1, int[] nums2) 
    {
        // brute
        int used[]=new int[nums2.length];
        List<Integer> temp=new ArrayList<>();
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                if(nums1[i]==nums2[j] && used[j]==0)
                {
                    temp.add(nums1[i]);
                    used[j]=1;
                    break;
                }
                if(nums2[j]>nums1[i])
                {
                    break;
                }
            }
        }
        int result[]=new int[temp.size()];
        for(int i=0;i<temp.size();i++)
        {
            result[i]=temp.get(i);
        }
        return result;
    }
}

class Solution2
{
    public int[] intersectionArray(int[] nums1, int[] nums2) 
    {
        // slightly optimal
        Map<Integer,Integer> dict1=new TreeMap<>();
        Map<Integer,Integer> dict2=new TreeMap<>();
        List<Integer> temp=new ArrayList<>();
        for(int n : nums1)
        {
            dict1.put(n,dict1.getOrDefault(n,0)+1);
        }
        for(int n : nums2)
        {
            dict2.put(n,dict2.getOrDefault(n,0)+1);
        }
        for(int key : dict1.keySet())
        {
            if(dict2.containsKey(key))
            {
                int count=Math.min(dict1.get(key),dict2.get(key));
                for(int i=0;i<count;i++)
                {
                    temp.add(key);
                }
            }
        }
        int result[]=new int[temp.size()];
        for(int i=0;i<temp.size();i++)
        {
            result[i]=temp.get(i);
        }
        return result;
    }
}

class Solution3
{
    public int[] intersectionArray(int[] nums1, int[] nums2) 
    {
        //optimal
        List<Integer> temp=new ArrayList<>();
        int n1=nums1.length;
        int n2=nums2.length;
        int i=0;
        int j=0;
        while(i<n1 && j<n2)
        {
            if(nums1[i]<nums2[j])
            {
                i++;
            }
            else if(nums2[j]<nums1[i])
            {
                j++;
            }
            else
            {
                temp.add(nums1[i]);
                i++;
                j++;
            }
        }
        int result[]=new int[temp.size()];
        for(int k=0;k<temp.size();k++)
        {
            result[k]=temp.get(k);
        }
        return result; 
    }
}

class Solution4 
{
    public int[] intersectionArray(int[] nums1, int[] nums2) 
    {
        // if the array is not Sorted then
        // optimal
        Map<Integer,Integer> dict=new HashMap<>();
        List<Integer> temp=new ArrayList<>();
        for(int n : nums1)
        {
            dict.put(n,dict.getOrDefault(n,0)+1);
        }
        for(int n : nums2)
        {
            if(dict.containsKey(n) && dict.get(n)>0)
            {
                temp.add(n);
                dict.put(n,dict.get(n)-1);
            }
        }
        int result[]=new int[temp.size()];
        for(int i=0;i<temp.size();i++)
        {
            result[i]=temp.get(i);
        }
        return result;   
    }
}