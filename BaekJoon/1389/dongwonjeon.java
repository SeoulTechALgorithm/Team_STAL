import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static Queue<Integer> levels = new LinkedList<>();
	static int[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		int b = Integer.parseInt(a[0]);
		int c = Integer.parseInt(a[1]);
		int[][] input = new int[b+1][b+1];
		for(int i=0; i<c; i++) {
			String[] e = br.readLine().split(" ");
			int f = Integer.parseInt(e[0]);
			int g = Integer.parseInt(e[1]);
			input[f][g] = input[g][f] = 1;
		}
		check = new int[b+1];
		int[] output = new int[b];
		
		for(int i=1; i<=b; i++) {
			check[i] = 1;
			DFS(input, i, 0);
			while(levels.size()>0) {
				output[i-1] += levels.poll();
			}
			for(int j=0; j<check.length; j++) {
				check[j] = 0;
			}
		}
		int min = output[0];
		int index = 1;
		for(int i=1; i<output.length; i++) {
			if(min>output[i]) {
				min = output[i];
				index = i+1;
			}
		}
		System.out.println(index);
	}
	
	public static void DFS(int[][] input, int now, int level) {
		levels.add(level);
		int[] a = new int[input.length+1];
		for(int i=1; i<input.length; i++) {
			if(input[now][i] == 1 && check[i] == 0) {
				a[i] = 1;
				check[i] = 1;
			}
		}
		for(int i=1; i<input.length; i++) {
			if(input[now][i] == 1 && a[i] == 1) {
				DFS(input, i, level+1);
			}
		}
	}
}
