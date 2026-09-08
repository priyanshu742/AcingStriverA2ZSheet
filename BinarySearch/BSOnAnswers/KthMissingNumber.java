package BinarySearch.BSOnAnswers;

/*

Given a sorted array of unique positive integers arr,
your task is to return the kᵗʰ missing positive number that is not present in arr.
The array is guaranteed to be strictly increasing,
and the missing numbers are those positive integers that do not appear in arr but would appear in a full sequence starting from 1.

Example 1
Input: arr = [3, 5, 7, 10], k = 6
Output: 9
Explanation:
The missing numbers are [1, 2, 4, 6, 8, 9, 11, ...]. The 6ᵗʰ missing number is 9.

Example 2
Input: arr = [1, 4, 6, 8, 9], k = 3
Output: 5
Explanation:
The missing numbers are [2, 3, 5, 7, 10, ...]. The 3ʳᵈ missing number is 5.


Constraints
1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
arr[i] < arr[j] for all 1 <= i < j <= arr.length

HARD
*/

class Solution 
{
    public int findKthPositive(int[] arr, int k) 
    {
        int low=0;
        int high=arr.length-1;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int missing=arr[mid]-(mid+1);

            if(missing<k)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        // missing=arr[high]-(high+1)
        // more=k-missing

        // ans=arr[high]+more
        // ans=arr[high]+(k-missing)
        // ans=arr[high]+(k-(arr[high]-(high+1)))
        // ans=k+high+1
        //ans=high+1+k (low=high+1)
        return low+k;
    }
}