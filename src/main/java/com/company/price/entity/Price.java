package com.company.price.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "PRICE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
public class Price {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotNull
    private Integer brandId;

    @NotNull
    private Timestamp startDate;

    @NotNull
    private Timestamp endDate;

    @NotNull
    private Integer priceList;

    @NotNull
    private Integer productId;

    @NotNull
    private Integer priority;

    @NotNull
    private Float price;

    @NotNull
    private String currency;

}
