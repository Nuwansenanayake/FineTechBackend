package com.sheshan.employee.service.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sheshan.employee.service.dao.EmployeeDao;
import com.sheshan.employee.service.dto.EmployeeDto;
import com.sheshan.employee.service.dto.EmployeeGoogleProfile;
import com.sheshan.employee.service.dto.LeaveQuotaDto;
import com.sheshan.employee.service.util.ValidateAouth;

public class EmployeeLogic {

	private final String EMAIL_VERIFIED = "true";
	private final String INVALID_TOKEN = "invalid token";
	private final String INVALID_USER = "invalid user";
	private final String EMAIL_ID_MISMATCH = "invalid user";
	private final String SYSTEM_ERROR = "invalid user";

	public EmployeeDto validateEmployeeLogin(String tokenId) {
		ValidateAouth googleValidateAouth = new ValidateAouth();
		EmployeeDto employeeDto = new EmployeeDto();
		EmployeeGoogleProfile employeeGoogleProfile = googleValidateAouth.validateIdToken(tokenId);
		if (employeeGoogleProfile.getEmail_verified() != null) {
			if (employeeGoogleProfile.getEmail_verified().toString().equals(EMAIL_VERIFIED)) {
				ResultSet rs = EmployeeDao.getVlaidLoginEmployee(employeeGoogleProfile.getEmail());
				try {
					rs.next();
					if (rs.getInt(1) != 0) {
						employeeDto.setEmployeeId(rs.getInt(1));
						employeeDto.setEmail(rs.getString(2));
						employeeDto.setProfilePicUrl(employeeGoogleProfile.getPicture());
					} else {
						employeeDto.setErrorMessage(INVALID_USER);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					employeeDto.setErrorMessage(SYSTEM_ERROR);
				}
			} else {
				employeeDto.setErrorMessage(EMAIL_ID_MISMATCH);
			}
		} else {
			employeeDto.setErrorMessage(INVALID_TOKEN);
		}
		ArrayList<LeaveQuotaDto> leaveQuotaList = getEmployeeLeaveQuota(employeeDto);
		employeeDto.setLeaveQuotaList(leaveQuotaList);
		return employeeDto;
	}
	
	public ArrayList<LeaveQuotaDto> getEmployeeLeaveQuota(EmployeeDto employeeDto){
		ResultSet rs = EmployeeDao.getEmployeeLeaveQuota(employeeDto.getEmployeeId());
		System.out.println(employeeDto.getEmployeeId());
		ArrayList<LeaveQuotaDto> leaveQuotaList = new ArrayList<>(); 
		try {
			while(rs.next()){
					LeaveQuotaDto leaveQuotaObject = new LeaveQuotaDto();
					leaveQuotaObject.setLeaveId(rs.getInt(1));
					leaveQuotaObject.setLeaveType(rs.getString(2));
					leaveQuotaObject.setAnualQuotavValue(rs.getDouble(3));
					leaveQuotaObject.setRemaningQuotaValue(rs.getDouble(4));
					leaveQuotaList.add(leaveQuotaObject);
			}
			return leaveQuotaList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			employeeDto.setErrorMessage(SYSTEM_ERROR);
		}
		return leaveQuotaList;
	}
	
	public ArrayList<EmployeeDto> getEmployeeListByGroupId(String groupId){
		ResultSet rs = EmployeeDao.getEmployeeListByGroupId(groupId);
		
		EmployeeDto employeeDto = new EmployeeDto();

		System.out.println(employeeDto.getEmployeeId());
		ArrayList<EmployeeDto> employeeDtoList = new ArrayList<>(); 
		try {
			while(rs.next()){
				employeeDto = new EmployeeDto();
				employeeDto.setEmployeeId(rs.getInt(1));
				employeeDto.setEmail(rs.getString(2));
				employeeDtoList.add(employeeDto);
			}
			return employeeDtoList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			employeeDto.setErrorMessage(SYSTEM_ERROR);
		}
		return employeeDtoList;
		

	}

}
