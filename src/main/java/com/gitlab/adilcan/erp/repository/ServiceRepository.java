package com.gitlab.adilcan.erp.repository;

import com.gitlab.adilcan.erp.domain.PurchaseStatus;
import com.gitlab.adilcan.erp.domain.SaleStatus;
import com.gitlab.adilcan.erp.domain.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Long>{

	List<Service> findBySaleStatusAndPurchaseStatus(SaleStatus saleStatus, PurchaseStatus purchaseStatus);

	int countBySaleStatusAndPurchaseStatus(SaleStatus saleStatus, PurchaseStatus purchaseStatus);

}
