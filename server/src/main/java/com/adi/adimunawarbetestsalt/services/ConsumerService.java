package com.adi.adimunawarbetestsalt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adi.adimunawarbetestsalt.dto.ConsumerDTO;
import com.adi.adimunawarbetestsalt.dto.InputConsumerDTO;
import com.adi.adimunawarbetestsalt.models.Consumer;
import com.adi.adimunawarbetestsalt.repositories.JdbcConsumerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsumerService {
  private final JdbcConsumerRepository consumerRepository;

  public int saveConsumer(InputConsumerDTO consumer) {
    return consumerRepository.save(consumer);
  }

  public int updateConsumer(ConsumerDTO consumer) {
    return consumerRepository.update(consumer);
  }

  public Consumer getConsumerById(Long id) {
    return consumerRepository.findById(id);
  }

  public int deleteConsumerById(Long id) {
    return consumerRepository.deleteById(id);
  }

  public List<Consumer> getAllConsumers() {
    return consumerRepository.findAll();
  }
}
