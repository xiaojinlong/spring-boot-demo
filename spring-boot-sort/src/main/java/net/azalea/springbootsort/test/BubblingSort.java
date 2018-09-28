package net.azalea.springbootsort.test;

/**
 * 冒泡排序，时间复杂度O(n2)
 * @author user
 *
 */
public class BubblingSort {

	public static void main(String[] args) {
		int[] arr={6,3,8,2,9,1};
		System.out.println("排序前数组为：");
		for(int num:arr){
			System.out.print(num+" ");
		}
		for(int i=0;i<arr.length-1;i++){//外层循环控制排序趟数
			for(int j=0;j<arr.length-1-i;j++){//内层循环控制每一趟排序多少次
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					System.out.println(arr[j]);
					arr[j+1]=temp;
					System.out.println(temp);
				}
			}
		} 
		System.out.println();
		System.out.println("排序后的数组为：");
		for(int num:arr){
			System.out.print(num+" ");
		}
	}

}
