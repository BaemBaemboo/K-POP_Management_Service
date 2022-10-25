package service;

import static DB.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import dao.IdolGroupDAO;
import ui.IdolGroupUI;
import vo.IdolGroupVO;
//트랜젝션 처리는 Service 단에서 수행하므로
//Connection 관리(생성, 소멸)는 Service 클래스에서 처리함
//자바에서 트랜젝션은 Connection 단위로 이루어지기 때문
public class IdolGroupService {

	/*	public boolean registIdolGroupVO(IdolGroupVO newIdolGroupVO) {
			// TODO Auto-generated method stub
			boolean registSuccess = true;
			for (int i = 0; i < IdolGroupUI.idolGroupArray.length; i++) {
				if(IdolGroupUI.idolGroupArray[i].getName().contentEquals(newIdolGroupVO.getName())) {
					registSuccess = false;
					break;
				}
			}
			if(registSuccess) {
				IdolGroupVO[] tempArray = IdolGroupUI.idolGroupArray;
				IdolGroupUI.idolGroupArray = new IdolGroupVO[tempArray.length + 1];
				
				for (int i = 0; i < tempArray.length; i++) {
					IdolGroupUI.idolGroupArray[i] = tempArray[i];
				}
				
				IdolGroupUI.idolGroupArray[IdolGroupUI.idolGroupArray.length - 1] = newIdolGroupVO;
			}
			return registSuccess;
		}
		
		public IdolGroupVO[] getIdolGroupList() {
			// TODO Auto-generated method stub
			
			return IdolGroupUI.idolGroupArray;
		}
		
		public IdolGroupVO getDetailIdolGroupVO(String name) {
			// TODO Auto-generated method stub
			IdolGroupVO idolGroupVO = null;
			for (int i = 0; i < IdolGroupUI.idolGroupArray.length; i++) {
				if(IdolGroupUI.idolGroupArray[i].getName().contentEquals(name)) {
					idolGroupVO = IdolGroupUI.idolGroupArray[i];
					break;
				}
			}
			return idolGroupVO;
		}
		
		public IdolGroupVO getOldIdolGroupVO(String name) {
			// TODO Auto-generated method stub
			IdolGroupVO idolGroupVO = null;
			for (int i = 0; i < IdolGroupUI.idolGroupArray.length; i++) {
				if(IdolGroupUI.idolGroupArray[i].getName().contentEquals(name)) {
					idolGroupVO = IdolGroupUI.idolGroupArray[i];
					break;
				}
			}
			return idolGroupVO;
		}
		
		public boolean modifyIdolGroupVO(IdolGroupVO newIdolGroupVO) {
			// TODO Auto-generated method stub
			boolean modifySuccess = false;
			//1. 현재 배열에서 인자로 넘어온 idolGropVO객체(수정할 정보를 가지고 있는 객체)
			//의 name 속성값과 동일한 name 속성값을 가지고 있는 idolGroupVO 객체를 찾는다.
			
			for (int i = 0; i < IdolGroupUI.idolGroupArray.length; i++) {
				if(IdolGroupUI.idolGroupArray[i].getName().contentEquals
						(newIdolGroupVO.getName())) {
					//2. 해당 인덱스 영역의 참조하는 객체를 인자로 넘어온 새로운 객체의
					//위치값으로 변경한다.
					IdolGroupUI.idolGroupArray[i] = newIdolGroupVO;
					modifySuccess = true;
					break;
					
				}
			}
			return modifySuccess;
		}
		
		public boolean removeIdolGroupVO(String name) {
			// TODO Auto-generated method stub
			boolean removeSuccess = false;
			//삭제할 IdolGroupVO 객체를 참조하고 있는 배열의 인덱스 검색
			
			//배열의 인덱스 값을 구하는 로직에서는 인덱스값을 저장하는 변수의 초기값은
			//-1로 지정하는 것이 관습이다.
			int index = -1;
			for (int i = 0; i < IdolGroupUI.idolGroupArray.length; i++) {
				if(IdolGroupUI.idolGroupArray[i].getName().contentEquals(name)) {
					index = i;
					break;
				}
			}
			
			if(index != -1) {
				IdolGroupVO[] tempArray = IdolGroupUI.idolGroupArray;
				IdolGroupUI.idolGroupArray = new IdolGroupVO[tempArray.length - 1];
				
				for (int i = 0; i < tempArray.length; i++) {
					if(i < index) {
						IdolGroupUI.idolGroupArray[i] = tempArray[i];
					}
					else if(i > index) {
						IdolGroupUI.idolGroupArray[i-1] = tempArray[i];
					}
				}
				removeSuccess = true;
			}
			
			
			return removeSuccess;
		}
		public IdolGroupVO searchIdolGroupVOByName(String name) {
			// TODO Auto-generated method stub
			IdolGroupVO idolGroupVO = null;
			for (int i = 0; i < IdolGroupUI.idolGroupArray.length; i++) {
				if(IdolGroupUI.idolGroupArray[i].getName().contentEquals(name)) {
					idolGroupVO = IdolGroupUI.idolGroupArray[i];
					break;
				}
			}
			return idolGroupVO;
		}
	
		public IdolGroupVO[] searchIdolGroupVOArrayByGeneration(String generation) {
			// TODO Auto-generated method stub
			//반환되는 배열의 크기가 다양하다.
			//----> 검색된 IdolGroupVO의 개수로 최종 반환할 배열의 크기를 지정해야 한다.
			IdolGroupVO[] searchArray = null;
			int count = 0;
			
			//검색조건에 맞아서 찾아진 IdolGroupVO객체들을 저장할 배열 생성
			IdolGroupVO[] tempArray = 
					new IdolGroupVO[IdolGroupUI.idolGroupArray.length];
			
			//IdolGroupUI.idolGroupArray 배열에서 조건에 맞는 IdolGroupVO 객체들을 찾아서
			//tempArray에 저장
			for (int i = 0; i < IdolGroupUI.idolGroupArray.length; i++) {
				if(IdolGroupUI.idolGroupArray[i].getGeneration() == Integer.parseInt(generation)) {
					tempArray[count++] = IdolGroupUI.idolGroupArray[i];
				}
			}
	
			searchArray = new IdolGroupVO[count];
			
			for (int i = 0; i < count; i++) {
				searchArray[i] = tempArray[i];
			}
			
			return searchArray;
		}

	public boolean registIdolGroupHashMap(HashMap<String, String> idolGroupHashMap) {
		// TODO Auto-generated method stub
		boolean registSuccess = true;
		for (int i = 0; i < IdolGroupUI.idolGroupList.size(); i++) {
			if(IdolGroupUI.idolGroupList.get(i).get("name").contentEquals(idolGroupHashMap.get("name"))) {
				registSuccess = false;
				break;
			}
		}
		if(registSuccess) {
			IdolGroupUI.idolGroupList.add(idolGroupHashMap);
			//배열은 크기가 한번 정해지면 변경할수 없다.
			//컬렉션은 크기가 자동으로 늘어난다.
		}
		return registSuccess;
	}

	public ArrayList<HashMap<String, String>> getIdolGroupList() {
		// TODO Auto-generated method stub
		
		return IdolGroupUI.idolGroupList;
	}

	public HashMap<String, String> getDetailIdolGroupHashMap(String name) {
		// TODO Auto-generated method stub
		HashMap<String, String> idolGroupHashMap = null;
		for (int i = 0; i < IdolGroupUI.idolGroupList.size(); i++) {
			//HashMap 객체에서 특정 키값을 가지고 있는 요소의 Value를 가져오는 방법
			//Value<T> get(T keyName)
			if(IdolGroupUI.idolGroupList.get(i).get("name").contentEquals(name)) {
				idolGroupHashMap = IdolGroupUI.idolGroupList.get(i);
				break;
			}
		}
		return idolGroupHashMap;
	}

	public HashMap<String, String> getOldIdolGroupHashMap(String name) {
		// TODO Auto-generated method stub
		HashMap<String, String> idolGroupHashMap = null;
		for (int i = 0; i < IdolGroupUI.idolGroupList.size(); i++) {
			//HashMap 객체에서 특정 키값을 가지고 있는 요소의 Value를 가져오는 방법
			//Value<T> get(T keyName)
			if(IdolGroupUI.idolGroupList.get(i).get("name").contentEquals(name)) {
				idolGroupHashMap = IdolGroupUI.idolGroupList.get(i);
				break;
			}
		}
		return idolGroupHashMap;
	}

	public boolean modifyIdolGroupHashMap(HashMap<String, String> newIdolGroupHashMap) {
		// TODO Auto-generated method stub
		boolean modifySuccess = false;
		//1. 현재 배열에서 인자로 넘어온 idolGropVO객체(수정할 정보를 가지고 있는 객체)
		//의 name 속성값과 동일한 name 속성값을 가지고 있는 idolGroupVO 객체를 찾는다.
		
		for (int i = 0; i < IdolGroupUI.idolGroupList.size(); i++) {
			if(IdolGroupUI.idolGroupList.get(i).get("name").contentEquals
					(newIdolGroupHashMap.get("name"))) {
				//2. 해당 인덱스 영역의 참조하는 객체를 인자로 넘어온 새로운 객체의
				//위치값으로 변경한다.
				IdolGroupUI.idolGroupList.set(i, newIdolGroupHashMap);
				//ArrayList 에서 특정 인덱스 위치의 값을 수정하는 메소드
				//set(int index, Object obj)
				
				modifySuccess = true;
				break;
				
			}
		}
		return modifySuccess;
	}

	public boolean removeIdolGroupHashMap(String name) {
		// TODO Auto-generated method stub
		boolean removeSuccess = false;
		
		for (int i = 0; i < IdolGroupUI.idolGroupList.size(); i++) {
			if(IdolGroupUI.idolGroupList.get(i).get("name").contentEquals(name)) {
				IdolGroupUI.idolGroupList.remove(i);
				removeSuccess = true;
				break;
			}
		}
		
		return removeSuccess;
	}

	public HashMap<String, String> searchIdolGroupHashMapByName(String name) {
		// TODO Auto-generated method stub
		HashMap<String, String> idolGroupHashMap = null;
		for (int i = 0; i < IdolGroupUI.idolGroupList.size(); i++) {
			//HashMap 객체에서 특정 키값을 가지고 있는 요소의 Value를 가져오는 방법
			//Value<T> get(T keyName)
			if(IdolGroupUI.idolGroupList.get(i).get("name").contentEquals(name)) {
				idolGroupHashMap = IdolGroupUI.idolGroupList.get(i);
				break;
			}
		}
		return idolGroupHashMap;
	}

	public ArrayList<HashMap<String, String>> searchIdolGroupHashMapListByGeneration(String generation) {
		// TODO Auto-generated method stub
		//반환되는 배열의 크기가 다양하다.
		//----> 검색된 IdolGroupVO의 개수로 최종 반환할 배열의 크기를 지정해야 한다.
		ArrayList<HashMap<String, String>> searchIdolGroupHashMapList = 
				new ArrayList<HashMap<String,String>>();
		
		for (int i = 0; i < IdolGroupUI.idolGroupList.size(); i++) {
			if(IdolGroupUI.idolGroupList.get(i).get("generation").contentEquals(generation)) {
				searchIdolGroupHashMapList.add(IdolGroupUI.idolGroupList.get(i));
			}
		}

		return searchIdolGroupHashMapList;
	}
*/
	
