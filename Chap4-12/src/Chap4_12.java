import java.util.Scanner;

class Row {
	private String seats[] = new String[10];

	Row() {
		for(int i = 0; i < seats.length; i++) seats[i] = "- " + (i + 1) + " -";
	}

	String getName(int index) { return seats[index - 1]; }

	void reserve(int index, String name) { seats[index - 1] = name; }
	void cancel(int index) { seats[index - 1] = "- " + index + " -"; }	
	void print() {
		for(int i = 0; i < seats.length; i++)
			System.out.print(seats[i] + "\t");
		System.out.print("\n");
	}
}

class Reservation {
	private Scanner sc = new Scanner(System.in);
	private Row row[] = new Row[3]; // row[0] = S��, row[1] = A��, row[2] = B��

	Reservation() {
		for(int i = 0; i < row.length; i++) row[i] = new Row();
	}
	
	void reserve() {
		System.out.print("[����] S��(1), A��(2), B��(3) >> ");
		int cmd = sc.nextInt();
		
		switch(cmd) {
		case 1:
			System.out.print("S >>\t"); row[0].print();
			break;
		case 2:
			System.out.print("A >>\t"); row[1].print();
			break;
		case 3:
			System.out.print("B >>\t"); row[2].print();
			break;
		default:
			System.out.println("�ٽ� �Է��ϼ���..."); return;
		}
		
		System.out.print("[����] ������ ���� >> ");
		String name = sc.next();
		System.out.print("[����] ������ �¼� >> ");
		int index = sc.nextInt();
		
		if(index >= 1 && index <= 10) {
			row[cmd - 1].reserve(index, name);
			System.out.println(name + "��, " + index + "�� �¼��� ����Ǿ����ϴ�...");
		}
		else { System.out.println("�ٽ� �Է��ϼ���..."); return; }
	}
	
	void inquiry() {
		System.out.print("S >>\t"); row[0].print();
		System.out.print("A >>\t"); row[1].print();
		System.out.print("B >>\t"); row[2].print();
	}
	
	void cancel() {
		System.out.print("[���] S��(1), A��(2), B��(3) >> ");
		int cmd = sc.nextInt();
		
		switch(cmd) {
		case 1:
			System.out.print("S >>\t"); row[0].print();
			break;
		case 2:
			System.out.print("A >>\t"); row[1].print();
			break;
		case 3:
			System.out.print("B >>\t"); row[2].print();
			break;
		default:
			System.out.println("�ٽ� �Է��ϼ���..."); return;
		}
		
		System.out.print("[���] ������ ���� >> ");
		String name = sc.next();
		
		int index = 99;
		
		for(int i = 0; i < 10; i++) {
			if(row[cmd - 1].getName(i + 1).equals(name)) index = i + 1;
		}
		
		if(index == 99) {
			System.out.println(name + "��(��) ã�� �� �����ϴ�...");
		}
		else {
			row[cmd - 1].cancel(index);
			System.out.println(name + "���� ������ ��ҵǾ����ϴ�...");
		}
	}
	
	void run() {
		boolean exit = true;
		System.out.println("��ǰ�ܼ�ƮȦ ���� �ý���");
		
		while(exit) {
			System.out.print("\n����(1), ��ȸ(2), ���(3), ����(4) >> ");
			int cmd = sc.nextInt();
			
			switch(cmd) {
			case 1:
				reserve();
				break;
			case 2:
				inquiry();
				break;
			case 3:
				cancel();
				break;
			case 4:
				exit = false;
				break;
			default:
				System.out.println("�ٽ� �Է��ϼ���...");
			}
		}
		
		System.out.println("����...");
	}
}

public class Chap4_12 {
	public static void main(String[] args) {
		Reservation obj = new Reservation();
		obj.run();
	}
}