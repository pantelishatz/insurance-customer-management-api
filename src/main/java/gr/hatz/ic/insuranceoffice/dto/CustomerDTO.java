package gr.hatz.ic.insuranceoffice.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDTO  {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    public CustomerDTO(Long id, String firstName, String lastName, String phoneNumber, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
