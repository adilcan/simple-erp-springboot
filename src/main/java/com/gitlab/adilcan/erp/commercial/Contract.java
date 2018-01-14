package com.gitlab.adilcan.erp.commercial;


import com.gitlab.adilcan.erp.domain.BaseEntity;
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
public class Contract extends BaseEntity {

    private String reference;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private ThirdParty thirdParty;

    @OneToOne
    private Contract followingUpContract;

    @OneToOne
    private Contract signingContract;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Lob
    private String publicNote;

    @Lob
    private String privateNote;

}
