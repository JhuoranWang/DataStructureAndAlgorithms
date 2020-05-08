package DataStructure;
import java.util.Scanner;
public class ArrayStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����һ��ArrayStack �Ƿ���ȷ
		// �ȴ���һ��ArrayStack����->��ʾջ
		ArrayStack stack = new ArrayStack(4);
		String key = "";
		boolean loop = true; // �����Ƿ��˳��˵�
		Scanner scanner = new Scanner(System.in);

		while (loop) {
			System.out.println("show: ��ʾ��ʾջ");
			System.out.println("exit: �˳�����");
			System.out.println("push: ��ʾ������ݵ�ջ(��ջ)");
			System.out.println("pop: ��ʾ��ջȡ������(��ջ)");
			System.out.println("���������ѡ��");
			key = scanner.next();
			switch (key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("������һ����");
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("��ջ�������� %d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}

		System.out.println("�����˳�~~~");
	}
}

//����һ��ArrayStack ��ʾջ
class ArrayStack {
	private int maxSize; // ջ�Ĵ�С
	private int[] stack; // ����ģ��ջ, ���ݾͷ���������
	private int top = -1; // ջ����ʼ��Ϊ-1, ��ʾû������
	
	//������
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	
	//ջ��
	public boolean isFull() {
		return top == maxSize-1;
	}
	
	//ջ��
	public boolean isEmpty() {
		return top == -1;
	}
	
	//��ջ-push
	public void push(int value) {
		//���ж��Ƿ�ջ��
		if(isFull()) {
			System.out.println("ջ��");
			return; // ջ��
		}
		top++;
		stack[top] = value;
	}
	
	//��ջ-pop ��ջ�������ݷ���
	public int pop() {
		//���ж��Ƿ�ջ��
		if(isEmpty()) {
			throw new RuntimeException("ջ��, û�п��Է��ص�����");
		}
		int value = stack[top];
		top--;
		return value;
	}
	
	//��ʾջ�����, ����ջ, ��Ҫ��ջ����ʼ��ʾ����
	public void list() {
		if(isEmpty()) {
			System.out.println("ջ��, û������, �޷�����");
			return;
		}
		//��Ҫ��ջ����ʼ��ʾ����
		for (int i = top; i >= 0 ; i--) {
			System.out.printf("stack[%d] = %d\n", i, stack[i]);
		}		
	}	
}





