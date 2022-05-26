import java.util.*;
public class Minmax {
public static void maxmini(int a[])
{
long start=System.nanoTime();
int max=a[0],min=a[0];
for(int i=0;i<a.length;i++)
{
if(a[i]>max)
{
max = a[i];
}
else if(a[i]<min)
{
min = a[i];
}
}
System.out.println("Maximum element is : "+max);
System.out.println("Minimum element is : "+min);
long end=System.nanoTime();
System.out.println("Time complexity is : "+(end-start)+" nanoseconds");
}
static int maximum(int array[], int index, int len)
{
  int max;
  if(index >= len-2)
  {
      if(array[index] > array[index + 1])
          return array[index];
      else
          return array[index + 1];
  }
  max = maximum(array, index + 1, len);
  if(array[index] > max)
      return array[index];
  else
      return max;
}
static int minimum(int array[], int index, int len)
{
  int min;

  if(index >= len-2)
  {
      if(array[index] < array[index + 1])
          return array[index];
      else
          return array[index + 1];
  }

  min = minimum(array, index + 1, len);

  if(array[index] < min)
      return array[index];
  else
      return min;
}

public static void maxminr(int a[])
{
	long start=System.nanoTime();
	int max = maximum(a,0,a.length);
	int min = minimum(a,0,a.length);
	System.out.println("Maximum element is : "+max);
	System.out.println("Minimum element is : "+min);
	long end=System.nanoTime();
	System.out.println("Time complexity is : "+(end-start)+" nanoseconds");
}
public static void main(String[] args)
{
	int n,op;
	char option;
	Scanner sc = new Scanner(System.in);
do
{
	String opt;
	System.out.print("Enter size of array : ");
	n = sc.nextInt();
	int[] a = new int[n];
	System.out.print("Enter "+n+" elements : ");
for(int i=0;i<n;i++)
{
	a[i] = sc.nextInt();
}
System.out.println("1.Iterative   2.Recursive");
System.out.print("Enter your choice : ");
op = sc.nextInt();
	switch(op)
	{
		case 1: maxmini(a);break;
		case 2: maxminr(a);break;
	}
		System.out.print("Do you want to check another array(y/n) : ");
		opt = sc.next();
		option = opt.charAt(0);
	}while(option=='y');
  }
}