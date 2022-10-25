package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import vo.IdolGroupVO;
import vo.SearchVO;

public class ConsoleUtil {

	public IdolGroupVO getNewIdolGroupVO(Scanner scanner) {
		// TODO Auto-generated method stub
		IdolGroupVO newIdolGroupVO = new IdolGroupVO();
		System.out.println("====�� ���̵��׷�����====");
		System.out.print("�̸� : ");
		String name = scanner.next();
		System.out.print("���� : ");
		String gender = scanner.next();
		System.out.print("���̴� : ");
		int generation = scanner.nextInt();
		System.out.print("��߳⵵ : ");
		int year = scanner.nextInt();
		System.out.print("���� : ");
		String nation = scanner.next();
		System.out.print("�Ҽӻ� : ");
		String company = scanner.next();
		System.out.print("�ٹ��̸� : ");
		String albumName = scanner.next();
		System.out.print("��ǥ�� : ");
		String songName = scanner.next();

		newIdolGroupVO.setAlbumName(albumName);
		newIdolGroupVO.setSongName(songName);
		newIdolGroupVO.setCompany(company);
		newIdolGroupVO.setGender(gender);
		newIdolGroupVO.setGeneration(generation);
		newIdolGroupVO.setName(name);
		newIdolGroupVO.setNation(nation);
		newIdolGroupVO.setYear(year);
		return newIdolGroupVO;
	}

