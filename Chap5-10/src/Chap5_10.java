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
		for(int i = 0; i < keyArray.length; i++) { // 이미 배열에 key가 있는 경우
			if(keyArray[i] != null && keyArray[i].equals(key)) {
				keyArray[i] = key;
				valueArray[i] = value;
				return;
			}
		}
		
		for(int i = 0; i < keyArray.length; i++) { // 새로 입력된 key인 경우
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
		
		dic.put("황기태", "자바");
		dic.put("이재문", "파이썬");
		dic.put("이재문", "C++"); // 이재문의 값을 C++로 수정
		
		System.out.println("이재문의 값은 " + dic.get("이재문"));
		System.out.println("황기태의 값은 " + dic.get("황기태"));
		
		dic.delete("황기태");
		System.out.println("황기태의 값은 " + dic.get("황기태"));
		
		dic.print();
	}
}