import java.util.Calendar;
//Ư�� ������ MONTH, YEAR, HOUR ��� ���� ���� �ʵ� ��Ʈ���� ��¥�� ��ȯ�ϴ� �޼ҵ带 �����ϴ� �߻� Ŭ����
import java.awt.*;
//Java���� GUI �Ǵ� â ��� ���ø����̼��� �����ϱ����� API 
import java.awt.event.*;
//�̺�Ʈ�� AWT�� ������ ó���ϱ� ���� ���Ǵ� Ŭ���� �� �������̽��� ���� 
import javax.swing.*;

//������ �� ��� �÷������� �����ϰ� �۵��ϴ� "�淮"(��� Java ���) ���� ��� ��Ʈ�� ����
public class SwingCalender implements ActionListener {
	Calendar cal;
	int int_Year, int_Month;
	String year, month;
	StringBuffer sb_Print;

	JLabel lb_title, lb_YearSpace, lb_MonthSpace;
	JTextField textField_Year, textField_Month;
	JTextPane textPane;
	// JEditorPane Ŭ������ ���� Ŭ�����̴�. JTextPane�� �̹����� ������Ʈ�� ���� �� ��Ÿ�� ������ ���
	// JEditorPane :�پ��� ������ �������� �����ϴ� �ؽ�Ʈ ���� ���
	// �ؽ�Ʈ, �̹���ó��, ��Ʈũ��, ���� � ó������ �ϴٴ� ������ JTestArea�� �񱳵�.
	JPanel panel_North, panel_NorthFloor;
	JButton bt_Input;

	public SwingCalender() {
		cal = Calendar.getInstance();
		// Calendar getInstance() : ���� ��¥�� �ð� ������ ���� Calendar ��ü�� �����Ѵ�.
		setCalFrame();// setCalFrame() ȣ����
	}

	public void setCalendar() {
		sb_Print = new StringBuffer();
		// StringBuffer �ڷ����� append ��� �޼ҵ带 �̿��Ͽ� ����ؼ� ���ڿ��� �߰��� ���� �� �ִ�.
		sb_Print.append("     ��   ��   ȭ   ��   ��    ��   ��\n");

		cal.set(int_Year, int_Month - 1, 1);
		// ���� 0���� �����ؾ� �ϹǷ� 0�� 1���� ��.
		int cal_Field = cal.get(7);
		for (int j = 1; j < cal_Field; j++) {
			sb_Print.append("       ");
			// sb_Print�� ������ ����
		}

		int cal_Gam = cal.getActualMaximum(5);
		// getActualMaximum() :��¥�� ���� �� Calender�� ������ �ִ� ��
		// ���� ��ü�� Ư�� �ʵ��� �ִ� ���� ��ȯ�Ѵ�.
		// cal_Gam�� �� ���� '��'�� ��

		int comp = 1;
		for (int k = cal_Field; comp <= cal_Gam; k++)
		// k = cal_Field, comp�� cal_Gam���� �۰ų� ���� ������ k�� ����
		{
			if (comp >= cal_Gam) {
				if (comp < 10) {
					sb_Print.append("    ");
					// sb_Print�� ������ ����
				} else
					sb_Print.append("   ");
				// sb_Print�� ������ ����

				sb_Print.append(comp);
				// sb_Print�� comp�� ����
				textPane.setText(sb_Print.toString());
				// textPane�� �ؽ�Ʈ�� sb_Print�� ���ڿ����� ������ �� ������ ������.
			} else {
				if (comp < 10) {
					sb_Print.append("     ");
					// sb_Print�� ������ ����
				} else
					sb_Print.append("   ");
				// sb_Print�� ������ ����

				sb_Print.append(comp);
				// sb_Print�� comp�� ����
				textPane.setText(sb_Print.toString());
				// textPane�� �ؽ�Ʈ�� sb_Print�� ���ڿ����� ������ �� ������ ������.
			}

			if (k % 7 == 0)
				sb_Print.append("\n");
			// k(��)�� 7�� ������ �������� sb_Print�� �ٹٲ��� ����.
			comp++;// comp�� ����
		}
	}

