package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Result;

import connection.dataConnection;
import model.usermodel;

public class userdao {
	// insertdata
	public static void insertdata(usermodel um) {
		try {
			Connection conn = dataConnection.connectmethod();
			String sql = "insert into register_user (name,email,contact,password) values (?,?,?,?)";
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, um.getName());
			pStatement.setString(2, um.getEmail());
			pStatement.setLong(3, um.getContact());
			pStatement.setString(4, um.getPassword());
			pStatement.executeUpdate();
			System.out.println("data inserted");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// check email
	public static boolean chkemail(String email) {
		boolean flag = false;
		try {
			Connection conn = dataConnection.connectmethod();
			String sql = "select * from register_user where email = ?";
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, email);
			ResultSet rset = pStatement.executeQuery();
			if (rset.next()) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	// login
	public static usermodel login(usermodel um) {
		usermodel m1 = null;
		try {
			Connection conn = dataConnection.connectmethod();
			String sql = "select * from register_user where email = ? and password = ?";
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, um.getEmail());
			pStatement.setString(2, um.getPassword());
			ResultSet rSet = pStatement.executeQuery();
			if (rSet.next()) {
				m1 = new usermodel();
				m1.setId(rSet.getInt("id"));
				m1.setName(rSet.getString("name"));
				m1.setEmail(rSet.getString("email"));
				m1.setContact(rSet.getLong("contact"));
				m1.setPassword(rSet.getString("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return m1;
	}

	// get all detail
	public static usermodel getalldata(int id) {
		usermodel um = null;
		try {
			Connection conn = dataConnection.connectmethod();
			String sql = "select * from register_user where id = ?";
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, id);
			ResultSet rSet = pStatement.executeQuery();
			if (rSet.next()) {
				um = new usermodel();
				um.setId(rSet.getInt("id"));
				um.setName(rSet.getString("name"));
				um.setContact(rSet.getLong("contact"));
				um.setEmail(rSet.getString("email"));
				um.setPassword(rSet.getString("password"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return um;
	}

	public static void updatadata(usermodel um) {
		try {
			Connection conn = dataConnection.connectmethod();
			String sql = "update register_user set name=?,email=?,contact=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, um.getName());
			pst.setString(2, um.getEmail());
			pst.setLong(3, um.getContact());
			pst.setInt(4, um.getId());
			pst.executeUpdate();
			System.out.println("Updated");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
