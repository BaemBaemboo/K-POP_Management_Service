package vo;

//DTO(Data Transfer Object) : Ŭ���̾�Ʈ���� ���۵� �����͸� �������� �����Ͻ� �������� ����
//VO(value Object) : DB���� ������ �����͸� ��ü�� ��ȯ�ϴ� �뵵�� �ַ� ���

//�ֱٿ��� ȥ��
public class IdolGroupVO {
	private String name;  //�ĺ���
	private String gender;
	private int generation;
	private int year;
	private String nation;
	private String albumName;
	private String songName;
	private String company;
	public IdolGroupVO() {
		
	}
	public IdolGroupVO(String name, String gender, int generation, int year, String nation, String albumName,
			String songName, String company) {
		super();
		this.name = name;
		this.gender = gender;
		this.generation = generation;
		this.year = year;
		this.nation = nation;
		this.albumName = albumName;
		this.songName = songName;
		this.company = company;
	}
	//Accessor
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getGeneration() {
		return generation;
	}
	public void setGeneration(int generation) {
		this.generation = generation;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	
	//�ڹٿ��� Ư����ü�� "+" ����ǰų� print �޼ҵ��� ���ڷ� �����Ǹ�
	//�ش� ��ü�� toString() �޼ҵ尡 �ڵ����� ȣ��ȴ�.
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "�̸� : " + name + ", ���� : " + nation + ", �Ҽӻ� : " + company
				+ ", ���� : " + gender + ", ���̴� : " + generation;
	}
}






