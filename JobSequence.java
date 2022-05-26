import java.util.Scanner;

public class JobSequence {
public static void main(String args[])
{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of jobs : ");
        int n=sc.nextInt();
        String job[]= new String[n];
        int p[]=new int[n];
        int d[]=new int[n];
        System.out.println("Enter the jobs : ");
        for(int i=0;i<n;i++)
        {
             job[i]=sc.next();
        }
        System.out.println("Enter the profit : ");
        for(int i=0;i<n;i++)
             p[i]=sc.nextInt();
        System.out.println("Enter the deadline : ");
        for(int i=0;i<n;i++)
        d[i]=sc.nextInt();
        System.out.println("Jobs in the given order");
        System.out.print("jobs : ");
        for(int i=0;i<n;i++)
        System.out.print(job[i]+" ");
        System.out.print("\nprofit : ");
        for(int i=0;i<n;i++)
        System.out.print(p[i]+" ");
        System.out.print("\nDeadline : ");
        for(int i=0;i<n;i++)
        System.out.print(d[i]+" ");
        System.out.println();
        for(int i=0;i<n-1;i++)
        {
          for(int j=i+1;j<n;j++)
          {
           if(p[i]<p[j])
           {
            int temp=p[i];
            p[i]=p[j];
            p[j]=temp;
            temp=d[j];
            d[j]=d[i];
            d[i]=temp;
            String s= job[i];
            job[i]=job[j];
            job[j]=s;
           }
          }
        }
        System.out.println("Jobs in the decreasing order");
        System.out.print("jobs : ");
        for(int i=0;i<n;i++)
        System.out.print(job[i]+" ");
        System.out.print("\nprofit : ");
        for(int i=0;i<n;i++)
        System.out.print(p[i]+" ");
        System.out.print("\nDeadline : ");
        for(int i=0;i<n;i++)
        System.out.print(d[i]+" ");
        System.out.println();
        int max=d[0];
        for(int i=0;i<n;i++)
        {
         if(d[i]>max)
         max=d[i];
        }
        String s[] = new String[max];
        int profit=0;
        for(int i=0;i<n;i++)
        {
         int dl=d[i];
         dl--;
        if(s[dl]==null)
        {
         s[dl]=job[i];
         profit+=p[i];
        }
        else
        {
         while(dl!=-1)
        {
          if(s[dl]==null)
                {
                 s[dl]=job[i];
                 profit+=p[i];
                 break;
                }
           dl--;
         }
       }
      }
        for(int i=0;i<max;i++)
        System.out.print("--->"+s[i]);
        System.out.println();
        System.out.print("Profit Earned : "+profit);
     }
}