	public void setCalFrame() {
		lb_title = new JLabel("������ ���� �Է��ϼ��� -> ex) xxxx xx", SwingConstants.CENTER);
		// SwingConstants :ȭ��󿡼� ���۳�Ʈ�� ��ġ �� ���� ������ �ǽ��ϱ� ���ؼ�(������) ���
		// lb_title�� ��ġ�� center�� ������
		lb_YearSpace = new JLabel("�� ");
		// lb_YearSpace�� "��"�̶�� ��
		lb_MonthSpace = new JLabel("�� ");
		// lb_MonthSpace�� "��"�̶�� ��
		textField_Year = new JTextField(5);
		// textField_Year�� ũ�Ⱑ 5�� JTextField�̴�
		textField_Month = new JTextField(3);
		// textField_Month�� ũ�Ⱑ 5�� JTextField�̴�
		textPane = new JTextPane();
		// JTextPane: �̹����� ������Ʈ�� ���� �� ��Ÿ�� ������ ���
		// �ؽ�Ʈ, �̹���ó��, ��Ʈũ��, ��Ʈ���� ���� ó������(TestArea�� �񱳵�)
		panel_North = new JPanel(new GridLayout(2, 1));
		// panel_North : 2�� 1���� ������ ���̾ƿ�.
		panel_NorthFloor = new JPanel();
		// panel_NorthFloor�̶�� �̸��� Panel����
		bt_Input = new JButton("�Է�");
		// bt_Input �̶�� �̸��� ��ư "�Է�" ����

		try {// ���ܰ� �߻��� �� �ִ� �ڵ� �κ�
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			// ��� �÷������� �����ϰ� ���̴� "Java L & F"("�ݼ�"�̶�� ��), �ڵ忡�� �ƹ� �͵� �������� ���� ��� ���Ǵ� �⺻��
			// LookAndFeel : ���α׷� ��ü�� UI ����� ������ �� �ִ�.
			// ȯ�濡 ������� �����ϰ� ������ ������� ���Ͽ� �ý����� ������ ����� ���� ������ ����

			// UIManager :����� ����, ����� �⺻��, �پ��� �⺻���� ������� ���� ����� �˷��ִ� ���� �����, ��� ������ ����� ��Ʈ��
			// ����
			// ����ó���� �ʿ���, ��θ� ã�� ���� ClassNotFoundException�� �߻��� �� �ֱ� ����
		} catch (Exception e) {
		} // Exception e : ó���� ���� Ÿ�� e
			// try��� �ȿ��� ���ܰ� �߻����� �� ���ܰ� �߻����� �� ���ܸ� ó���ϴ� �κ�

		JFrame.setDefaultLookAndFeelDecorated(true);
		// ���Ӱ� �ۼ��� JFrame�� ������ Look & Feel�� ���� �����Ǵ�
		// ������ ����(���, ������ Ŭ�ν�, Ÿ��Ʋ�� ��)�� ����� �� �����ϴ� �Լ�,
		// true�� ���, swing�������� ������.
		JFrame frame = new JFrame("==Ķ����==");
		// JFrame����, ������ �̸� : Swing Calendar
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("pig.png");
		frame.setIconImage(img);

		frame.add(panel_North, "North");
		// �������� panel_North�� North�ʿ� ��ġ
		panel_North.add(lb_title);
		// panel_North�� lb_title�� ���Ѵ�
		panel_North.add(panel_NorthFloor);
		// panel_North�� panel_NorthFloor�� ���Ѵ�
		panel_NorthFloor.add(textField_Year);
		// panel_NorthFloor�� textField_Year�� ���Ѵ�
		panel_NorthFloor.add(lb_YearSpace);
		// panel_NorthFloor�� lb_YearSpace�� ���Ѵ�
		panel_NorthFloor.add(textField_Month);
		// panel_NorthFloor�� textField_Month�� ���Ѵ�
		panel_NorthFloor.add(lb_MonthSpace);
		// panel_NorthFloor�� lb_MonthSpace�� ���Ѵ�
		panel_NorthFloor.add(bt_Input);
		// panel_NorthFloor�� bt_Input�� ���Ѵ�

		frame.add(textPane, "Center");
		// frame�� textPane�� Center�� ��ġ
		textPane.setEditable(false);
		// setEditable(): �޺��ڽ��� ���� ���� ���¸� ����
		// �Ű� ������ false �� ��� ����ڴ� �ʵ忡 �Է� �� �� ����.
		textPane.setFont(new Font("font", Font.BOLD, 16));
		// ��Ʈ�� �̸�, ��Ÿ��, ũ�⸦ ����
		textPane.setForeground(Color.blue);
		// ��Ʈ�� ������ �Ķ����� ����

		bt_Input.addActionListener(this);
		// bt_Input�� �̺�Ʈ ���

		frame.setSize(260, 280);
		// frameũ�� 260 X 280
		frame.setLocation(300, 300);
		// �� ���۳�Ʈ�� ���ο� ��ġ�� �̵�
		frame.setVisible(true);
		// frame�� ���̰� ��
		frame.setResizable(false);
		// frame�� ũ�� ���� ���� (�Ұ�)
		frame.setLocationRelativeTo(null);// ��� ����
		// frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// getSource() : �̺�Ʈ�� �߻���Ų ��ü�� ��ġ���� �����´�.
		if (obj == bt_Input) {
			year = textField_Year.getText();
			// textField_Year�� �ؽ�Ʈ�� year�� ����
			month = textField_Month.getText();
			// textField_MONTH�� �ؽ�Ʈ�� month�� ����
			try {
				int_Year = Integer.parseInt(year);
				// year�� intŸ������ ��ȯ�Ͽ� Year�� ����
				int_Month = Integer.parseInt(month);

				if (year.length() != 4 || month.length() != 2)
				// year�� ũ�Ⱑ 4�� �����ʰų� month�� ũ�Ⱑ 2�� ���� ������
				{
					textPane.setText("�⵵ �� �� �Է��� �߸��Ǿ����ϴ�.");
					// textPane�� �ؽ�Ʈ�� ()�� �ؽ�Ʈ�� ������
					return;
				} else if ((int_Month == 0) || (12 < int_Month))
				// int_Month�� 0�� ���ų� int_Month�� 12���� ũ��
				{
					textPane.setText("�⵵ �� �� �Է��� �߸��Ǿ����ϴ�.");
					// textPane�� �ؽ�Ʈ�� ()�� �ؽ�Ʈ�� ������
					return;
				} else
					setCalendar();
			} catch (NumberFormatException ne)
			// ��ȣ �� �����޼����� �ߴ� ���� ���� ó��
			{
				textPane.setText("�Էµ� �⵵�� ���� �������°� �ƴմϴ�.");
				// textPane�� �ؽ�Ʈ�� ()�� �ؽ�Ʈ�� ������
				return;
			} // end of catch
		} // end of outer if
	}// end of actionPerformed

	public static void main(String[] args) {
		new SwingCalender();
	}
}// end of class
