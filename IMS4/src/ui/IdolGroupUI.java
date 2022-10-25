package ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import action.Action;
import action.IdolGroupDetailAction;
import action.IdolGroupListAction;
import action.IdolGroupModifyAction;
import action.IdolGroupRegistAction;
import action.IdolGroupRemoveAction;
import action.IdolGroupSearchAction;
import controller.IdolGroupController;
import util.ConsoleUtil;
import vo.IdolGroupVO;
import vo.SearchVO;

public class IdolGroupUI {
//	public static IdolGroupVO[] idolGroupArray = 
//			new IdolGroupVO[0];
	//�� ��ü�� ��� ��Ű������ ������ �����ؾ� �Ѵ�.
	//��� Ŭ�������� �����ϱ� ���ؼ� static�� ������
	
	//1. ���̵� �׷��������� ������ ������ ArrayList Ÿ������ ����
	//2. ���̵� �׷� �ϳ��� ������ �ϳ��� HashMap ��ü�� ����
	
//	public static ArrayList<HashMap<String, String>> idolGroupList = 
//			new ArrayList<HashMap<String, String>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter(System.getProperty("line.separator"));
		//System.getProperty : �ý��� �Ӽ����� ��ȯ
		
		IdolGroupController idolGroupController
		= new IdolGroupController();
		//��ü ������� ��û�� �޾Ƽ� �����ϴ� Ŭ����
		
		boolean stop = false;
		
		//�������� ����ؼ� ��ûó���� ��
		Action action = null;
		
		
		do {
			System.out.println("=====���̵��׷����======");
			System.out.println("1. ���̵��׷���"); //C(Create)
			System.out.println("2. ���̵��׷��Ϻ���");//R(Read)
			System.out.println("3. ���̵��׷����� �󼼺���");//R(Read)
			System.out.println("4. ���̵��׷����� ����");
			System.out.println("5. ���̵��׷����� ����");
			System.out.println("6. ���̵��׷����� �˻�");
			System.out.println("7. ���α׷�����");
			
			System.out.print("�޴���ȣ : ");
			int menuNumber = scanner.nextInt();
			
			switch (menuNumber) {
			case 1: 
				action = new IdolGroupRegistAction();
				break;
			case 2:
				action = new IdolGroupListAction();
				break;
			case 3:
				action = new IdolGroupDetailAction();
				break;
			case 4:
				action = new IdolGroupModifyAction();
				break;
			case 5:
				action = new IdolGroupRemoveAction();
				break;
			case 6:
				action = new IdolGroupSearchAction();
				
				break;
			case 7:
				stop = true;
				action = null;
			default:
			}
			
			if(action != null) {
				try {
					idolGroupController.processRequest(action, scanner);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} while (!stop);
	}

}






