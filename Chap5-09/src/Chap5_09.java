import java.util.Scanner;

interface Stack {
	int length();
	int capacity();
	String pop();
	boolean push(String val);
}

class StringStack implements Stack {
	private int tos, max; // 저장된 데이터 수, 저장 가능한 데이터 수
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
		
		System.out.print("스택 저장 공간의 크기 입력 >> ");
		StringStack obj = new StringStack(sc.nextInt());
		
		while(true) {
			System.out.print("문자열 입력 >> ");
			String input = sc.next();
			
			if(input.equals("그만")) {
				break;
			}
			else {
				if(obj.push(input));
				else System.out.println("스택 용량 초과!");
			}
		}
		
		System.out.print("스택에 저장된 모든 문자열 pop : ");
		
		for(int i = 0, j = obj.length(); i < j; i++) // obj.length()의 값은 계속 바뀌므로 별도의 변수에 저장
			System.out.print(obj.pop() + " ");
		
		sc.close();
	}
}