import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main{
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int p = Integer.parseInt(br.readLine());
        for(int i = 0; i<p; i++) {
        	int a = Integer.parseInt(br.readLine());
            String b = br.readLine();
            int[] c = new int[a];
            for(int j = 0; j < a; j++) {
            	c[j] = Integer.parseInt(b.split(" ")[j]);
            }
            int d = divide(c, 0, a-1);
            bw.write(String.valueOf(d+"\n"));
        }
        
        bw.flush();
        }
    
    public static int divide(int[] list, int start, int end) {
    	if(start == end) {
    		return list[start];
    	}
    	else {
    		int mid = (start+end)/2;
    		int f = divide(list, start, mid);
    		int s = divide(list, mid+1, end);
    		return conquer(list, start, mid, end, f, s);
    	}
    }
    
    public static int conquer(int[] list, int start, int mid, int end, int f, int s) {
    	int checkf = 0;
    	int checkb = 0;
		for(int i = mid; i >= start; i--) {
			if(i==mid) {
				checkf = list[mid];
			}
			else {
				int a = 0;
				for(int j=i; j<=mid; j++) {
					a += list[j];
				}
				if(a > checkf) {
					checkf = a;
				}
			}
		}
		for(int i = mid+1; i <= end; i++) {
			if(i==mid+1) {
				checkb = list[mid+1];
			}
			else {
				int b = 0;
				for(int j=mid+1; j<=i; j++) {
					b += list[j];
				}
				if(b > checkb) {
					checkb = b;
				}
			}
		}
		int m = checkf + checkb;
		int[] complist = {m, f, s};
		Arrays.sort(complist);
		
    	return complist[2];	
    }
}
    
