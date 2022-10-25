package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import service.IdolGroupService;
import service.SearchService;
import util.ConsoleUtil;
import vo.IdolGroupVO;
import vo.SearchVO;

public class IdolGroupSearchAction implements Action {

	@Override
	public void execute(Scanner scanner) throws Exception {
		// TODO Auto-generated method stub
		ConsoleUtil consoleUtil = new ConsoleUtil();
		SearchVO searchVO = consoleUtil.getSearchVO(scanner);

		IdolGroupService idolGroupService
		= new IdolGroupService();

		/*if(searchVO.getSearchCondition().contentEquals("이름")) {
			IdolGroupVO idolGroupVO = 
					idolGroupService.searchIdolGroupVOByName(searchVO.getSearchValue());
			consoleUtil.printSearchIdolGroupVO(idolGroupVO);
		}
		else {
			IdolGroupVO[] idolGroupVOList = 
					idolGroupService.searchIdolGroupVOArrayByGeneration(searchVO.getSearchValue());
			consoleUtil.printSearchIdolGroupVOArray(idolGroupVOList);
		}*/

		//		if(searchVO.getSearchCondition().contentEquals("이름")) {
		//			HashMap<String, String> idolGroupHashMap = 
		//					idolGroupService.searchIdolGroupHashMapByName(searchVO.getSearchValue());
		//			consoleUtil.printSearchIdolGroupHashMap(idolGroupHashMap);
		//		}
		//		else {
		////			IdolGroupVO[] idolGroupVOList = 
		////					idolGroupService.searchIdolGroupVOArrayByGeneration(searchVO.getSearchValue());
		//			
		//			ArrayList<HashMap<String, String>> idolGroupHashMapList = 
		//					idolGroupService.searchIdolGroupHashMapListByGeneration(searchVO.getSearchValue());
		//			consoleUtil.printSearchIdolGroupHashMapList(idolGroupHashMapList);
		//		}
		if(searchVO.getSearchCondition().contentEquals("이름")) {
			IdolGroupVO idolGroupVO = 
					idolGroupService.searchIdolGroupVOByName(searchVO.getSearchValue());
			consoleUtil.printSearchIdolGroupVO(idolGroupVO);
		}
		else {
			ArrayList<IdolGroupVO> idolGroupVOList = 
					idolGroupService.searchIdolGroupVOArrayByGeneration(searchVO.getSearchValue());
			consoleUtil.printSearchIdolGroupVOArray(idolGroupVOList);
		}
	}
}



