import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String parenthesis = br.readLine();
        char[] parenarray= parenthesis.toCharArray();
        Stack<String> store = new Stack<String>();
        int [] score = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int level = 0;
        
        try {
        	for(int i = 0; i <parenarray.length; i++) {
            	if(Character.toString(parenarray[i]).equals("(")){
            	store.push(Character.toString(parenarray[i]));
            	}
            	
            	else if(Character.toString(parenarray[i]).equals("[")){
                store.push(Character.toString(parenarray[i]));
                }
            	
            	else if(store.peek().equals("(") && Character.toString(parenarray[i]).equals(")")){
            		if(Character.toString(parenarray[i-1]).equals(")")||Character.toString(parenarray[i-1]).equals("]")) {
            			score[store.size()] += score[store.size()+1]*2;
            			score[store.size()+1]= 0;
            		}else {
            			score[store.size()] += 2;
            		}
            	store.pop();
            	}
            	else if(store.peek().equals("[") && Character.toString(parenarray[i]).equals("]")){
            		if(Character.toString(parenarray[i-1]).equals(")")||Character.toString(parenarray[i-1]).equals("]")) {
            			score[store.size()] += score[store.size()+1]*3;
            			score[store.size()+1]= 0;
            		}else {
            			score[store.size()] += 3;
            		}
            	store.pop();
                }
            	else {
            	System.out.println("0");
            	return;
            	}
            	
          }System.out.println(score[1]);
        }catch(Exception e){
        	System.out.println(0);
        }
  }
}
    
