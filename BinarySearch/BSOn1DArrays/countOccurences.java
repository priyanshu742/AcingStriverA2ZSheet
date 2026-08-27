package BinarySearch.BSOn1DArrays;

/* 

You are given a sorted array of integers arr and an integer target. Your task is to determine how many times target appears in arr.
Return the count of occurrences of target in the array.

Example 1
Input: arr = [0, 0, 1, 1, 1, 2, 3], target = 1
Output: 3
Explanation: The number 1 appears 3 times in the array.

Example 2
Input: arr = [5, 5, 5, 5, 5, 5], target = 5
Output: 6
Explanation: All elements in the array are 5, so the target appears 6 times.


Constraints
1 <= arr.length <= 106
1 <= arr[i] <= 106
1 <= target <= 106

EASY
*/

class Solution 
{
    public int countOccurrences(int[] arr, int target) 
    {
        int first=firstOccurence(arr,arr.length,target);
        if(first==-1)
        {
            return 0;
        }
        int last=lastOccurence(arr,arr.length,target);
        return last-first+1;
    }

    public int firstOccurence(int arr[],int size,int target)
    {
        int low=0;
        int high=size-1;
        int first=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]==target)
            {
                first=mid;
                high=mid-1;
            }
            else if(arr[mid]<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return first;
    }
    
    public int lastOccurence(int arr[],int size,int target)
    {
        int low=0;
        int high=size-1;
        int last=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]==target)
            {
                last=mid;
                low=mid+1;
            }
            else if(arr[mid]<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return last;
    }
}
