import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        
        for(int i = 0; i< total; i++) {
        	LinkedList numbers = new LinkedList();
        	String a = br.readLine();
        	int b = Integer.parseInt(a.split(" ")[0]);
        	int c = Integer.parseInt(a.split(" ")[1]);
        	int index = 0;
        	for(int j = 1; j <= b; j++) {
        		numbers.addLast(j);
        	}
            while(numbers.size() != 2) {
            	numbers.remove(index);
            	index += (c-1);
            	index = index % numbers.size();
            }
            bw.write(numbers.toString().split(", ")[0].substring(1) + " "
            		+ numbers.toString().split(", ")[1].substring(0, numbers.toString().split(", ")[1].length()-1) + "\n");
        }
       bw.flush();
        
  }
}

class LinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node {
		private Object data;
		private Node next;
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		head = newNode;
		size++;
		if(head.next == null) {
			tail = newNode;
			tail.next = head;
		}
	}

	public void addLast(Object input) {
		Node newNode = new Node(input);
		if(size == 0) {
			addFirst(input);
		}else {
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
			size++;
		}
	}
	
	public void add(int k, Object input) {
		if(k==0) {
			addFirst(input);
		}else {
			Node newNode = new Node(input);
			newNode.next = node(k);
			node(k-1).next = newNode;
			size++;
			if(newNode.next == null) {
				tail = newNode;
			}
		}
	}
	
	public Node hasNext(int k) {
		return node(k).next;
	}
	
	public String toString() {
		if(head==null) {
			return "[]";
		}
		Node temp = head;
		String str = "[";
		int index = 1;
		while(size > index) {
			str += temp.data + ", ";
			temp = temp.next;
			index++;
		}
		str += temp.data;
		
		return str+"]";
	}
	
	public Object removeFirst(){
		Node temp = head;
		head = temp.next;
		tail.next = head;
		Object returnData = temp.data;
		temp = null;
		size--;
		return returnData;
	}
	
	public Object remove(int k) {
		if(k==0) {
			return removeFirst();
		}
		Node temp = node(k-1);
		Node todoDeleted = temp.next;
		temp.next = temp.next.next;
		Object returnData = todoDeleted.data;
		if(todoDeleted == tail) {
			tail = temp;
			tail.next = head;
		}
		todoDeleted = null;
		size--;
		return returnData;
	}
	
	public int size() {
		return size;
	}
	
	// 내부에서 사용하는 메소드 > index를 넣으면 노드가 출력
	public Node node(int index) {
		Node x = head;
		for(int i = 0; i < index; i++) {
			x = x.next;
		}
		return x;
	}
	
}
