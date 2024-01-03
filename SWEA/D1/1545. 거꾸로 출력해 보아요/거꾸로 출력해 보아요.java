import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
        while(num>=0) {
            System.out.print(num--+" ");
        }
	}
}