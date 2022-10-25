package vo;

//DTO(Data Transfer Object) : 클라이언트에서 전송된 데이터를 저장한후 비지니스 로직으로 전달
//VO(value Object) : DB에서 가져온 데이터를 객체로 변환하는 용도로 주로 사용

//최근에는 혼용
public class IdolGroupVO {
	private String name;  //식별자
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
	
	//자바에서 특정객체가 "+" 연산되거나 print 메소드의 인자로 지정되면
	//해당 객체의 toString() 메소드가 자동으로 호출된다.
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "이름 : " + name + ", 국가 : " + nation + ", 소속사 : " + company
				+ ", 성별 : " + gender + ", 나이대 : " + generation;
	}
}






