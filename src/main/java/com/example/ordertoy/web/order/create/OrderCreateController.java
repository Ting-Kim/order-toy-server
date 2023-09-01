package com.example.ordertoy.web.order.create;

import com.example.ordertoy.web.order.create.rqrs.OrderCreateRq;
import com.example.ordertoy.web.order.create.rqrs.OrderCreateRs;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderCreateController {

  private final OrderCreateAppService orderCreateAppService;

  @PostMapping("/orders")
  public ResponseEntity<OrderCreateRs> createOrder(
      @RequestHeader("loginMemberId") UUID actorId,
      @RequestBody OrderCreateRq rq
  ) { // TODO: Return 메시지 정의
    return new ResponseEntity<>(orderCreateAppService.createOrder(actorId, rq),
                                HttpStatusCode.valueOf(200));
  }

}
