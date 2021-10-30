import java.util.Scanner;

public class CharDemo {
	public char[] conversion(String a) {
		char[] b= new char[a.length()];
		for (int j = 0; j < b.length; j++) {

			if(j==0 || j%2==0) {
				b[j]=(char)a.charAt(j);
			}
			else {
				b[j]=a.charAt(j);
			}
		}
		return b;
	}

	public static void main(String[] args) {
		CharDemo cd = new CharDemo();
		System.out.println("Enter the string");
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		sc.close();
		System.out.println(cd.conversion(a));
	}
}
