package beans;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("gebruiker")
@RequestScoped
public class GebruikerBean {

	private String naam;
	private Date date;

	public int getLeeftijd() {
		return Period.between(LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date)), LocalDate.now()).getYears();
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}