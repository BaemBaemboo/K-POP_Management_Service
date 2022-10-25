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
	//이 객체는 모든 패키지에서 접근이 가능해야 한다.
	//모든 클래스에서 공유하기 위해서 static을 지정함
	
	//1. 아이돌 그룹정보들을 저장할 단위를 ArrayList 타입으로 변경
	//2. 아이돌 그룹 하나의 정보를 하나의 HashMap 객체에 저장
	
//	public static ArrayList<HashMap<String, String>> idolGroupList = 
//			new ArrayList<HashMap<String, String>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter(System.getProperty("line.separator"));
		//System.getProperty : 시스템 속성값을 반환
		
		IdolGroupController idolGroupController
		= new IdolGroupController();
		//전체 사용자의 요청을 받아서 제어하는 클래스
		
		boolean stop = false;
		
		//다형성을 사용해서 요청처리를 함
		Action action = null;
		
		
		do {
			System.out.println("=====아이돌그룹관리======");
			System.out.println("1. 아이돌그룹등록"); //C(Create)
			System.out.println("2. 아이돌그룹목록보기");//R(Read)
			System.out.println("3. 아이돌그룹정보 상세보기");//R(Read)
			System.out.println("4. 아이돌그룹정보 수정");
			System.out.println("5. 아이돌그룹정보 삭제");
			System.out.println("6. 아이돌그룹정보 검색");
			System.out.println("7. 프로그램종료");
			
			System.out.print("메뉴번호 : ");
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






