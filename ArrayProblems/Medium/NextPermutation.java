package ArrayProblems.Medium;

/*

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1].

The next permutation of an array of integers is the next lexicographically greater permutation of its integers.
More formally, if all the permutations of the array are sorted in lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted order.
If such arrangement is not possible (i.e., the array is the last permutation), then rearrange it to the lowest possible order (i.e., sorted in ascending order).
You must rearrange the numbers in-place and use only constant extra memory.

Example 1
Input: nums = [1,2,3]
Output: [1,3,2]
Explanation:
The next permutation of [1,2,3] is [1,3,2].

Example 2
Input: nums = [3,2,1]
Output: [1,2,3]
Explanation:
[3,2,1] is the last permutation. So we return the first: [1,2,3].


Constraints
1 <= nums.length <= 100
0 <= nums[i] <= 100

MEDIUM
*/

class Solution 
{
    public void nextPermutation(int[] nums) 
    {
        int size=nums.length;
        int index=-1;

        for(int i=size-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                index=i;
                break;
            }
        }
        if(index == -1)
        {
            for(int i=0;i<size/2;i++)
            {
                int temp=nums[i];
                nums[i]=nums[size-1-i];
                nums[size-1-i]=temp;
            }
            return;
        }
        else
        {
            for(int i=size-1;i>index;i--)
            {
                if(nums[i]>nums[index])
                {
                    int temp=nums[index];
                    nums[index]=nums[i];
                    nums[i]=temp;
                    break;
                }
            }
        }
        int start=index+1;
        int end=size-1;
        while(start<end)
        {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
