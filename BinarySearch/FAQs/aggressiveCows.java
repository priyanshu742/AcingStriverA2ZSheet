package BinarySearch.FAQs;
import java.util.Arrays;

/*

Given an array nums of size n, which denotes the positions of stalls, and an integer k, which denotes the number of aggressive cows, 
assign stalls to k cows such that the minimum distance between any two cows is the maximum possible.
Find the maximum possible minimum distance.

Example 1
Input: n = 6, k = 4, nums = [0, 3, 4, 7, 10, 9]
Output: 3
Explanation:
The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions [0, 3, 7, 10]. 
Here the distances between cows are 3, 4, and 3 respectively.
In no manner can we increase the minimum distance beyond 3.

Example 2
Input : n = 5, k = 2, nums = [4, 2, 1, 3, 6]
Output: 5
Explanation: The maximum possible minimum distance between any two cows will be 5 when 2 cows are placed at positions [1, 6]. 


Constraints
2 <= n <= 105
2 <= k <= n
0 <= nums[i] <= 109
All the positions of stalls are unique

HARD    
*/

class Solution1 
{
    public int aggressiveCows(int[] nums, int k) 
    {
        // linearSearch
        Arrays.sort(nums);
        int low=0;
        int high=nums[nums.length-1]-nums[0];
        int ans=-1;
        for(int i=low;i<=high;i++)
        {
            if(canWePlace(nums,i,k)==true)
            {
               ans=i;
            }
            else
            {
                break;
            }
        }
        return ans;
    }
    public boolean canWePlace(int[] nums,int distance, int k)
    {
        int noOfCows=1;
        int lastCowPosition=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]-lastCowPosition>=distance)
            {
                noOfCows++;
                lastCowPosition=nums[i];
            }
            if(noOfCows>=k)
            {
                return true;
            } 
        }
        return false;
    } 
}

class Solution2 
{
    public int aggressiveCows(int[] nums, int k) 
    {
        // linearSearch
        Arrays.sort(nums);
        int low=0;
        int high=nums[nums.length-1]-nums[0];
        int ans=-1;
        for(int i=low;i<=high;i++)
        {
            int noOfCows=calculate(nums,i);
            if(noOfCows>=k)
            {
               ans=i;
            }
            else
            {
                break;
            }
        }
        return ans;
    }
    public int calculate(int[] nums,int distance)
    {
        int cows=1;
        int lastCowPosition=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]-lastCowPosition>=distance)
            {
                cows++;
                lastCowPosition=nums[i];
            }
        }
        return cows;
    } 
}

class Solution3 
{
    public int aggressiveCows(int[] nums, int k) 
    {
        // binarySearch
        Arrays.sort(nums);
        int low=0;
        int high=nums[nums.length-1]-nums[0];
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int noOfcows=calculate(nums,mid);
            if(noOfcows>=k)
            {
                ans=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans;
    }
    public int calculate(int[] nums, int distance)
    {
        int cows=1;
        int lastCowPosition=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]-lastCowPosition>=distance)
            {
                cows++;
                lastCowPosition=nums[i];
            }
        }
        return cows;
    } 
}

class Solution4 
{
    public int aggressiveCows(int[] nums, int k) 
    {
        // binarySearch
        Arrays.sort(nums);
        int low=0;
        int high=nums[nums.length-1]-nums[0];
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(canWePlace(nums,mid,k)==true)
            {
                ans=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans; // return high
    }
    public boolean canWePlace(int[] nums, int distance,int cows)
    {
        int noOfCows=1;
        int lastCowPosition=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]-lastCowPosition>=distance)
            {
                noOfCows++;
                lastCowPosition=nums[i];
            }
            if(noOfCows>=cows)
            {
                return true;
            }
        }
        return false;
    } 
}