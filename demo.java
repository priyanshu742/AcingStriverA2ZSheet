import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution 
{
    // optimal
    public long numberOfInversions(int[] nums) 
    {
        return mergeSort(nums,0,nums.length-1);
    }

    public int mergeSort(int arr[],int low,int high)
    {
        int count=0;
        if(low>=high)
        {
            return count;
        }
        int mid=(low+high)/2;
        count+=mergeSort(arr,low,mid);
        count+=mergeSort(arr,mid+1,high);
        count+=merge(arr,low,mid,high);
        return count;
    }

    public int merge(int arr[],int low,int mid,int high)
    {
        int count=0;
        int index=0;
        int temp[]=new int[high-low+1];
        int left=low;
        int right=mid+1;
        while(left<=mid && right <=high)
        {
            if (arr[left]<=arr[right])
            {
                temp[index]=arr[left];
                index++;
                left++;
            }
            //right is smaller
            else
            {
                temp[index]=arr[right];
                index++;
                right++;
            }
        }
        while(left<=mid)
        {
            temp[index]=arr[left];
            index++;
            left++;
        }
        while(right<=high)
        {
            temp[index]=arr[right];
            index++;
            right++;
        }
        for(int i=low;i<=high;i++)
        {
            arr[i]=temp[i-low];
        }
        return count;
    }
}

public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[] ={ 6, 5, 7, 1, 8, 6, 4, 3, 2};

        int result[]=s1.findMissingRepeatingNumbers(nums);

        for(int n: result)
        System.out.println(n);
    }
}