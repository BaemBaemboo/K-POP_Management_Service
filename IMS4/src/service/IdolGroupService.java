package service;

import static DB.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import dao.IdolGroupDAO;
import ui.IdolGroupUI;
import vo.IdolGroupVO;
//Ʈ������ ó���� Service �ܿ��� �����ϹǷ�
//Connection ����(����, �Ҹ�)�� Service Ŭ�������� ó����
//�ڹٿ��� Ʈ�������� Connection ������ �̷������ ����
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
			//1. ���� �迭���� ���ڷ� �Ѿ�� idolGropVO��ü(������ ������ ������ �ִ� ��ü)
			//�� name �Ӽ����� ������ name �Ӽ����� ������ �ִ� idolGroupVO ��ü�� ã�´�.
			
			for (int i = 0; i < IdolGroupUI.idolGroupArray.length; i++) {
				if(IdolGroupUI.idolGroupArray[i].getName().contentEquals
						(newIdolGroupVO.getName())) {
					//2. �ش� �ε��� ������ �����ϴ� ��ü�� ���ڷ� �Ѿ�� ���ο� ��ü��
					//��ġ������ �����Ѵ�.
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
			//������ IdolGroupVO ��ü�� �����ϰ� �ִ� �迭�� �ε��� �˻�
			
			//�迭�� �ε��� ���� ���ϴ� ���������� �ε������� �����ϴ� ������ �ʱⰪ��
			//-1�� �����ϴ� ���� �����̴�.
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
			//��ȯ�Ǵ� �迭�� ũ�Ⱑ �پ��ϴ�.
			//----> �˻��� IdolGroupVO�� ������ ���� ��ȯ�� �迭�� ũ�⸦ �����ؾ� �Ѵ�.
			IdolGroupVO[] searchArray = null;
			int count = 0;
			
			//�˻����ǿ� �¾Ƽ� ã���� IdolGroupVO��ü���� ������ �迭 ����
			IdolGroupVO[] tempArray = 
					new IdolGroupVO[IdolGroupUI.idolGroupArray.length];
			
			//IdolGroupUI.idolGroupArray �迭���� ���ǿ� �´� IdolGroupVO ��ü���� ã�Ƽ�
			//tempArray�� ����
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
			//�迭�� ũ�Ⱑ �ѹ� �������� �����Ҽ� ����.
			//�÷����� ũ�Ⱑ �ڵ����� �þ��.
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
			//HashMap ��ü���� Ư�� Ű���� ������ �ִ� ����� Value�� �������� ���
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
			//HashMap ��ü���� Ư�� Ű���� ������ �ִ� ����� Value�� �������� ���
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
		//1. ���� �迭���� ���ڷ� �Ѿ�� idolGropVO��ü(������ ������ ������ �ִ� ��ü)
		//�� name �Ӽ����� ������ name �Ӽ����� ������ �ִ� idolGroupVO ��ü�� ã�´�.
		
		for (int i = 0; i < IdolGroupUI.idolGroupList.size(); i++) {
			if(IdolGroupUI.idolGroupList.get(i).get("name").contentEquals
					(newIdolGroupHashMap.get("name"))) {
				//2. �ش� �ε��� ������ �����ϴ� ��ü�� ���ڷ� �Ѿ�� ���ο� ��ü��
				//��ġ������ �����Ѵ�.
				IdolGroupUI.idolGroupList.set(i, newIdolGroupHashMap);
				//ArrayList ���� Ư�� �ε��� ��ġ�� ���� �����ϴ� �޼ҵ�
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
			//HashMap ��ü���� Ư�� Ű���� ������ �ִ� ����� Value�� �������� ���
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
		//��ȯ�Ǵ� �迭�� ũ�Ⱑ �پ��ϴ�.
		//----> �˻��� IdolGroupVO�� ������ ���� ��ȯ�� �迭�� ũ�⸦ �����ؾ� �Ѵ�.
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
	
	//DAO ������
	public boolean registIdolGroupVO(IdolGroupVO newIdolGroupVO) {
		// TODO Auto-generated method stub
		boolean registSuccess = false;
		Connection con = getConnection();
		
		//SQL ������ ������(������) DAO(Data Access Object) ��ü ���� 
		//DAO Ŭ���� : �Ϲ������� ���̺� �ϳ��� �ϳ��� ����, JOIN�� ���� ���� �ϳ��� CRUD �۾��� �ϳ��� ����
		
		IdolGroupDAO idolGroupDAO = IdolGroupDAO.getInstance();
		idolGroupDAO.setConnection(con);
		
		int insertCount = idolGroupDAO.insertIdolGroup(newIdolGroupVO);
		//���Ե� ���̵� ���� ������ ��ȯ��
		
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







