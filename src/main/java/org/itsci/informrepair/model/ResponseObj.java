package org.itsci.informrepair.model;

public class ResponseObj {

	int code;
	Object result;

	public ResponseObj(int code, Object result) {
		super();
		this.code = code;
		this.result = result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
}
