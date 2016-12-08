package geeksforgeeks;

import java.util.*;

public class CountInversion{

	public static int count =0;
	public static int arr[];
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int t  = in.nextInt();
		while(t-- > 0){
			count =0;
			int n = in.nextInt();
			arr = new int[n];
			for(int i=0;i<n;i++){
				arr[i] = in.nextInt();
			}
			//System.out.println(Arrays.toString(arr));
			mergeSort(0,n-1);

			System.out.println(count);
			//System.out.println(Arrays.toString(arr));

		}

	}


	public static void mergeSort(int l, int m){
		
		if(l<m){
			int mid = (l+m)/2;
			//System.out.println(mid);
			mergeSort(l,mid);
			mergeSort(mid+1,m);
			//System.out.println(l+" "+mid+" "+m);
			merge(l,mid,m);

		}

	}

	public static void merge(int l, int mid, int m){
		//System.out.println("here1");
		int[] barr = new int[m-l+1];

		int k =0;
		int i=l;
		int j=mid+1;

		while(i<=mid && j<=m){
			if(arr[i] <= arr[j]){  // THIS = is IMPORTANT, DONOT PUT JUST <
				//System.out.println(arr[i]+" "+arr[j]+"here2");
				barr[k] = arr[i];
				i++;

			}else{
				barr[k] = arr[j];
				count += (mid-i+1);
				//System.out.println(arr[i]+" "+arr[j]+"here3");
				j++;

			}

			k++;

		}

		if(i>mid){
			//System.out.println("here4");
			for(;j<=m;j++){
				barr[k] = arr[j];
				k++;
			}

		}else{
			//System.out.println("here5");
			for(;i<=mid;i++){
				barr[k] = arr[i];
				k++;
			}

		}

		//k =l;
		j=0;
		i=l;
		while(i<=m){
			//System.out.println(Arrays.toString(barr)+ " "+l+" "+mid+" "+m);
			arr[i++] = barr[j++];

		}
		

		

	}

}