package com.deppon.rest.demos.bean;

import java.io.Serializable;

public class CallInfo implements Serializable {

	private static final long serialVersionUID = -2353211649341625079L;

	private Long id;

	private String number;

	private Boolean success;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "CallInfo{" +
				"id=" + id +
				", number='" + number + '\'' +
				", success=" + success +
				'}';
	}
}
