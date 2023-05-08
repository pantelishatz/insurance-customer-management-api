package gr.hatz.ic.insuranceoffice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AppointmentDTO {

    private Long id;
    private LocalDateTime appointmentDate;
    private Long insuranceAgentId;
    private Long customerId;

    public AppointmentDTO(Long id, LocalDateTime appointmentDate, Long insuranceAgentId, Long customerId) {
        this.appointmentDate = appointmentDate;
        this.insuranceAgentId = insuranceAgentId;
        this.customerId = customerId;
    }
}
