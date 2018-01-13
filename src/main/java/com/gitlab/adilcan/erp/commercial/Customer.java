package com.gitlab.adilcan.erp.commercial;

import com.gitlab.adilcan.erp.commercial.enumeration.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

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


}