	public void printRegistSuccessMessage(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + " �׷� ��� ����");
	}
	public void printRegistFailMessage(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + " �׷� ��� ����");
	}

	public void printIdolGroupList(ArrayList<IdolGroupVO> idolGroupList) {
		// TODO Auto-generated method stub
		if(idolGroupList == null || idolGroupList.size() == 0) {
			System.out.println("��ϵ� ���̵��׷� ������ �����ϴ�.");
		}
		else {
			System.out.println("���̵� �׷���");
			for (int i = 0; i < idolGroupList.size(); i++) {
				System.out.println(idolGroupList.get(i));
			}
		}
	}
	public String getName(String label, Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print(label);
		return scanner.next();
	}
	/*
	public void printIdolGroupList(IdolGroupVO[] idolGroupList) {
		// TODO Auto-generated method stub
		if(idolGroupList.length == 0) {
			System.out.println("��ϵ� ���̵��׷� ������ �����ϴ�.");
		}
		else {
			System.out.println("���̵� �׷���");
			for (int i = 0; i < idolGroupList.length; i++) {
				System.out.println(idolGroupList[i]);
			}
		}
	}


	public void printDetailIdolGroupVO(IdolGroupVO idolGroupVO) {
		// TODO Auto-generated method stub
		if(idolGroupVO == null) {
			System.out.println("�ش� ���̵� �׷��� �������� �ʽ��ϴ�.");
		}
		else {
			System.out.println("�ش� ���̵� �׷� ����");
			System.out.println(idolGroupVO);
		}
	}

	public IdolGroupVO getNewIdolGroupVO(IdolGroupVO oldIdolGroupVO, Scanner scanner) {
		// TODO Auto-generated method stub
		IdolGroupVO newIdolGroupVO = new IdolGroupVO();
		System.out.println("====�� ���̵��׷�����====");

		System.out.println("���� ���� : " + oldIdolGroupVO.getGender());
		System.out.print("���� : ");
		String gender = scanner.next();

		System.out.println("���� ���̴� : " + oldIdolGroupVO.getGeneration());
		System.out.print("���̴� : ");
		int generation = scanner.nextInt();

		System.out.println("���� ����⵵ : " + oldIdolGroupVO.getYear());
		System.out.print("��߳⵵ : ");
		int year = scanner.nextInt();

		System.out.println("���� ���� : " + oldIdolGroupVO.getNation());
		System.out.print("���� : ");
		String nation = scanner.next();

		System.out.println("���� �Ҽӻ� : " + oldIdolGroupVO.getCompany());
		System.out.print("�Ҽӻ� : ");
		String company = scanner.next();

		System.out.println("���� �ٹ� : " + oldIdolGroupVO.getAlbum());
		System.out.print("�ٹ� : ");
		String album = scanner.next();

		newIdolGroupVO.setAlbum(album);
		newIdolGroupVO.setCompany(company);
		newIdolGroupVO.setGender(gender);
		newIdolGroupVO.setGeneration(generation);
		newIdolGroupVO.setName(oldIdolGroupVO.getName());
		newIdolGroupVO.setNation(nation);
		newIdolGroupVO.setYear(year);
		return newIdolGroupVO;
	}


	public void printRemoveSuccessMessage(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + " ���̵� �׷� ���� ����");
	}
	public void printRemoveFailMessage(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + " ���̵� �׷� ���� ����");
	}

	//�˻��� �ʿ��� ������ ����ڷκ��� �Է¹޾Ƽ� ��ȯ
	public SearchVO getSearchVO(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print("�˻����� (�̸� | ���̴�) : ");
		String searchCondition = scanner.next();


		if(searchCondition.contentEquals("�̸�")) {
			System.out.print("�˻��� �̸� : ");
		}
		else if(searchCondition.contentEquals("���̴�")) {
			System.out.print("�˻��� ���̴� : ");
		}

		String searchValue = scanner.next();


		return new SearchVO(searchCondition, searchValue);
	}

	public void printSearchIdolGroupVO(IdolGroupVO searchIdolGroupVO) {
		// TODO Auto-generated method stub
		if(searchIdolGroupVO == null) {
			System.out.println("�˻��� ������ �����ϴ�.");
		}
		else {
			System.out.println("�̸����� �˻��� ���");
			System.out.println(searchIdolGroupVO);
		}
	}

	public void printSearchIdolGroupVOArray(IdolGroupVO[] searchIdolGroupVOArray) {
		// TODO Auto-generated method stub
		if(searchIdolGroupVOArray.length == 0) {
			System.out.println("�˻��� ���̵��׷� ������ �����ϴ�.");
		}
		else {
			System.out.println("�˻��� ���̵� �׷���");
			for (int i = 0; i < searchIdolGroupVOArray.length; i++) {
				System.out.println(searchIdolGroupVOArray[i]);
			}
		}
	}

	public HashMap<String, String> getNewIdolGroupHashMap(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("====�� ���̵��׷�����====");
		HashMap<String, String> newIdolGroupHashMap 
		= new HashMap<String, String>();

		System.out.print("�̸� : ");
		String name = scanner.next();

		System.out.print("���� : ");
		String gender = scanner.next();

		System.out.print("���̴� : ");
		int generation = scanner.nextInt();

		System.out.print("��߳⵵ : ");
		int year = scanner.nextInt();

		System.out.print("���� : ");
		String nation = scanner.next();

		System.out.print("�Ҽӻ� : ");
		String company = scanner.next();

		System.out.print("�ٹ� : ");
		String album = scanner.next();

		newIdolGroupHashMap.put("name", name);
		newIdolGroupHashMap.put("gender", gender);
		newIdolGroupHashMap.put("generation", generation + "");
		newIdolGroupHashMap.put("year", year + "");
		newIdolGroupHashMap.put("nation", nation);
		newIdolGroupHashMap.put("company", company);
		newIdolGroupHashMap.put("album", album);
		return newIdolGroupHashMap;
	}

	public void printIdolGroupList(ArrayList<HashMap<String, String>> idolGroupList) {
		// TODO Auto-generated method stub
		if(idolGroupList.size() == 0) {
			System.out.println("��ϵ� ���̵��׷� ������ �����ϴ�.");
		}
		else {
			System.out.println("���̵� �׷���");
			for (int i = 0; i < idolGroupList.size(); i++) {
				System.out.println("�̸� : " + idolGroupList.get(i).get("name")
						+ ", ���̴� : " + idolGroupList.get(i).get("generation") 
						+ ", ���� : " + idolGroupList.get(i).get("nation")
						+ ", �Ҽӻ� : " + idolGroupList.get(i).get("company")
						+ ", ���� : " + idolGroupList.get(i).get("gender"));

			}
		}
	}

	public void printDetailIdolGroupVO(HashMap<String, String> detailIdolGroupHashMap) {
		// TODO Auto-generated method stub
		System.out.println("�̸� : " + detailIdolGroupHashMap.get("name")
				+ ", ���̴� : " + detailIdolGroupHashMap.get("generation") 
				+ ", ���� : " + detailIdolGroupHashMap.get("nation")
				+ ", �Ҽӻ� : " + detailIdolGroupHashMap.get("company")
				+ ", ���� : " + detailIdolGroupHashMap.get("gender"));
	}

	public HashMap<String, String> getNewIdolGroupVO(HashMap<String, String> oldIdolGroupHashMap, Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("====�� ���̵��׷�����====");
		HashMap<String, String> newIdolGroupHashMap 
		= new HashMap<String, String>();

		System.out.println("���� ���� : " + oldIdolGroupHashMap.get("gender"));
		System.out.print("���� : ");
		String gender = scanner.next();

		System.out.println("���� ���̴� : " + oldIdolGroupHashMap.get("generation"));
		System.out.print("���̴� : ");
		int generation = scanner.nextInt();

		System.out.println("���� ���߳⵵ : " + oldIdolGroupHashMap.get("year"));
		System.out.print("��߳⵵ : ");
		int year = scanner.nextInt();

		System.out.println("���� ���� : " + oldIdolGroupHashMap.get("nation"));
		System.out.print("���� : ");
		String nation = scanner.next();

		System.out.println("���� �Ҽӻ� : " + oldIdolGroupHashMap.get("company"));
		System.out.print("�Ҽӻ� : ");
		String company = scanner.next();

		System.out.println("���� �ٹ� : " + oldIdolGroupHashMap.get("album"));
		System.out.print("�ٹ� : ");
		String album = scanner.next();

		newIdolGroupHashMap.put("name", oldIdolGroupHashMap.get("name"));
		newIdolGroupHashMap.put("gender", gender);
		newIdolGroupHashMap.put("generation", generation + "");
		newIdolGroupHashMap.put("year", year + "");
		newIdolGroupHashMap.put("nation", nation);
		newIdolGroupHashMap.put("company", company);
		newIdolGroupHashMap.put("album", album);
		return newIdolGroupHashMap;
	}

	public void printSearchIdolGroupHashMap(HashMap<String, String> idolGroupHashMap) {
		// TODO Auto-generated method stub
		if(idolGroupHashMap.size() == 0) {
			System.out.println("�˻��� ������ �����ϴ�.");
		}
		else {
		System.out.println("�˻��� ������ �Ʒ��� �����ϴ�.");
		System.out.println("�̸� : " + idolGroupHashMap.get("name")
		+ ", ���̴� : " + idolGroupHashMap.get("generation") 
		+ ", ���� : " + idolGroupHashMap.get("nation")
		+ ", �Ҽӻ� : " + idolGroupHashMap.get("company")
		+ ", ���� : " + idolGroupHashMap.get("gender"));
		}
	}

	public void printSearchIdolGroupHashMapList(ArrayList<HashMap<String, String>> idolGroupHashMapList) {
		// TODO Auto-generated method stub
		if(idolGroupHashMapList.size() == 0) {
			System.out.println("�˻��� ���̵��׷� ������ �����ϴ�.");
		}
		else {
			System.out.println("�˻��� ���̵� �׷���");
			for (int i = 0; i < idolGroupHashMapList.size(); i++) {
				System.out.println("�̸� : " + idolGroupHashMapList.get(i).get("name")
				+ ", ���̴� : " + idolGroupHashMapList.get(i).get("generation") 
				+ ", ���� : " + idolGroupHashMapList.get(i).get("nation")
				+ ", �Ҽӻ� : " + idolGroupHashMapList.get(i).get("company")
				+ ", ���� : " + idolGroupHashMapList.get(i).get("gender"));
			}
		}
	}
	 */

	public void printDetailIdolGroupVO(IdolGroupVO detailIdolGroupVO) {
		// TODO Auto-generated method stub
		if(detailIdolGroupVO == null) {
			System.out.println("�ش� ���̵� �׷��� �������� �ʽ��ϴ�.");
		}
		else {
			System.out.println("�ش� ���̵� �׷� ����");
			System.out.println(detailIdolGroupVO);
		}
	}

	public IdolGroupVO getNewIdolGroupVO(IdolGroupVO oldIdolGroupVO, Scanner scanner) {
		// TODO Auto-generated method stub
		IdolGroupVO newIdolGroupVO = new IdolGroupVO();
		System.out.println("====�� ���̵��׷�����====");

		System.out.println("���� ���� : " + oldIdolGroupVO.getGender());
		System.out.print("���� : ");
		String gender = scanner.next();

		System.out.println("���� ���̴� : " + oldIdolGroupVO.getGeneration());
		System.out.print("���̴� : ");
		int generation = scanner.nextInt();

		System.out.println("���� ���߳⵵ : " + oldIdolGroupVO.getYear());
		System.out.print("���߳⵵ : ");
		int year = scanner.nextInt();

		System.out.println("���� ���� : " + oldIdolGroupVO.getNation());
		System.out.print("���� : ");
		String nation = scanner.next();

		System.out.println("���� �Ҽӻ� : " + oldIdolGroupVO.getCompany());
		System.out.print("�Ҽӻ� : ");
		String company = scanner.next();

		System.out.println("���� �ٹ� : " + oldIdolGroupVO.getAlbumName());
		System.out.print("�ٹ� : ");
		String albumName = scanner.next();

		System.out.println("���� �뷡 : " + oldIdolGroupVO.getSongName());
		System.out.print("�뷡 : ");
		String SongName = scanner.next();

		newIdolGroupVO.setAlbumName(albumName);
		newIdolGroupVO.setAlbumName(SongName);
		newIdolGroupVO.setCompany(company);
		newIdolGroupVO.setGender(gender);
		newIdolGroupVO.setGeneration(generation);
		newIdolGroupVO.setName(oldIdolGroupVO.getName());
		newIdolGroupVO.setNation(nation);
		newIdolGroupVO.setYear(year);
		return newIdolGroupVO;
	}
	public void printModifySuccessMessage(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + " ���̵� �׷� ���� ���� ����");
	}
	public void printModifyFailMessage(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + " ���̵� �׷� ���� ���� ����");
	}
	public void printRemoveSuccessMessage(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + " ���̵� �׷� ���� ����");
	}
	public void printRemoveFailMessage(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + " ���̵� �׷� ���� ����");
	}
