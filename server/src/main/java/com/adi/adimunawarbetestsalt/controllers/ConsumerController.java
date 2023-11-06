package com.adi.adimunawarbetestsalt.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adi.adimunawarbetestsalt.dto.ConsumerDTO;
import com.adi.adimunawarbetestsalt.dto.InputConsumerDTO;
import com.adi.adimunawarbetestsalt.models.Consumer;
import com.adi.adimunawarbetestsalt.services.ConsumerService;
import com.adi.adimunawarbetestsalt.utils.constants.ConstantMessage;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/consumer")
@RequiredArgsConstructor
public class ConsumerController {
  private final ConsumerService consumerService;

  @GetMapping
  public ResponseEntity<Object> showConsumerList(Model model) {
    List<Consumer> consumers = consumerService.getAllConsumers();
    return ResponseEntity.ok(consumers);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> showConsumerDetail(@PathVariable Long id, Model model) {
    Consumer consumer = consumerService.getConsumerById(id);
    return ResponseEntity.ok(EntityModel.of(consumer));
  }

  @PostMapping
  public ResponseEntity<String> addConsumer(@RequestBody InputConsumerDTO consumer) {
    consumer.setTglRegistrasi(LocalDateTime.now());
    int result = consumerService.saveConsumer(consumer);

    if (result > 0) {
      return ResponseEntity.status(HttpStatus.CREATED)
          .body(ConstantMessage.APP_SUCCESS_CREATED);
    } else {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(ConstantMessage.CONSUMER_ADD_FAIL);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> editConsumer(@PathVariable Long id, @RequestBody ConsumerDTO consumer) {
    consumer.setId(id);
    int result = consumerService.updateConsumer(consumer);

    if (result > 0) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(ConstantMessage.APP_SUCCESS_UPDATED);
    } else {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(ConstantMessage.CONSUMER_UPDATE_FAIL);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteConsumer(@PathVariable Long id) {
    int result = consumerService.deleteConsumerById(id);

    if (result > 0) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(ConstantMessage.APP_SUCCESS_DELETED);
    } else {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(ConstantMessage.CONSUMER_DELETE_FAIL);
    }
  }
}
