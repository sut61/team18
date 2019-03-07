package sut.se.g18.Model;
import lombok.*;
import java.sql.Date;
@Data
@Getter
@Setter

public class DataLendEquipment{
    private Long cleaningId;
    private Long customerId;
   
    private Long lendId;
    private Long maidId;

    private String lendData;

    private Date lendstart;
    private Date lendend;

    /**
     * @return the cleaningId
     */
    public Long getCleaningId() {
        return cleaningId;
    }
    public void setCleaningId(Long cleaningId) {
        this.cleaningId = cleaningId;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getLendId() {
        return lendId;
    }
    public void setLendId(Long lendId) {
        this.lendId = lendId;
    }
    public Long getMaidId() {
        return maidId;
    }
    public void setMaidId(Long maidId) {
        this.maidId = maidId;
    }
    public String getLendData() {
        return lendData;
    }
    public void setLendData(String lendData) {
        this.lendData = lendData;
    }
    public Date getLendstart() {
        return lendstart;
    }
    public void setLendstart(Date lendstart) {
        this.lendstart = lendstart;
    }
    public Date getLendend() {
        return lendend;
    }
    public void setLendend(Date lendend) {
        this.lendend = lendend;
    }

    



}