package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.Dept;

public interface DeptDAO {

	// 부서등록
	int insertDept(Dept dept) throws SQLException;

	// 부서수정
	int updateDept(Dept dept) throws SQLException;

	// 부서삭제
	int deleteDept(int deptno) throws SQLException;

	// 부서목록조회
	List<Dept> selectDepts() throws SQLException;

	// 부서목록조회 - 부서이름포함검색
	List<Dept> selectDepts(String dname) throws SQLException;

	// 부서조회-deptno
	Dept selectDept(int deptno) throws SQLException;

}