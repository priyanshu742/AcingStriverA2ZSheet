package Arrays.Fundamentals;

/*

Given an integer array nums and a non-negative integer k, rotate the array to the left by k steps.

Example 1
Input: nums = [1, 2, 3, 4, 5, 6], k = 2
Output: nums = [3, 4, 5, 6, 1, 2]
Explanation:
rotate 1 step to the left: [2, 3, 4, 5, 6, 1]
rotate 2 steps to the left: [3, 4, 5, 6, 1, 2]

Example 2
Input: nums = [3, 4, 1, 5, 3, -5], k = 8
Output: nums = [1, 5, 3, -5, 3, 4]
Explanation:
rotate 1 step to the left: [4, 1, 5, 3, -5, 3]
rotate 2 steps to the left: [1, 5, 3, -5, 3, 4]
rotate 3 steps to the left: [5, 3, -5, 3, 4, 1]
rotate 4 steps to the left: [3, -5, 3, 4, 1, 5]
rotate 5 steps to the left: [-5, 3, 4, 1, 5, 3]
rotate 6 steps to the left: [3, 4, 1, 5, 3, -5]
rotate 7 steps to the left: [4, 1, 5, 3, -5, 3]
rotate 8 steps to the left: [1, 5, 3, -5, 3, 4]


Constraints
1 <= nums.length <= 105
-104 <= nums[i] <= 104
0 <= k <= 105

EASY
*/

class Solution1
{
    public void rotateArray(int[] nums, int k) 
    {
        // brute (A)
        k=k%nums.length;
        while(k!=0)
        {
            int first=nums[0];
            for(int i=0;i<nums.length-1;i++)
            {
                nums[i]=nums[i+1];
            }
            nums[nums.length-1]=first;
            k--;
        }
    }
}

class Solution2 
{
    public void rotateArray(int[] nums, int k) 
    {
        // brute (B)
        k=k%nums.length;
        for(int i=1;i<=k;i++)
        {
            int first=nums[0];
            for(int j=0;j<nums.length-1;j++)
            {
                nums[j]=nums[j+1];
            }
            nums[nums.length-1]=first;
        }
    }
}

class Solution 
{
    public void rotateArray(int[] nums, int k) 
    {
        // better
        int n=nums.length;
        k=k%n;
        int temp[]=new int[k];
        // 1. copy
        for(int i=0;i<k;i++)
        {
            temp[i]=nums[i];
        }
        // 2. shift
        for(int i=k;i<n;i++)
        {
            nums[i-k]=nums[i];
        }
        // 3. push back
        for(int i=n-k;i<n;i++)
        {
            // int j=0;
            // nums[i]=temp[j];
            // j++;
            nums[i]=temp[i-(n-k)];
        }
        
    }
}

class Solution4
{
    public void rotateArray(int[] nums, int k) 
    {
        // optimal
        int n=nums.length;
        k=k%nums.length;
        // reverses the first k elements
        reverse(nums,0,k-1);
        // reverses the remaining elements
        reverse(nums,k,n-1);
        // reverses the entire array
        reverse(nums,0,n-1); 
    }
    public void reverse(int nums[],int low,int high)
    {
        while(low<=high)
        {
            int temp=nums[low];
            nums[low]=nums[high];
            nums[high]=temp;
            low++;
            high--;
        }
    }
}