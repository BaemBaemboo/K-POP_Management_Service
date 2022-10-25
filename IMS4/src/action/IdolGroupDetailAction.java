package action;

import java.util.HashMap;
import java.util.Scanner;

import service.IdolGroupService;
import util.ConsoleUtil;
import vo.IdolGroupVO;

public class IdolGroupDetailAction implements Action {

	@Override
	public void execute(Scanner scanner) throws Exception {
		// TODO Auto-generated method stub
		ConsoleUtil consoleUtil = new ConsoleUtil();
		String name = 
		consoleUtil.getName("상세정보를 볼 아이돌 그룹 이름 : ", scanner);
		
		IdolGroupService idolGroupService = new IdolGroupService();
		
		IdolGroupVO detailIdolGroupVO = 
				idolGroupService.getDetailIdolGroupVO(name);
		
//		HashMap<String, String> detailIdolGroupHashMap = 
//				idolGroupService.getDetailIdolGroupHashMap(name);
		
//		consoleUtil.printDetailIdolGroupVO(detailIdolGroupHashMap);
		
		consoleUtil.printDetailIdolGroupVO(detailIdolGroupVO);
	}

}



