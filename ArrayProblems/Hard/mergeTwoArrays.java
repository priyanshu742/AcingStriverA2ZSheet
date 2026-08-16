package ArrayProblems.Hard;

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

class Solution 
{
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        // optimal Solution without extra space
        int p1=m-1; // pointing to the end of valid elements in nums1
        int p2=n-1;  // pointing to the end of nums2
        int p=m+n-1;  // pointing to the end of nums1

        while(p1>=0 && p2>=0)
        {
            if(nums1[p1]>nums2[p2])
            {
                nums1[p]=nums1[p1];
                p1--;
                p--;
            }
            else
            {
                nums1[p]=nums2[p2];
                p2--;
                p--;
            }
        }
        while(p2>=0)
        {
            nums1[p]=nums2[p2];
            p2--;
            p--;
        }
    }
}