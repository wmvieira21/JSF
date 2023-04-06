package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;

import model.Student;
import util.StudentDbUtil;

@ManagedBean
@SessionScoped
public class StudentController {

	private List<Student> students;
	private StudentDbUtil studentDbUtil;
	private Logger logger = Logger.getLogger(getClass().getName());
	private Student std;

	public StudentController() throws NamingException {
		students = new ArrayList<>();
		studentDbUtil = StudentDbUtil.getInstance();
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void loadStudents() {
		try {
			logger.info("Loading students");
			students.clear();
			students = studentDbUtil.getStudents();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error loading students", e);
			addErrorMessageTela(e);
		}

	}

	public String loadStudent(int id) {
		try {
			logger.info("Loading single student");

			students.forEach(studentList -> {
				if (studentList.getId() == id) {
					std = studentList;
				}
			});

			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("student", std);

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error loading single students", e);
			addErrorMessageTela(e);
		}
		return "update-student.xhtml";
	}

	public String addStudent(Student student) {
		try {
			logger.info("Adding students" + student);
			studentDbUtil.addStudent(student);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error adding student", e);
			addErrorMessageTela(e);
		}
		return "teste-db.xhtml";
	}

	public String updateStudent(Student student) {
		try {
			logger.info("Update student" + student);
			studentDbUtil.updateStudent(student);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error updating student", e);
			addErrorMessageTela(e);
		}
		return "teste-db?faces-redirect=true";
	}

	public String deleteStudent(int id) {
		try {
			logger.info("delete student" + id);
			studentDbUtil.deleteStudent(id);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error delete student", e);
			addErrorMessageTela(e);
		}
		return "teste-db?faces-redirect=true";
	}

	private void addErrorMessageTela(Exception e) {
		FacesMessage message = new FacesMessage(e.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
