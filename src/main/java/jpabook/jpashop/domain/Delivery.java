package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Delivery {
    @Id @GeneratedValue
    @Column(name="dilivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)//ORDINAL 은 숫자로되는데 다른 상태가 생기면 꼬인다. String 으로 써서 막아야한다.
    private DeliveryStatus status; //READY, COMP
}
