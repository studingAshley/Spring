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
public class DepartmentsDto {
	
	public int department_id;
	public String department_name;
	public int parent_id;
	public int manager_id;
	public Timestamp create_date;
	public Timestamp update_date;
	

}
/*--------------- -------- ------------ 
DEPARTMENT_ID   NOT NULL NUMBER(6)    
DEPARTMENT_NAME NOT NULL VARCHAR2(80) 
PARENT_ID                NUMBER(6)    
MANAGER_ID               NUMBER(6)    
CREATE_DATE              DATE         
UPDATE_DATE              DATE         
*/