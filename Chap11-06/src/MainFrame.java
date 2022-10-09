import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*; // ChangeEvent, ChangeListener�� javax.swing.event ��Ű��

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setSize(350, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		
		JTextArea ta = new JTextArea("������ �Է��ϼ���", 5, 20); // JTextArea(String text, int rows, int columns)
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, ta.getText().length()); // JSlider(int orientation, int min, int max, int val)
		slider.setMajorTickSpacing(20); // slider�� ū ���� ������ 20���� ��
		slider.setMinorTickSpacing(5); // slider�� ���� ���� ������ 5�� ����
		slider.setPaintTicks(true); // slider�� ������ ���̰� ��
		slider.setPaintLabels(true); // slider�� label�� ���̰� ��
		
		ta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setTitle("Characters : " + ta.getText().length()); // ���� ���� �� Ÿ��Ʋ�� ǥ��
				
				if(ta.getText().length() > 100) { // �Էµ� ���ڿ��� ���̰� 100 �ʰ��� ���
					ta.setText(ta.getText().substring(0, 100)); // 100 �̸�(index 0 ~ 99)�� ���ڿ��� TextArea�� ���
				}
				else {
					slider.setValue(ta.getText().length()); // Slider�� ���� ���� ���ڿ��� ���̷� ����
				}
			}
		});
		
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				setTitle("Characters : " + ta.getText().length()); // ���� ���� �� Ÿ��Ʋ�� ǥ��
				
				if(slider.getValue() <= ta.getText().length()) { // ������ Slider�� ���� ���ڿ� ���� ������ ���
					ta.setText(ta.getText().substring(0, slider.getValue())); // Slider�� ��(index) �̸��� ���ڿ��� TextArea�� ���
				}
				else { // ������ Slider�� ���� ���ڿ� ���̺��� ū ���
					slider.setValue(ta.getText().length()); // Slider�� ���� ���� ���ڿ��� ���̷� ����
				}
			}
		});
		
		c.add(new JScrollPane(ta), BorderLayout.CENTER); // JTextArea���� ��ũ�ѹٸ� ����� �� �ֵ��� JScrollPane�� ����
		c.add(slider, BorderLayout.SOUTH);
		
		setTitle("Characters : " + ta.getText().length()); // ���� ���� �� Ÿ��Ʋ�� ǥ��
		setVisible(true); // setVisible() �޼ҵ�� �������� ȭ�鿡 ����� �� Focus�� ���Ƿ� ����
		
		ta.setFocusable(true); // Focus�� ���� �� �ֵ��� ���� (setVisible() �޼ҵ� �ڿ� ȣ��)
		ta.requestFocus(); // Focus �־� Ű �Է��� �����ϵ��� �� (setVisible() �޼ҵ� �ڿ� ȣ��)
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
