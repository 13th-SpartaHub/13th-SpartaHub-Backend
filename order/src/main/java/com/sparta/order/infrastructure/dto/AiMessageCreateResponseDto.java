package com.sparta.order.infrastructure.dto;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AiMessageCreateResponseDto {
  private UUID aiMessageId;
  private String content;
}