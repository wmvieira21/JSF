package list_table;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class StudentDataUtil {
	
	private List<Student> listStudents;
	
	public StudentDataUtil() {
		this.loadStudents();
	}
	
	private void loadStudents() {
		this.listStudents = new ArrayList<>();
		this.listStudents.add(new Student("william", "Vieira"));
		this.listStudents.add(new Student("Joye", "Tri"));
		this.listStudents.add(new Student("Rachel", "Green"));
		this.listStudents.add(new Student("teste", "Green"));
	}

	public List<Student> getListStudents() {
		return listStudents;
	}

	public void setListStudents(List<Student> listStudents) {
		this.listStudents = listStudents;
	}
	
}
