package com.adp.billbreaker.exception;

public class ErrorInfo {
	
    private  String detail;
    private  String status;
    private  String code;
    private  String type;
    
    public ErrorInfo(){}


    public ErrorInfo(String detail, String status, String code, String type) {
		super();
		this.detail = detail;
		this.status = status;
		this.code = code;
		this.type = type;
	}


	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
