package com.moon.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.moon.app.JDBCUtil;

public class MVCBoardDao {

	// 게시글 전체 출력
	public List<MVCBoardDto> selectAll(){
		// db 연결
		Connection con = JDBCUtil.connect();
		Statement stmt = null;
		ResultSet rs = null;
		List<MVCBoardDto> res = new ArrayList<MVCBoardDto>();

		// 쿼리 실행 준비
		String sql = "SELECT * FROM MVCBOARD";

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				MVCBoardDto tmp = new MVCBoardDto();
				tmp.setBd_no(rs.getInt(1));
				tmp.setBd_name(rs.getString(2));
				tmp.setBd_title(rs.getString(3));
				tmp.setBd_content(rs.getString(4));
				tmp.setBd_date(rs.getDate(5));

				res.add(tmp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return res;
	}
	// 게시글 하나 출력
	public MVCBoardDto selectOne(int bd_no){
		// db 연결
		Connection con = JDBCUtil.connect();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MVCBoardDto res = new MVCBoardDto();

		// 쿼리 실행 준비
		String sql = "SELECT * FROM MVCBOARD WHERE BD_NO=?";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, bd_no);

			rs = pstm.executeQuery();

			while(rs.next()) {
				res.setBd_no(rs.getInt(1));
				res.setBd_name(rs.getString(2));
				res.setBd_title(rs.getString(3));
				res.setBd_content(rs.getString(4));
				res.setBd_date(rs.getDate(5));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstm, con);
		}

		return res;
	}
	// 글쓰기
	public int insert(MVCBoardDto dto){
		Connection con = JDBCUtil.connect();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " INSERT INTO MVCBOARD VALUES(MVCBD_SEQ.NEXTVAL,?,?,?,SYSDATE)";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getBd_name());
			pstm.setString(2, dto.getBd_title());
			pstm.setString(3, dto.getBd_content());
			
			res = pstm.executeUpdate();
			
			if(res>0) {
				JDBCUtil.commit(con);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstm, con);
		}
		return res;
	}
	
	// 글 수정
	public int update(MVCBoardDto dto){
		Connection con = JDBCUtil.connect();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " UPDATE MVCBOARD SET BD_TITLE=?,BD_CONTENT=? WHERE BD_NO=?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getBd_title());
			pstm.setString(2, dto.getBd_content());
			pstm.setInt(3, dto.getBd_no());
			
			res = pstm.executeUpdate();
			
			if(res>0) {
				JDBCUtil.commit(con);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstm, con);
		}
		return res;
	}
	// 글 삭제
	public int delete(MVCBoardDto dto){
		return 0;
	}
	// 글 여러개 삭제 (멀티삭제)
	public int multiDelete(String[] bd_no){
		Connection con = JDBCUtil.connect();
		PreparedStatement pstm = null;
		int res = 0;
		int[] cnt = null;
		
		String sql = " DELETE FROM MVCBOARD WHERE BD_NO=?";
		
		try {
			pstm = con.prepareStatement(sql);
			for(int i=0; i<bd_no.length; i++) {
				pstm.setString(1, bd_no[i]);
				pstm.addBatch();
			}
			cnt = pstm.executeBatch();
			
			for(int i = 0; i<cnt.length; i++) {
				if(cnt[i]==-2) {
					res++;
				}
			}
			
			if(bd_no.length==res) {
				JDBCUtil.commit(con);
				
			} else {
				JDBCUtil.rollback(con);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstm, con);
		}
		return res;
	}



}
