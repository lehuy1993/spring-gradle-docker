package fa.spring.model;

public class ResponseBodyDto<E> {

	private String status;
	private String message;
	private E data;
	private Long totalRecords;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public Long getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}
	public ResponseBodyDto(String status, String message, E data, Long totalRecords) {
		super();
		this.status = "200";
		this.message = "you request is successfuly";
		this.totalRecords = totalRecords;
	}
	public ResponseBodyDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
