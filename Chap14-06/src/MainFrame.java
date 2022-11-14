import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
class MyDialog extends JDialog {
	int sum;
	
	public MyDialog(JFrame frame) {
		super(frame, "Add", true);
		// 1��° ���ڿ� ���̾�α��� ������ �Ǵ� ������Ʈ�� �ش�
		// 3��° ���ڿ� true�� �־� ��� ���̾�α� ����
		setSize(200, 200);
		setLocationRelativeTo(null);
		
		JTextField num1 = new JTextField(12);
		JTextField num2 = new JTextField(12);
		JButton btn = new JButton("Add");
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sum = Integer.parseInt(num1.getText()) + Integer.parseInt(num2.getText());
				setVisible(false); // ���̾�α� �ݱ� (���̾�α״� �������� ������ ������� ���� �ƴϴ�)
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
				// ���̾�α׸� ����ϰ� �۵���Ŵ
				// ��� ���̾�α׿��� setVisible(true)�޼ҵ�� ���̾�αװ� ���� �� ���� �������� ����
				
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
