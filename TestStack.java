package DataStructure;

import java.util.Stack;

//��ʾջStack�Ļ���ʹ��
public class TestStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack();
		//��ջ
		stack.add("jack");
		stack.add("tom");
		stack.add("smith");
		
		//ȡ��
		while (stack.size()>0) {
			System.out.println(stack.pop());  //��ջ��������ȡ��
			
		}
		//recap��ջ��ѭ��������ԭ��(FILO, First in last out!)
		
	}

}
