package com.sparta.company.domain.service;

import com.sparta.company.infrastructure.dto.GetHubInfoRes;
import java.util.UUID;
import org.springframework.http.ResponseEntity;

public interface HubClientService {
    ResponseEntity<GetHubInfoRes> getHub(UUID hubId);
}