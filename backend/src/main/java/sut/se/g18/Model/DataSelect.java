package sut.se.g18.Model;

import lombok.Data;

import sut.se.g18.Entity.*;

@Data
public class DataSelect {
    private String maidName;
    private String maidEmail;
    private String companyName;
    private Long typeworkingDate;
    private Long typeworking;
	/**
	 * @return the maidName
	 */
	public String getMaidName() {
		return maidName;
	}
	/**
	 * @param maidName the maidName to set
	 */
	public void setMaidName(String maidName) {
		this.maidName = maidName;
	}
	/**
	 * @return the maidEmail
	 */
	public String getMaidEmail() {
		return maidEmail;
	}
	/**
	 * @param maidEmail the maidEmail to set
	 */
	public void setMaidEmail(String maidEmail) {
		this.maidEmail = maidEmail;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the typeworkingDate
	 */
	public Long getTypeworkingDate() {
		return typeworkingDate;
	}
	/**
	 * @param typeworkingDate the typeworkingDate to set
	 */
	public void setTypeworkingDate(Long typeworkingDate) {
		this.typeworkingDate = typeworkingDate;
	}
	/**
	 * @return the typeworking
	 */
	public Long getTypeworking() {
		return typeworking;
	}
	/**
	 * @param typeworking the typeworking to set
	 */
	public void setTypeworking(Long typeworking) {
		this.typeworking = typeworking;
	}


    
}