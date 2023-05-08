package gr.hatz.ic.insuranceoffice.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "INSURANCE_AGENTS")
public class InsuranceAgent {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "INSURANCE_COMPANY")
    private String insuranceCompany;

    @OneToMany(mappedBy = "insuranceAgent", cascade = CascadeType.ALL)
    private Set<Customer> customers = new HashSet<>();

    @OneToMany(mappedBy = "insuranceAgent", cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<>();

    public InsuranceAgent(Long id, String firstName, String lastName, String phoneNumber, String address,
                          String insuranceCompany) {
        this.id = id;
        this.firstname = firstName;
        this.lastname = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.insuranceCompany = insuranceCompany;
    }
}
