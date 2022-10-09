import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private int unit[] = {50000, 10000, 1000, 500, 100, 50, 10, 1};
	private String unitText[] = {"5����", "1����", "1000��", "500��", "100��", "50��", "10��", "1��"};
	
	public MainFrame() {
		setTitle("Chap11-03");
		setSize(300, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(255, 200, 200));
		
		/* �Էº� */
		JLabel label = new JLabel("�ݾ�");
		label.setBounds(30, 50, 40, 20);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JTextField tf = new JTextField(10);
		tf.setBounds(80, 50, 110, 20);
		
		JButton btn = new JButton("���");
		btn.setBounds(200, 50, 70, 20);
		
		c.add(label);
		c.add(tf);
		c.add(btn);
		
		/* ��º� */
		JLabel unitLabel[] = new JLabel[unit.length]; // ���� ǥ��
		JTextField unitTf[] = new JTextField[unit.length]; // ��ȯ�� ǥ��
		
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
		
		/* ��� */
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf.getText().length() == 0) return; // �Էµ� �ݾ��� ���� ��� ����
				
				int value = Integer.parseInt(tf.getText()); // �Էµ� �ݾ�
				
				for(int i = 0; i < unit.length; i++) {
					unitTf[i].setText(Integer.toString(value / unit[i])); // unit[i]�� ���� ���
					value %= unit[i]; // unit[i]�� ���� ��� �� ���� �ݾ�
				}
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
