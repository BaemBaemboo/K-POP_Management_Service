package action;

import java.util.Scanner;

import service.IdolGroupService;
import util.ConsoleUtil;

public class IdolGroupRemoveAction implements Action {

	@Override
	public void execute(Scanner scanner) throws Exception {
		// TODO Auto-generated method stub
		ConsoleUtil consoleUtil = new ConsoleUtil();
		String name = 
				consoleUtil.getName("������ ���̵� �׷� �̸� : ", scanner);
		
		IdolGroupService idolGroupService =
				new IdolGroupService();
		
		
		
		boolean removeSuccess = idolGroupService.removeIdolGroupVO(name);

		//		boolean removeSuccess = idolGroupService.removeIdolGroupHashMap(name);
		
		if(removeSuccess) {
			consoleUtil.printRemoveSuccessMessage(name);
		}
		else {
			consoleUtil.printRemoveFailMessage(name);
		}
	}

}




