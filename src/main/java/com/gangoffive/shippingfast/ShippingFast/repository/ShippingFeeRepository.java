package com.gangoffive.shippingfast.ShippingFast.repository;

import com.gangoffive.shippingfast.ShippingFast.entity.ShippingFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShippingFeeRepository extends JpaRepository<ShippingFee, Long> {
    @Query(value = "SELECT sf FROM tbl_shipping_fee sf WHERE ?1 >= sf.distanceStart AND ?1 < sf.distanceEnd")
    Optional<ShippingFee> findShippingFeeByDistanceRange(double distance);
}
