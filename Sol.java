







public class Sol
{
    public static void main(String args[]) 
    {
        int count=0;
        int index=0;
        for(int i=1; i<=26 ; i++)
        {
            if(26%i==0)
            {
                count++;
            }
        }
        int arr[]=new int[count];
        for(int i=1; i<=26 ; i++)
        {
            if(26%i==0)
            {
                arr[index]=i;
                index++;
            }
        }
        System.out.println(java.util.Arrays.toString(arr));
    }
}