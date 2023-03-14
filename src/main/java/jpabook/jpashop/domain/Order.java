package jpabook.jpashop.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {    //콘텐츠 느낌

    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne  //member 는 하나, orders 는 여러개를 의미
    @JoinColumn(name="member_id") //fk 의 이름이 member_id 가 된다.
    private Member member;  //order와 member는 다대일 관계

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne   //엑세스를 많이 사용하는 쪽에 FK를 놓는게 좋다. 일대일은 사실 딱히 상관이 없긴하다.
    @JoinColumn(name="delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OderStatus status;  //주문상태 [ORDER, CANCEL]
}
