package BinarySearch.FAQs;

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

class Solution1 
{
    public int kthElement(int[] a, int[] b, int k) 
    {
        // brute
        int n1=a.length;
        int n2=b.length;
        int temp[]=new int[n1+n2];
        int l=0;
        int r=0;
        int index=0;
        while(l<n1 && r<n2)
        {
            if(a[l]<=b[r])
            {
                temp[index]=a[l];
                index++;
                l++;
            }
            else
            {
                temp[index]=b[r];
                index++;
                r++;
            }
        }
        while(l<n1)
        {
            temp[index]=a[l];
            index++;
            l++;
        }
        while(r<n2)
        {
            temp[index]=b[r];
            index++;
            r++;
        }
        return temp[k-1];
    }
}

class Solution2 
{
    public int kthElement(int[] a, int[] b, int k) 
    {
        // better
        int n1=a.length;
        int n2=b.length;
        int ele=-1;
        int l=0;
        int r=0;
        int count=0;
        while(l<n1 && r<n2)
        {
            if(a[l]<=b[r])
            {
                if(count==k-1)
                {
                    return a[l];
                }
                count++;
                l++;
            }
            else
            {
                if(count==k-1)
                {
                    return b[r];
                }
                count++;
                r++;
            }
        }
        while(l<n1)
        {
            if(count==k-1)
            {
                return a[l];
            }
            count++;
            l++;
        }
        while(r<n2)
        {
            if(count==k-1)
            {
                return b[r];
            }
            count++;
            r++;
        }
       return 0;
    }
}

class Solution3 
{
    public int kthElement(int[] a, int[] b, int k) 
    {
        // optimal
        int n1=a.length;
        int n2=b.length;
        if(n1>n2)
        { 
            kthElement(b,a,k);
        }
        int low=Math.max(0,k-n2); // array2 will get exhausted if k>n2 (to handle this)
        int high=Math.min(k,n1); // if k<n1 then only k elements are needed in left half,not more than that
        int left=k;
        int n=n1+n2;
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
            else // if(l2>r1)
            {
                low=mid1+1;
            }
        }
        return 1;
    }
}

