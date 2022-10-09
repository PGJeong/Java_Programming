import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*; // ChangeEvent, ChangeListener는 javax.swing.event 패키지

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setSize(350, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		
		JTextArea ta = new JTextArea("내용을 입력하세요", 5, 20); // JTextArea(String text, int rows, int columns)
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, ta.getText().length()); // JSlider(int orientation, int min, int max, int val)
		slider.setMajorTickSpacing(20); // slider의 큰 눈금 간격을 20으로 지
		slider.setMinorTickSpacing(5); // slider의 작은 눈금 간격을 5로 지정
		slider.setPaintTicks(true); // slider의 눈금을 보이게 함
		slider.setPaintLabels(true); // slider의 label을 보이게 함
		
		ta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setTitle("Characters : " + ta.getText().length()); // 현재 글자 수 타이틀에 표시
				
				if(ta.getText().length() > 100) { // 입력된 문자열의 길이가 100 초과인 경우
					ta.setText(ta.getText().substring(0, 100)); // 100 미만(index 0 ~ 99)의 문자열만 TextArea에 출력
				}
				else {
					slider.setValue(ta.getText().length()); // Slider의 값을 현재 문자열의 길이로 설정
				}
			}
		});
		
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				setTitle("Characters : " + ta.getText().length()); // 현재 글자 수 타이틀에 표시
				
				if(slider.getValue() <= ta.getText().length()) { // 조정된 Slider의 값이 문자열 길이 이하인 경우
					ta.setText(ta.getText().substring(0, slider.getValue())); // Slider의 값(index) 미만의 문자열만 TextArea에 출력
				}
				else { // 조정된 Slider의 값이 문자열 길이보다 큰 경우
					slider.setValue(ta.getText().length()); // Slider의 값을 현재 문자열의 길이로 설정
				}
			}
		});
		
		c.add(new JScrollPane(ta), BorderLayout.CENTER); // JTextArea에서 스크롤바를 사용할 수 있도록 JScrollPane에 삽입
		c.add(slider, BorderLayout.SOUTH);
		
		setTitle("Characters : " + ta.getText().length()); // 현재 글자 수 타이틀에 표시
		setVisible(true); // setVisible() 메소드는 프레임을 화면에 출력한 후 Focus를 임의로 조정
		
		ta.setFocusable(true); // Focus를 받을 수 있도록 설정 (setVisible() 메소드 뒤에 호출)
		ta.requestFocus(); // Focus 주어 키 입력을 독점하도록 함 (setVisible() 메소드 뒤에 호출)
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
