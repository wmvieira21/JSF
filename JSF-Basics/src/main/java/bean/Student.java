package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Student {

	private String firstName;
	private String lastName;
	private String city;
	private String favoriteLanguage;
	private List<String> listCountryOptions = new ArrayList<>();
	private String[] listFavoriteLanguages = {""};

	// must have a no-args constructor
	public Student() {
		this.listCountryOptions.add("Brazil");
		this.listCountryOptions.add("India");
		this.listCountryOptions.add("Germany");
		this.listCountryOptions.add("Sweden");
		
		this.firstName = "default";
		this.lastName = "default";
		this.city = "UK";
		this.favoriteLanguage = "JAVA";
		this.listFavoriteLanguages[0] = "JAVA";
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getListCountryOptions() {
		return listCountryOptions;
	}

	public void setListCountryOptions(List<String> listCountryOptions) {
		this.listCountryOptions = listCountryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String[] getListFavoriteLanguages() {
		return listFavoriteLanguages;
	}

	public void setListFavoriteLanguages(String[] listFavoriteLanguages) {
		this.listFavoriteLanguages = listFavoriteLanguages;
	}	
}
