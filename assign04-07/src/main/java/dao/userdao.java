package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.dataconnect;
import model.usermodel;

public class userdao {
	public static void insertuser(usermodel um) {
		try {
			Connection connection = dataconnect.connect();
			String sql = "insert into projecttbl (fname,lname,email,gender,contact,password) values (?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, um.getFname());
			pst.setString(2, um.getLname());
			pst.setString(3, um.getEmail());
			pst.setString(4, um.getGender());
			pst.setLong(5, um.getContact());
			pst.setString(6, um.getPassword());
			pst.executeUpdate();
			System.out.println("User Registered..");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static usermodel login(String email, String password) {
		usermodel um = null;
		try {
			Connection conncetion = dataconnect.connect();
			String sql = "select * from projecttbl where email = ? and password= ?";
			PreparedStatement pStatement = conncetion.prepareStatement(sql);
			pStatement.setString(1, email);
			pStatement.setString(2, password);
			ResultSet rSet = pStatement.executeQuery();
			if (rSet.next()) {
				um = new usermodel();
				um.setFname(rSet.getString("fname"));
				um.setLname(rSet.getString("lname"));
				um.setContact(rSet.getLong("contact"));
				um.setEmail(rSet.getString("email"));
				um.setGender(rSet.getString("gender"));
				um.setPassword(rSet.getString("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return um;

	}

	// list of all user
	public static List<usermodel> alluser() {
		List<usermodel> list = new ArrayList<>();
		try {
			Connection connection = dataconnect.connect();
			String sql = "select * from projecttbl";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet rSet = pStatement.executeQuery();
			if (rSet.next()) {
				usermodel um = new usermodel();
				um.setId(rSet.getInt("id"));
				um.setFname(rSet.getString("fname"));
				um.setContact(rSet.getLong("contact"));
				um.setEmail(rSet.getString("email"));
				um.setGender(rSet.getString("gender"));
				um.setLname(rSet.getString("lname"));
				um.setPassword(rSet.getString("password"));
				list.add(um);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	// to get all user by id
	public static usermodel getAllUserById(int id) {
		usermodel um = null;
		try {
			Connection connection = dataconnect.connect();
			String sql = "select * from projecttbl where id = ?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			ResultSet rSet = pStatement.executeQuery();
			if (rSet.next()) {
				um = new usermodel();
				um.setId(rSet.getInt("id"));
				um.setFname(rSet.getString("fname"));
				um.setLname(rSet.getString("lname"));
				um.setContact(rSet.getLong("contact"));
				um.setEmail(rSet.getString("email"));
				um.setGender(rSet.getString("gender"));
				um.setPassword(rSet.getString("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return um;

	}

	// to update by id
	public static void updateuser(usermodel um) {
		
		try {
			Connection connection = dataconnect.connect();
			String sql = "update projecttbl set fname = ?,lname=?,email=?,gender=?,contact=? where id = ?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, um.getFname());
			pStatement.setString(2, um.getLname());
			pStatement.setString(3, um.getEmail());
			pStatement.setString(4, um.getGender());
			pStatement.setLong(5, um.getContact());
			pStatement.setInt(6, um.getId());
			pStatement.executeUpdate();
			System.out.println("Updated..");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
