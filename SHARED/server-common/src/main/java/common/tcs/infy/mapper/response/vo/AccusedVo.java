package common.tcs.infy.mapper.response.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AccusedVo {
	
	
	private String accusedName;

	@ApiModelProperty(position = 1, required = true, value = "29")
	private int age;
	
	private String gender;
	
	private String adharNo;

	public AccusedVo(){}
	
	
	public AccusedVo(String accusedName, int age, String gender, String adharNo){
		this.accusedName=accusedName;
		this.age=age;
		this.gender=gender;
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

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}
	
}
