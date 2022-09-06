abstract class PairMap {
	protected String keyArray[];
	protected String valueArray[];
	
	abstract String get(String key);
	abstract void put(String key, String value);
	
	abstract String delete(String key);
	abstract int length();
}

class Dictionary extends PairMap {
	public Dictionary(int capacity) { keyArray = new String[capacity]; valueArray = new String[capacity]; }
	
	public String get(String key) {
		for(int i = 0; i < keyArray.length; i++) {
			if(key.equals(keyArray[i]))
				return valueArray[i];
		}
		return null;
	}
	
	public void put(String key, String value) {
		for(int i = 0; i < keyArray.length; i++) { // �̹� �迭�� key�� �ִ� ���
			if(keyArray[i] != null && keyArray[i].equals(key)) {
				keyArray[i] = key;
				valueArray[i] = value;
				return;
			}
		}
		
		for(int i = 0; i < keyArray.length; i++) { // ���� �Էµ� key�� ���
			if(keyArray[i] == null) {
				keyArray[i] = key;
				valueArray[i] = value;
				return;
			}
		}
	}
	
	public String delete(String key) {
		String deletedValue = null;
		for(int i = 0; i < keyArray.length; i++) {
			if(keyArray[i] != null && keyArray[i].equals(key)) {
				deletedValue = valueArray[i];
				keyArray[i] = null;
				valueArray[i] = null;
			}
		}
		return deletedValue;
	}
	
	public int length() {
		int numOfDatas = 0;
		for(int i = 0; i < keyArray.length; i++) {
			if(keyArray[i] != null) numOfDatas++;
		}
		
		return numOfDatas;
	}
	
	public void print() {
		System.out.println("");
		for(int i = 0; i < 10; i++)
			System.out.println(i + " : " + keyArray[i] + ", " + valueArray[i]);
	}
}

public class Chap5_10 {
	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		
		dic.put("Ȳ����", "�ڹ�");
		dic.put("���繮", "���̽�");
		dic.put("���繮", "C++"); // ���繮�� ���� C++�� ����
		
		System.out.println("���繮�� ���� " + dic.get("���繮"));
		System.out.println("Ȳ������ ���� " + dic.get("Ȳ����"));
		
		dic.delete("Ȳ����");
		System.out.println("Ȳ������ ���� " + dic.get("Ȳ����"));
		
		dic.print();
	}
}