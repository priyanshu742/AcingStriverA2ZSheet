package BeginnerProblems.basicArrays;

/*

Given an array arr of size n, the task is to find the sum of all the elements in the array.

Example 1:
Input: n=5, arr = [1,2,3,4,5]
Output: 15
Explanation: Sum of all the elements is 1+2+3+4+5 = 15

Example 2:
Input: n=6, arr = [1,2,1,1,5,1]
Output: 11
Explanation: Sum of all the elements is 1+2+1+1+5+1 = 11

Example 3:
Input: n=3, arr = [2,1,1]
Output: 4


Constraints:
1 <= n <= 105
1 <= arr[i] <= 104

EASY
*/

class Solution 
{
  public  int sum(int arr[], int n) 
  {
    int sum=0;
    for(int i=0;i<n;i++)
    {
        sum=sum+arr[i];
    }
    return sum;
    }
}