package com.java.model;


public class Cron{
	/**
	 * cronId
	 **/
	private Integer id;
	/**
	 * cronName
	 **/
	private String cronName;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCronName() {
		return cronName;
	}

	public void setCronName(String cronName) {
		this.cronName = cronName;
	}

	@Override
	public String toString() {
		 final StringBuffer sb=new StringBuffer("Cron{");
		if (id != null) {
			sb.append(", \"id\":\"").append(id).append("\"");
		}
		if (cronName != null) {
			sb.append(", \"cronName\":\"").append(cronName).append("\"");
		}
		sb.append("}");
		return sb.toString();
	}
}