class Solution 
{
    public void rotateMatrix(int[][] matrix) 
    {
        int n=matrix.length;
        int result[][]=new int[n][n];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                result[j][n-1-i]=matrix[i][j];
            }
        }
        for(int nw[]: result)
        {
            for(int m:nw)
            {
                System.out.print(m);
            }
            System.out.println();
        }
    }
}

public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[][]={{0,1,2,0},{3,4,5,2},{1,3,1,5},{3,5,6,7}};

        s1.rotateMatrix(nums);

       // System.out.println(result);

       
    }
}