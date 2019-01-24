package sut.se.g18.Model;
import lombok.*;

@Data
@Getter
@Setter

public class DataLendEquipment{
    private Long cleaningId;
    private Long customerId;
    private Long electricId;
    private Long lendId;
    private Long maidId;

    private String lendData;

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
    public Long getElectricId() {
        return electricId;
    }
    public void setElectricId(Long electricId) {
        this.electricId = electricId;
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

    



}