import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        double sum;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            sum = 0;
            for(int i=0; i<10; i++) {
                sum += sc.nextInt();
            }
            System.out.println("#"+test_case+" "+Math.round(sum/10));
        }
	}
}