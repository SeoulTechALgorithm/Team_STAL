import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int minus = 1;
		int multi = 1;
		while(true) {
			minus += multi * 6;
			multi++;
			
			if(minus >= a) {
				break;
			}
		}
		if(a == 1) {
			System.out.println(1);
		}else {
			System.out.println(multi);	
		}
	}
}
