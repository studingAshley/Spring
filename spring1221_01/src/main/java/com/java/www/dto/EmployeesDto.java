package com.java.www.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeesDto {

	public int employee_id;
	public String emp_name;
	public String email;
	public String phone_number;
	public Timestamp hire_date;
	public int salary;
	public int manager_id;
	public int commission_pct;
	public Timestamp retire_date;
	public int department_id;
	public String job_id;
	public Timestamp crete_date;
	public Timestamp update_date;
	
}


/*EMPLOYEE_ID    NOT NULL NUMBER(6)    
EMP_NAME       NOT NULL VARCHAR2(80) 
EMAIL                   VARCHAR2(50) 
PHONE_NUMBER            VARCHAR2(30) 
HIRE_DATE      NOT NULL DATE         
SALARY                  NUMBER(8,2)  
MANAGER_ID              NUMBER(6)    
COMMISSION_PCT          NUMBER(2,2)  
RETIRE_DATE             DATE         
DEPARTMENT_ID           NUMBER(6)    
JOB_ID                  VARCHAR2(10) 
CREATE_DATE             DATE         
UPDATE_DATE             DATE         */