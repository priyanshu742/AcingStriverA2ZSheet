package LearnTheBasics.LearnBasicRecursion;


/*

Given an array arr of n elements. The task is to reverse the given array. The reversal of array should be inplace.

Example 1
Input: n=5, arr = [1,2,3,4,5]
Output: [5,4,3,2,1]
Explanation: The reverse of the array [1,2,3,4,5] is [5,4,3,2,1]

Example 2
Input: n=6, arr = [1,2,1,1,5,1]
Output: [1,5,1,1,2,1]
Explanation: The reverse of the array [1,2,1,1,5,1] is [1,5,1,1,2,1].


Constraints
1 <= n <= 104
1 <= arr[i] <= 105

MEDIUM
*/


class Solution 
{
    public void reverse(int[] arr, int n)
    {
        int first=0;
        int last=n-1;
        swap(arr,first,last);
    }

    public void swap(int arr[],int first,int last)
    {
        if(first>=last)
        {
            return;
        }
        else
        {
            int temp=arr[first];
            arr[first]=arr[last];
            arr[last]=temp;

            swap(arr,first+1,last-1);
        }
    }
}


    

