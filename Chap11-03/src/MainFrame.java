import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private int unit[] = {50000, 10000, 1000, 500, 100, 50, 10, 1};
	private String unitText[] = {"5만원", "1만원", "1000원", "500원", "100원", "50원", "10원", "1원"};
	
	public MainFrame() {
		setTitle("Chap11-03");
		setSize(300, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(255, 200, 200));
		
		/* 입력부 */
		JLabel label = new JLabel("금액");
		label.setBounds(30, 50, 40, 20);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JTextField tf = new JTextField(10);
		tf.setBounds(80, 50, 110, 20);
		
		JButton btn = new JButton("계산");
		btn.setBounds(200, 50, 70, 20);
		
		c.add(label);
		c.add(tf);
		c.add(btn);
		
		/* 출력부 */
		JLabel unitLabel[] = new JLabel[unit.length]; // 단위 표시
		JTextField unitTf[] = new JTextField[unit.length]; // 변환값 표시
		
		for(int i = 0; i < unit.length; i++) {
			unitLabel[i] = new JLabel(unitText[i]);
			unitLabel[i].setBounds(30, 70 + 20 * (i + 1), 40, 20);
			unitLabel[i].setHorizontalAlignment(SwingConstants.RIGHT);
			
			unitTf[i] = new JTextField(5);
			unitTf[i].setBounds(80, 70 + 20 * (i + 1), 80, 20);
			unitTf[i].setHorizontalAlignment(SwingConstants.CENTER);
			
			c.add(unitLabel[i]);
			c.add(unitTf[i]);
		}
		
		/* 계산 */
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf.getText().length() == 0) return; // 입력된 금액이 없는 경우 리턴
				
				int value = Integer.parseInt(tf.getText()); // 입력된 금액
				
				for(int i = 0; i < unit.length; i++) {
					unitTf[i].setText(Integer.toString(value / unit[i])); // unit[i]원 단위 계산
					value %= unit[i]; // unit[i]원 단위 계산 후 남은 금액
				}
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
