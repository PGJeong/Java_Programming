import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private int unit[] = {50000, 10000, 1000, 500, 100, 50, 10, 1};
	private String unitText[] = {"5만원", "1만원", "1000원", "500원", "100원", "50원", "10원", "1원"};
	
	public MainFrame() {
		setTitle("Chap11-04");
		setSize(300, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(255, 200, 200)); // 스윙 컴포넌트들의 공통 메소드 (JComponent 메소드). 배경색 설정
		
		/* 입력부 */
		JLabel label = new JLabel("금액");
		label.setBounds(30, 50, 40, 20); // setBounds(int x, int y, int width, int height) 위치 및 크기 동시 설정
		label.setHorizontalAlignment(SwingConstants.RIGHT); // JButton과 JLable에서 사용 가능한 수평 정렬 메소드
		
		JTextField tf = new JTextField(10); // 변환할 금액을 입력할 텍스트필드
		tf.setBounds(80, 50, 110, 20);
		
		JButton btn = new JButton("계산");
		btn.setBounds(200, 50, 70, 20);
		
		c.add(label);
		c.add(tf);
		c.add(btn);
		
		/* 출력부 */
		JLabel unitLabel[] = new JLabel[unit.length]; // 단위 표시
		JTextField unitTf[] = new JTextField[unit.length]; // 변환값 표시
		JCheckBox unitSel[] = new JCheckBox[unit.length - 1]; // 변환할 단위 선택
		
		for(int i = 0; i < unit.length; i++) {
			unitLabel[i] = new JLabel(unitText[i]);
			unitLabel[i].setBounds(30, 70 + 20 * (i + 1), 40, 20);
			unitLabel[i].setHorizontalAlignment(SwingConstants.RIGHT);
			
			unitTf[i] = new JTextField(5);
			unitTf[i].setBounds(80, 70 + 20 * (i + 1), 80, 20);
			unitTf[i].setHorizontalAlignment(SwingConstants.CENTER);
			
			if (i < unit.length - 1) {
				unitSel[i] = new JCheckBox("", true); // 처음부터 선택 상태인 체크박스 생성
				unitSel[i].setBounds(170, 70 + 20 * (i + 1), 20, 20);
				unitSel[i].setBackground(c.getBackground()); // 배경색을 컨텐트팬의 배경색과 동일하게 설정
				
				c.add(unitSel[i]);
			}
			
			c.add(unitLabel[i]);
			c.add(unitTf[i]);
		}
		
		/* 계산 */
		btn.addActionListener(new ActionListener() { // JButton을 클릭하거나 키로 선택하면 ActionEvent 발생
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf.getText().length() == 0) return; // 입력된 금액이 없는 경우 리턴
				
				int value = Integer.parseInt(tf.getText()); // 입력된 금액을 value에 대입
				
				for(int i = 0; i < unit.length - 1; i++) {
					if (unitSel[i].isSelected()) { // unitSel[i] (unit[i]원 단위)가 선택된 경우
						unitTf[i].setText(Integer.toString(value / unit[i])); // unit[i]원 단위 계산 후 setText() 메소드를 통해 변환값 입력
						value %= unit[i]; // unit[i]원 단위 계산 후 남은 금액
					}
					else { // unitSel[i] (unit[i]원 단위)가 선택되지 않은 경우 해당 단위 0으로 표시
						unitTf[i].setText("0");
					}
				}
				unitTf[unit.length - 1].setText(Integer.toString(value)); // 계산 후 남은금액은 모두 1원 단위에 출력
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
