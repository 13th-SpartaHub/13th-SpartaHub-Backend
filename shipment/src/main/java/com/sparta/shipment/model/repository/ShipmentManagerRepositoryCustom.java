package com.sparta.shipment.model.repository;

import com.sparta.shipment.domain.dto.ShipmentManagerSearchDto;
import com.sparta.shipment.domain.dto.response.GetShipmentManagerResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShipmentManagerRepositoryCustom {

    Page<GetShipmentManagerResponseDto> searchShipmentManagers(ShipmentManagerSearchDto searchDto, Pageable pageable);
}