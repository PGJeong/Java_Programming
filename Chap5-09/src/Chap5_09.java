import java.util.Scanner;

interface Stack {
	int length();
	int capacity();
	String pop();
	boolean push(String val);
}

class StringStack implements Stack {
	private int tos, max; // ����� ������ ��, ���� ������ ������ ��
	private String data[];
	public StringStack(int capacity) { tos = 0; max = capacity; data = new String[capacity]; }
	
	public int length() { return tos; }
	public int capacity() { return max; }
	public String pop() {
		if(tos > 0) {
			tos--;
			return data[tos];
		}
		else return null;
	}
	public boolean push(String val) {
		if(tos < max) {
			data[tos] = val;
			tos++;
			return true;
		}
		else {
			return false;
		}
	}
}

public class Chap5_09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ���� ������ ũ�� �Է� >> ");
		StringStack obj = new StringStack(sc.nextInt());
		
		while(true) {
			System.out.print("���ڿ� �Է� >> ");
			String input = sc.next();
			
			if(input.equals("�׸�")) {
				break;
			}
			else {
				if(obj.push(input));
				else System.out.println("���� �뷮 �ʰ�!");
			}
		}
		
		System.out.print("���ÿ� ����� ��� ���ڿ� pop : ");
		
		for(int i = 0, j = obj.length(); i < j; i++) // obj.length()�� ���� ��� �ٲ�Ƿ� ������ ������ ����
			System.out.print(obj.pop() + " ");
		
		sc.close();
	}
}