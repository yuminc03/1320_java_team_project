
import javax.swing.*;
//������ �� ��� �÷������� �����ϰ� �۵��ϴ� "�淮"(��� Java ���) ���� ��� ��Ʈ�� ����
import java.awt.*;
//�ڹ� �ý��ۿ��� ����ȴٰ� �� ��쿡�� �ڹ� ������Ʈ�� ����ϱ� ������ ���� ������Ʈ���� AWT�� ����Ѵٰ� �� ��� 
//�����ϴ� ������Ʈ�� ����� ���� �޶� �ϰ��� ȭ���� �����ϴ� ���� ������� ������. �ڹ� �ʱ� ������ �����Ǵ� GUI�̴�.
import java.awt.event.ActionEvent;
//���� ��� ���� ��ġ�� �߻������� ��Ÿ���� �ǹ� ���� �̺�Ʈ. 
import java.awt.event.ActionListener;

//��ư �Ǵ� �޴� �׸��� Ŭ�� �� ������ Java ActionListener�� �˸���. ActionEvent�� ���� ����
public class Main_1 {

	private JFrame frame;// JFrame frame����

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			// ���� ������Ʈ�� �����ϱ� ���� java.awt.EventQueue.invokeLater�� ���
			// �̺�Ʈ ����Ī �����忡 ���� Runnalbe.run()�� �����Ѵ�.
			// �� �޼ҵ带 ȣ���ϸ� �̺�Ʈ ť�� runnable.run()�� ������ �ְ� �ٷ� �����Ѵ�.
			// Swing�� �̿��� ���� �����忡�� ���ÿ� GUI�۾��� �ϸ� ������ �߻��ϱ� ������ �����.

			public void run() {
				try {// try - catch�� : ���� ó��
					Main_1 window = new Main_1();// Main_1�� ȣ��
					window.frame.setVisible(true);// �������� ���̰� ��
				} catch (Exception e) {// () => ���� �߻� �κ�
					e.printStackTrace();// ���� �޼��� ��� ���
					// printStackTrace�� ���ϰ��� ����. �� �޼ҵ带 ȣ���ϸ� �޼ҵ尡 ���������� ���� ����� ȭ�鿡 ����Ѵ�.
					// printStackTrace�� ���� �ڼ��� ���� ������ ����
				}
			}// end of run()
		});// end of EventQueue
	}// end of main

	/**
	 * Create the application.
	 */
	public Main_1() {
		initialize();// initialize ȣ��
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();// frame ����
		frame.setTitle("����ȭ��");// frame���� : ����ȭ��
		frame.setBounds(100, 100, 775, 501);
		// ������Ʈ���� ��ġ ������ ���� ��ġ�ؾߵǴ� ���, �ش� ������Ʈ�� ���� ��ġ�� ũ�� ����
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();//������ �ֱ�
	      Image img = toolkit.getImage("pig.png");
	      frame.setIconImage(img);

		frame.setLocationRelativeTo(null);// ��� ����
		frame.setResizable(false);// â �ø��� �Ұ��� �ϰ� �� �� �ִ°�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// X��ư ������ ���α׷��� ����
		frame.getContentPane().setLayout(null);// Contentpane�� ���� ������� ������Ʈ�� ��ġ�ϰڴ�.
		// getContentPane() ȭ�鿡 ��µ� ��� ������Ʈ���� �����Ǵ� ����
		// setLayout(null) ���̾ƿ� �����ھ��� �����̳ʸ� ���� �� ���

		JLabel lblNewLabel = new JLabel("New label");// JLabel lblNewLabel�� "New label"��Ʈ �ֱ�
		lblNewLabel.setBounds(0, -22, 776, 500);// lblNewLabel�� ��ġ �� ��ġ
		lblNewLabel.setIcon(new ImageIcon("main.JPG"));// lblNewLabel�� �̹��� ����, �̹��� ���
														// �̹���
														// ����,
														// �̹���
														// ���
		frame.getContentPane().add(lblNewLabel);// (lblNewLabel)�̹����� getContentPane()�� ����

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(527, 12, 211, 126);// btnNewButton�� ��ġ �� ��ġ
		btnNewButton.setBorderPainted(false);// �� �� ������ �̸��̶� �����ϰ� ����� �ȱ׷��� ������ //����ȭ
		btnNewButton.setContentAreaFilled(false);// btnNewButton�� ���뿵�� ä��� ����
		frame.getContentPane().add(btnNewButton);// (btnNewButton)�̹����� getContentPane()�� ����

		JButton button = new JButton("New button");// JButton button�� "New button"��Ʈ �ֱ�
		button.setBounds(527, 157, 211, 126);// button�� ��ġ �� ��ġ
		button.setBorderPainted(false);// �� �� ������ �̸��̶� �����ϰ� ����� �ȱ׷��� ������ //����ȭ
		button.setContentAreaFilled(false);// button�� ���뿵�� ä��� ����
		frame.getContentPane().add(button);// �̹����� getContentPane()�� ����

		btnNewButton.addActionListener(new ActionListener() {
			// ������� ��ư "����"�� ��ư�� �������� �߻��ϴ� �ൿ�� ����
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("����");
				new menu_1();// �������� �Ѿ�� Ŭ���� �̸�
			}
		});

		button.addActionListener(new ActionListener() {
			// ������� ��ư "����"�� ��ư�� �������� ���α׷� �����ϴ� �ൿ�� ����
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("����");
				System.exit(0);// ����
			}
		});
	}
}
