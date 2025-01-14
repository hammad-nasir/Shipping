package com.designmyecon.shipping.Shipping.repository;

import com.designmyecon.shipping.Shipping.model.entity.TrackingEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingEventRepository extends JpaRepository<TrackingEvent, Long> {
}
