package BinarySearch.BSOnAnswers;

/*

Given two sorted arrays arr1 and arr2 of size m and n respectively, 
return the median of the two sorted arrays.
The median is defined as the middle value of a sorted list of numbers.
In case the length of the list is even, the median is the average of the two middle elements.

Example 1
Input: arr1 = [2, 4, 6], arr2 = [1, 3, 5]
Output: 3.5
Explanation: The array after merging arr1 and arr2 will be [ 1, 2, 3, 4, 5, 6 ].
As the length of the merged list is even, the median is the average of the two middle elements. 
Here two medians are 3 and 4. So the median will be the average of 3 and 4, which is 3.5.

Example 2
Input: arr1 = [2, 4, 6], arr2 = [1, 3]
Output: 3.0
Explanation: The array after merging arr1 and arr2 will be [ 1, 2, 3, 4, 6 ]. The median is simply 3.


Constraints
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= arr1[i], arr2[i] <= 106

HARDEST
*/

class Solution 
{
    public double median(int[] arr1, int[] arr2) 
    {
        int n1=arr1.length;
        int n2=arr2.length;

        if(n1>n2) 
        {
            return median(arr2,arr1);
        }
        int low=0;
        int high=n1;
        int left=(n1+n2+1)/2;
        int n=n1+n2;

        while(low<=high)
        {
            int mid1=low+(high-low)/2;
            int mid2=left-mid1;
            int l1=Integer.MIN_VALUE, l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE, r2=Integer.MAX_VALUE;

            if(mid1<n1)
            {
                r1=arr1[mid1];
            }
            if(mid2<n2)
            {
                r2=arr2[mid2];
            }

            if(mid1-1>=0)
            {
                l1=arr1[mid1-1];
            }

            if(mid2-1>=0)
            {
                l2=arr2[mid2-1];
            }

            if(l1<=r2 && l2<=r1)
            {
                if(n%2==1)
                {
                    return Math.max(l1,l2);
                }
                return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }
            else if(l1>r2)
            {
                high=mid1-1;
            }
            else
            {
                low=mid1+1;
            }
        }
        return 0.0;
    }
}





