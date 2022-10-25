package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.IdolGroupVO;
import static DB.JdbcUtil.*;
//직접 SQL 구문을 DBMS로 전송하는 클래스
public class IdolGroupDAO {

	//singleton 패턴
	//클래스 객체가 특정 속성값을 저장하는 용도가 아니고, 연산을 수행하는 메소드만 제공하는 경우
	//객체를 처음에 사용할때만 메모리에 하나만 생성해서 공유하는 패턴

	private static IdolGroupDAO instance;

	private IdolGroupDAO() {
		// TODO Auto-generated constructor stub
	}

	public static IdolGroupDAO getInstance() {
		if(instance == null) {
			//메소드를 처음 호출했으면...
			instance = new IdolGroupDAO();
		}
		return instance;
	}

	private Connection con;//자바에서 트랜젝션 작업은 Connection 단위로 이루어짐
	//계좌이체를 처리할려면 계좌이체에 관한 DB 작업을할 Connection 객체를 하나 생성해서 DAO 에 전달해야 함
	public void setConnection(Connection con) {
		this.con = con;
	}

	public int insertIdolGroup(IdolGroupVO newIdolGroupVO) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		int insertCount = 0;
		String sql = "INSERT INTO idolGroup VALUES('" + newIdolGroupVO.getName() + "','"
				+ newIdolGroupVO.getGender() + "',"
				+ newIdolGroupVO.getGeneration() + ","
				+ newIdolGroupVO.getYear() + ",'"
				+ newIdolGroupVO.getNation() + "','"
				+ newIdolGroupVO.getAlbumName() + "','"
				+ newIdolGroupVO.getSongName() + "','"
				+ newIdolGroupVO.getCompany() + "')"
				;
		try {
			stmt = con.createStatement();
			insertCount = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(stmt);
		}
		return insertCount;
	}

	public ArrayList<IdolGroupVO> selectIdolGroupList() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		ArrayList<IdolGroupVO> idolGroupList = null;
		Statement stmt = null;
		String sql = "SELECT * FROM idolGroup";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if(rs.next()) {
				//이것이 true라는뜻은, '반환된 메소드가 하나라도 있으면?' 이라는 의미
				idolGroupList = new ArrayList<IdolGroupVO>();


				do {
					idolGroupList.add(new IdolGroupVO(
							rs.getString("name"), 
							rs.getString("gender"), 
							rs.getInt("generation"), 
							rs.getInt("year"), 
							rs.getString("nation"), 
							rs.getString("albumName"), 
							rs.getString("songName"), 
							rs.getString("company")));
				} while (rs.next());
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(stmt);
		}
		return idolGroupList;
	}

	public IdolGroupVO selectIdolGroupVO(String name) {
		// TODO Auto-generated method stub
		IdolGroupVO idolGroupVO = null;
		ResultSet rs = null;
		Statement stmt = null;
		String sql = "SELECT * FROM idolGroup WHERE name = '" + name + "'";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if(rs.next()) {
				
					idolGroupVO = new IdolGroupVO(
							rs.getString("name"), 
							rs.getString("gender"), 
							rs.getInt("generation"), 
							rs.getInt("year"), 
							rs.getString("nation"), 
							rs.getString("albumName"), 
							rs.getString("songName"), 
							rs.getString("company"));		
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(stmt);
		}


		return idolGroupVO;
	}

	public IdolGroupVO selectOldIdolGroupVO(String name) {
		// TODO Auto-generated method stub
		IdolGroupVO idolGroupVO = null;
		ResultSet rs = null;
		Statement stmt = null;
		String sql = "SELECT * FROM idolGroup WHERE name = '" + name + "'";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if(rs.next()) {
				
					idolGroupVO = new IdolGroupVO(
							rs.getString("name"), 
							rs.getString("gender"), 
							rs.getInt("generation"), 
							rs.getInt("year"), 
							rs.getString("nation"), 
							rs.getString("albumName"), 
							rs.getString("songName"), 
							rs.getString("company"));		
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(stmt);
		}


		return idolGroupVO;
	}

	public int updateIdolGroup(IdolGroupVO newIdolGroupVO) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		int updateCount = 0;
		String sql = "UPDATE idolGroup "
				+ " SET gender = '" + newIdolGroupVO.getGender() + "'," 
				+ "generation = " + newIdolGroupVO.getGeneration() + ","
				+ "year = " +  newIdolGroupVO.getYear() + ","
				+ "nation = '" + newIdolGroupVO.getNation() + "',"
				+ "albumName = '" +  newIdolGroupVO.getAlbumName() + "',"
				+ "songName = '" + newIdolGroupVO.getSongName() + "',"
				+ "company = '" + newIdolGroupVO.getCompany() + "'"
				+ " WHERE name = '" + newIdolGroupVO.getName() + "'"
				;
		try {
			stmt = con.createStatement();
			updateCount = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(stmt);
		}
		return updateCount;
	}

	public int deleteIdolGroup(String name) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		int deleteCount = 0;
		String sql = "DELETE idolGroup "
				+ " WHERE name = '" + name + "'"
				;
		try {
			stmt = con.createStatement();
			deleteCount = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(stmt);
		}
		return deleteCount;	
	}
	public IdolGroupVO selectSearchOldIdolGroupVO(String name) {
	IdolGroupVO idolGroupVO = null;
	ResultSet rs = null;
	Statement stmt = null;
	String sql = "SELECT * FROM idolGroup WHERE name = '" + name + "'";
	try {
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);

		if(rs.next()) {
			
				idolGroupVO = new IdolGroupVO(
						rs.getString("name"), 
						rs.getString("gender"), 
						rs.getInt("generation"), 
						rs.getInt("year"), 
						rs.getString("nation"), 
						rs.getString("albumName"), 
						rs.getString("songName"), 
						rs.getString("company"));		
		}

	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		close(stmt);
	}
	return idolGroupVO;
}

	public ArrayList<IdolGroupVO> selectSearchOldIdolGroupVOList(String generation) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		ArrayList<IdolGroupVO> idolGroupList = null;
		Statement stmt = null;
		String sql = "SELECT * FROM idolGroup WHERE generation = " + generation;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			if(rs.next()) {
				//이것이 true라는뜻은, '반환된 메소드가 하나라도 있으면?' 이라는 의미
				idolGroupList = new ArrayList<IdolGroupVO>();


				do {
					idolGroupList.add(new IdolGroupVO(
							rs.getString("name"), 
							rs.getString("gender"), 
							rs.getInt("generation"), 
							rs.getInt("year"), 
							rs.getString("nation"), 
							rs.getString("albumName"), 
							rs.getString("songName"), 
							rs.getString("company")));
				} while (rs.next());
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(stmt);
		}
		return idolGroupList;
	}
}
















