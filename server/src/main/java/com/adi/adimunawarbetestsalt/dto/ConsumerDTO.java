package com.adi.adimunawarbetestsalt.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerDTO {
  private Long id;
  private String nama;
  private String alamat;
  private String kota;
  private String provinsi;
  private LocalDateTime tglRegistrasi;
  private String status;
}
