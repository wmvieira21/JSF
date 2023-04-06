package scope;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
//@ApplicationScoped
//@SessionScoped
@RequestScoped
public class Scope {

	private int counter = 0;

	public Scope() {

	}

	public String increment() {
		this.counter++;
		return "AplicationScope";
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	

}
