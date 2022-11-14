import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*; // FileNameExtensionFilter 클래스 사용을 위해 import

@SuppressWarnings("serial")
public class MainFrame extends JFrame {	
	private String imgPath;
	
	class MyPanel extends JPanel { // 내부클래스. 이미지를 출력할 Panel
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // JPanel에 구현된 paintComponent() 호출. 그려진 내용을 모두 지우고 지정된 배경색으로 칠하기
			
			if(imgPath != null) {
				Image img = new ImageIcon(imgPath).getImage();
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this); // 이미지가 패널의 크기에 꽉 차도록 그리기
			}
		}
	}
	
	public MainFrame() {
		setTitle("Chap14-02");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		MyPanel panel = new MyPanel();
		setContentPane(panel);
		
		JMenuBar mb = new JMenuBar(); // (메뉴 만들기) 1. 메뉴바 만들기
		
		JMenu menu = new JMenu("File"); // 2. 메뉴 만들고, 메뉴바에 붙이기
		mb.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Open"); // 3. 메뉴아이템을 만들고, 메뉴에 붙이기
		menu.add(menuItem);
		
		setJMenuBar(mb); // 4. 메뉴바를 프레임에 붙이기
		
		menuItem.addActionListener(new ActionListener() { // 메뉴 아이템 클릭 시 Action 이벤트 발생
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(); // (파일열기 다이얼로그 만들기) 1. JFileChooser 생성
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg"); // 2. 파일 필터 생성. JPG 확장자만 필터링
				chooser.setFileFilter(filter); // 3. JFileChooser에 파일 필터 설정
				
				int ret = chooser.showOpenDialog(null); // 4. 파일 열기 다이얼로그 출력
				
				if(ret == JFileChooser.APPROVE_OPTION) { // 열기 버튼을 누른 경우
					imgPath = chooser.getSelectedFile().getPath(); // 5. 사용자가 선택한 파일 경로 알아내기
					panel.getParent().repaint(); // JFrame의 Content Pane인 panel 다시 그리기
				}
				else {
					imgPath = null;
				}
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
