import java.util.Scanner;

public class Chap3_16 {
	public static void main(String[] args) {
		String str[] = {"����", "����", "��"};
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[��ǻ�Ϳ� ���� ���� �� ����]");
		System.out.println("���� : \"����\" �Է�");
		
		boolean exit = true;
		
		while(exit) {
			System.out.print("���� / ���� / �� >> ");
			String input = sc.nextLine();
			
			int n = (int)(Math.random()*3);
			
			switch(input) {
			case "����":
				if (input.equals(str[n]) == true) { System.out.print("����� = " + input + ", ��ǻ�� = " + str[n] + ", "); System.out.println("�����ϴ�"); }
				else if (str[n].equals("����")) { System.out.print("����� = " + input + ", ��ǻ�� = " + str[n] + ", "); System.out.println("��ǻ�� ��!"); }
				else { System.out.print("����� = " + input + ", ��ǻ�� = " + str[n] + ", "); System.out.println("����� ��!"); }
				break;
			case "����":
				if (input.equals(str[n]) == true) { System.out.print("����� = " + input + ", ��ǻ�� = " + str[n] + ", "); System.out.println("�����ϴ�"); }
				else if (str[n].equals("��")) { System.out.print("����� = " + input + ", ��ǻ�� = " + str[n] + ", "); System.out.println("��ǻ�� ��!"); }
				else { System.out.print("����� = " + input + ", ��ǻ�� = " + str[n] + ", "); System.out.println("����� ��!"); }
				break;
			case "��":
				if (input.equals(str[n]) == true) { System.out.print("����� = " + input + ", ��ǻ�� = " + str[n] + ", "); System.out.println("�����ϴ�"); }
				else if (str[n].equals("����")) { System.out.print("����� = " + input + ", ��ǻ�� = " + str[n] + ", "); System.out.println("��ǻ�� ��!"); }
				else { System.out.print("����� = " + input + ", ��ǻ�� = " + str[n] + ", "); System.out.println("����� ��!"); }
				break;
			case "����": System.out.println("����..."); exit = false;
				break;
			default:
				System.out.println("�ٽ� �Է��ϼ���...");
			}
		}
		
		sc.close();
	}
}