import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;



class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int N;
		N=sc.nextInt();
        int num;
        int[] nums = new int[N];
        
		for(int i = 0; i < N; i++)
		{
           num=sc.nextInt();
           nums[i] = num;
		}
        Arrays.sort(nums);
        System.out.println(nums[N/2]);
	}
}