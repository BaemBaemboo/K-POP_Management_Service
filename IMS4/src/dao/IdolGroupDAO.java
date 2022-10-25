package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.IdolGroupVO;
import static DB.JdbcUtil.*;
//���� SQL ������ DBMS�� �����ϴ� Ŭ����
public class IdolGroupDAO {

	//singleton ����
	//Ŭ���� ��ü�� Ư�� �Ӽ����� �����ϴ� �뵵�� �ƴϰ�, ������ �����ϴ� �޼ҵ常 �����ϴ� ���
	//��ü�� ó���� ����Ҷ��� �޸𸮿� �ϳ��� �����ؼ� �����ϴ� ����

	private static IdolGroupDAO instance;

	private IdolGroupDAO() {
		// TODO Auto-generated constructor stub
	}

	public static IdolGroupDAO getInstance() {
		if(instance == null) {
			//�޼ҵ带 ó�� ȣ��������...
			instance = new IdolGroupDAO();
		}
		return instance;
	}

	private Connection con;//�ڹٿ��� Ʈ������ �۾��� Connection ������ �̷����
	//������ü�� ó���ҷ��� ������ü�� ���� DB �۾����� Connection ��ü�� �ϳ� �����ؼ� DAO �� �����ؾ� ��
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
				//�̰��� true��¶���, '��ȯ�� �޼ҵ尡 �ϳ��� ������?' �̶�� �ǹ�
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
				//�̰��� true��¶���, '��ȯ�� �޼ҵ尡 �ϳ��� ������?' �̶�� �ǹ�
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
















