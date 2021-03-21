import javax.swing.*;
//������ �� ��� �÷������� �����ϰ� �۵��ϴ� "�淮"(��� Java ���) ���� ��� ��Ʈ�� ����
import java.awt.*;
//�ڹ� �ý��ۿ��� ����ȴٰ� �� ��쿡�� �ڹ� ������Ʈ�� ����ϱ� ������ ���� ������Ʈ���� AWT�� ����Ѵٰ� �� ��� 
//�����ϴ� ������Ʈ�� ����� ���� �޶� �ϰ��� ȭ���� �����ϴ� ���� ������� ������. �ڹ� �ʱ� ������ �����Ǵ� GUI�̴�.
import java.awt.event.ActionEvent;
//���� ��� ���� ��ġ�� �߻������� ��Ÿ���� �ǹ� ���� �̺�Ʈ. 
import java.awt.event.ActionListener;
//��ư �Ǵ� �޴� �׸��� Ŭ�� �� ������ Java ActionListener�� �˸���. ActionEvent�� ���� ����

public class menu_1 {

	private JFrame frame;// JFrame frame����

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { menu window = new menu();
	 * window.frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); }
	 * } }); }
	 * 
	 * /** Create the application.
	 */
	public menu_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();// frame ����
		frame.setBounds(100, 100, 816, 497);
		//// ������Ʈ���� ��ġ ������ ���� ��ġ�ؾߵǴ� ���, �ش� ������Ʈ�� ���� ��ġ�� ũ�� ����
		frame.setLocationRelativeTo(null);// ��� ����
		frame.setResizable(false);// â �ø��� �Ұ��� �ϰ� �� �� �ִ°�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// X��ư ������ ���α׷��� ����
		frame.getContentPane().setLayout(null);// Contentpane�� ���� ������� ������Ʈ�� ��ġ�ϰڴ�.
		Toolkit toolkit = Toolkit.getDefaultToolkit();//������ �ֱ�
	      Image img = toolkit.getImage("pig.png");
	      frame.setIconImage(img);


		JLabel lblNewLabel = new JLabel("New label");// JLabel lblNewLabel�� "New label"��Ʈ �ֱ�
		lblNewLabel.setBounds(0, -41, 805, 537);// lblNewLabel�� ��ġ �� ��ġ
		lblNewLabel.setIcon(new ImageIcon("MENU.JPG"));// lblNewLabel�� �̹��� ����, �̹��� ���
		frame.getContentPane().add(lblNewLabel);// �̹����� getContentPane()�� ����

		JButton getmoney = new JButton("getmoney");// JButton getmoney�� "getmoney"��Ʈ �ֱ�
		getmoney.setBounds(640, 12, 144, 45);// getmoney�� ��ġ �� ��ġ
		getmoney.setBorderPainted(false);// �� �� ������ �̸��̶� �����ϰ� ����� �ȱ׷��� ������ //����ȭ
		getmoney.setContentAreaFilled(false);// getmoney�� ���뿵�� ä��� ����
		frame.getContentPane().add(getmoney);// (getmoney)�̹����� getContentPane()�� ����
		getmoney.addActionListener(new ActionListener() {
			// ������� ��ư "�� â ����"�� ��ư�� �������� �߻��ϴ� �ൿ�� ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new getMoney(); // Ŭ���� newWindow�� ���� ������
			}
		});

		JButton outmoney = new JButton("outmoney");// JButton outmoney�� "outmoney"��Ʈ �ֱ�
		outmoney.setBounds(640, 69, 144, 45);// outmoney�� ��ġ �� ��ġ
		outmoney.setBorderPainted(false);// �� �� ������ �̸��̶� �����ϰ� ����� �ȱ׷��� ������ //����ȭ
		outmoney.setContentAreaFilled(false);// outmoney�� ���뿵�� ä��� ����
		frame.getContentPane().add(outmoney);// (outmoney)�̹����� getContentPane()�� ����
		outmoney.addActionListener(new ActionListener() {
			// ������� ��ư "�� â ����"�� ��ư�� �������� �߻��ϴ� �ൿ�� ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new outMoney(); // Ŭ���� newWindow�� ���� ������
			}
		});

		JButton goal = new JButton("goal");
		goal.setBounds(640, 139, 144, 45);// goal�� ��ġ �� ��ġ
		goal.setBorderPainted(false);// �� �� ������ �̸��̶� �����ϰ� ����� �ȱ׷��� ������ //����ȭ
		goal.setContentAreaFilled(false);// goal�� ���뿵�� ä��� ����
		frame.getContentPane().add(goal);// (goal)�̹����� getContentPane()�� ����
		goal.addActionListener(new ActionListener() {
			// ������� ��ư "�� â ����"�� ��ư�� �������� �߻��ϴ� �ൿ�� ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MyGoal(); // Ŭ���� newWindow�� ���� ������
			}
		});

		JButton book = new JButton("book");
		book.setBounds(640, 202, 144, 45);// book�� ��ġ �� ��ġ
		book.setBorderPainted(false);// �� �� ������ �̸��̶� �����ϰ� ����� �ȱ׷��� ������ //����ȭ
		book.setContentAreaFilled(false);// book�� ���뿵�� ä��� ����
		frame.getContentPane().add(book);// (book)�̹����� getContentPane()�� ����
		book.addActionListener(new ActionListener() {
			// ������� ��ư "�� â ����"�� ��ư�� �������� �߻��ϴ� �ൿ�� ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Book(); // Ŭ���� newWindow�� ���� ������
			}
		});

		JButton calcu = new JButton("calcu");
		calcu.setBounds(640, 263, 144, 45);// calcu�� ��ġ �� ��ġ
		calcu.setBorderPainted(false);// �� �� ������ �̸��̶� �����ϰ� ����� �ȱ׷��� ������ //����ȭ
		calcu.setContentAreaFilled(false);// calcu�� ���뿵�� ä��� ����
		frame.getContentPane().add(calcu);// (calcu)�̹����� getContentPane()�� ����
		calcu.addActionListener(new ActionListener() {
			// ������� ��ư "�� â ����"�� ��ư�� �������� �߻��ϴ� �ൿ�� ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Calculator(); // Ŭ���� newWindow�� ���� ������
			}
		});

		JButton calender = new JButton("calender");
		calender.setBounds(640, 332, 144, 45);// calender�� ��ġ �� ��ġ
		calender.setBorderPainted(false);// �� �� ������ �̸��̶� �����ϰ� ����� �ȱ׷��� ������ //����ȭ
		calender.setContentAreaFilled(false);// calender�� ���뿵�� ä��� ����
		frame.getContentPane().add(calender);// (calender)�̹����� getContentPane()�� ����
		calender.addActionListener(new ActionListener() {
			// ������� ��ư "�� â ����"�� ��ư�� �������� �߻��ϴ� �ൿ�� ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SwingCalender(); // Ŭ���� newWindow�� ���� ������
			}
		});

		JButton Memo = new JButton("memo");
		Memo.setBounds(640, 389, 144, 45);// memo�� ��ġ �� ��ġ
		Memo.setBorderPainted(false);// �� �� ������ �̸��̶� �����ϰ� ����� �ȱ׷��� ������ //����ȭ
		Memo.setContentAreaFilled(false);// memo�� ���뿵�� ä��� ����
		frame.getContentPane().add(Memo);// (memo)�̹����� getContentPane()�� ����
		frame.setVisible(true);
		Memo.addActionListener(new ActionListener() {
			// ������� ��ư "�� â ����"�� ��ư�� �������� �߻��ϴ� �ൿ�� ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new NotePad(); // Ŭ���� newWindow�� ���� ������
			}
		});
	}

}