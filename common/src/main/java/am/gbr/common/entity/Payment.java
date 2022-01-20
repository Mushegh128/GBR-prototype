package am.gbr.common.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double size;
    private boolean isSynchronized;
    private LocalDateTime createdDateTime;
    @Enumerated(value = EnumType.STRING)
    private PaymentStatus paymentStatus;
    private String companyRegisterNumber;
    private String serialNumber;
    @ManyToOne
    private User fromUser;
    @ManyToOne
    @JoinColumn(name = "order_basket_id")
    private Order order;
}
