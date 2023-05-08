package gr.hatz.ic.insuranceoffice.Model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "APPOINTMENTS")
public class Appointment {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "APPOINTMENT_DATE")
    private LocalDateTime appointmentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INSURANCE_AGENT_ID")
    private InsuranceAgent insuranceAgent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customerId;

    public Appointment(Long id, LocalDateTime appointmentDate, InsuranceAgent insuranceAgent, Customer customer) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.insuranceAgent = insuranceAgent;
        this.customerId = customer;
    }
}