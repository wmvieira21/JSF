package custom;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UICommand;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
public class StudentCustom {

	private String firstName;
	private String lastName;
	private String courseCode;

	public StudentCustom() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public void validadeCourseCode(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {

		if (value == null) {
			return;
		}
		String data = value.toString().toUpperCase();

		if (!data.startsWith("LUV")) {
			throw new ValidatorException(new FacesMessage("Course code must start with LUV"));
		}
	}
}
