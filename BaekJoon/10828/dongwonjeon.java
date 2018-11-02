import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main{
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        String b[] = new String[a];
        for(int i = 0; i < a; i++) {
        	b[i] = br.readLine();
        }
        ArrayList<Integer> dongArray = new ArrayList<>();
        for(int i = 0; i < a; i++) {
        	if(b[i].equals("top")) {
        		if(dongArray.size() == 0) {
        			bw.write("-1\n");
        		}else {
        			bw.write(dongArray.get(dongArray.size()-1)+"\n");
        		}
        	}
        	else if (b[i].equals("size")) {
        		bw.write(dongArray.size()+"\n");
        	}
        	else if (b[i].equals("empty")) {
        		if(dongArray.size() == 0) {
        			bw.write("1"+"\n");
        		}else {
        			bw.write("0"+"\n");
        		}
        	}
        	else if (b[i].equals("pop")) {
        		if(dongArray.size() == 0) {
        			bw.write("-1\n");
        		}else {
        			bw.write(dongArray.get(dongArray.size()-1)+"\n");
            		dongArray.remove(dongArray.size()-1);
        		}
        	}
        	else{
        		int t = Integer.parseInt(b[i].split(" ")[1]);
        		dongArray.add(t);
        	}
        }
        bw.flush();
    }
}
    
