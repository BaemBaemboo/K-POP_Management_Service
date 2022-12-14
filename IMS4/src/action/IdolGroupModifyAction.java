package action;

import java.util.HashMap;
import java.util.Scanner;

import service.IdolGroupService;
import util.ConsoleUtil;
import vo.IdolGroupVO;

public class IdolGroupModifyAction implements Action {

	@Override
	public void execute(Scanner scanner) throws Exception {
		// TODO Auto-generated method stub
		ConsoleUtil consoleUtil = new ConsoleUtil();
		String name = 
				consoleUtil.getName("수정할 아이돌 그룹 이름 : ", scanner);
		IdolGroupService idolGroupService = new 
				IdolGroupService();
		
		
		IdolGroupVO oldIdolGroupVO = 
				idolGroupService.getOldIdolGroupVO(name);
//		HashMap<String, String> oldIdolGroupHashMap = 
//				idolGroupService.getOldIdolGroupHashMap(name);
		
		
		IdolGroupVO newIdolGroupVO = 
				consoleUtil.getNewIdolGroupVO(oldIdolGroupVO, scanner);
		
//		HashMap<String, String> newIdolGroupHashMap = 
//				consoleUtil.getNewIdolGroupVO(oldIdolGroupHashMap, scanner);
		
		
		boolean modifySuccess = 
				idolGroupService.modifyIdolGroupVO(newIdolGroupVO);
		
//		boolean modifySuccess = 
//				idolGroupService.modifyIdolGroupHashMap(newIdolGroupHashMap);
		
		if(modifySuccess) {
			consoleUtil.printModifySuccessMessage(name);
		}
		else {
			consoleUtil.printModifyFailMessage(name);
		}
	}

}




