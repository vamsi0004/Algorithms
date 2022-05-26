import java.util.*;
public class QuickSort {
	int partition(int arr[],int low,int high) {
		int pivot = arr[high];
		int i=(low-1);
		for(int j=low;j<high;j++) {
			if(arr[j]<=pivot) {
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		printArray(arr);
		return i+1;
	}
	void sort(int arr[], int low,int high) {
		
		if(low<high) {
		int pi=partition(arr,low,high);
		sort(arr,low,pi-1);
			sort(arr,pi+1,high);
		}
	}
	static void printArray(int arr[]) {
		int n=arr.length;
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of an array : ");
		int n = sc.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter values into array: ");
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		QuickSort ob = new QuickSort();
		long s = System.nanoTime();
		ob.sort(arr,0,n-1);
		long e = System.nanoTime();
		System.out.println("Sorted Array : ");
		printArray(arr);
		System.out.println("Time taken : "+(e-s)+
				"nano seconds");		
	}
}
