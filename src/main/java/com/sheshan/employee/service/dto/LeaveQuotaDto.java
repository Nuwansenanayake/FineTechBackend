package com.sheshan.employee.service.dto;

public class LeaveQuotaDto {
	
	private int leaveId;
	private String leaveType;
	private double anualQuotavValue;
	private double remaningQuotaValue;
	
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public double getAnualQuotavValue() {
		return anualQuotavValue;
	}
	public void setAnualQuotavValue(double anualQuotavValue) {
		this.anualQuotavValue = anualQuotavValue;
	}
	public double getRemaningQuotaValue() {
		return remaningQuotaValue;
	}
	public void setRemaningQuotaValue(double remaningQuotaValue) {
		this.remaningQuotaValue = remaningQuotaValue;
	}

	
	
	

}
