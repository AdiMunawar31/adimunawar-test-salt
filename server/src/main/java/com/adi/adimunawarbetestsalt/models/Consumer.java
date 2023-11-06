package com.adi.adimunawarbetestsalt.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumer {
  @Id
  private Long id;
  private String nama;
  private String alamat;
  private String kota;
  private String provinsi;
  private LocalDateTime tglRegistrasi;
  private String status;
}
