package BinarySearch.BSOnAnswers;

/*

Given two sorted arrays a and b of size m and n respectively.
Find the kth element of the final sorted array.

Example 1
Input: a = [2, 3, 6, 7, 9], b = [1, 4, 8, 10], k = 5
Output: 6
Explanation: The final sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. 
The 5th element of this array is 6.

Example 2
Input: a = [100, 112, 256, 349, 770], b = [72, 86, 113, 119, 265, 445, 892], k = 7
Output: 256
Explanation: Final sorted array is - [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892], 
7th element of this array is 256.


Constraints
1 <= m, n <= 104
0 <= arr1[i[, arr2[i] < 109
1 <= k <= m+n

HARD
*/

class Solution 
{
    public int kthElement(int[] a, int[] b, int k) 
    {
        // optimal
        int n1=a.length;
        int n2=b.length;
        if(n1>n2)
        {
            return kthElement(b,a,k);
        }
        int low=Math.max(0,k-n2);
        int high=Math.max(n1,k);
        int left=k;
        while(low<=high)
        {
            int mid1=low+(high-low)/2;
            int mid2=left-mid1;
            int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
            if(mid1<n1)
            {
                r1=a[mid1];
            }
            if(mid2<n2)
            {
                r2=b[mid2];
            }
            if(mid1-1>=0)
            {
                l1=a[mid1-1];
            }
            if(mid2-1>=0)
            {
                l2=b[mid2-1];
            }

            if(l1<=r2 && l2<=r1)
            {
                return Math.max(l1,l2);
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
        return 0;
    }
}
