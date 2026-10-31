package BinarySearch.FAQs;


/*

Given an array nums of n integers, where nums[i] represents the number of pages in the i-th book, 
and an integer m representing the number of students, allocate all the books to the students so that each student gets at least one book, 
each book is allocated to only one student, and the allocation is contiguous.

Allocate the books to m students in such a way that the maximum number of pages assigned to a student is minimized.
If the allocation of books is not possible, return -1.

Example 1
Input: nums = [12, 34, 67, 90], m=2
Output: 113
Explanation: The allocation of books will be 12, 34, 67 | 90. One student will get the first 3 books and the other will get the last one.

Example 2
Input: nums = [25, 46, 28, 49, 24], m=4
Output: 71
Explanation: The allocation of books will be 25, 46 | 28 | 49 | 24.


Constraints
1 <= n, m <= 104
1 <= nums[i] <= 105

MEDIUM
*/

class Solution1 
{
    public int findPages(int[] nums, int m) 
    {
        // linearSearch
        if(m>nums.length)
        {
            return -1;
        }
        int low=Integer.MIN_VALUE;
        int high=0;
        int ans=-1;
        for(int n : nums)
        {
            high=high+n;
            if(n>low)
            {
                low=n;
            }
        }
        for(int i=low;i<=high;i++)
        {
            int noOfstudents=calculate(nums,i);
            if(noOfstudents<=m)
            {
                ans=i;
                break;
            }
        }
        return ans;
    }
    public int calculate(int[] nums, int noOfPages)
    {
        int student=1;
        int pages=0;
        for(int i=0;i<nums.length;i++)
        {
            if(pages+nums[i]<=noOfPages)
            {
                pages=pages+nums[i];
            }
            else
            {
                student++;
                pages=nums[i];
            }
        }
        return student;
    } 
}
    
class Solution2
{
    public int findPages(int[] nums, int m) 
    {
        // binarySearch
        if(m>nums.length)
        {
            return -1;
        }
        int low=Integer.MIN_VALUE;
        int high=0;
        int ans=-1;
        for(int n : nums)
        {
            high=high+n;
            if(n>low)
            {
                low=n;
            }
        }
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int noOfStudents=calculate(nums,mid);
            if(noOfStudents<=m)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans; // return low
    }
    public int calculate(int[] nums, int maxPages)
    {
        int student=1;
        int pages=0;
        for(int i=0;i<nums.length;i++)
        {
            if(pages+nums[i]<=maxPages)
            {
                pages=pages+nums[i];
            }
            else
            {
                student++;
                pages=nums[i];
            }
        }
        return student;
    } 
}