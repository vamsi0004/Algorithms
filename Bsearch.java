
import java.util.Arrays;
import java.util.Scanner;

public class Bsearch {
static void iterator(int a[],int low,int high,int e)
    {
long start=System.nanoTime(),end;
int mid=0;
while(low<=high)
{
   mid=(low+high)/2;
if(a[mid]<e)
low=mid+1;
else if(a[mid]==e)
{
System.out.println("Element founded at "+mid);
end=System.nanoTime();
System.out.println("Time complexity Iterator: "+(end-start));
return;
}
else
high=mid-1;
}
System.out.println("Element not founded");
end=System.nanoTime();
System.out.println("Time complexity Iterator: "+(end-start));
    }
static void  recursive(int a[],int lb,int ub,int k)
{
long start=System.nanoTime(),end;
int mid=0;
if(lb<=ub)
{
mid=(lb+ub)/2;
if(a[mid]==k)
{
System.out.println("Element founded at "+mid);
end=System.nanoTime();
System.out.println("Time complexity for recersive: "+(end-start));
return;
}
if(a[mid]>k)
recursive(a,lb,mid-1,k);
else
  recursive(a,mid+1,ub,k);
}
else
{
System.out.println("Element not founded");
end=System.nanoTime();
System.out.println("Time complexity recursive: "+(end-start));
}
}
public static void main(String[] args) {
// TODO Auto-generated method stub
int n,e;
Scanner sc = new Scanner(System.in);
System.out.println("Enter the size of the array : ");
   n=sc.nextInt();
   int a[]=new int[n];
   System.out.println("Enter "+n+" elements : ");
   for(int i=0;i<n;i++)
   {
    a[i]=sc.nextInt();
   }
   System.out.println("Enter element to be searched : ");
   e=sc.nextInt();
   Arrays.sort(a);
   int op,c=0;
   do
   {
    c++;
   System.out.println("1.Iterator\t2.Recursive\nEnter your choice ");
   op=sc.nextInt();
   switch(op)
   {
   case 1: iterator(a,0,n-1,e);
           break;
   case 2: recursive(a,0,n-1,e);
           break;
   }
   }while(op<3&&c<2);
}
}
