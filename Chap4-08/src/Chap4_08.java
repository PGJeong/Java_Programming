import java.util.Scanner;

class Phone {
	private String name, tel;
	Phone(String name, String tel) { this.name = name; this.tel = tel; }
	String getName() { return name; }
	String getTel() { return tel; }
}

class PhoneBook {
	private Scanner sc = new Scanner(System.in);
	private int persons;
	private Phone book[];

	private void regist() {
		System.out.print("둥록할 인원 수 >> ");
		persons = sc.nextInt();

		book = new Phone[persons];
		for(int i = 0; i < persons; i++) {
			System.out.print("이름과 전화번호 (이름과 번호는 빈 칸없이 입력) >> ");
			book[i] = new Phone(sc.next(), sc.next());
		}

		System.out.println("저장되었습니다...\n");
	}

	private void search() {
		
		sc.nextLine(); // 버퍼 비우기
		
		while(true) {
			System.out.print("검색할 이름 (종료 : \"종료\"입력) >> ");
			String input = sc.nextLine();
			
			if(input.equals("종료")) break;
			
			boolean found = false;
			for(int i = 0; i < persons; i++) {
				if(input.equals(book[i].getName())) {
					found = true;
					System.out.println(input + "의 전화번호 : " + book[i].getTel() + "\n");
					break;
				}
			}
			
			if(!found) System.out.println(input + "을(를) 찾을 수 없습니다...\n");
		}
		
		System.out.println("종료...");
	}

	void run() {
		regist();
		search();
		sc.close();
	}
}

public class Chap4_08 {
	public static void main(String[] args) {	
		PhoneBook obj = new PhoneBook();
		obj.run();
	}
}