package DataStructure;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		//���в���
		//�ȴ����ڵ�
		HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode hero2 = new HeroNode(2, "¬����", "������");
		HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");
		
		//����һ������
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		
//		//����
//		singleLinkedList.add(hero1);
//		singleLinkedList.add(hero2);
//		singleLinkedList.add(hero3);
//		singleLinkedList.add(hero4);
		
		
		//����
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero3);
		
		//��ʾһ��
		singleLinkedList.list();
		
		
		//ɾ��һ���ڵ�
		singleLinkedList.del(1);
		singleLinkedList.del(4);
		System.out.println("ɾ������������");
		singleLinkedList.list();
		
	}

	//����Single Linked List(������)
static class SingleLinkedList{
	//�ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ㲻Ҫ��
	private HeroNode head = new HeroNode(0, "", ""); //�������ͷ�ڵ㣬����ž��������
	

	//��ӽڵ㵽����������
	//˼·���������Ǳ��˳��ʱ
	//1. �ҵ���ǰ��������ڵ�
	//2. ���������ڵ��next ָ�� �µĽڵ�
	public void add(HeroNode heroNode) {
		
		//��Ϊhead�ڵ㲻�ܶ�, ���������Ҫһ������ָ��(��������)
		HeroNode temp = head;
		//��������, �ҵ����
		while(true) {
			if (temp.next==null) {
				break;
			}
			//���û���ҵ����,��temp����
			temp = temp.next;
		}
		//���˳�whileѭ��ʱ,temp��ָ������������
		//���������ڵ��next ָ�� �µĽڵ�
		temp.next = heroNode;

	}
	
	
	
	
	
	
	//�޸Ľڵ����Ϣ, ����no������޸ģ���no��Ų��ܸ�.
	//˵��
	//1. ���� newHeroNode �� no ���޸ļ���
	public void update(HeroNode newHeroNode) {
		//�ж��Ƿ��
		if(head.next == null) {
			System.out.println("����Ϊ��~");
			return;
		}
		//�ҵ���Ҫ�޸ĵĽڵ�, ����no���
		//����һ����������
		HeroNode temp = head.next;
		boolean flag = false; //��ʾ�Ƿ��ҵ��ýڵ�
		while(true) {
			if (temp == null) {
				break; //�Ѿ�����������
			}
			if(temp.no == newHeroNode.no) {
				//�ҵ�
				flag = true;
				break;
			}
			temp = temp.next;
		}
		//����flag �ж��Ƿ��ҵ�Ҫ�޸ĵĽڵ�
		if(flag) {
			temp.name = newHeroNode.name;
			temp.nickName = newHeroNode.nickName;
		} else { //û���ҵ�
			System.out.printf("û���ҵ� ��� %d �Ľڵ㣬�����޸�\n", newHeroNode.no);
		}
	}
		
	
	
	
	//ɾ���ڵ�
	//˼·
	//1. head ���ܶ������������Ҫһ��temp�����ڵ��ҵ���ɾ���ڵ��ǰһ���ڵ�
	//2. ˵�������ڱȽ�ʱ����temp.next.no ��  ��Ҫɾ���Ľڵ��no�Ƚ�
	public void del(int no) {
		HeroNode temp = head;
		boolean flag = false; // ��־�Ƿ��ҵ���ɾ���ڵ��
		while(true) {
			if(temp.next == null) { //�Ѿ�����������
				break;
			}
			if(temp.next.no == no) {
				//�ҵ��Ĵ�ɾ���ڵ��ǰһ���ڵ�temp
				flag = true;
				break;
			}
			temp = temp.next; //temp���ƣ�����
		}
		//�ж�flag
		if(flag) { //�ҵ�
			//����ɾ��
			temp.next = temp.next.next;
		}else {
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
			HeroNode temp = head.next;
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
		
		
		
		
		
		//�ڶ��ַ�ʽ�����Ӣ��ʱ������������Ӣ�۲��뵽ָ��λ��
		//(�������������������ʧ�ܣ���������ʾ)
		public void addByOrder(HeroNode heroNode) {
			//��Ϊͷ�ڵ㲻�ܶ������������Ȼͨ��һ������ָ��(����)�������ҵ���ӵ�λ��
			//��Ϊ��������Ϊ�����ҵ�temp ��λ�� ���λ�õ�ǰһ���ڵ㣬������벻��
			HeroNode temp = head;
			boolean flag = false; // flag��־��ӵı���Ƿ���ڣ�Ĭ��Ϊfalse
			while(true) {
				if(temp.next == null) {//˵��temp�Ѿ�����������
					break; //
				} 
				if(temp.next.no > heroNode.no) { //λ���ҵ�������temp�ĺ������
					break;
				} else if (temp.next.no == heroNode.no) {//˵��ϣ����ӵ�heroNode�ı����Ȼ����
					
					flag = true; //˵����Ŵ���
					break;
				}
				temp = temp.next; //���ƣ�������ǰ����
			}
			//�ж�flag ��ֵ
			if(flag) { //������ӣ�˵����Ŵ���
				System.out.printf("׼�������Ӣ�۵ı�� %d �Ѿ�������, ���ܼ���\n", heroNode.no);
			} else {
				//���뵽������, temp�ĺ���
				heroNode.next = temp.next;
				temp.next = heroNode;
			}
		}

	}
}


	
	
	
	
	
//����HeroNode, ÿ��HeroNode����һ���ڵ�
class HeroNode{
	public int no;
	public String name;
	public String nickName;
	public HeroNode next;//ָ����һ���ڵ�
	//������
	public HeroNode(int no, String name, String nickName) {
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

