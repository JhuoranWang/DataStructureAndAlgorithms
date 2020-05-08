package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {1,6,3,7,4,0};
		// ����Ҫһ����80000�����ݵ����������
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 80000); // ����һ��[0, 8000000) ��
		}
		
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ���� = " + date1Str);
//		
//		shellSort(arr);
		shellSort2(arr);
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("������ʱ���� = " + date2Str);
		
		//System.out.println(Arrays.toString(arr));
		
//		int[] arr2 = {1,6,3,7,4,0};
		
		
	}
	
	public static void shellSort(int[] arr) {
		int temp = 0;
		int count = 0;
		
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				// �������������е�Ԫ��(��gap�飬ÿ���и�Ԫ��), ����gap
				for (int j = i - gap; j >= 0; j -= gap) {
					// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
//			System.out.println("ϣ�������" + (++count) + "�� =" + Arrays.toString(arr));
		}
		
	}
	
	
	// �Խ���ʽ��ϣ����������Ż�->��λ��
	public static void shellSort2(int[] arr) {
		int count = 0;
		// ����gap, ���𲽵���С����
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// �ӵ�gap��Ԫ�أ�����������ڵ������ֱ�Ӳ�������
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				if (arr[j] < arr[j - gap]) {
					while (j - gap >= 0 && temp < arr[j - gap]) {
						// �ƶ�
						arr[j] = arr[j - gap];
						j -= gap;
					}
					// ���˳�while�󣬾͸�temp�ҵ������λ��
					arr[j] = temp;
				}

			}
//			System.out.println("ϣ�������" + (++count) + "�� =" + Arrays.toString(arr));
		}
	}

}
