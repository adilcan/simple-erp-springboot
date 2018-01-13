package com.gitlab.adilcan.erp.commercial;

import com.gitlab.adilcan.erp.commercial.enumeration.Currency;
import com.gitlab.adilcan.erp.commercial.enumeration.PaymentTerms;
import com.gitlab.adilcan.erp.commercial.enumeration.PaymentTypes;
import com.gitlab.adilcan.erp.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ThirdParty extends BaseEntity {

    private String reference;

    private PaymentTerms paymentTerms;

    private PaymentTypes paymentTypes;

    @Lob
    private String publicNote;

    @Lob
    private String privateNote;

    private Currency currency;

}
