package BinarySearch.OnAnswers;

/* 

You are given an array weights where weights[i] represents the weight of the i-th package on a conveyor belt. 
All the packages must be shipped in the order given from one port to another within days days.
Each day, the ship can carry a contiguous sequence of packages, as long as the total weight does not exceed its maximum capacity.
Your task is to find the minimum possible capacity of the ship so that all packages can be shipped within the given number of days.

Example 1:
Input: weights = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], days = 5
Output: 15
Explanation:
Minimum ship capacity = 15. One way to ship in 5 days:
Day 1: 1 + 2 + 3 + 4 + 5 = 15
Day 2: 6 + 7 = 13
Day 3: 8
Day 4: 9
Day 5: 10
No day exceeds capacity 15 and all packages are shipped in order in 5 days.

Example 2:
Input: weights = [3, 2, 2, 4, 1, 4], days = 3
Output: 6
Explanation:
One possible division with capacity 6:
Day 1: 3 + 2 = 5
Day 2: 2 + 4 = 6
Day 3: 1 + 4 = 5
All packages shipped in order within 3 days.


Constraints:
1 <= days <= weights.length <= 5 * 10⁴
1 <= weights[i] <= 500

MEDIUM
*/

class Solution1
{
    public int shipWithinDays(int[] weights, int days) 
    {
        //linearSearch
        int low=Integer.MIN_VALUE;
        int high=0;
        int ans=-1;
        for(int n : weights)
        {
            high=high+n;
            if(n>low)
            {
                low=n;
            }
        }
        for(int i=low;i<=high;i++)
        {
            int noOFDays=calculate(weights,i);
            if(noOFDays<=days)
            {
                ans=i;
                break;
            }
        }   
       return ans;
    }
    public int calculate(int[] weights, int capacity)
    {
        int load=0;
        int days=1;
        for(int i=0;i<weights.length;i++)
        {
            if(load+weights[i]<=capacity)
            {
                load=load+weights[i];
            }
            else
            {
                days++;
                load=weights[i];
            }
        }
    return days;
    } 
}

class Solution2
{
    public int shipWithinDays(int[] weights, int days) 
    {
        // binarySearch
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int n : weights)
        {
            high=high+n;
            if(n>low)
            {
                low=n;
            }
        }
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int noOfDays=findDays(weights,mid);
            if(noOfDays<=days)
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
    public int findDays(int[] weights, int capacity)
    {
        int load=0;
        int days=1;
        for(int i=0;i<weights.length;i++)
        {
            if(load+weights[i]>capacity)
            {
                days=days+1;
                load=weights[i];
            }
            else
            {
                load=load+weights[i];
            }
        }
        return days;
    } 
}

class Solution3 
{
    public int shipWithinDays(int[] weights, int days) 
    {
        // binarySearch
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int n : weights)
        {
            high=high+n;
            if(n>low)
            {
                low=n;
            }
        }
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int noOfDays=calculate(weights,mid);
            if(noOfDays<=days)
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
    public int calculate(int[] weights, int capacity)
    {
        int load=0;
        int days=1;
        for(int i=0;i<weights.length;i++)
        {
            if(load+weights[i]<=capacity)
            {
                load=load+weights[i];
            }
            else
            {
                days++;
                load=weights[i];
            }
        }
        return days;
    } 
}