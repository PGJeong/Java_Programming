import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.io.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private JTextArea ta = new JTextArea();
	private File file1;
	private File file2;
	private File dest = new File("appended.txt");
	
	public MainFrame() {
		setTitle("Chap8-06");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.add(new JScrollPane(ta));
		ta.setEditable(false);
		
		JFileChooser chooser = new JFileChooser(); // JFileChooser 객체 생성
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", "txt"); // 파일 필터 생성
		chooser.setFileFilter(filter); // 파일 필터 설정
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // 파일만 선택 가능하도록 설정
		int ret;
		
		ret = chooser.showOpenDialog(null); // 파일 열기 다이얼로그 출력 - 첫 번째 파일 선택
		if(ret == JFileChooser.APPROVE_OPTION) {
			file1 = chooser.getSelectedFile(); // 선택된 파일 리턴
			ta.append("1번째 파일 경로 : " + file1.getPath() + '\n');
		}
		else {
			JOptionPane.showMessageDialog(null, "오류! 반드시 파일을 선택해야 합니다", "오류", JOptionPane.ERROR_MESSAGE);
			System.exit(0); // 파일을 선택하지 않은 경우 강제종료
		}
		
		ret = chooser.showOpenDialog(null); // 파일 열기 다이얼로그 출력 - 두 번째 파일 선택
		if(ret == JFileChooser.APPROVE_OPTION) {
			file2 = chooser.getSelectedFile(); // 선택된 파일 리턴
			ta.append("2번째 파일 경로 : " + file2.getPath() + '\n');
		}
		else {
			JOptionPane.showMessageDialog(null, "오류! 반드시 파일을 선택해야 합니다", "오류", JOptionPane.ERROR_MESSAGE);
			System.exit(0); // 파일을 선택하지 않은 경우 강제종료
		}
		
		
		try {
			FileReader fin1 = new FileReader(file1); // 파일 입력 스트림(문자 스트림) 생성
			FileReader fin2 = new FileReader(file2); // 파일 입력 스트림(문자 스트림) 생성
			FileWriter fout = new FileWriter(dest, true); // 파일 출력 스트림(문자 스트림) 생성, 매개변수 append는 true로 설정
			
			char buf[] = new char[1024]; // 1KB 버퍼 생성
			
			while(true) {
				int n = fin1.read(buf); // 문자를 읽어 buf 배열에 저장하고 읽은 개수 리턴
				fout.write(buf, 0, n); // buf[0]부터 n개 쓰기
				
				if(n < buf.length)
					break; // 버퍼 크기보다 작게 읽은 경우 = 파일의 끝(EOF)에 도달
			}
			
			while(true) {
				int n = fin2.read(buf);
				fout.write(buf, 0, n);
				
				if(n < buf.length)
					break;
			}
			
			ta.append(dest.getPath() + "에 저장하였습니다\n");
			
			fin1.close(); // 입력 스트림 닫기, 관련 시스템 자원 해제
			fin2.close();
			fout.close(); // 출력 스트림 닫기, 관련 시스템 자원 해제
		}
		catch(FileNotFoundException e) {
			ta.append("FileNotFoundException\n");
			System.exit(0);
		}
		catch(IOException e) {
			ta.append("IOException\n");
			System.exit(0);
		}
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
