package action;

import java.util.HashMap;
import java.util.Scanner;

import service.IdolGroupService;
import util.ConsoleUtil;
import vo.IdolGroupVO;
//���� �ǹ��� Controller
//�����Ͻ� ������ Service Ŭ������ ����
//Action Ŭ������ Service Ŭ�������� �����Ͻ� ������ ó���ϱ� ���� ����ó�� �۾��� ��
//���� ��� : ����� �ҷ��� ����� ������ �޴� �۾� ��
//�����Ͻ� ������ ó���� ���� ����ڿ��� �����ִ� ȭ���� ����� �۾�
public class IdolGroupRegistAction implements Action {

	@Override
	public void execute(Scanner scanner) throws Exception {
		// TODO Auto-generated method stub
		ConsoleUtil consoleUtil = new ConsoleUtil();
		IdolGroupVO newIdolGroupVO = 
				consoleUtil.getNewIdolGroupVO(scanner);
		
//		HashMap<String, String> idolGroupHashMap = 
//				consoleUtil.getNewIdolGroupHashMap(scanner);
		
		IdolGroupService idolGroupService
		= new IdolGroupService();
		
		boolean registSuccess = 
				idolGroupService.registIdolGroupVO(newIdolGroupVO);
		
		
//		boolean registSuccess = 
//				idolGroupService.registIdolGroupHashMap(idolGroupHashMap);
		
		if(registSuccess) {
			consoleUtil.printRegistSuccessMessage(newIdolGroupVO.getName());
		}
		else {
			consoleUtil.printRegistFailMessage(newIdolGroupVO.getName());
		}
		
//		if(registSuccess) {
//			consoleUtil.printRegistSuccessMessage(idolGroupHashMap.get("name"));
//		}
//		else {
//			consoleUtil.printRegistFailMessage(idolGroupHashMap.get("name"));
//		}
	}

}




