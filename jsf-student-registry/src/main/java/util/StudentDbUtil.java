package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Student;

public class StudentDbUtil {

	private static StudentDbUtil instance;
	private DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/web_student_tracker";

	private StudentDbUtil() throws NamingException {
		dataSource = getDataSource();
	}

	public static StudentDbUtil getInstance() throws NamingException {
		if (instance == null) {
			instance = new StudentDbUtil();
		}
		return instance;
	}

	private DataSource getDataSource() throws NamingException {
		Context context = new InitialContext();
		DataSource dataSourse = (DataSource) context.lookup(jndiName);
		return dataSourse;
	}

	private Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public List<Student> getStudents() throws SQLException {
		List<Student> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			st = conn.prepareStatement("select * from student");
			rs = st.executeQuery();

			while (rs.next()) {
				list.add(new Student(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("email")));
			}
		} finally {
			close(conn, st, rs);
		}
		return list;
	}

	public void addStudent(Student s) throws SQLException {

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = getConnection();
			st = conn.prepareStatement("insert into student (first_name, last_name, email) values (?,?,?)");
			st.setString(1, s.getFirstName());
			st.setString(2, s.getLastName());
			st.setString(3, s.getEmail());
			st.executeUpdate();

		} finally {
			close(conn, st, null);
		}

	}

	public void updateStudent(Student student) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = getConnection();
			st = conn.prepareStatement("update student set first_name=?, last_name=?, email=? where id=?");
			st.setString(1, student.getFirstName());
			st.setString(2, student.getLastName());
			st.setString(3, student.getEmail());
			st.setInt(4, student.getId());
			st.executeUpdate();

		} finally {
			close(conn, st, null);
		}
	}
	public void deleteStudent(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = getConnection();
			st = conn.prepareStatement("delete from student where id=?");
			st.setInt(1, id);
			st.executeUpdate();
			
		} finally {
			close(conn, st, null);
		}
	}

	private void close(Connection conn, PreparedStatement pre, ResultSet result) throws SQLException {
		if (conn != null) {
			conn.close();
		}
		if (pre != null) {
			pre.close();
		}
		if (result != null) {
			result.close();
		}
	}
}
