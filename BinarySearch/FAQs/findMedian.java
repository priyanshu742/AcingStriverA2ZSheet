package BinarySearch.FAQs;

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

class Solution1 
{
    public double median(int[] arr1, int[] arr2) 
    {
        //brute 
        int temp[]=new int[arr1.length+arr2.length];
        int l=0;
        int r=0;
        int n1=arr1.length;
        int n2=arr2.length;
        int index=0;
        while(l<n1 && r<n2)
        {
            if(arr1[l]<=arr2[r])
            {
                temp[index]=arr1[l];
                index++;
                l++;
            }
            else
            {
                temp[index]=arr2[r];
                index++;
                r++;
            }
        }
        while(l<n1)
        {
            temp[index]=arr1[l];
            index++;
            l++;
        }
        while(r<n2)
        {
            temp[index]=arr2[r];
            index++;
            r++;
        }
        if(temp.length%2==0) // even number of elements
        {
            int num1=temp.length/2;
            int num2=num1-1;
            return ((double)temp[num1]+temp[num2])/2;
        }
        return temp[temp.length/2]; // odd number of elements
    }
}

class Solution2
{
    public double median(int[] arr1, int[] arr2) 
    {
        //better
        int l=0;
        int r=0;
        int n1=arr1.length;
        int n2=arr2.length;
        int n=n1+n2;
        int ind1=n/2;
        int ind2=ind1-1;
        int ele1=Integer.MIN_VALUE;
        int ele2=Integer.MIN_VALUE;
        int count=0;
        while(l<n1 && r<n2)
        {
            if(arr1[l]<=arr2[r])
            {
                if(count==ind1)
                {
                    ele1=arr1[l];
                }
                if(count==ind2)
                {
                    ele2=arr1[l];
                }
                count++;
                l++;
                if(ele1!=Integer.MIN_VALUE && ele2!=Integer.MIN_VALUE)
                {
                    break;
                }
            }
            else
            {
                if(count==ind1)
                {
                    ele1=arr2[r];
                }
                if(count==ind2)
                {
                    ele2=arr2[r];
                }
                count++;
                r++;
                if(ele1!=Integer.MIN_VALUE && ele2!=Integer.MIN_VALUE)
                {
                    break;
                }
            }
        }
        while(l<n1)
        {
            if(count==ind1)
            {
               ele1=arr1[l];
            }
            if(count==ind2)
            {
                ele2=arr1[l];
            }
            count++;
            l++;
            if(ele1!=Integer.MIN_VALUE && ele2!=Integer.MIN_VALUE)
            {
                break;
            }
        }
        while(r<n2)
        {
            if(count==ind1)
            {
                ele1=arr2[r];
            }
            if(count==ind2)
            {
                ele2=arr2[r];
            }
            count++;
            r++;
            if(ele1!=Integer.MIN_VALUE && ele2!=Integer.MIN_VALUE)
            {
                break;
            }
        }
        if(n%2==0)
        {
            return ((double)ele1+ele2)/2;
        }
        return ele1;
    }
}

class Solution3
{
    public double median(int[] arr1, int[] arr2) 
    {
        // optimal
        int n1=arr1.length;
        int n2=arr2.length;
        if(n1>n2)
        {
            return median(arr2,arr1);
        }
        int low=0;
        int high=n1; 
        int left=(n1+n2+1)/2; // no. of elements in left side
        int n=n1+n2;
        while(low<=high)
        {
            int mid1=low+(high-low)/2;
            int mid2=left-mid1;
            int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
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
                return ((double)Math.max(l1,l2)+Math.min(r1,r2))/2;
            }
            else if(l1>r2)
            {
                high=mid1-1;
            }
            else // else if(l2>r1)
            {
                low=mid1+1;
            }
        }
        return 0;
    }
}
