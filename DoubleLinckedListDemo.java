package DataStructure;

public class DoubleLinckedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����
		System.out.println("˫������Ĳ���");
		//�ȴ����ڵ�
		HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
		HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
		HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
		HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");
		//����һ��˫������
		DoubleLinckedList doubleLickedList = new DoubleLinckedList();
		doubleLickedList.add(hero1);
		doubleLickedList.add(hero2);
		doubleLickedList.add(hero3);
		doubleLickedList.add(hero4);
		
		doubleLickedList.list();
		
		
		//�޸�
		HeroNode2 newHeroNode = new HeroNode2(4, "����ʤ", "������");
		doubleLickedList.update(newHeroNode);
		System.out.println("�޸Ĺ����˫�����������");
		doubleLickedList.list();
		
		//ɾ���ڵ�
		doubleLickedList.del(3);
		System.out.println("ɾ���ڵ��Ժ�����");
		doubleLickedList.list();

	}

}


//����һ��˫���������
class DoubleLinckedList {
	//�ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ㲻Ҫ��
	private HeroNode2 head = new HeroNode2(0, "", ""); //�������ͷ�ڵ㣬����ž��������
	
	
	
	//���һ���ڵ㵽˫����������
	public void add(HeroNode2 heroNode) {

		// ��Ϊhead�ڵ㲻�ܶ�, ���������Ҫһ������ָ��(��������)
		HeroNode2 temp = head;
		// ��������, �ҵ����
		while (true) {
			if (temp.next == null) {
				break;
			}
			// ���û���ҵ����,��temp����
			temp = temp.next;
		}
		// ���˳�whileѭ��ʱ,temp��ָ������������
		// ���������ڵ��next ָ�� �µĽڵ�
		// ����˫������
		temp.next = heroNode;
		heroNode.pre = temp;
	}
	
	
	
	//�޸�һ���ڵ�����ݣ����Կ���˫��������޸ĺ͵���������޸�һ����ֻ�����͸�Ϊ��HeroNode2
	//�޸Ľڵ����Ϣ, ����no������޸ģ���no��Ų��ܸ�.
	// ˵��
	// 1. ���� newHeroNode �� no ���޸ļ���
	public void update(HeroNode2 newHeroNode) {
		// �ж��Ƿ��
		if (head.next == null) {
			System.out.println("����Ϊ��~");
			return;
		}
		// �ҵ���Ҫ�޸ĵĽڵ�, ����no���
		// ����һ����������
		HeroNode2 temp = head.next;
		boolean flag = false; // ��ʾ�Ƿ��ҵ��ýڵ�
		while (true) {
			if (temp == null) {
				break; // �Ѿ�����������
			}
			if (temp.no == newHeroNode.no) {
				// �ҵ�
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// ����flag �ж��Ƿ��ҵ�Ҫ�޸ĵĽڵ�
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickName = newHeroNode.nickName;
		} else { // û���ҵ�
			System.out.printf("û���ҵ� ��� %d �Ľڵ㣬�����޸�\n", newHeroNode.no);
		}
	}
	
	
	
	// ɾ���ڵ�(��˫��������ɾ��һ���ڵ�)
	//˵��
	//1 ����˫������, ���ǿ���ֱ���ҵ�Ҫɾ��������ڵ�
	//2 �ҵ��Ժ�, ����ɾ������
	public void del(int no) {
		
		//�жϵ�ǰ�Ƿ�Ϊ������, �������޷�ɾ��
		if (head.next == null) {
			System.out.println("��ǰ����Ϊ��, �޷�ɾ��");
			return;
		}
		HeroNode2 temp = head.next;  //��������(����ָ��)
		boolean flag = false; // ��־�Ƿ��ҵ���ɾ���ڵ��
		while (true) {
			if (temp == null) { // �Ѿ�����������
				break;
			}
			if (temp.no == no) {
				// �ҵ��Ĵ�ɾ���ڵ��ǰһ���ڵ�temp
				flag = true;
				break;
			}
			temp = temp.next; // temp���ƣ�����
		}
		// �ж�flag
		if (flag) { // �ҵ�
			// ����ɾ��
			//temp.next = temp.next.next;   [���������ɾ����ʽ, ��˫�������ﲻ������]
			temp.pre.next = temp.next;
			//�������ǵĴ���������!
			//��һ�����Ҫɾ���Ľڵ������һ���ڵ��أ�
			//������������һ���ڵ�Ͳ���Ҫִ��������仰, �������ֿ�ָ���쳣
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
			
		} else {
			System.out.printf("Ҫɾ���� %d �ڵ㲻����\n", no);
		}
	}
	
	
	//��ʾ����[����]
			public void list() {
				//�ж������Ƿ�Ϊ��
				if(head.next == null) {
				System.out.println("����Ϊ��");
				return;
			}
				//��Ϊͷ�ڵ㣬���ܶ������������Ҫһ����������������
				HeroNode2 temp = head.next;
				while(true) {
				//�ж��Ƿ��������
					if(temp == null) {
					  break;
				}
				//����ڵ����Ϣ
					System.out.println(temp);
				//��temp���ƣ� һ��С��
					temp = temp.next;
			  }
		   }
	
	
	
	
}

//����HeroNode, ÿ��HeroNode����һ���ڵ�
class HeroNode2{
	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next;//ָ����һ���ڵ�, Ĭ��Ϊnull
	public HeroNode2 pre; //ָ��ǰһ���ڵ�, Ĭ��Ϊnull
	//������
	public HeroNode2(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
		
	}
	//Ϊ����ʾ���㣬������дtoString����
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickName + "]";
	}

}
