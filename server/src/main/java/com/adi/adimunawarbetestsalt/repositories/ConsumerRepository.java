package com.adi.adimunawarbetestsalt.repositories;

import java.util.List;

import com.adi.adimunawarbetestsalt.dto.ConsumerDTO;
import com.adi.adimunawarbetestsalt.dto.InputConsumerDTO;
import com.adi.adimunawarbetestsalt.models.Consumer;

public interface ConsumerRepository {
  int save(InputConsumerDTO consumer);

  int update(ConsumerDTO consumer);

  Consumer findById(Long id);

  int deleteById(Long id);

  List<Consumer> findAll();
}
