package DataStructure;

import java.util.Scanner;

//��ԭ���Ĵ�������Ż����Ķ���Ϊ���ζ��У�˼·���£�
/*
 * 1��front�����ĺ�����һ��������frontָ����еĵ�һ��Ԫ�أ�Ҳ����˵arr[front]���Ƕ��еĵ�һ��Ԫ��
 * front�ĳ�ʼֵ=0
 * 2��rear�����ĺ�����һ��������rearָ����е����һ��Ԫ�صĺ�һ��λ��. ��Ϊϣ������һ���ռ���ΪԼ��
 * rear�ĳ�ʼֵ=0
 * 3����������ʱ��������(rear+1)%maxSize==front
 * 4������Ϊ�յ������ǣ�rear==front
 * 5����������������, ��������Ч�����ݵĸ���Ϊ��(rear + maxSize - front)%maxSize   //�ٸ����ӻ�����
 */
public class CircleArrayQueueDemo {
	public static void main(String[] args) {
		//����һ��
		//��������
		CircleArray queue = new CircleArray(4);
		char key = ' '; // �����û�����
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s(show): ��ʾ����");
			System.out.println("e(exit): �˳�����");
			System.out.println("a(add): ������ݵ�����");
			System.out.println("g(get): �Ӷ���ȡ������");
			System.out.println("h(head): �鿴����ͷ������");
			key = sc.next().charAt(0);
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("������һ������ ");
				int value = sc.nextInt();
				queue.addQueue(value);
				break;
			case 'g': // ȡ������
				try {
					int res = queue.getQueue();
					System.out.printf("ȡ���������ǣ�%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h': // �鿴����ͷ������
				try {
					int res = queue.headQueue();
					System.out.printf("����ͷ�������ǣ�%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e': // �˳�
				sc.close();
				loop = false;
				break;
			default:
				break;
			}
		}

		System.out.println("�����˳�");

	}

static class CircleArray {
		private int maxSize; // ��ʾ������������
		private int front; // ָ�����ͷ��
		private int rear; // ָ�����β��
		private int[] arr; // ���������ڴ�����ݣ�ģ�����

		public CircleArray(int arrayMaxSize) {
			maxSize = arrayMaxSize;
			arr = new int[maxSize];
			front = 0;
			rear = 0;
		}

		// �ж϶����Ƿ���
		public boolean is_full() {
			return (rear + 1) % maxSize == front;
		}

		// �ж϶���Ϊ��
		public boolean is_empty() {
			return rear == front;
		}

		// ������ݵ�����
		public void addQueue(int n) {
			// �ж϶����Ƿ�����
			if (is_full()) {
				System.out.println("�������������ܼ�������");
				return;
			}
			// ֱ�ӽ����ݼ���
			arr[rear] = n;
			// ��rear���ƣ�������뿼��ȡģ
			rear = (rear + 1) % maxSize;
		}

		// ��ȡ�������ݣ�������
		public int getQueue() {
			// �ж϶����Ƿ��
			if (is_empty()) {
				// ͨ���׳��쳣������
				throw new RuntimeException("����Ϊ�գ�����ȡ����");
			}
			// ������Ҫ������frontָ����еĵ�һ��Ԫ��
			// 1.�Ȱ�front��Ӧ��ֵ������һ����ʱ����
			// 2.��front���ƣ�����ȡģ
			// 3.����ʱ����ı���ֵ����
			int value = arr[front];
			front = (front + 1) % maxSize;
			return value;
		}

		// ��ʾ���е���������
		public void showQueue() {
			// ����
			if (is_empty()) {
				System.out.println("����Ϊ�գ��޷�����");
				return;
			}
			// ˼·����front��ʼ�������������ٸ�Ԫ��
			for (int i = front; i < front + size(); i++) {
				System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
			}
		}

		// �����ǰ��������Чֵ�ĸ���
		public int size() {
			return (rear + maxSize - front) % maxSize;
		}

		// ��ʾ���е�ͷ�����ݣ�ע�ⲻ��ȡ����
		public int headQueue() {
			if (is_empty())
				throw new RuntimeException("����Ϊ�գ�û������");
			return arr[front];
		}

	}
}
