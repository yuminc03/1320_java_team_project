public class BookTest_1 {

	private int a1, gu;// a1 = ������ �ݾ�,����ݾ�, gu = ���԰� ������ ����
	private String memo;// memo :����, ���� ����

	public int getA1() {// A1������ �����ؾ� �հ踦 ���ϱ� ������ ������.
		return a1;
	}// return �������μ� �����Ѵ�

	public int getGu() {// ���԰� ������ �����ϱ� ���ؼ� gu�� return ����.
		return gu;
	}// return �������μ� �����Ѵ�

	public BookTest_1(int a1, String memo, int gu) {// ������ �޼���
		this.a1 = a1;// a1�� ����
		this.gu = gu;// gu�� ����
		this.memo = memo;// memo�� ����
	}// ���� ��������

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return gu == 1 ? "���Աݾ�" + "\t" + a1 + "\t" + memo + "\r\n" : "����ݾ�" + "\t" + a1 + "\t" + memo + "\r\n";
		// gu�� ���� 1�̸� ���Աݾ��� ���, �ƴϸ� ����ݾ��� �����.
	}
}
