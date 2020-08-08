package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.dao.util.ConnManager;
import com.lti.entity.Product;

public class ProductDao {

	private static String table = "tbl_product";
	private static Connection conn = null;
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;

	public Product select(int id) {

		try {
			conn = ConnManager.connect();

			if (conn == null) {
				throw new Exception("Connection failed");
			}

			String query = "Select * from " + table + " where id=?";

			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice((double) rs.getInt("price"));
				return product;
			}

			return null;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.commit();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	public List<Product> selectAll() {
		List<Product> products = new ArrayList<Product>();

		try {
			conn = ConnManager.connect();

			if (conn == null) {
				throw new Exception("Connection failed");
			}

			String query = "Select * from " + table;

			stmt = conn.prepareStatement(query);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice((double) rs.getInt("price"));
				products.add(product);
			}

			return products;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.commit();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return products;
	}

	public void insert(Product product) {
		try {
			conn = ConnManager.connect();

			if (conn == null) {
				throw new Exception("Connection failed");
			}

			String query = "Insert into " + table + " values(?, ?, ?)";

			stmt = conn.prepareStatement(query);
			stmt.setInt(1, product.getId());
			stmt.setString(2, product.getName());
			stmt.setInt(3, (int) product.getPrice());

			stmt.executeUpdate();
			System.out.println("Data inserted successfully...");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.commit();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}