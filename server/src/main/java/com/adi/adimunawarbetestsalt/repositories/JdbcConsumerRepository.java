package com.adi.adimunawarbetestsalt.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.adi.adimunawarbetestsalt.dto.ConsumerDTO;
import com.adi.adimunawarbetestsalt.dto.InputConsumerDTO;
import com.adi.adimunawarbetestsalt.models.Consumer;

@Repository
public class JdbcConsumerRepository implements ConsumerRepository {
  private final JdbcTemplate jdbcTemplate;

  public JdbcConsumerRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int save(InputConsumerDTO consumer) {
    String sql = "INSERT INTO konsumen (nama, alamat, kota, provinsi, tgl_registrasi, status) " +
        "VALUES (?, ?, ?, ?, ?, ?)";
    return jdbcTemplate.update(sql, consumer.getNama(), consumer.getAlamat(), consumer.getKota(),
        consumer.getProvinsi(), consumer.getTglRegistrasi(), consumer.getStatus());
  }

  @Override
  public int update(ConsumerDTO consumer) {
    Consumer existingConsumer = findById(consumer.getId());

    String nama = consumer.getNama() != null ? consumer.getNama() : existingConsumer.getNama();
    String alamat = consumer.getAlamat() != null ? consumer.getAlamat() : existingConsumer.getAlamat();
    String kota = consumer.getKota() != null ? consumer.getKota() : existingConsumer.getKota();
    String provinsi = consumer.getProvinsi() != null ? consumer.getProvinsi() : existingConsumer.getProvinsi();
    LocalDateTime tglRegistrasi = consumer.getTglRegistrasi() != null ? consumer.getTglRegistrasi()
        : existingConsumer.getTglRegistrasi();
    String status = consumer.getStatus() != null ? consumer.getStatus() : existingConsumer.getStatus();

    String sql = "UPDATE konsumen SET nama = ?, alamat = ?, kota = ?, provinsi = ?, " +
        "tgl_registrasi = ?, status = ? WHERE id = ?";

    return jdbcTemplate.update(sql, nama, alamat, kota, provinsi, tglRegistrasi, status, consumer.getId());
  }

  @Override
  public Consumer findById(Long id) {
    String sql = "SELECT * FROM konsumen WHERE id = ?";
    return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Consumer.class), id);
  }

  @Override
  public int deleteById(Long id) {
    String sql = "DELETE FROM konsumen WHERE id = ?";
    return jdbcTemplate.update(sql, id);
  }

  @Override
  public List<Consumer> findAll() {
    String sql = "SELECT * FROM konsumen";
    return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Consumer.class));
  }

}
