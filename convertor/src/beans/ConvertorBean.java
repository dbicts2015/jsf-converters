package beans;

import java.math.BigDecimal;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named("convertorBean")
@RequestScoped
// let op ! RequestScoped uit javax.enterprise.context
public class ConvertorBean {
	private Integer intGetal;
	private Double doubleGetal;
	private BigDecimal bedrag;
	private Double percentage;
	private Date datum;
	private Date tijd;
	private Date datumtijd;

	public Integer getIntGetal() {
		return intGetal;
	}

	public void setIntGetal(Integer intGetal) {
		this.intGetal = intGetal;
	}

	public Double getDoubleGetal() {
		return doubleGetal;
	}

	public void setDoubleGetal(Double doubleGetal) {
		this.doubleGetal = doubleGetal;
	}

	public BigDecimal getBedrag() {
		return bedrag;
	}

	public void setBedrag(BigDecimal bedrag) {
		this.bedrag = bedrag;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Date getTijd() {
		return tijd;
	}

	public void setTijd(Date tijd) {
		this.tijd = tijd;
	}

	public Date getDatumtijd() {
		return datumtijd;
	}

	public void setDatumtijd(Date datumtijd) {
		this.datumtijd = datumtijd;
	}

	public void validateDatum(FacesContext context, UIComponent component,
			Object value) {
		System.out.println("invalidator");
		Date datum = (Date) value;
		Date vandaag = new Date();
		if (datum.compareTo(vandaag) > 0) {
			System.out.println("oeps");
			FacesMessage msg = new FacesMessage(
					"Datum moet voor vandaag liggen");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
}
