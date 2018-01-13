package com.gitlab.adilcan.erp.commercial;


import com.gitlab.adilcan.erp.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contract extends BaseEntity {

    private String reference;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private ThirdParty thirdParty;

    private Contract followingUpContract;

    private Contract signingContract;

    private Date date;

    @Lob
    private String publicNote;

    @Lob
    private String privateNote;

}
