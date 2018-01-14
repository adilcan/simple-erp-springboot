package com.gitlab.adilcan.erp.commercial;

import com.gitlab.adilcan.erp.commercial.enumeration.*;
import com.gitlab.adilcan.erp.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer extends ThirdParty{


    private String customerReference;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Source source;

    private AvailabilityDelay availabilityDelay;

    private ShippingMethod shippingMethod;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliveryDate;

    private IncoTerms incoTerms;

    private DefaultDocTemplate defaultDocTemplate;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

}