	//DAO 사용버전
	public boolean registIdolGroupVO(IdolGroupVO newIdolGroupVO) {
		// TODO Auto-generated method stub
		boolean registSuccess = false;
		Connection con = getConnection();
		
		//SQL 구문을 전송할(실행할) DAO(Data Access Object) 객체 생성 
		//DAO 클래스 : 일반적으로 테이블 하나당 하나를 생성, JOIN이 사용될 때는 하나의 CRUD 작업당 하나씩 생성
		
		IdolGroupDAO idolGroupDAO = IdolGroupDAO.getInstance();
		idolGroupDAO.setConnection(con);
		
		int insertCount = idolGroupDAO.insertIdolGroup(newIdolGroupVO);
		//삽입된 아이돌 정보 개수가 반환됨
		
		close(con);
		if(insertCount > 0) {
			registSuccess = true;
		}
		return registSuccess;
	}

	public ArrayList<IdolGroupVO> getIdolGroupList() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		IdolGroupDAO idolGroupDAO = IdolGroupDAO.getInstance();
		idolGroupDAO.setConnection(con);
		ArrayList<IdolGroupVO> idolList = idolGroupDAO.selectIdolGroupList();
		close(con);
		return idolList;
	}

	public IdolGroupVO getDetailIdolGroupVO(String name) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		IdolGroupDAO idolGroupDAO = IdolGroupDAO.getInstance();
		idolGroupDAO.setConnection(con);
		
		IdolGroupVO idolGroupVO = idolGroupDAO.selectIdolGroupVO(name);
		close(con);
		return idolGroupVO;
	}

	public IdolGroupVO getOldIdolGroupVO(String name) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		IdolGroupDAO idolGroupDAO = IdolGroupDAO.getInstance();
		idolGroupDAO.setConnection(con);
		
		IdolGroupVO idolGroupVO = idolGroupDAO.selectOldIdolGroupVO(name);
		close(con);
		return idolGroupVO;
	}

	public boolean modifyIdolGroupVO(IdolGroupVO newIdolGroupVO) {
		// TODO Auto-generated method stub
		boolean modifySuccess = false;
		Connection con = getConnection();
		IdolGroupDAO idolGroupDAO = IdolGroupDAO.getInstance();
		idolGroupDAO.setConnection(con);
		
		int updateCount = idolGroupDAO.updateIdolGroup(newIdolGroupVO);
		close(con);
				if(updateCount > 0) {
			modifySuccess = true;
			
		}
		return modifySuccess;
	}

	public boolean removeIdolGroupVO(String name) {
		// TODO Auto-generated method stub
		boolean removeSuccess = false;
		Connection con = getConnection();
		IdolGroupDAO idolGroupDAO = IdolGroupDAO.getInstance();
		idolGroupDAO.setConnection(con);
		
		int deleteCount = idolGroupDAO.deleteIdolGroup(name);
		close(con);
		
		if(deleteCount > 0) {
			removeSuccess = true;
		}
		
		return removeSuccess;
	}

	public IdolGroupVO searchIdolGroupVOByName(String name) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		IdolGroupDAO idolGroupDAO = IdolGroupDAO.getInstance();
		idolGroupDAO.setConnection(con);
		
		IdolGroupVO idolGroupVO = 
				idolGroupDAO.selectSearchOldIdolGroupVO(name);
		close(con);
		return idolGroupVO;
	}

	public ArrayList<IdolGroupVO> searchIdolGroupVOArrayByGeneration(String generation) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		IdolGroupDAO idolGroupDAO = IdolGroupDAO.getInstance();
		idolGroupDAO.setConnection(con);
		
		ArrayList<IdolGroupVO> searchIdolGroupVOList = 
				idolGroupDAO.selectSearchOldIdolGroupVOList(generation);
		close(con);
		return searchIdolGroupVOList;
	}
}







