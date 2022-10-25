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
		System.out.println("====새 아이돌그룹정보====");
		System.out.print("이름 : ");
		String name = scanner.next();
		System.out.print("성별 : ");
		String gender = scanner.next();
		System.out.print("나이대 : ");
		int generation = scanner.nextInt();
		System.out.print("대뷔년도 : ");
		int year = scanner.nextInt();
		System.out.print("국가 : ");
		String nation = scanner.next();
		System.out.print("소속사 : ");
		String company = scanner.next();
		System.out.print("앨범이름 : ");
		String albumName = scanner.next();
		System.out.print("대표곡 : ");
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
		System.out.println(name + " 그룹 등록 성공");
	}
	public void printRegistFailMessage(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + " 그룹 등록 실패");
	}

	public void printIdolGroupList(ArrayList<IdolGroupVO> idolGroupList) {
		// TODO Auto-generated method stub
		if(idolGroupList == null || idolGroupList.size() == 0) {
			System.out.println("등록된 아이돌그룹 정보가 없습니다.");
		}
		else {
			System.out.println("아이돌 그룹목록");
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
			System.out.println("등록된 아이돌그룹 정보가 없습니다.");
		}
		else {
			System.out.println("아이돌 그룹목록");
			for (int i = 0; i < idolGroupList.length; i++) {
				System.out.println(idolGroupList[i]);
			}
		}
	}


	public void printDetailIdolGroupVO(IdolGroupVO idolGroupVO) {
		// TODO Auto-generated method stub
		if(idolGroupVO == null) {
			System.out.println("해당 아이돌 그룹이 존재하지 않습니다.");
		}
		else {
			System.out.println("해당 아이돌 그룹 정보");
			System.out.println(idolGroupVO);
		}
	}

	public IdolGroupVO getNewIdolGroupVO(IdolGroupVO oldIdolGroupVO, Scanner scanner) {
		// TODO Auto-generated method stub
		IdolGroupVO newIdolGroupVO = new IdolGroupVO();
		System.out.println("====새 아이돌그룹정보====");

		System.out.println("이전 성별 : " + oldIdolGroupVO.getGender());
		System.out.print("성별 : ");
		String gender = scanner.next();

		System.out.println("이전 나이대 : " + oldIdolGroupVO.getGeneration());
		System.out.print("나이대 : ");
		int generation = scanner.nextInt();

		System.out.println("이전 데뷰년도 : " + oldIdolGroupVO.getYear());
		System.out.print("대뷔년도 : ");
		int year = scanner.nextInt();

		System.out.println("이전 국가 : " + oldIdolGroupVO.getNation());
		System.out.print("국가 : ");
		String nation = scanner.next();

		System.out.println("이전 소속사 : " + oldIdolGroupVO.getCompany());
		System.out.print("소속사 : ");
		String company = scanner.next();

		System.out.println("이전 앨범 : " + oldIdolGroupVO.getAlbum());
		System.out.print("앨범 : ");
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
		System.out.println(name + " 아이돌 그룹 삭제 성공");
	}
	public void printRemoveFailMessage(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + " 아이돌 그룹 삭제 실패");
	}

	//검색에 필요한 값들을 사용자로부터 입력받아서 반환
	public SearchVO getSearchVO(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.print("검색조건 (이름 | 나이대) : ");
		String searchCondition = scanner.next();


		if(searchCondition.contentEquals("이름")) {
			System.out.print("검색할 이름 : ");
		}
		else if(searchCondition.contentEquals("나이대")) {
			System.out.print("검색할 나이대 : ");
		}

		String searchValue = scanner.next();


		return new SearchVO(searchCondition, searchValue);
	}

	public void printSearchIdolGroupVO(IdolGroupVO searchIdolGroupVO) {
		// TODO Auto-generated method stub
		if(searchIdolGroupVO == null) {
			System.out.println("검색된 정보가 없습니다.");
		}
		else {
			System.out.println("이름으로 검색한 결과");
			System.out.println(searchIdolGroupVO);
		}
	}

	public void printSearchIdolGroupVOArray(IdolGroupVO[] searchIdolGroupVOArray) {
		// TODO Auto-generated method stub
		if(searchIdolGroupVOArray.length == 0) {
			System.out.println("검색된 아이돌그룹 정보가 없습니다.");
		}
		else {
			System.out.println("검색된 아이돌 그룹목록");
			for (int i = 0; i < searchIdolGroupVOArray.length; i++) {
				System.out.println(searchIdolGroupVOArray[i]);
			}
		}
	}

	public HashMap<String, String> getNewIdolGroupHashMap(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("====새 아이돌그룹정보====");
		HashMap<String, String> newIdolGroupHashMap 
		= new HashMap<String, String>();

		System.out.print("이름 : ");
		String name = scanner.next();

		System.out.print("성별 : ");
		String gender = scanner.next();

		System.out.print("나이대 : ");
		int generation = scanner.nextInt();

		System.out.print("대뷔년도 : ");
		int year = scanner.nextInt();

		System.out.print("국가 : ");
		String nation = scanner.next();

		System.out.print("소속사 : ");
		String company = scanner.next();

		System.out.print("앨범 : ");
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
			System.out.println("등록된 아이돌그룹 정보가 없습니다.");
		}
		else {
			System.out.println("아이돌 그룹목록");
			for (int i = 0; i < idolGroupList.size(); i++) {
				System.out.println("이름 : " + idolGroupList.get(i).get("name")
						+ ", 나이대 : " + idolGroupList.get(i).get("generation") 
						+ ", 국가 : " + idolGroupList.get(i).get("nation")
						+ ", 소속사 : " + idolGroupList.get(i).get("company")
						+ ", 성별 : " + idolGroupList.get(i).get("gender"));

			}
		}
	}

	public void printDetailIdolGroupVO(HashMap<String, String> detailIdolGroupHashMap) {
		// TODO Auto-generated method stub
		System.out.println("이름 : " + detailIdolGroupHashMap.get("name")
				+ ", 나이대 : " + detailIdolGroupHashMap.get("generation") 
				+ ", 국가 : " + detailIdolGroupHashMap.get("nation")
				+ ", 소속사 : " + detailIdolGroupHashMap.get("company")
				+ ", 성별 : " + detailIdolGroupHashMap.get("gender"));
	}

	public HashMap<String, String> getNewIdolGroupVO(HashMap<String, String> oldIdolGroupHashMap, Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("====새 아이돌그룹정보====");
		HashMap<String, String> newIdolGroupHashMap 
		= new HashMap<String, String>();

		System.out.println("예전 성별 : " + oldIdolGroupHashMap.get("gender"));
		System.out.print("성별 : ");
		String gender = scanner.next();

		System.out.println("예전 나이대 : " + oldIdolGroupHashMap.get("generation"));
		System.out.print("나이대 : ");
		int generation = scanner.nextInt();

		System.out.println("예전 데뷔년도 : " + oldIdolGroupHashMap.get("year"));
		System.out.print("대뷔년도 : ");
		int year = scanner.nextInt();

		System.out.println("예전 국가 : " + oldIdolGroupHashMap.get("nation"));
		System.out.print("국가 : ");
		String nation = scanner.next();

		System.out.println("예전 소속사 : " + oldIdolGroupHashMap.get("company"));
		System.out.print("소속사 : ");
		String company = scanner.next();

		System.out.println("예전 앨범 : " + oldIdolGroupHashMap.get("album"));
		System.out.print("앨범 : ");
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
			System.out.println("검색된 정보가 없습니다.");
		}
		else {
		System.out.println("검색된 정보는 아래와 같습니다.");
		System.out.println("이름 : " + idolGroupHashMap.get("name")
		+ ", 나이대 : " + idolGroupHashMap.get("generation") 
		+ ", 국가 : " + idolGroupHashMap.get("nation")
		+ ", 소속사 : " + idolGroupHashMap.get("company")
		+ ", 성별 : " + idolGroupHashMap.get("gender"));
		}
	}

	public void printSearchIdolGroupHashMapList(ArrayList<HashMap<String, String>> idolGroupHashMapList) {
		// TODO Auto-generated method stub
		if(idolGroupHashMapList.size() == 0) {
			System.out.println("검색된 아이돌그룹 정보가 없습니다.");
		}
		else {
			System.out.println("검색된 아이돌 그룹목록");
			for (int i = 0; i < idolGroupHashMapList.size(); i++) {
				System.out.println("이름 : " + idolGroupHashMapList.get(i).get("name")
				+ ", 나이대 : " + idolGroupHashMapList.get(i).get("generation") 
				+ ", 국가 : " + idolGroupHashMapList.get(i).get("nation")
				+ ", 소속사 : " + idolGroupHashMapList.get(i).get("company")
				+ ", 성별 : " + idolGroupHashMapList.get(i).get("gender"));
			}
		}
	}
	 */

	public void printDetailIdolGroupVO(IdolGroupVO detailIdolGroupVO) {
		// TODO Auto-generated method stub
		if(detailIdolGroupVO == null) {
			System.out.println("해당 아이돌 그룹이 존재하지 않습니다.");
		}
		else {
			System.out.println("해당 아이돌 그룹 정보");
			System.out.println(detailIdolGroupVO);
		}
	}

	public IdolGroupVO getNewIdolGroupVO(IdolGroupVO oldIdolGroupVO, Scanner scanner) {
		// TODO Auto-generated method stub
		IdolGroupVO newIdolGroupVO = new IdolGroupVO();
		System.out.println("====새 아이돌그룹정보====");

		System.out.println("이전 성별 : " + oldIdolGroupVO.getGender());
		System.out.print("성별 : ");
		String gender = scanner.next();

		System.out.println("이전 나이대 : " + oldIdolGroupVO.getGeneration());
		System.out.print("나이대 : ");
		int generation = scanner.nextInt();

		System.out.println("이전 데뷔년도 : " + oldIdolGroupVO.getYear());
		System.out.print("데뷔년도 : ");
		int year = scanner.nextInt();

		System.out.println("이전 국가 : " + oldIdolGroupVO.getNation());
		System.out.print("국가 : ");
		String nation = scanner.next();

		System.out.println("이전 소속사 : " + oldIdolGroupVO.getCompany());
		System.out.print("소속사 : ");
		String company = scanner.next();

		System.out.println("이전 앨범 : " + oldIdolGroupVO.getAlbumName());
		System.out.print("앨범 : ");
		String albumName = scanner.next();

		System.out.println("이전 노래 : " + oldIdolGroupVO.getSongName());
		System.out.print("노래 : ");
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
		System.out.println(name + " 아이돌 그룹 정보 수정 성공");
	}
	public void printModifyFailMessage(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + " 아이돌 그룹 정보 수정 실패");
	}
	public void printRemoveSuccessMessage(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + " 아이돌 그룹 삭제 성공");
	}
	public void printRemoveFailMessage(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + " 아이돌 그룹 삭제 실패");
	}
