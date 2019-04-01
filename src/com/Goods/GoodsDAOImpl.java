package com.Goods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GoodsDAOImpl implements GoodsDAO_interface {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "WESHARE";
	private static final String PASSEARD = "123456";

	private static final String INSTER_STMT = "INSERT INTO Goods VALUES (('GD'||LPAD(to_char(Goods_seq.NEXTVAL), 5, '0')),'TC00001',?,?,?,?,?)";
	private static final String UPDATE_STMT = "UPDATE Goods SET goodId = ?, teacherId = ?, goodName = ?, goodPrice = ?, goodInfo = ?, goodImg = ?,"
			+ "goodStatus = ? WHERE goodId = ?";
	private static final String FINDBYPK_STMT = "SELECT * FROM Goods WHERE GoodId = ?";
	private static final String DELETE_STMT = "DELETE FROM GOODS WHERE GOODID = ?";// DELETE FROM GOODS WHERE GOODID =
																					// 'GD00011';

	@Override
	public void add(GoodsVO goodVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSEARD);
			pstmt = con.prepareStatement(INSTER_STMT);

			pstmt.setString(1, goodVO.getGoodName());
			pstmt.setDouble(2, goodVO.getGoodPrice());
			pstmt.setString(3, goodVO.getGoodInfo());
			pstmt.setBytes(4, goodVO.getGoodImg());
			pstmt.setDouble(5, goodVO.getGoodStatus());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt == null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			if (con == null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(GoodsVO goodVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSEARD);
			pstmt = con.prepareStatement(UPDATE_STMT);			
			
			pstmt.setString(1, goodVO.getGoodId());
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String goodId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSEARD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setString(1, goodId);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt == null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			if (con == null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public GoodsVO findByPK(String goodId) {
		GoodsVO goods = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSEARD);
			pstmt = con.prepareStatement(FINDBYPK_STMT);

			pstmt.setString(1, goodId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				goods = new GoodsVO();
				goods.setGoodId(rs.getString("goodId"));
				goods.setTeacherId(rs.getString("teacherId"));
				goods.setGoodName(rs.getString("goodName"));
				goods.setGoodPrice(rs.getDouble("goodPrice"));
				goods.setGoodInfo(rs.getString("goodInfo"));
				goods.setGoodImg(rs.getBytes("goodImg"));
				goods.setGoodStatus(rs.getDouble("goodStatus"));
			}

		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (pstmt == null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			if (con == null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return goods;
	}

	@Override
	public List<GoodsVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {

		GoodsDAOImpl dao = new GoodsDAOImpl();

		// add
//		GoodsVO goods1 = new GoodsVO();		
//		goods1.setGoodName("深入淺出Servlet");
//		goods1.setGoodPrice(new Double(7788));
//		goods1.setGoodInfo(null);
//		goods1.setGoodImg(null);
//		goods1.setGoodStatus(new Double (0));
//		System.out.println(goods1);
//		dao.add(goods1);
//		System.out.println("add = " + dao);
		//update
		
		// delete
//		dao.delete("GD00016");
		// findByPK
//		GoodsVO goods = dao.findByPK("GD00001");
//		System.out.println(goods.getGoodId());
//		System.out.println(goods.getTeacherId());
//		System.out.println(goods.getGoodName());
//		System.out.println(goods.getGoodPrice());
//		System.out.println(goods.getGoodInfo());
//		System.out.println(goods.getGoodImg());
//		System.out.println(goods.getGoodStatus());
	}
}
