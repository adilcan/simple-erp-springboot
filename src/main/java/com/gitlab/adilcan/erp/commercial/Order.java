package com.gitlab.adilcan.erp.commercial;

import com.gitlab.adilcan.erp.commercial.enumeration.*;
import com.gitlab.adilcan.erp.domain.BaseEntity;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_table")
public class Order extends BaseEntity{

    private String reference;

    @ManyToOne
    private Customer customer;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date plannedDateDelivery;

    private PaymentTerms paymentTerms;

    private PaymentTypes paymentTypes;

    private AvailabilityDelay availabilityDelay;

    private ShippingMethod shippingMethod;

    private Source source;

    private DefaultDocTemplate defaultDocTemplate;

    private IncoTerms incoTerms;

    private Currency currency;

    @Lob
    private String publicNote;

    @Lob
    private String privateNote;
}