//�˻��� �ʿ��� ������ ����ڷκ��� �Է¹޾Ƽ� ��ȯ
public SearchVO getSearchVO(Scanner scanner) {
	// TODO Auto-generated method stub
	System.out.print("�˻����� (�̸� | ���̴�) : ");
	String searchCondition = scanner.next();


	if(searchCondition.contentEquals("�̸�")) {
		System.out.print("�˻��� �̸� : ");
	}
	else if(searchCondition.contentEquals("���̴�")) {
		System.out.print("�˻��� ���̴� : ");
	}

	String searchValue = scanner.next();


	return new SearchVO(searchCondition, searchValue);
}

public void printSearchIdolGroupVO(IdolGroupVO searchIdolGroupVO) {
	// TODO Auto-generated method stub
	if(searchIdolGroupVO == null) {
		System.out.println("�˻��� ������ �����ϴ�.");
	}
	else {
		System.out.println("�̸����� �˻��� ���");
		System.out.println(searchIdolGroupVO);
	}
}

public void printSearchIdolGroupVOArray(ArrayList<IdolGroupVO> idolGroupVOList) {
	// TODO Auto-generated method stub
	if(idolGroupVOList == null || idolGroupVOList.size() == 0) {
		System.out.println("�˻��� ���̵��׷� ������ �����ϴ�.");
	}
	else {
		System.out.println("�˻��� ���̵� �׷���");
		for (int i = 0; i < idolGroupVOList.size(); i++) {
			System.out.println(idolGroupVOList.get(i));
		}
	}
}
}




