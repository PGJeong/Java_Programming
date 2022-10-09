import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private int unit[] = {50000, 10000, 1000, 500, 100, 50, 10, 1};
	private String unitText[] = {"5����", "1����", "1000��", "500��", "100��", "50��", "10��", "1��"};
	
	public MainFrame() {
		setTitle("Chap11-04");
		setSize(300, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(255, 200, 200)); // ���� ������Ʈ���� ���� �޼ҵ� (JComponent �޼ҵ�). ���� ����
		
		/* �Էº� */
		JLabel label = new JLabel("�ݾ�");
		label.setBounds(30, 50, 40, 20); // setBounds(int x, int y, int width, int height) ��ġ �� ũ�� ���� ����
		label.setHorizontalAlignment(SwingConstants.RIGHT); // JButton�� JLable���� ��� ������ ���� ���� �޼ҵ�
		
		JTextField tf = new JTextField(10); // ��ȯ�� �ݾ��� �Է��� �ؽ�Ʈ�ʵ�
		tf.setBounds(80, 50, 110, 20);
		
		JButton btn = new JButton("���");
		btn.setBounds(200, 50, 70, 20);
		
		c.add(label);
		c.add(tf);
		c.add(btn);
		
		/* ��º� */
		JLabel unitLabel[] = new JLabel[unit.length]; // ���� ǥ��
		JTextField unitTf[] = new JTextField[unit.length]; // ��ȯ�� ǥ��
		JCheckBox unitSel[] = new JCheckBox[unit.length - 1]; // ��ȯ�� ���� ����
		
		for(int i = 0; i < unit.length; i++) {
			unitLabel[i] = new JLabel(unitText[i]);
			unitLabel[i].setBounds(30, 70 + 20 * (i + 1), 40, 20);
			unitLabel[i].setHorizontalAlignment(SwingConstants.RIGHT);
			
			unitTf[i] = new JTextField(5);
			unitTf[i].setBounds(80, 70 + 20 * (i + 1), 80, 20);
			unitTf[i].setHorizontalAlignment(SwingConstants.CENTER);
			
			if (i < unit.length - 1) {
				unitSel[i] = new JCheckBox("", true); // ó������ ���� ������ üũ�ڽ� ����
				unitSel[i].setBounds(170, 70 + 20 * (i + 1), 20, 20);
				unitSel[i].setBackground(c.getBackground()); // ������ ����Ʈ���� ������ �����ϰ� ����
				
				c.add(unitSel[i]);
			}
			
			c.add(unitLabel[i]);
			c.add(unitTf[i]);
		}
		
		/* ��� */
		btn.addActionListener(new ActionListener() { // JButton�� Ŭ���ϰų� Ű�� �����ϸ� ActionEvent �߻�
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf.getText().length() == 0) return; // �Էµ� �ݾ��� ���� ��� ����
				
				int value = Integer.parseInt(tf.getText()); // �Էµ� �ݾ��� value�� ����
				
				for(int i = 0; i < unit.length - 1; i++) {
					if (unitSel[i].isSelected()) { // unitSel[i] (unit[i]�� ����)�� ���õ� ���
						unitTf[i].setText(Integer.toString(value / unit[i])); // unit[i]�� ���� ��� �� setText() �޼ҵ带 ���� ��ȯ�� �Է�
						value %= unit[i]; // unit[i]�� ���� ��� �� ���� �ݾ�
					}
					else { // unitSel[i] (unit[i]�� ����)�� ���õ��� ���� ��� �ش� ���� 0���� ǥ��
						unitTf[i].setText("0");
					}
				}
				unitTf[unit.length - 1].setText(Integer.toString(value)); // ��� �� �����ݾ��� ��� 1�� ������ ���
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
