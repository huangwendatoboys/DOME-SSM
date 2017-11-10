
public class test {
	public static void main(String[] args) {
		final int n=10;
		int[] num=new int[n];
		num[0]=1;
		for (int i = 1; i!=n; i++) {
			for (int j = n; j !=i-1; j--) {
				System.out.print("    ");
			}
			for (int j = 0; j !=i; j++) {
				System.out.print(num[j]+"      ");
			}
			System.out.println();
			num[i]=1;
			for (int j = i-1; j !=0; j--) {
				num[j]=num[j]+num[j-1];
			}
		}
	}
}
