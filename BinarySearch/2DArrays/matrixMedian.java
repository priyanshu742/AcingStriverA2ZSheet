import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*

Given a 2D array matrix that is row-wise sorted. The task is to find the median of the given matrix.

Example 1
Input: matrix=[ [1, 4, 9], [2, 5, 6], [3, 7, 8] ] 
Output: 5
Explanation: If we find the linear sorted array, the array becomes 1 2 3 4 5 6 7 8 9. So, median = 5

Example 2
Input: matrix=[ [1, 3, 8], [2, 3, 4], [1, 2, 5] ] 
Output: 3
Explanation: If we find the linear sorted array, the array becomes 1 1 2 2 3 3 4 5 8. So, median = 3


Constraints
N==matrix.size
M==matrix[0].size
1 <= N, M <= 105
1 <= N*M <= 106
1 <= matrix[i] <= 109
N*M is odd

MEDIUM
*/

class Solution1 
{
    public int findMedian(int[][] matrix) 
    {
        // brute
        int row=matrix.length;
        int column=matrix[0].length;
        int n=row*column;
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                arr.add(matrix[i][j]);
            }   
        }
       Collections.sort(arr);
       return arr.get(n/2);
    }
}

class Solution2 
{
    public int findMedian(int[][] matrix) 
    {
        // optimal
        int row=matrix.length;
        int column=matrix[0].length;
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        int req=(row*column)/2;
        int ans=-1;
        for(int i=0;i<row;i++)
        {
            if(matrix[i][0]<low)
            {
                low=matrix[i][0];
            }
            if(matrix[i][column-1]>high)
            {
                high=matrix[i][column-1];
            }
        }
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int smaller=calculate(matrix,mid);
            if(smaller<=req)
            {
                low=mid+1;
            }
            else
            {
                ans=mid;
                high=mid-1;
            }
        }
        return ans; // return low;
    }
    public int calculate(int[][] matrix,int number)
    {
        int count=0;
        for(int i=0;i<matrix.length;i++)
        {
            count=count+upperBound(matrix[i],number);
        }
        return count;
    } 
    public int upperBound(int[] arr,int number)
    {
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]>number)
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
}