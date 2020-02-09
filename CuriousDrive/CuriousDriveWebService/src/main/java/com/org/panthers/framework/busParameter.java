package com.org.panthers.framework;

public class busParameter {

	public String key;
	public String value;
	public String dataType;
	
	public busParameter(String key,String value,String dataType){
		this.key = key;
		this.value = value;
		this.dataType = dataType;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
}
