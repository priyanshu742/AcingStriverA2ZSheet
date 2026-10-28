package BinarySearch.LogicBuilding;

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

class Solution1
{
    public int countOccurrences(int[] arr, int target) 
    {
        // linearSearch
        int first=-1;
        int last=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==target)
            {
                if(first==-1)
                {
                    first=i;
                }
                last=i;
            }
        }
        if(first==-1)
        {
            return 0;
        }
        return last-first+1;
    }
}

class Solution2
{
    public int countOccurrences(int[] arr, int target) 
    {
        // using lowerBound and UpperBound to find first and lastOccurrence
        int first=lowerBound(arr,target);
        if(first==arr.length || arr[first]!=target)
        {
            return 0;
        }
        int last=upperBound(arr,target)-1;
        return last-first+1;
    }
    public int lowerBound(int[] arr, int target) 
    {
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]>=target)
            {
                ans=mid;
                high=mid-1;
            }
            else 
            {
                low=mid+1;
            }
        }
        return ans;
    }
    public int upperBound(int[] arr, int target) 
    {
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]>target)
            {
                ans=mid;
                high=mid-1;
            }
            else 
            {
                low=mid+1;
            }
        }
        return ans;
    }
}

class Solution3 
{
    public int countOccurrences(int[] arr, int target) 
    {
        // binarySearch
        int first=firstOccurrence(arr,target);
        if(first==-1)
        {
            return 0;
        }
        int last=lastOccurrence(arr,target);
        return last-first+1;
    }
    public int firstOccurrence(int[] arr, int target) 
    {
        int low=0;
        int high=arr.length-1;
        int first=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]==target)
            {
                first=mid;
                high=mid-1;
            }
            else if(arr[mid]>target)
            {
                high=mid-1;
            }
            else 
            {
                low=mid+1;
            }
        }
        return first;
    }
    public int lastOccurrence(int[] arr, int target) 
    {
        int low=0;
        int high=arr.length-1;
        int last=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]==target)
            {
                last=mid;
                low=mid+1;
            }
            else if(arr[mid]>target)
            {
                high=mid-1;
            }
            else 
            {
                low=mid+1;
            }
        }
        return last;
    }
}

