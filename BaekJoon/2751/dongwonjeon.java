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
        int array_num = Integer.parseInt(br.readLine());
        
        int array [] = new int[array_num];
        for(int i = 0; i < array_num; i++) {
        	array[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(array, 0, array.length-1);
        for(int i=0; i<array_num; i++) {
        	System.out.println(array[i]);
        }
    }
    
    public static void mergeSort(int[] array, int start, int end) {
    	if(start != end) {
    		int mid = (start+end)/2;
    		mergeSort(array, start, mid);
    		mergeSort(array, mid+1, end);
    		merge(array, start, mid, end);
    	}else {
    		
    	}
    }
    
    public static void merge(int[] array, int start, int mid, int end) {
    	int a = start;
    	int b = mid+1;
    	int c [] = new int[end-start+1];
    	int d = 0;
    	
    	while(a <= mid+1 || b <= end+1) {
    		if(array[a] <= array[b]) {
    			c[d] = array[a];
    			a++;
    			d++;
    		}else{
    			c[d] = array[b];
    			b++;
    			d++;
    		}
    		if(a == mid+1) {
    			for(int i=b;i<=end;i++) {
    				c[d] = array[i];
    				d++;
    			}
    			break;
    		}else if( b == end+1) {
    			for(int i=a;i<=mid;i++) {
    				c[d] = array[i];
    				d++;
    			}
    			break;
    		}
    	}
    	int e = 0;
    	for(int i = start;i<=end;i++) {
    		array[i] = c[e];
    		e++;
    	}
    	
    }
}
