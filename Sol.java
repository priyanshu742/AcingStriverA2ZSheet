







public class Sol
{
    public static void main(String args[])
    {
        for(int i = 1 ; i<=4 ; i++)
        {
            for(int s=1 ; s<=i ; s++)
            {
                System.out.print("*");
            }
            for(int b=2*(4-i) ; b>=1 ; b--)
            {
                System.out.print(" ");
            }
            for(int s=1 ; s<=i ; s++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        // for lower part 

        for(int i =3 ; i>=1 ; i--)
        {
            for(int s=1 ; s<=i ; s++)
            {
                System.out.print("*");
            }
            for(int b=2*(4-i) ; b>=1 ; b--)
            {
                System.out.print(" ");
            }
            for(int s=1 ; s<=i ; s++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
        
