package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ����80000�������ݵ����������
		//�ٶȲ���
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
		}
		
//		System.out.println("����ǰ");
//		System.out.println(Arrays.toString(arr));

		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ����=" + date1Str);

		selectSort(arr);
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("����ǰ��ʱ����=" + date2Str);
		
//		System.out.println("�����");
//		System.out.println(Arrays.toString(arr));
	}

	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			int minIndex = i;
			int min = arr[i];
			for (int j = i+1; j < arr.length; j++) {
				if (min > arr[j]) {     // ˵���ٶ�����Сֵ����������С
					min = arr[j];       // ����min
					minIndex = j;       // ����minIndex					
				}
			}
			// ����Сֵ������arr[i], ������
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}
	}
}
//ѡ������ʱ�临�Ӷ��� O(n^2)