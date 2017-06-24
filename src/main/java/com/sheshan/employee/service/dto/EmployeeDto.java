package com.sheshan.employee.service.dto;

import java.util.ArrayList;

public class EmployeeDto {
	private int employeeId;
	private String email;
	private String profilePicUrl;
	private String errorMessage;
	private ArrayList<LeaveQuotaDto> leaveQuotaList;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfilePicUrl() {
		return profilePicUrl;
	}
	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public ArrayList<LeaveQuotaDto> getLeaveQuotaList() {
		return leaveQuotaList;
	}
	public void setLeaveQuotaList(ArrayList<LeaveQuotaDto> leaveQuotaList) {
		this.leaveQuotaList = leaveQuotaList;
	}
	
	
	
	

	
	
}
