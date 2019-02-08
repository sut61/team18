package sut.se.g18.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "CUSTOMER")
public class CustomerEntity {
    @Id
    @SequenceGenerator(name="customer_seq",sequenceName="customer_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_seq")
    @Column(name="customerId",unique = true, nullable = false)
    @NotNull
    private  Long customerId;
    @NotNull
    @Size(min = 2,max = 20)
    private  String customerName;
    @NotNull
    private  String customeraddress;
    @NotNull
    private  String customerEmail;
    @NotNull
    @Pattern(regexp = "^0([0-9])+")
    private  String customerphone;
    @NotNull
    private  String customerpass;
    @NotNull
    private  String customerper;

    @ManyToOne(fetch=FetchType.EAGER, targetEntity = CountryCodeEntity.class)
    private CountryCodeEntity country;

    @ManyToOne(fetch=FetchType.EAGER, targetEntity = SexEntity.class)
    private SexEntity sexEntity;

    @ManyToOne(fetch=FetchType.EAGER, targetEntity = TitleNameEntity.class)
    private TitleNameEntity title;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomeraddress() {
        return customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerphone() {
        return customerphone;
    }

    public void setCustomerphone(String customerphone) {
        this.customerphone = customerphone;
    }

    public String getCustomerpass() {
        return customerpass;
    }

    public void setCustomerpass(String customerpass) {
        this.customerpass = customerpass;
    }

    public String getCustomerper() {
        return customerper;
    }

    public void setCustomerper(String customerper) {
        this.customerper = customerper;
    }

    public CountryCodeEntity getCountry() {
        return country;
    }

    public void setCountry(CountryCodeEntity country) {
        this.country = country;
    }

    public SexEntity getSexEntity() {
        return sexEntity;
    }

    public void setSexEntity(SexEntity sexEntity) {
        this.sexEntity = sexEntity;
    }

    public TitleNameEntity getTitle() {
        return title;
    }

    public void setTitle(TitleNameEntity title) {
        this.title = title;
    }
}
