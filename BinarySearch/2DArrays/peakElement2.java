

/*

Given a 0-indexed n x m matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the array [i, j].
A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbours to the left, right, top, and bottom.
Assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

Note: As there can be many peak values, 1 is given as output if the returned index is a peak number, otherwise 0.

Example 1
Input: mat=[[10, 20, 15], [21, 30, 14], [7, 16, 32]]
Output: [1, 1]
Explanation: The value at index [1, 1] is 30, which is a peak element because all its neighbours are smaller or equal to it. 
Similarly, {2, 2} can also be picked as a peak.

Example 2
Input: mat=[[10, 7], [11, 17]]
Output : [1, 1]
Explanation:The value at index [1, 1] is 17, which is the only peak element because all its neighbours are smaller or equal to it.


Constraints
n == mat.length
m == mat[i].length
1 <= m, n <= 500
1 <= mat[i][j] <= 105
No two adjacent cells are equal

MEDIUM
*/

class Solution1
{
    public int[] findPeakGrid(int[][] mat) 
    {
        // brute
        int row=mat.length;
        int column=mat[0].length;
        // edgeCases
        if(row==1 && column==1)
        {
            return new int[]{0,0};
        }
        if(row==1)
        {
            int maxCol=0;
            for(int j=1;j<column;j++)
            {
                if(mat[0][j]>mat[0][maxCol])
                {
                    maxCol=j;
                }
            }
            return new int[]{0,maxCol};
        }
        if(column==1)
        {
            int maxRow=0;
            for(int i=1;i<row;i++)
            {
                if(mat[i][0]>mat[maxRow][0])
                {
                    maxRow=i;
                }
            }
            return new int[]{maxRow,0};
        }
        // corner elements
        if(mat[0][0]>mat[0][1] && mat[0][0]>mat[1][0])
        {
            return new int[]{0,0};
        }
        if(mat[0][column-1]>mat[0][column-2] && mat[0][column-1]>mat[1][column-1])
        {
            return new int[]{0,column-1};
        }
        if(mat[row-1][0]>mat[row-1][1] && mat[row-1][0]>mat[row-2][0])
        {
            return new int[]{row-1,0};
        }
        if(mat[row-1][column-1]>mat[row-1][column-2] && mat[row-1][column-1]>mat[row-2][column-1])
        {
            return new int[]{row-1,column-1};
        }
        // first row
        for(int j=1;j<column-1;j++)
        {
            if(mat[0][j]>mat[0][j-1] && mat[0][j]>mat[0][j+1] && mat[0][j]>mat[1][j])
            {
                return new int[]{0,j};
            }
        }
        // last row
        for(int j=1;j<column-1;j++)
        {
            if(mat[row-1][j]>mat[row-1][j-1] && mat[row-1][j]>mat[row-1][j+1] && mat[row-1][j]>mat[row-2][j])
            {
                return new int[]{row-1,j};
            }
        }
        // first column 
        for(int i=1;i<row-1;i++)
        {
            if(mat[i][0]>mat[i][1] && mat[i][0]>mat[i-1][0] && mat[i][0]>mat[i+1][0])
            {
                return new int[]{i,0};
            }
        }
        // last column
        for(int i=1;i<row-1;i++)
        {
            if(mat[i][column-1]>mat[i][column-2] && mat[i][column-1]>mat[i+1][column-1] && mat[i][column-1]>mat[i-1][column-1])
            {
                return new int[]{i,column-1};
            }
        }
        // remaining elements
        for(int i=1;i<row;i++)
        {
            for(int j=1;j<column;j++)
            {
                if(mat[i][j]>mat[i][j+1] && mat[i][j]>mat[i][j-1] && mat[i][j]>mat[i-1][j] && mat[i][j]>mat[i+1][j])
                {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}

class Solution2 
{
    public int[] findPeakGrid(int[][] mat) 
    {
        // brute
        int row=mat.length;
        int column=mat[0].length;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                int up=-1;
                int down=-1;
                int left=-1;
                int right=-1;
                if(i>0)
                {
                    up=mat[i-1][j];
                }
                if(i<row-1)
                {
                    down=mat[i+1][j];
                }
                if(j>0)
                {
                    left=mat[i][j-1];
                }
                if(j<column-1)
                {
                    right=mat[i][j+1];
                }

                if(mat[i][j]>up && mat[i][j]>down && mat[i][j]>left && mat[i][j]>right)
                {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}

class Solution3
{
    public int[] findPeakGrid(int[][] mat) 
    {
        // optimal
        // binarySearch
        int row=mat.length;
        int column=mat[0].length;
        int low=0;
        int high=column-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int maxRowIndex=findMaxIndex(mat,row,mid);
            int left=-1;
            int right=-1;
            if(mid-1>=0)
            {
                left=mat[maxRowIndex][mid-1];
            }
            if(mid+1<column)
            {
                right=mat[maxRowIndex][mid+1];
            }
            if(mat[maxRowIndex][mid]>left && mat[maxRowIndex][mid]>right)
            {
                return new int[]{maxRowIndex,mid};
            }
            else if(mat[maxRowIndex][mid]<left)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return new int[]{};
    }
    public int findMaxIndex(int [][]mat,int row,int column)
    {
        int maxValue=-1;
        int index=-1;
        for(int i=0;i<row;i++)
        {
            if(mat[i][column]>maxValue)
            {
                maxValue=mat[i][column];
                index=i;
            }
        }
        return index;
    }
}