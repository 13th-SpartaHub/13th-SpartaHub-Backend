package com.sparta.order.domain.controller;

import com.sparta.order.domain.dto.request.CreateOrderReq;
import com.sparta.order.domain.dto.request.UpdateOredrReq;
import com.sparta.order.domain.dto.response.GetOrderRes;
import com.sparta.order.domain.dto.response.OrderIdRes;
import com.sparta.order.domain.service.OrderService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

  private final OrderService orderService;

  @PostMapping
  public ResponseEntity<OrderIdRes> createOrder(
      @RequestBody CreateOrderReq createOrderReq,
      @RequestHeader("X-User-Username") String requestUsername
      ){
      return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(createOrderReq,requestUsername));
  }

  @GetMapping("/{orderId}")
  public ResponseEntity<GetOrderRes> getOrder(
      @PathVariable UUID orderId,
      @RequestHeader("X-User-Role") String requestRole,
      @RequestHeader("X-User-Username") String requestUsername
  ){
    return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrder(orderId,requestRole,requestUsername));
  }
  @PatchMapping("/{orderId}")
  public ResponseEntity<OrderIdRes> updateOrder(
      @PathVariable UUID orderId,
      @RequestBody UpdateOredrReq updateOredrReq,
      @RequestHeader("X-User-Role") String requestRole,
      @RequestHeader("X-User-Username") String requestUsername
  ){
    return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrder(orderId,updateOredrReq,requestRole,requestUsername));
  }

  @DeleteMapping("/{orderId}")
  public ResponseEntity<OrderIdRes> deleteOrder(
      @PathVariable UUID orderId,
      @RequestHeader("X-User-Role") String requestRole,
      @RequestHeader("X-User-Username") String requestUsername
  ){
    return ResponseEntity.status(HttpStatus.OK).body(orderService.deleteOrder(orderId,requestRole,requestUsername));
  }
  @GetMapping
  public ResponseEntity<PagedModel<GetOrderRes>> getAllOrders(
      @RequestParam(required = false) String username,
      @RequestParam(required = false) UUID requestCompanyId,
      @RequestParam(required = false) UUID receiveCompanyId,
      @RequestParam(required = false) UUID productId,
      @RequestParam(required = false) UUID shipmentId,
      @PageableDefault(sort = "createdAt")Pageable pageable,
      @RequestHeader("X-User-Role") String requestRole,
      @RequestHeader("X-User-Username") String requestUsername
  ) {

    Page<GetOrderRes> resPage = orderService.searchOrders(
        username, requestCompanyId, receiveCompanyId, productId, shipmentId, pageable,requestRole,requestUsername
    );
    return ResponseEntity.status(HttpStatus.OK).body(new PagedModel<>(resPage));
  }

}
