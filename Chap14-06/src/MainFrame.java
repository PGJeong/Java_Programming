import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
class MyDialog extends JDialog {
	int sum;
	
	public MyDialog(JFrame frame) {
		super(frame, "Add", true);
		// 1번째 인자에 다이얼로그의 주인이 되는 컴포턴트를 준다
		// 3번째 인자에 true를 주어 모달 다이얼로그 생성
		setSize(200, 200);
		setLocationRelativeTo(null);
		
		JTextField num1 = new JTextField(12);
		JTextField num2 = new JTextField(12);
		JButton btn = new JButton("Add");
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sum = Integer.parseInt(num1.getText()) + Integer.parseInt(num2.getText());
				setVisible(false); // 다이얼로그 닫기 (다이얼로그는 숨겨지는 것이지 사라지는 것이 아니다)
			}
		});
		
		setLayout(new FlowLayout());
		add(new JLabel("Add two numbers"));
		add(num1);
		add(num2);
		add(btn);
	}
	
	public int getValue() {
		return sum;
	}
}

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Chap14-06");
		setSize(250, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Calculate");
		JLabel label = new JLabel("Result");
		MyDialog dialog = new MyDialog(this);
		
		label.setBackground(Color.GREEN);
		label.setOpaque(true);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				// 다이얼로그를 출력하고 작동시킴
				// 모달 다이얼로그에서 setVisible(true)메소드는 다이얼로그가 닫힐 때 까지 리턴하지 않음
				
				label.setText(Integer.toString(dialog.getValue()));
			}
		});
		
		c.add(btn);
		c.add(label);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
