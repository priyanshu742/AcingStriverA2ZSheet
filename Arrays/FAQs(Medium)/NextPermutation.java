import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1].

The next permutation of an array of integers is the next lexicographically greater permutation of its integers.
More formally, if all the permutations of the array are sorted in lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted order.
If such arrangement is not possible (i.e., the array is the last permutation), then rearrange it to the lowest possible order (i.e., sorted in ascending order).
You must rearrange the numbers in-place and use only constant extra memory.

Example 1
Input: nums = [1,2,3]
Output: [1,3,2]
Explanation:
The next permutation of [1,2,3] is [1,3,2].

Example 2
Input: nums = [3,2,1]
Output: [1,2,3]
Explanation:
[3,2,1] is the last permutation. So we return the first: [1,2,3].


Constraints
1 <= nums.length <= 100
0 <= nums[i] <= 100

MEDIUM
*/

class Solution1 
{
    public void nextPermutation(int[] nums) 
    {
        // brute
        // generating all the possiblePermutations then finding the nextPermutation using an extra array as Map
        Set<List<Integer>> uniquePermutations=new HashSet<>();
        int hash[]=new int[nums.length];
        List<Integer> pair=new ArrayList<>();
        generatePermutation(nums,pair,hash,uniquePermutations);
        List<List<Integer>> allPermutations=new ArrayList<>(uniquePermutations);
        allPermutations.sort((a,b) -> {
            for(int i=0;i<a.size();i++)
            {
                int cmp=Integer.compare(a.get(i),b.get(i));
                if(cmp!=0)
                {
                    return cmp;
                }
            }
            return 0;
        });
        List<Integer> current=new ArrayList<>();
        for(int n : nums)
        {
            current.add(n);
        }
        int currentIndex=allPermutations.indexOf(current);
        int nextIndex=(currentIndex +1)%allPermutations.size();
        List<Integer> next=allPermutations.get(nextIndex);
        for(int i=0;i<next.size();i++)
        {
            nums[i]=next.get(i);
        }
    }
    public void generatePermutation(int[] nums,List<Integer> pair,int []hash,Set<List<Integer>> uniquePermutations)
    {
        if(pair.size()==nums.length)
        {
            uniquePermutations.add(new ArrayList<>(pair));
            return ;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(hash[i]==0)
            {
                hash[i]=1;
                pair.add(nums[i]);
                generatePermutation(nums,pair,hash,uniquePermutations);
                pair.remove(pair.size()-1);
                hash[i]=0;
            }
        }
    }
}

class Solution2
{
    public void nextPermutation(int[] nums) 
    {
        // brute
        // generating all the possiblePermutations then finding the nextPermutation without using extra space
        Set<List<Integer>> uniquePermutations=new HashSet<>();
        generatePermutation(0,nums,uniquePermutations);
        List<List<Integer>> allPermutations=new ArrayList<>(uniquePermutations);
        allPermutations.sort((a,b) -> {
            for(int i=0;i<a.size();i++)
            {
                int cmp=Integer.compare(a.get(i),b.get(i));
                if(cmp!=0)
                {
                    return cmp;
                }
            }
            return 0;
        });
        List<Integer> current=new ArrayList<>();
        for(int n : nums)
        {
            current.add(n);
        }
        int currentIndex=allPermutations.indexOf(current);
        int nextIndex=(currentIndex+1)%allPermutations.size();
        List<Integer> next=allPermutations.get(nextIndex);
        for(int i=0;i<next.size();i++)
        {
            nums[i]=next.get(i);
        }
    }
    public void generatePermutation(int index,int []nums,Set<List<Integer>> uniquePermutations)
    {
        if(index==nums.length)
        {
            List<Integer> pair =new ArrayList<>();
            for(int i=0;i<nums.length;i++)
            {
                pair.add(nums[i]);
            }
            uniquePermutations.add(new ArrayList<>(pair));
            return ;
        }
        for(int i=index;i<nums.length;i++)
        {
            swap(i,index,nums);
            generatePermutation(index+1,nums,uniquePermutations);
            swap(i,index,nums);
        }
    }
    public void swap(int i,int j,int []nums)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}

class Solution3 
{
    public void nextPermutation(int[] nums) 
    {
        // optimal
        int index=-1;
        // finding a breakpoint
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                index=i;
                break;
            }
        }
        if(index==-1)
        {
            reverse(nums,0,nums.length-1);
            return;
        } 
        // swapping breakpoint number with the smallest greater number available (suffix is already sorted in descending order)

        for(int i=nums.length-1;i>=index;i--)
        {
            if(nums[i]>nums[index])
            {
                swap(nums,i,index);
                break;
            }
        }
        // reversing the array after the breapoint to generate the smallest possible number (array is in descending order so reversing it will make it in ascending order)
        reverse(nums,index+1,nums.length-1);
    }
    public void swap(int[] nums,int left,int right)
    {
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    } 
    public void reverse(int[] nums,int start,int end)
    {
        while(start<end)
        {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    } 
}