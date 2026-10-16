import java.util.ArrayList;
import java.util.List;

/*

Given an integer n, 
return the first n (1-Indexed) rows of Pascal's triangle.

In Pascal's triangle:
The first row has one element with a value of 1.
Each row has one more element in it than its previous row.
The value of each element is equal to the sum of the elements directly above it when arranged in a triangle format.

Example 1:
Input: n = 4
Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]
Explanation: The Pascal's Triangle is as follows:

1
1 1
1 2 1
1 3 3 1

1st Row has its value set to 1.
All other cells take their value as the sum of the values directly above them

Example 2:
Input: n = 5
Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
Explanation: The Pascal's Triangle is as follows:

1
1 1
1 2 1
1 3 3 1
1 4 6 4 1

1st Row has its value set to 1.
All other cells take their value as the sum of the values directly above them


Constraints:
1 <= n <= 30
All values will fit inside a 32-bit integer.

MEDIUM
*/

class Solution1 
{
    public List<List<Integer>> pascalTriangleIII(int n) 
    {
        // brute
        List<List<Integer>> result=new ArrayList<>();
        for(int row=1;row<=n;row++)
        {
            List<Integer> temp=new ArrayList<>();
            for(int column=1;column<=row;column++)
            {
                temp.add(generateRow(row-1,column-1));
            }
            result.add(temp);
        }
        return result;
    }
    public int generateRow(int row,int column) 
    {
        // nCr= rowCcolumn
        int res=1;
        for(int i=0;i<column;i++)
        {
            res=res*(row-i);
            res=res/(i+1);
        }
        return res;
    }
}

class Solution2 
{
    public List<List<Integer>> pascalTriangleIII(int n) 
    {
        // optimal
        List<List<Integer>> result=new ArrayList<>();
        for(int row=1;row<=n;row++)
        {
            result.add(generateRow(row));
        }
        return result;
    }
    public List<Integer> generateRow(int row)
    {
        List<Integer> temp=new ArrayList<>();
        int ans=1;
        temp.add(ans);
        for(int col=1;col<row;col++)
        {
            ans=ans*(row-col);
            ans=ans/col;
            temp.add(ans);
        }
        return temp;
    }
}