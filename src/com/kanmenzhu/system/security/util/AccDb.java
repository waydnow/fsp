package com.kanmenzhu.system.security.util;

import java.sql.*;
import com.wondersgroup.bswsj_ch.util.Constant;

public class AccDb {
	String sDBDriver = "com.sybase.jdbc3.jdbc.SybDriver";

	String sConnStr = "jdbc:sybase:Tds:192.168.1.11:5000/BSNW";//��jawsj�����ļ��϶�ȡ��

	private String user = "sa";

	private String pwd = "wonders_bsws305";

	private Connection conn = null;

	private Statement stmt = null;
	
	private CallableStatement cstmt;   

	ResultSet rs = null;

	public AccDb() {
		try {
			Class.forName(sDBDriver);
			conn = DriverManager.getConnection(sConnStr, user, pwd);
			//cstmt= conn.prepareCall("{call check_data(?,?,?)}");//�洢���check_data ʵ�ֶԱȲ�������T_WS_YDKB_REPORT
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println("virtual_1():" + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	}

	/**
	 * ִ�в�ѯ����
	 * @param sql Ҫִ�е�����SQL��䡣
	 * @return ���ؼ�¼����
	 */
	public ResultSet executeQuery(String sql) {
		rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException ex) {
			System.err.println("aq.executeQuery:" + ex.getMessage());
		}
		return rs;
	}

	
	/**
	 * ִ�и��²١�
	 * @param sql Ҫִ�е�����SQL��䡣
	 * @return �ɹ�����0��ʧ�ܷ���1
	 */
	public int executeUpdate(String sql) {
//		System.out.println("UP_sql:" + sql);
		try {
			stmt.executeQuery(sql);
			return 0;//sucess
		} catch (SQLException ex) {
			System.err.println("aq.executeQuery:" + ex.getMessage());
			return 1;//failed
		}
	}
	/**
	 * ��currentYm ��oldYm1��oldYm2֮���ƽ��ֵ���жԱȣ��ɹ�����0��ʧ�ܷ���1��
	 * @param currentYm ҪУ�������
	 * @param oldYm1 �Աȷ�Χȷ��������1
	 * @param oldYm2 �Ա�ȷ��������2
	 * �Ա�N����ƽ��N=oldYm2-oldYm1
	 * @return �ɹ�����0��ʧ�ܷ���1
	 */
	public int executeProc(String currentYm,String oldYm1,String oldYm2){
		try {
			cstmt.setString(1,currentYm);
			cstmt.setString(2, oldYm1);
			cstmt.setString(3, oldYm2);
			cstmt.execute();
			cstmt.close();
			return(0);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				cstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return(1);//failed
			}
			return(1);//failed
		}
	
		
	}
	/**
	 * 
	 *
	 */
	public void Connect() {
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void disConnect() {
		closeStmt();
		closeConn();

	}

	private void closeStmt() {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
