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
        while(true){
            String b = br.readLine();
            if(b.equals("0")) {
        		break;
        	}
            int a = Integer.parseInt(b.split(" ")[0]);
            int[] c = new int[a];
            for(int j = 1; j < a+1; j++) {
            	c[j-1] = Integer.parseInt(b.split(" ")[j]);
            }
//            for(int i = 0; i<c.length; i++) {
//            	System.out.println(c[i]);
//            }
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
    	int checkss = 0;
    	int check = 0;
    	
    	if(list[mid] <= list[mid+1]) {
    		check = list[mid];
    	}else {
    		check = list[mid+1]; }
    	for(int i = mid+1; i <= end; i++) {
    		if(list[i] <= check) {
    			check = list[i];
    			for(int j = mid; j >= start; j--) {
    				if(list[j]<list[i]){
    					if(checkss <= (i-j)*list[i]) {
    						checkss = (i-j)*list[i]; }
    					break; }
    				else if(j==start) {
    					if(checkss <= (i+1)*list[i]) {
    						checkss = (i+1)*list[i]; }
    					break; } } } }
    	
    	if(list[mid] <= list[mid+1]) {
    		check = list[mid];
    	}else {
    		check = list[mid+1]; }
    	
    	for(int i = mid; i >= start; i--) {
    		if(list[i] <= check) {
    			check = list[i];
    			for(int j = mid+1; j <= end; j++) {
    				if(list[j]<list[i]){
    					if(checkss <= (j-i)*list[i]) {
    						checkss = (j-i)*list[i]; }
    					break; }
    				else if(j==end) {
    					if(checkss <= (j-i+1)*list[i]) {
    						checkss = (j-i+1)*list[i]; }
    					break; } } } }
		
		int m = checkss;
		int[] complist = {m, f, s};
		Arrays.sort(complist);
		
    	return complist[2];	
    }
}
    
