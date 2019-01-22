package sut.se.g18.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "ADMINACCOUNT")
public class AdminAccountEntity {
    @Id
    @SequenceGenerator(name="admin_seq",sequenceName="admin_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="admin_seq")
    @Column(name="adminId",unique = true, nullable = false)
    private @NonNull Long adminId;
    private @NonNull String adminUsername;
    private @NonNull String adminPassword;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
