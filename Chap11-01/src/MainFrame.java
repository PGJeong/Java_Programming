import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Chap11-01");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JCheckBox cb1 = new JCheckBox("��ư ��Ȱ��ȭ");
		JCheckBox cb2 = new JCheckBox("��ư ���߱�");
		JButton btn = new JButton("Test Button");
		
		cb1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) // ItemEvent�� getStateChange() ���
					btn.setEnabled(false);
				else
					btn.setEnabled(true);
			}
		});
		
		cb2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(cb2.isSelected()) // JCheckBox�� isSelected() ���
					btn.setVisible(false);
				else
					btn.setVisible(true);
			}
		});
		
		c.add(cb1);
		c.add(cb2);
		c.add(btn);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
