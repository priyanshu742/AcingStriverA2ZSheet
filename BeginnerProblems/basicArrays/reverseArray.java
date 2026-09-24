package BeginnerProblems.basicArrays;

/* 

Given an array arr of n elements. The task is to reverse the given array. 
The reversal of array should be inplace.


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

EASY
*/

class Solution1
{
    public void reverse(int[] arr, int n) 
    {
        // while loop
        int low=0;
        int high=n-1;
        while(low<high)
        {
            swap(arr,low,high);
            low++;
            high--;
        }
    }
    public void swap(int[] arr, int low,int high)
    {
        int temp=arr[low];
        arr[low]=arr[high];
        arr[high]=temp;
    } 
}

class Solution2
{
    public void reverse(int[] arr, int n) 
    {
        // for loop
        for(int i=0;i<n/2;i++)
        {
            int temp=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
        }
    }
}