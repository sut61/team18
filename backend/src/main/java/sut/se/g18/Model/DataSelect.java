package sut.se.g18.Model;

import lombok.Data;

import sut.se.g18.Entity.*;

@Data
public class DataSelect {
    private String maidName;
    private String maidEmail;

    private Long companyId;
    private Long maidId;
    private Long maidStatusId;
    private Long typeworkingId;
    private Long typeworkingDateId;

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
     * @return the companyId
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId the companyId to set
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * @return the maidId
     */
    public Long getMaidId() {
        return maidId;
    }

    /**
     * @param maidId the maidId to set
     */
    public void setMaidId(Long maidId) {
        this.maidId = maidId;
    }

    /**
     * @return the maidStatusId
     */
    public Long getMaidStatusId() {
        return maidStatusId;
    }

    /**
     * @param maidStatusId the maidStatusId to set
     */
    public void setMaidStatusId(Long maidStatusId) {
        this.maidStatusId = maidStatusId;
    }

    /**
     * @return the typeworkingId
     */
    public Long getTypeworkingId() {
        return typeworkingId;
    }

    /**
     * @param typeworkingId the typeworkingId to set
     */
    public void setTypeworkingId(Long typeworkingId) {
        this.typeworkingId = typeworkingId;
    }

    /**
     * @return the typeworkingDateId
     */
    public Long getTypeworkingDateId() {
        return typeworkingDateId;
    }

    /**
     * @param typeworkingDateId the typeworkingDateId to set
     */
    public void setTypeworkingDateId(Long typeworkingDateId) {
        this.typeworkingDateId = typeworkingDateId;
    }

    
}