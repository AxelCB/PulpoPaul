package unlp.ttpsInfoPoolCBR.model;

public class JsonResponse {
	
	private Boolean ok;
	private String data;
	private String message;
	
	public JsonResponse(){
		
	}
	
	public Boolean getOk() {
		return ok;
	}
	public void setOk(Boolean ok) {
		this.ok = ok;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
