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
	private Row row[] = new Row[3]; // row[0] = S석, row[1] = A석, row[2] = B석

	Reservation() {
		for(int i = 0; i < row.length; i++) row[i] = new Row();
	}
	
	void reserve() {
		System.out.print("[예약] S석(1), A석(2), B석(3) >> ");
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
			System.out.println("다시 입력하세요..."); return;
		}
		
		System.out.print("[예약] 예약자 성명 >> ");
		String name = sc.next();
		System.out.print("[예약] 예약할 좌석 >> ");
		int index = sc.nextInt();
		
		if(index >= 1 && index <= 10) {
			row[cmd - 1].reserve(index, name);
			System.out.println(name + "님, " + index + "번 좌석에 예약되었습니다...");
		}
		else { System.out.println("다시 입력하세요..."); return; }
	}
	
	void inquiry() {
		System.out.print("S >>\t"); row[0].print();
		System.out.print("A >>\t"); row[1].print();
		System.out.print("B >>\t"); row[2].print();
	}
	
	void cancel() {
		System.out.print("[취소] S석(1), A석(2), B석(3) >> ");
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
			System.out.println("다시 입력하세요..."); return;
		}
		
		System.out.print("[취소] 예약자 성명 >> ");
		String name = sc.next();
		
		int index = 99;
		
		for(int i = 0; i < 10; i++) {
			if(row[cmd - 1].getName(i + 1).equals(name)) index = i + 1;
		}
		
		if(index == 99) {
			System.out.println(name + "을(를) 찾을 수 없습니다...");
		}
		else {
			row[cmd - 1].cancel(index);
			System.out.println(name + "님의 예약이 취소되었습니다...");
		}
	}
	
	void run() {
		boolean exit = true;
		System.out.println("명품콘서트홀 예약 시스템");
		
		while(exit) {
			System.out.print("\n예약(1), 조회(2), 취소(3), 종료(4) >> ");
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
				System.out.println("다시 입력하세요...");
			}
		}
		
		System.out.println("종료...");
	}
}

public class Chap4_12 {
	public static void main(String[] args) {
		Reservation obj = new Reservation();
		obj.run();
	}
}