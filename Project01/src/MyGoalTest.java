import java.awt.Color;
import java.awt.FlowLayout;//FlowLayout�� �ҷ���.
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
//���� ��� ���� ��ġ�� �߻������� ��Ÿ���� �ǹ� ���� �̺�Ʈ. 
import java.awt.event.ActionListener;
//��ư �Ǵ� �޴� �׸��� Ŭ�� �� ������ Java ActionListener�� �˸���. ActionEvent�� ���� ����
import javax.swing.JButton;
//JButton Ŭ������ �÷��� �������� �������ִ� ���̺��� ������ ���߸� �ۼ��ϴ� �� ����
import javax.swing.JFrame;
//java.awt.Frame Ŭ������ ����ϴ� �����̳� ����. JFrame�� GUI�� ����� ���� ���̺�, ��ư, �ؽ�Ʈ �ʵ�� ���� ���� ��Ұ� �߰��Ǵ� �⺻ âó�� �۵���
import javax.swing.JLabel;
//JLabel�� java Swing Ŭ�����̴�. JLabel�� ª�� ���ڿ� �Ǵ� �̹��� �������� ǥ���ϴ� �� �����.
import javax.swing.JPanel;
//Java Swing ��Ű���� �Ϻ��� JPanel�� ���� ��� �׷�(��, ��ư ��.)�� ������ ���ִ� �����̳��̴�.
import javax.swing.JTextField;
//JTextField Ŭ������ ��ü�� �� �� �ؽ�Ʈ�� ���� �� ���ִ� �ؽ�Ʈ ���� ����̴�.

