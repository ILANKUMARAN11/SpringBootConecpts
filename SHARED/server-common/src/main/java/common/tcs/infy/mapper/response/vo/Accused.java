package common.tcs.infy.mapper.response.vo;

public class Accused {
	
	
	private String accusedName;
	
	private int age;
	
	private String gender;
	
	private String address;
	
	private String adharNo;

	public Accused(){}
	
	
	public Accused(String accusedName,int age,String gender,String address,String adharNo){
		this.accusedName=accusedName;
		this.age=age;
		this.gender=gender;
		this.address=address;
		this.adharNo=adharNo;
	}
	

	public String getAccusedName() {
		return accusedName;
	}

	public void setAccusedName(String accusedName) {
		this.accusedName = accusedName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}
	
}
