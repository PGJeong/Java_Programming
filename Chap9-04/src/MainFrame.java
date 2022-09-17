import javax.swing.*; // Swing 패키지 import
import java.awt.*; // 배치관리자 및 Container 클래스, Color 클래스 사용

@SuppressWarnings("serial") // java.io.Serializable 인터페이스를 간접적으로 구현하여 발생한 오류메시지 무시
public class MainFrame extends JFrame { // JFrame을 상속받아 프레임 생성
	public MainFrame() { // Swing 응용프로그램에서는 생성자에 실행할 코드들을 입력한다
		setTitle("Ten Color Buttons Frame"); // 프레임 타이틀 설정
		setSize(500, 200); // 프레임 크기 설정
		setLocationRelativeTo(null); // 프레임울 모니터의 중앙에 띄운다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임이 닫힐 때 프로그램도 같이 종료
		
		Container c = getContentPane(); // 프레임에 부착된 컨텐트팬을 리턴 (컨텐트팬은 Container 타입)
		c.setLayout(new GridLayout(1, 10)); // GridLayout을 컨텐트팬의 새로운 배치관리자로 설정, 1x10 그리드
		
		Color colors[] = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN,
				Color.BLUE, Color.MAGENTA, Color.GRAY, Color.PINK, Color.LIGHT_GRAY}; // java.awt.Color 클래스
		
		for(int i = 0; i < 10; i++) {
			JButton btn = new JButton(Integer.toString(i)); // JButton 컴포넌트 생성
			btn.setBackground(colors[i]); // 버튼의 색을 colors[i] 색으로
			c.add(btn); // 컨텐트팬에 버튼 달기
		}
		
		setVisible(true); // 프레임이 출력되도록 지시. 컴포넌트들을 다 붙이고 맨 마지막에 호출해야 한다
	}
	
	public static void main(String[] args) { // Swing 응용프로그램에서 main() 메소드의 기능은 최소화 권장
		new MainFrame(); // Swing 프레임 생성. 프로그램의 시작점
	}
}