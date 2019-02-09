import java.util.Scanner;
import java.math.BigInteger;
import java.util.Stack;

public class Main {
	
	static Tower tower1;
	static Tower tower2;
	static Tower tower3;
	static Tower[] ar = new Tower[3];
	
	static StringBuilder sb;
	
	static int n;
	static int count=0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		sc.close();
		
		if(n<=20){
		
			sb = new StringBuilder();
	
			ar[0] = tower1 = new Tower(1);
			ar[1] = tower2 = new Tower(2);
			ar[2] = tower3 = new Tower(3);
			
			for(int i=n-1 ; i>=0 ; i--){
				tower1.add(i);
			}
			
			hanoi(n, 1,2,3);
			
			sb.deleteCharAt(sb.length()-1);
			System.out.println(count+"\n"+sb.toString());
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
		Tower from = ar[t1-1];
		Tower mid = ar[t2-1];
		Tower to = ar[t3-1];
		if(extras==1){
			from.moveTo(to);
		}
		else{	
			moveToMid(extras-1, from.name, mid.name, to.name);
			from.moveTo(to);
			hanoi(extras-1,mid.name,from.name,to.name);
		}
		
	}	
	
	private static void moveToMid(int extras, int t1, int t2, int t3) {		
		Tower from = ar[t1-1];
		Tower mid = ar[t2-1];
		Tower to = ar[t3-1];
		if(extras==1){
			from.moveTo(mid);
		}
		else{
			hanoi(extras,from.name,to.name,mid.name);
		}				
	}

	static class Tower extends Stack<Integer>{		
		private static final long serialVersionUID = 1L; // warning 제거용
		int name;
		Tower(int name){
			this.name = name;
		}
		public void moveTo(Tower poped) {
			poped.add(this.pop());
			count++;
			sb.append(this.name+" "+poped.name+"\n");
		}
	}
}
