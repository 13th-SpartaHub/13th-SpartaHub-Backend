package com.sparta.shipment.domain.dto.request;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateShipmentManagerRequestDto {

    private UUID inHubId;
    private String managerType;
    private Boolean isShipping;


}
