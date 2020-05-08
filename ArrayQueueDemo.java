package DataStructure;
import java.util.Scanner;
import javax.management.RuntimeErrorException;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		//����һ��
		//��������
		ArrayQueue queue = new ArrayQueue(3);
		char key = ' '; //�����û�����
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
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
			case 'g': //ȡ������
				try {
					int res = queue.getQueue();
					System.out.printf("ȡ���������ǣ�%d\n", res);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h': //�鿴����ͷ������
				try {
					int res = queue.headQueue();
					System.out.printf("����ͷ�������ǣ�%d\n", res);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e': //�˳�
				sc.close();
				loop = false;
				break;
			default:
				break;
			}			
		}
		
		System.out.println("�����˳�");
		
		
	
	}

}
//ʹ������ģ����С�����дһ��ArrayQueue��
class ArrayQueue{
	private int maxSize; //��ʾ������������
	private int front; //ָ�����ͷ��
	private int rear; //ָ�����β��
	private int[] arr; //���������ڴ�����ݣ�ģ�����
	
	//�������еĹ�����
	public ArrayQueue(int arrayMaxSize) {
		maxSize = arrayMaxSize;
		arr = new int[maxSize];
		front = -1; //ָ�����ͷ����������frontָ�����ͷ��ǰһ��λ��
		rear = -1;  //ָ�����β���������
	}
	
	//�ж϶����Ƿ���
	public boolean is_full() {
		return rear == maxSize - 1;
	}
	
	//�ж϶���Ϊ��
	public boolean is_empty() {
		return rear == front;
	}
	
	//������ݵ�����
	public void addQueue(int n) {
		//�ж϶����Ƿ�����
		if (is_full()) {
			System.out.println("�������������ܼ�������");
			return;
		}
		rear++; //��rear����
		arr[rear] = n;
	}
	
	//��ȡ�������ݣ�������
	public int getQueue() {
		//�ж϶����Ƿ��
		if(is_empty()) {
			//ͨ���׳��쳣������
			throw new RuntimeException("����Ϊ�գ�����ȡ����");
		}
		front++; //front����
		return arr[front];
	}
	
	//��ʾ���е���������
	public  void showQueue() {
		//����
		if(is_empty()) {
			System.out.println("����Ϊ�գ��޷�����");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] = %d\n", i, arr[i]);
		}
	}
	
	//��ʾ���е�ͷ�����ݣ�ע�ⲻ��ȡ����
	public int headQueue() {
		if(is_empty())
		throw new RuntimeException("����Ϊ�գ�û������");
		return front + 1;
	}
}



