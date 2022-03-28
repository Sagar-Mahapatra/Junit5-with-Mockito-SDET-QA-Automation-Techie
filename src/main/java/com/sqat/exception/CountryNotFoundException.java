package com.sqat.exception;

public class CountryNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private String respCode;
	private String respMsg;

	public CountryNotFoundException(String respCode, String respMsg) {
		super();
		this.respCode = respCode;
		this.respMsg = respMsg;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

}
