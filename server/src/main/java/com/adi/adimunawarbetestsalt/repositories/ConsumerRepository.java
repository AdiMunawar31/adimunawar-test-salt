package com.adi.adimunawarbetestsalt.repositories;

import java.util.List;

import com.adi.adimunawarbetestsalt.models.Consumer;

public interface ConsumerRepository {
  int save(Consumer consumer);

  int update(Consumer consumer);

  Consumer findById(Long id);

  int deleteById(Long id);

  List<Consumer> findAll();
}
