import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        int[] nums = new int[10];
        int n;
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            for(int i=0; i<10; i++)
            {
                n = sc.nextInt();
                nums[i] = n;
            }
            System.out.printf("#%d %d\n", test_case, Arrays.stream(nums).max().getAsInt());
		}
	}
}