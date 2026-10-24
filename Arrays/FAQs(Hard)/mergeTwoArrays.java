
/* 

Given two integer arrays nums1 and nums2. Both arrays are sorted in non-decreasing order.
Merge both the arrays into a single array sorted in non-decreasing order.

The final sorted array should be stored inside the array nums1 and it should be done in-place.
nums1 has a length of m + n, where the first m elements denote the elements of nums1 and rest are 0s.
nums2 has a length of n.

Example 1
Input: nums1 = [-5, -2, 4, 5], nums2 = [-3, 1, 8]
Output: [-5, -3, -2, 1, 4, 5, 8]
Explanation:
The merged array is: [-5, -3, -2, 1, 4, 5, 8], where [-5, -2, 4, 5] are from nums1 and [-3, 1, 8] are from nums2

Example 2
Input: nums1 = [0, 2, 7, 8], nums2 = [-7, -3, -1]
Output: [-7, -3, -1, 0, 2, 7, 8]
Explanation:
The merged array is: [-7, -3, -1, 0, 2, 7, 8], where [0, 2, 7, 8] are from nums1 and [-7, -3, -1] are from nums2


Constraints
n == nums2.length.
m + n == nums1.length.
0 <= n, m <= 1000
-104 <= nums1[i], nums2[i] <= 104
Both nums1 and nums2 are sorted in non-decreasing order.

EASY
*/

class Solution1
{
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        // brute
        // using an extra array to store values
        int temp[]=new int[m+n];
        int left=0;
        int right=0;
        int index=0;
        while(left<m && right<n)
        {
            if(nums1[left]<=nums2[right])
            {
                temp[index]=nums1[left];
                left++;
                index++;
            }
            else
            {   
                temp[index]=nums2[right];
                right++;
                index++;
            }
        }
        while(left<m)
        {
            temp[index]=nums1[left];
            left++;
            index++;
        }
        while(right<n)
        {
            temp[index]=nums2[right];
            right++;
            index++;
        }
        for(int i=0;i<temp.length;i++)
        {
            nums1[i]=temp[i];
        }
    }
}

class Solution2 
{
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        // better
        // creating a copy instead
        int copy[]=nums1.clone();
        int left=0;
        int right=0;
        int index=0;
        while(left<m && right<n)
        {
            if(copy[left]<=nums2[right])
            {
                nums1[index]=copy[left];
                index++;
                left++;
            }
            else
            {
                nums1[index]=nums2[right];
                index++;
                right++;
            }
        }
        while(left<m)
        {
            nums1[index]=copy[left];
            index++;
            left++;
        }
        while(right<n)
        {
            nums1[index]=nums2[right];
            index++;
            right++;
        }
    }
}

class Solution3
{
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        // optimal
        int left=m-1;  //pointer at end of valid index of nums1; 
        int right=n-1; //pointer at end of nums2;
        int put=m+n-1; //pointer at end of nums1;
        while(left>=0 && right>=0)
        {
            if(nums1[left]>=nums2[right])
            {
                nums1[put]=nums1[left];
                put--;
                left--;
            }
            else
            {
                nums1[put]=nums2[right];
                put--;
                right--;
            }
        }
        /* left elements will already be sorted and in the correct position
        while(left>=0)
        {
            nums1[put]=nums1[left];
            put--;
            left--;
        }
        */
        while(right>=0)
        {
            nums1[put]=nums2[right];
            put--;
            right--;
        }
    }
}