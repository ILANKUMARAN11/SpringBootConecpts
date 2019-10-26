package common.tcs.infy.tcs.infy.response;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonComponent
public class ResponseData<T>
{
	
	
	public ResponseData()
	{
		
	}
	
	public ResponseData(T data,boolean success,String message)
	{
		this.data=data;
		this.success=success;
		this.message=message;
	}
	
	@JsonProperty("DATA")
	private T data;
	
	@JsonProperty("SUCCESS")
	private boolean success;
	
	@JsonProperty("MESSAGE")
	private String message;

	

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	

}
