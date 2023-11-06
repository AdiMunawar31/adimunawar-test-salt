package com.adi.adimunawarbetestsalt.repositories;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.adi.adimunawarbetestsalt.models.Consumer;

public class JdbcConsumerRepository implements ConsumerRepository {
  private final JdbcTemplate jdbcTemplate;

  public JdbcConsumerRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int save(Consumer consumer) {
    String sql = "INSERT INTO konsumen (nama, alamat, kota, provinsi, tgl_registrasi, status) " +
        "VALUES (?, ?, ?, ?, ?, ?)";
    return jdbcTemplate.update(sql, consumer.getNama(), consumer.getAlamat(), consumer.getKota(),
        consumer.getProvinsi(), consumer.getTglRegistrasi(), consumer.getStatus());
  }

  @Override
  public int update(Consumer consumer) {
    String sql = "UPDATE konsumen SET nama = ?, alamat = ?, kota = ?, provinsi = ?, " +
        "tgl_registrasi = ?, status = ? WHERE id = ?";
    return jdbcTemplate.update(sql, consumer.getNama(), consumer.getAlamat(), consumer.getKota(),
        consumer.getProvinsi(), consumer.getTglRegistrasi(), consumer.getStatus(),
        consumer.getId());
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
