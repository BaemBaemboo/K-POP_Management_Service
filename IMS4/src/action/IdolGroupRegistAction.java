package action;

import java.util.HashMap;
import java.util.Scanner;

import service.IdolGroupService;
import util.ConsoleUtil;
import vo.IdolGroupVO;
//넓은 의미의 Controller
//비지니스 로직은 Service 클래스에 구현
//Action 클래스는 Service 클래스에서 비지니스 로직을 처리하기 위한 전후처리 작업을 함
//예를 들면 : 등록을 할려면 등록을 정보를 받는 작업 등
//비지니스 로직이 처리가 된후 사용자에게 보여주는 화면을 만드는 작업
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




