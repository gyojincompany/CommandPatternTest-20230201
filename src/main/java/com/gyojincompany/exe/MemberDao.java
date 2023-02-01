package com.gyojincompany.exe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/webdb";
	String username = "root";
	String password = "1234";	
	
	public int joinMember(String id, String pw, String name, String email) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO members(id, password, name, email) VALUES (?,?,?,?)";
		
		int resultFlag = 0;
		
		try {
			Class.forName(driverName);//드라이버 불러오기
			conn = DriverManager.getConnection(url, username, password);//DB 연동
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			resultFlag = pstmt.executeUpdate();//성공하면 1로 값이 변경
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return resultFlag;
	}
	
	public int checkId(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		int resultFlag = 0;
		
		String sql = "SELECT * FROM members WHERE id = ?";
		
		try {
			Class.forName(driverName);//드라이버 불러오기
			conn = DriverManager.getConnection(url, username, password);//DB 연동
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();//ResultSect 객체인 rs로 받기
			
			if(rs.next()) {
				resultFlag = 1;//가입하려는 아이디가 이미 존재
			} else {
				resultFlag = 0;//가입하려는 아이디가 존재하지 않음
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}				
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return resultFlag;				
	}
	
	public int loginCheck(String id, String pw) {
		
		//int checkId = checkId(id);//1이면 가입된 아이디 존재
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		int resultFlag = 0;
		
		String sql = "SELECT * FROM members WHERE id = ?";
		String dbpw;
		
		try {
			Class.forName(driverName);//드라이버 불러오기
			conn = DriverManager.getConnection(url, username, password);//DB 연동
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();//ResultSect 객체인 rs로 받기
			
			if(rs.next()) {
				dbpw = rs.getString("password");
				if(dbpw.equals(pw)) {
					resultFlag = 1;//아이디와 비밀번호가 일치->로그인 성공
				} else {
					resultFlag = 0;//아이디는 존재하지만 비밀번호가 불일치->로그인 실패
				}
			} else {
				resultFlag = 0;//로그인하려는 아이디가 존재하지 않음
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}				
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return resultFlag;//1이면 로그인성공, 0이면 로그인실패
		
	}
	
	public MemberDto getMemberInfo(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		int resultFlag = 0;
		MemberDto dto = null;
		
		String sql = "SELECT * FROM members WHERE id = ?";
		
		try {
			Class.forName(driverName);//드라이버 불러오기
			conn = DriverManager.getConnection(url, username, password);//DB 연동
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();//ResultSect 객체인 rs로 받기
			
			if(rs.next()) {//rs로 받은 레코드를 dto 객체에 옮겨 싣기
				dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setJointime(rs.getTimestamp("jointime"));
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}				
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return dto; 
	}
	
	public int modify(String id, String pw, String name, String email) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE members SET password=?, name=?, email=? WHERE id=?";
		
		int resultFlag = 0;
		
		try {
			Class.forName(driverName);//드라이버 불러오기
			conn = DriverManager.getConnection(url, username, password);//DB 연동
			
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			
			resultFlag = pstmt.executeUpdate();//정보 수정 성공하면 1로 값이 변경
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return resultFlag;//1이면 정보수정 성공
		
	}
	
	public int delete(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM members WHERE id=?";
		
		int resultFlag = 0;
		
		try {
			Class.forName(driverName);//드라이버 불러오기
			conn = DriverManager.getConnection(url, username, password);//DB 연동
			
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, id);
			
			
			resultFlag = pstmt.executeUpdate();//성공하면 1로 값이 변경
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return resultFlag;//1이면 정보삭제 성공
		
	}
	
	
	
	
}
