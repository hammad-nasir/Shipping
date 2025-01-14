package com.designmyecon.shipping.Shipping.repository;

import com.designmyecon.shipping.Shipping.model.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<Shipment, Long> {
}
