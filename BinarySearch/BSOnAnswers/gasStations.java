package BinarySearch.BSOnAnswers;

/*

Given a sorted array arr of size n, containing integer positions of n gas stations on the X-axis, and an integer k, place k new gas stations on the X-axis.
The new gas stations can be placed anywhere on the non-negative side of the X-axis, including non-integer positions.
Let dist be the maximum distance between adjacent gas stations after adding the k new gas stations.
Find the minimum value of dist.
Your answer will be accepted if it is within 1e-6 of the true value.


Example 1
Input: n = 10, arr = [1, 2, 3, 4, 5, 6 ,7, 8, 9, 10], k = 10
Output: 0.50000
Explanation:
There are initially 10 gas stations from 1 to 10. We need to add 10 new gas stations.
Place the new stations at: [1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 7.5, 8.5, 9.5, 10.5]
The resulting positions are: [1, 1.5, 2, 2.5, 3, 3.5, 4, 4.5, 5, 5.5, 6, 6.5, 7, 7.5, 8, 8.5, 9, 9.5, 10, 10.5]
The maximum distance between adjacent gas stations is 0.5.
Hence, the minimum possible value of dist is 0.5.

Example 2
Input : n = 10, arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 1
Output: 1.00000
Explanation:
One of the possible ways to place 1 gas station is [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
New Gas Station is at 11.
Thus the maximum difference between adjacent gas stations is still 1.
Hence, the value of dist is 1.
It can be shown that there is no possible way to add 1 gas station in such a way that the value of dist is lower than this. 


Constraints
10 <= n <= 5000 
0 <= arr[i] <= 109
arr is sorted in a strictly increasing order 
0 <= k <= 105

HARDEST
*/

class Solution 
{
    public double minimiseMaxDistance(int[] arr, int k) 
    {
        double low=0;
        double high=0;
        for(int i=0;i<arr.length-1;i++)
        {
            high=Math.max(high,(double)arr[i+1]-arr[i]);
        }
        while(high-low>1e-6)
        {
            double mid=low+(high-low)/2.0;
            int Stations=countStations(arr,mid);
            if(Stations>k)
            {
                low=mid;
            }
            else
            {
                high=mid;
            }
        }
        return high;
    }

    public int countStations(int []arr,double dist)
    {
        int count=0;
        for(int i=0;i<arr.length-1;i++)
        {
            int numberInBetween=(int)((arr[i+1]-arr[i])/dist);
            if((arr[i+1]-arr[i])==numberInBetween*dist)
            {
                numberInBetween--;
            }
            count+=numberInBetween;
        }
        return count;
    }
}

