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
        Tree t = new Tree();
        int num = Integer.parseInt(br.readLine());
        String[][] base = new String[num][3];
        for(int i=0; i<num; i++) {
        	String[] a = br.readLine().split(" ");
        	base[i][0] = a[0];
        	base[i][1] = a[1];
        	base[i][2] = a[2];
        }
        Node[] nodes = new Node[num];
        int check = 0;
        for(int i=num-1; i>=0; i--) {
        	if(base[i][1].equals(".") && base[i][2].equals(".")){
        		nodes[num-i-1] = t.makeNode(null, base[i][0], null);
        	}else if(base[i][1].equals(".")){
        		for(int j=0;j<nodes.length;j++) {
        			if(nodes[j].data.equals(base[i][2])) {
        				nodes[num-i-1] = t.makeNode(null, base[i][0], nodes[j]);
        				break;
        			}
        		}
        	}else if(base[i][2].equals(".")){
        		for(int j=0;j<nodes.length;j++) {
        			if(nodes[j].data.equals(base[i][1])) {
        				nodes[num-i-1] = t.makeNode(nodes[j], base[i][0], null);
        				break;
        			}
        		}
        	}else {
        		for(int j=0;j<nodes.length;j++) {
        			for(int p=0;p<nodes.length;p++) {
        				if(nodes[j].data.equals(base[i][1]) && nodes[p].data.equals(base[i][2])) {
        					nodes[num-i-1] = t.makeNode(nodes[j], base[i][0], nodes[p]);
        					check += 1;
        					break;
            			}
        			}
        			if(check == 1) {
        				check = 0;
        				break;
        			}
        		}
        	}
        }
        t.preorder(nodes[num-1]);
        System.out.print("\n");
        t.inorder(nodes[num-1]);
        System.out.print("\n");
        t.postorder(nodes[num-1]);
        System.out.print("\n");
	}
}

class Node{
	String data;
	Node left;
	Node right;
}

class Tree{
	public Node root;
	
	public void setRoot(Node node) {
		this.root = node;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public Node makeNode(Node left, String data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}
	
	public void inorder(Node node) {
		if(node != null) {
			inorder(node.left);
			System.out.print(node.data);
			inorder(node.right);
		}
	}
	
	public void preorder(Node node) {
		if(node != null) {
			System.out.print(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	public void postorder(Node node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data);
		}
	}
}
