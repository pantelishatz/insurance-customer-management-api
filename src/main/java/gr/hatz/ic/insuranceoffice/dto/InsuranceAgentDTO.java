package gr.hatz.ic.insuranceoffice.dto;
import gr.hatz.ic.insuranceoffice.Model.Appointment;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InsuranceAgentDTO extends CustomerDTO  {
    private Long id;
    private String Firstname;
    private String Lastname;
    private String phoneNumber;
    private String address;
    private String insuranceCompany;

    public InsuranceAgentDTO(Long id, String firstname, String lastname, String phoneNumber, String address, String insuranceCompany) {
        this.id = id;
        Firstname = firstname;
        Lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.insuranceCompany = insuranceCompany;
    }
}



