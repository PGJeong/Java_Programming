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
		System.out.print("�շ��� �ο� �� >> ");
		persons = sc.nextInt();

		book = new Phone[persons];
		for(int i = 0; i < persons; i++) {
			System.out.print("�̸��� ��ȭ��ȣ (�̸��� ��ȣ�� �� ĭ���� �Է�) >> ");
			book[i] = new Phone(sc.next(), sc.next());
		}

		System.out.println("����Ǿ����ϴ�...\n");
	}

	private void search() {
		
		sc.nextLine(); // ���� ����
		
		while(true) {
			System.out.print("�˻��� �̸� (���� : \"����\"�Է�) >> ");
			String input = sc.nextLine();
			
			if(input.equals("����")) break;
			
			boolean found = false;
			for(int i = 0; i < persons; i++) {
				if(input.equals(book[i].getName())) {
					found = true;
					System.out.println(input + "�� ��ȭ��ȣ : " + book[i].getTel() + "\n");
					break;
				}
			}
			
			if(!found) System.out.println(input + "��(��) ã�� �� �����ϴ�...\n");
		}
		
		System.out.println("����...");
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