//검색에 필요한 값들을 사용자로부터 입력받아서 반환
public SearchVO getSearchVO(Scanner scanner) {
	// TODO Auto-generated method stub
	System.out.print("검색조건 (이름 | 나이대) : ");
	String searchCondition = scanner.next();


	if(searchCondition.contentEquals("이름")) {
		System.out.print("검색할 이름 : ");
	}
	else if(searchCondition.contentEquals("나이대")) {
		System.out.print("검색할 나이대 : ");
	}

	String searchValue = scanner.next();


	return new SearchVO(searchCondition, searchValue);
}

public void printSearchIdolGroupVO(IdolGroupVO searchIdolGroupVO) {
	// TODO Auto-generated method stub
	if(searchIdolGroupVO == null) {
		System.out.println("검색된 정보가 없습니다.");
	}
	else {
		System.out.println("이름으로 검색한 결과");
		System.out.println(searchIdolGroupVO);
	}
}

public void printSearchIdolGroupVOArray(ArrayList<IdolGroupVO> idolGroupVOList) {
	// TODO Auto-generated method stub
	if(idolGroupVOList == null || idolGroupVOList.size() == 0) {
		System.out.println("검색된 아이돌그룹 정보가 없습니다.");
	}
	else {
		System.out.println("검색된 아이돌 그룹목록");
		for (int i = 0; i < idolGroupVOList.size(); i++) {
			System.out.println(idolGroupVOList.get(i));
		}
	}
}
}




