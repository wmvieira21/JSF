package tour;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TourBean {

	private String kindOfTour;

	public TourBean() {

	}

	public String getKindOfTour() {
		return kindOfTour;
	}

	public void setKindOfTour(String kindOfTour) {
		this.kindOfTour = kindOfTour;
	}

	public String starTour() {
		if (this.kindOfTour.equalsIgnoreCase("CITY")) {
			return "city_tour";
		} else {
			return "country_tour";
		}
	}

}
