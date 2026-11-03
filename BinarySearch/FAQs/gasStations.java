package BinarySearch.FAQs;

import java.util.PriorityQueue;

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

class Solution1 
{
    public double minimiseMaxDistance(int[] arr, int k) 
    {
        // brute
        int howMany[]=new int[arr.length-1];
        for(int i=0;i<k;i++)
        {
            double maxSection=-1;
            int maxInd=-1;
            for(int j=0;j<arr.length-1;j++)
            {
                double difference=arr[j+1]-arr[j];
                double sectionLength=difference/(howMany[j]+1);
                if(sectionLength>maxSection)
                {
                    maxSection=sectionLength;
                    maxInd=j;
                }
            }  
            howMany[maxInd]++;
        }
        double maxAns=-1;
        for(int i=0;i<arr.length-1;i++)
        {
            double difference=arr[i+1]-arr[i];
            double sectionLength=difference/(howMany[i]+1);
            if(sectionLength>maxAns)
            {
                maxAns=sectionLength;
            }
        }
        return maxAns;  
    }
}


class Solution2
{
    public double minimiseMaxDistance(int[] arr, int k) 
    {
        // better
        int howMany[]=new int[arr.length-1];
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b) -> Double.compare(b[0],a[0]));
        for(int i=0;i<arr.length-1;i++)
        {
            pq.add(new double[]{(double)arr[i+1]-arr[i],(double)i});
        }
        for(int i=0;i<k;i++) // putting gasStations
        {
            double[] tp=pq.poll();
            int sectionIndex=(int)tp[1];
            howMany[sectionIndex]++;
            double difference=arr[sectionIndex+1]-arr[sectionIndex];
            double newSectionLength=difference/(howMany[sectionIndex]+1);
            pq.add(new double[]{(double)newSectionLength,(double)sectionIndex});
        }
        return pq.peek()[0];  
    }
}

class Solution 
{
    public double minimiseMaxDistance(int[] arr, int k) 
    {
        // optimal
        double low=0;
        double high=Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++)
        {
            int difference=arr[i]-arr[i-1];
            if(difference>high)
            {
                high=difference;
            }
        }
        while(high-low>1e-6)
        {
            double mid=low+(high-low)/2;
            int count=numberOfGasStations(arr,mid);
            if(count>k)
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
    public int numberOfGasStations(int[] arr, double distance) 
    {
        int count=0;
        for(int i=1;i<arr.length;i++)
        {
            double gap=arr[i]-arr[i-1];
            int numberInBetween=(int)((arr[i]-arr[i-1])/distance);
            if(gap==distance*numberInBetween)
            {
                numberInBetween--;
            }
            count=count+numberInBetween;
        }
        return count;
    }
}