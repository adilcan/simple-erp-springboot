package com.gitlab.adilcan.erp.service_product;

import com.gitlab.adilcan.erp.service_product.enumeration.PurchaseStatus;
import com.gitlab.adilcan.erp.service_product.enumeration.SaleStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Long>{

	List<Service> findBySaleStatusAndPurchaseStatus(SaleStatus saleStatus, PurchaseStatus purchaseStatus);

	int countBySaleStatusAndPurchaseStatus(SaleStatus saleStatus, PurchaseStatus purchaseStatus);

	List<Service> findBySaleStatus(SaleStatus saleStatus);

}
