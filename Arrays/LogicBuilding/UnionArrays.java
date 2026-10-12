package Arrays.LogicBuilding;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* 

Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. The elements in the union must be in ascending order.
The union of two arrays is an array where all values are distinct and are present in either the first array, the second array, or both.

Example 1
Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
Output: [1, 2, 3, 4, 5, 7]
Explanation:
The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2

Example 2
Input: nums1 = [3, 4, 6, 7, 9, 9], nums2 = [1, 5, 7, 8, 8]
Output: [1, 3, 4, 5, 6, 7, 8, 9]
Explanation:
The element 7 is common to both, 3, 4, 6, 9 are from nums1 and 1, 5, 8 is from nums2

Constraints
1 <= nums1.length, nums2.length <= 1000
-104 <= nums1[i] , nums2[i] <= 104
Both nums1 and nums2 are sorted in non-decreasing order

EASY
*/

class Solution1 
{
    public int[] unionArray(int[] nums1, int[] nums2) 
    {
        // brute
        Set<Integer> unique=new TreeSet<>();
        for(int n:nums1)
        {
            unique.add(n);
        }
        for(int n:nums2)
        {
            unique.add(n);
        }
        int union[]=new int[unique.size()];
        int index=0;
        for(int n: unique)
        {
            union[index]=n;
            index++;
        }
        return union;   
    }
}

class Solution2
{
    public int[] unionArray(int[] nums1, int[] nums2) 
    {
        // optimal (A)
        List<Integer> temp=new ArrayList<>();
        int n1=nums1.length;
        int n2=nums2.length;
        int i=0;
        int j=0;
        while(i<n1 && j<n2)
        {
            if(nums1[i]<=nums2[j])
            {
                if(temp.size()==0 || temp.get(temp.size()-1)!=nums1[i])
                {
                    temp.add(nums1[i]);
                }
                i++;
            }
            else
            {
                if(temp.size()==0 || temp.get(temp.size()-1)!=nums2[j])
                {
                    temp.add(nums2[j]);
                }
                j++;
            }
        }
        while(i<n1)
        {
            if(temp.size()==0 || temp.get(temp.size()-1)!=nums1[i])
            {
                temp.add(nums1[i]);
            }
            i++;
        }
        while(j<n2)
        {
            if(temp.size()==0 || temp.get(temp.size()-1)!=nums2[j])    
            {
                temp.add(nums2[j]);
            }
            j++;
        }
        int []result=new int[temp.size()];
        for(int k=0;k<temp.size();k++)
        {
            result[k]=temp.get(k);
        }
        return result; 
    }
}

class Solution3
{
    public int[] unionArray(int[] nums1, int[] nums2) 
    {
        // optimal (B)
        int count=0;
        int lastAdded=Integer.MIN_VALUE;
        int n1=nums1.length;
        int n2=nums2.length;
        int i=0;
        int j=0;
        // counting unique elements
        while(i<n1 && j< n2)
        {
            if(nums1[i]<=nums2[j])
            {
                if(count==0 || lastAdded!=nums1[i])
                {   
                    lastAdded=nums1[i];
                    count++;
                }
                i++;
            }
            else
            {
                if(count==0 || lastAdded!=nums2[j])
                {
                    lastAdded=nums2[j];
                    count++;
                }
                j++;
            }
        }
        while(i<n1)
        {
            if(count==0 || lastAdded!=nums1[i])
            {
                lastAdded=nums1[i];
                count++;
            }
            i++;
        }
        while(j<n2)
        {
            if(count==0 || lastAdded!=nums2[j])    
            {
                lastAdded=nums2[j];
                count++;
            }
            j++;
        }
        
        int result[]=new int[count];
        int index=0;
        i=0;
        j=0;
        while(i<n1 && j<n2)
        {
            if(nums1[i]<=nums2[j])
            {
                if(index==0 || result[index-1]!=nums1[i])
                {
                   result[index]=nums1[i];
                   index++;
                }
                i++;
            }
            else
            {
                if(index==0 || result[index-1]!=nums2[j])
                {
                    result[index]=nums2[j];
                    index++;
                }
                j++;
            }
        }
        while(i<n1)
        {
            if(index==0 || result[index-1]!=nums1[i])
            {
                result[index]=nums1[i];
                index++;
            }
            i++;
        }
        while(j<n2)
        {
            if(index==0 || result[index-1]!=nums2[j])    
            {
                result[index]=nums2[j];
                index++;
            }
            j++;
        }
        return result; 
    }
}