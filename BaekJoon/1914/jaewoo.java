import java.util.Scanner;
import java.math.BigInteger;

public class Main {

	static StringBuilder sb;

	static int n;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		sc.close();

		sb = new StringBuilder();		

		if(n<=20){
			hanoi(n, 1,2,3);		
			sb.deleteCharAt(sb.length()-1);
			System.out.println((int)Math.pow(2, n)-1);
			System.out.println(sb.toString());
		}
		else{
			BigInteger result = new BigInteger("1");
			while(n--!=0){
				result = result.multiply(new BigInteger("2"));
			}
			result = result.subtract(new BigInteger("1"));
			System.out.println(result);
		}
	}

	private static void hanoi(int extras, int t1, int t2, int t3) {
		if(extras==1){
			sb.append(t1+" "+t3+"\n");
		}
		else{	
			moveToMid(extras-1, t1, t2, t3);
			sb.append(t1+" "+t3+"\n");
			hanoi(extras-1,t2,t1,t3);
		}		
	}	

	private static void moveToMid(int extras, int t1, int t2, int t3) {	
		if(extras==1){
			sb.append(t1+" "+t2+"\n");
		}
		else{
			hanoi(extras,t1,t3,t2);
		}				
	}
}
