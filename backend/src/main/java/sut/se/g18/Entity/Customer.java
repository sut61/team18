package sut.se.g18.Entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
@Entity
@Data
@Getter @Setter
@ToString
@EqualsAndHashCode
@Table(name = "Customer")
public class Customer {
  @Id
  @SequenceGenerator(name="customer_seq",sequenceName="customer_seq")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_seq")
  @Column(name="Customer_ID",unique = true, nullable = false)
  private @NonNull Long customerid;
  private @NonNull String customername;
  private @NonNull String customeraddress;
  private @NonNull String customeremail;
  private @NonNull String customerphone;
  private @NonNull String customerpass;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name = "countrycodeid")
  private CountryCode country;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name = "sexid")
  private Sex sex;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name = "titlenameid")
  private TitleName title;


  public Customer() {

  }

  public Customer(String customername,String customeraddress,
                  String customeremail,String customerphone, String customerpass) {
    this.customername = customername;
    this.customeraddress = customeraddress;
    this.customeremail = customeremail;
    this.customerphone = customerphone;
    this.customerpass= customerpass;

  }

  public  void setTitleName(TitleName ti){
    this.title = ti;
  }

  public TitleName getTitleName(){
    return this.title;
  }
  public  void setCustomersex(Sex sex){
    this.sex = sex;
  }

  public Sex getCustomersex(){
    return this.sex;
  }

  public void setCountry(CountryCode country) {
    this.country = country;
  }

  public CountryCode getCountry() {
    return this.country;
  }

  public void setCustomerid(Long customerid) {
    this.customerid = customerid;
  }

  public Long getCustomerid() {
    return customerid;
  }

  public void setCustomername(String customername) {
    this.customername = customername;
  }

  public String getCustomername() {
    return customername;
  }

  public void setCustomeraddress(String customeraddress) {
    this.customeraddress = customeraddress;
  }

  public String getCustomeraddress() {
    return customeraddress;
  }

  public void setCustomeremail(String customeremail) {
    this.customeremail = customeremail;
  }

  public String getCustomeremail() {
    return customeremail;
  }

  public void setCustomerphone(String customerphone) {
    this.customerphone = customerphone;
  }

  public String getCustomerphone() {
    return customerphone;
  }

  public void setCustomerpass(String customerpass){this.customerpass = customerpass;}

  public String getCustomerpass() { return customerpass; }
}
