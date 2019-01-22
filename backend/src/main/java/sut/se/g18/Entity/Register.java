package sut.se.g18.Entity;
import lombok.NonNull;

public class Register {
    private @NonNull Long maidId;
    private @NonNull String maidName;
    private @NonNull String maidAddress;
    private @NonNull String maidEmail;
    private @NonNull String maidPhone;

    public Long getMaidId() { return maidId; }
    public void setMaidId(Long maidId) {
        this.maidId = maidId;
    }
    public String getMaidName() {
        return maidName;
    }
    public void setMaidName(String maidName) {
        this.maidName = maidName;
    }
    public String getMaidAddress() {
        return maidAddress;
    }
    public void setMaidAddress(String maidAddress) {
        this.maidAddress = maidAddress;
    }
    public String getMaidEmail() {
        return maidEmail;
    }
    public void setMaidEmail(String maidEmail) {
        this.maidEmail = maidEmail;
    }
    public String getMaidPhone() {
        return maidPhone;
    }
    public void setMaidPhone(String maidPhone) {
        this.maidPhone = maidPhone;
    }


}