class MyGoal {
	// ��ǥ
	public MyGoal() {

		JFrame frame1 = new JFrame();// ��ǥ������ ��Ÿ�� ������ ����
		frame1.setLayout(new FlowLayout());
		// FlowLayout = ������Ʈ���� ���ʿ��� ���������� �߰���
		// �⺻������ ��� ����
//		JPanel goalP, buttonP;//�ݾ� �Է� �г�, ��ư�����г�
//		JTextField goalT;//�ݾ� �Է� �ؽ�Ʈ�ʵ�
//		JLabel goalL;//�ݾ� �Է� ��
//		JButton goalB;//��ǥ �޽����� ��� ��ư

		JPanel moneyP = new JPanel();// ���� ������ �ִ� ���� �˷��ִ� JLabel�� ������ JPanel
		JPanel goalP = new JPanel();// ��ǥ�ݾ��� ������ ������ JPanel
		JPanel buttonP = new JPanel();// ��ư�� ������ JPanel

		moneyP.setBackground(new Color(255, 204, 0));// moneyP�� ���� ����
		goalP.setBackground(new Color(255, 204, 0));// goalP�� ���� ����
		buttonP.setBackground(new Color(255, 204, 0));// buttonP�� ���� ����
		Toolkit toolkit = Toolkit.getDefaultToolkit();// ������ �ֱ�
		Image img = toolkit.getImage("pig.png");
		frame1.setIconImage(img);

		JLabel moneyL = new JLabel("���� ������ �ִ� ���� ");// JLabel moneyL�� "���� ������ �ִ� ����" ��Ʈ�� �ִ´�.
		String haveMoney = Integer.toString(Book.Total);// ���� ������ �ִ� ���� ��ο��� �ҷ��ͼ� intŸ������ �ٲ� ��, haveMoney�� ����
		JTextField moneyT = new JTextField();// JTextField moneyT�� ������(���� ������ �ִ� �ݾ��� ���� TextField).
		moneyT.setText(haveMoney);// moneyT�� �ؽ�Ʈ�� haveMoney�� ������
		JLabel moneyL2 = new JLabel("�� �Դϴ�.");// moneyL2�� "�� �Դϴ�." ��Ʈ�� �ִ´�.

		JLabel goalL = new JLabel("������ ���� �ݾ��� �Է����ּ��� : ");// "������ ���� �ݾ��� �Է����ּ��� : "��Ʈ�� goalL�� �ִ´�, JLabel����
		JTextField goalT = new JTextField(12);// ũ�� 12�� �ؽ�Ʈ�ʵ� ����(������ ���� �ݾ��� �Է��� â)
		JButton goalB = new JButton("Ȯ��");// ��ư �̸��� Ȯ���� goalB ����
		moneyP.add(moneyL);// moneyP�� moneyL�� ���� (moneyP = ���� ������ �ִ� ���� ������ ��Ÿ��)
		moneyP.add(moneyT);// moneyP�� moneyT�� ����
		moneyP.add(moneyL2);// moneyP�� moneyL2�� ����
		goalP.add(goalL);// goalP�� goalL�� ���� (goalP = ��ǥ�ݾ� ������ ��Ÿ��)
		goalP.add(goalT);// goalP�� goalT�� ����
		buttonP.add(goalB);// buttonP�� goalB�� ����

		frame1.add(moneyP);// frame1�� moneyP�� ����(����)
		frame1.add(goalP);// frame1�� goalP�� ����(����)
		frame1.add(buttonP);// frame1�� buttonP����

		goalB.addActionListener(new ActionListener() {// goalB�� ����� �߰���
			@Override
			public void actionPerformed(ActionEvent arg0) {// ��ư�� Ŭ���ϸ� ������

				JFrame moneyf = new JFrame();// JFrame moneyf�� ����(������ ���� �ݾ� ������ ������)
				JPanel moneyp = new JPanel();// JPanel moneyp�� ����(��ǥ �ݾ� ������ JPanel)

				int moneyI = Integer.parseInt(haveMoney);// haveMoney(���� ������ �ִ� ��)�� intŸ������ �ٲٰ� moneyI�� ������
				int getmoney = Integer.parseInt(goalT.getText());// goalT�� �ؽ�Ʈ(������ ���� �ݾ�)��
				// �����ͼ� intŸ������ �ٲ� ��, getmoney�� ����. getmoney = ������ ���� �ݾ�
				// gText�� intŸ�� �������·� �ٲ۴�
				int gather = getmoney - moneyI;// getmoney(������ ���� �ݾ�)���� moneyI(���� ������ �ִ� ��)
				// �� ����, gether�� ����. gather = ��ƾ� �� �ݾ�

				if (getmoney <= moneyI) {// ��ƾ� �� �ݾ��� ������ �ִ� ������ �۰ų� ���ٸ�

					JLabel result2 = new JLabel("��ǥ�� �� ���� ��ƺ�����!");
					// JLabel result2����, "��ǥ�� �� ���� ��ƺ�����!" ��Ʈ�� ����
					moneyp.add(result2);// result2�� moneyp�� ����
					moneyf.add(moneyp);// moneyp�� moneyf�� ����
					result2.setFont(new Font("����", Font.PLAIN, 30));// label�� ��Ʈ ����( �۲�, ũ��)
					moneyp.setBackground(new Color(255, 204, 0));
					moneyf.setLocationRelativeTo(null);// ��� ����
					moneyf.setSize(400, 100);// moneyf�� ũ�� :400 X 200
					moneyf.setVisible(true);// moneyf�� ���̰� ��
					moneyf.setResizable(false);// moneyf�� ũ�� ���� �Ұ�
					// moneyf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//X��ư�� ������ ���α׷� ������
				} else {// ��ƾ� �� �ݾ��� �� �޿뵷 ���� ũ��
					JLabel moneyl = new JLabel("������ ");// JLabel moneyl�� "������ "��Ʈ�� ����
					String result = Integer.toString(gather);// gather(��ƾ� �� ��)�� StringŸ������ �ٲٰ� result�� ����
					JTextField result2 = new JTextField();// JTextField result2�� ������.
					result2.setText(result);// result2�� �ؽ�Ʈ�� Result�� �Ѵ�
					result2.setEditable(false);// setText�� �۵�������, ����ڴ� �ؽ�Ʈ�ʵ忡 �Է��� �� ����
					result2.setFont(new Font("����", Font.PLAIN, 30));// label�� ��Ʈ ����( �۲�, ũ��)

					JLabel money2 = new JLabel("�� ���ҽ��ϴ�! ȭ����!");// JLabel money2�� "�� ���ҽ��ϴ�! ȭ����!"��Ʈ�� ����.
					moneyp.add(moneyl);// moneyp(��ǥ �ݾ� ������ JPanel)�� moneyl�� ����
					moneyp.add(result2);// moneyp(��ǥ �ݾ� ������ JPanel)�� result2�� ����
					moneyp.add(money2);// moneyp(��ǥ �ݾ� ������ JPanel)�� money2�� ����
					moneyf.add(moneyp);// moneyf(������ ���� �ݾ� ������ ������)�� moneyP�� ����

					moneyf.setTitle("��ǥ�ݾ�");// moneyf�� ������ "��ǥ�ݾ�"���� ��
					moneyf.setSize(400, 200);// moneyf ũ�⸦ 250 X 200���� ����
					moneyf.setVisible(true);// moneyf�� ���̰� ����
					moneyf.setResizable(false);// moneyf�� ũ�⸦ ������ �� ���� ����.
					moneyf.setLocationRelativeTo(null);// ��� ����
					moneyl.setFont(new Font("����", Font.PLAIN, 20));// ��Ʈ ����( �۲�, ũ��)
					money2.setFont(new Font("����", Font.PLAIN, 20));// ��Ʈ ����( �۲�, ũ��)
					moneyf.setLocationRelativeTo(null);// ��� ����
					moneyp.setBackground(new Color(255, 204, 0));
					// moneyf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} // end of else

			}// end of actionPerformed

		});// end of ActionListener
		frame1.setTitle("��ǥ");// frame1�� ���� : ��ǥ
		frame1.setSize(385, 200);// frame1�� ũ�� : 385 X 500
		frame1.setVisible(true);// frame1�� ���̰� ��
		frame1.setResizable(false);// frame1�� ũ�⸦ ������ �� ����.
		frame1.setLocationRelativeTo(null);// ��� ����
		frame1.getContentPane().setBackground(new Color(255, 204, 0));// frame1�� ���� ������
		// frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// end of MyGoal

}// end of class

public class MyGoalTest {

	public static void main(String[] args) {
		new MyGoal();
	}
}