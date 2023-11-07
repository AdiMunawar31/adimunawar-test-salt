package com.adi.adimunawarfetestsalt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.adi.adimunawarfetestsalt.dto.ConsumerDTO;
import com.adi.adimunawarfetestsalt.dto.InputConsumerDTO;
import com.adi.adimunawarfetestsalt.models.Consumer;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/consumer")
public class ConsumerController {
  private final String apiBaseUrl = "http://localhost:8080/api/v1/consumer/";
  RestTemplate restTemplate = new RestTemplate();

  @GetMapping
  public String showConsumerList(Model model) {
    var consumers = restTemplate.getForObject(apiBaseUrl, Consumer[].class);
    model.addAttribute("consumers", consumers);
    return "index";
  }

  @GetMapping("/detail/{id}")
  public String showDetailConsumerForm(@PathVariable Long id, Model model) {
    Consumer consumer = restTemplate.getForObject(apiBaseUrl + id, Consumer.class);
    ConsumerDTO consumerDto = new ConsumerDTO();
    consumerDto.setId(consumer.getId());
    consumerDto.setNama(consumer.getNama());
    consumerDto.setAlamat(consumer.getAlamat());
    consumerDto.setKota(consumer.getKota());
    consumerDto.setProvinsi(consumer.getProvinsi());
    consumerDto.setTglRegistrasi(consumer.getTglRegistrasi());
    consumerDto.setStatus(consumer.getStatus());

    model.addAttribute("consumerDto", consumerDto);
    model.addAttribute("consumerId", consumerDto.getId());
    return "detail";
  }

  @GetMapping("/add")
  public String showAddConsumerForm(Model model) {
    model.addAttribute("consumerDto", new InputConsumerDTO());
    return "add";
  }

  @PostMapping("/add-consumer")
  public String addConsumer(@ModelAttribute InputConsumerDTO consumerDto, BindingResult bindingResult, Model model,
      RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
      return "add";
    }
    try {
      restTemplate.postForEntity(apiBaseUrl, consumerDto, Consumer.class);
      redirectAttributes.addFlashAttribute("successMessage", "Consumer updated successfully!");
      return "redirect:/consumer";
    } catch (Exception e) {
      model.addAttribute("error", "Gagal menambahkan konsumen.");
      return "add";
    }
  }

  @GetMapping("/edit/{id}")
  public String showEditConsumerForm(@PathVariable Long id, Model model) {
    Consumer consumer = restTemplate.getForObject(apiBaseUrl + id, Consumer.class);
    ConsumerDTO consumerDto = new ConsumerDTO();
    consumerDto.setId(consumer.getId());
    consumerDto.setNama(consumer.getNama());
    consumerDto.setAlamat(consumer.getAlamat());
    consumerDto.setKota(consumer.getKota());
    consumerDto.setProvinsi(consumer.getProvinsi());
    consumerDto.setTglRegistrasi(consumer.getTglRegistrasi());
    consumerDto.setStatus(consumer.getStatus());

    model.addAttribute("consumerDto", consumerDto);
    model.addAttribute("consumerId", consumerDto.getId());
    return "edit";
  }

  @PostMapping("/edit/{id}")
  public String editConsumer(@PathVariable Long id,
      @Validated @ModelAttribute("consumerDto") InputConsumerDTO consumerDto,
      BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
      return "edit";
    }

    restTemplate.put(apiBaseUrl + id, consumerDto);
    redirectAttributes.addFlashAttribute("successMessage", "Consumer updated successfully!");
    return "redirect:/consumer";
  }

  @GetMapping("/confirm-delete/{id}")
  public String showDeleteConfirmation(@PathVariable Long id, Model model) {
    model.addAttribute("consumerId", id);
    return "delete";
  }

  @GetMapping("/delete/{id}")
  public String deleteConsumer(@PathVariable Long id, RedirectAttributes redirectAttributes) {
    restTemplate.delete(apiBaseUrl + id);
    redirectAttributes.addFlashAttribute("successMessage", "Consumer deleted successfully!");
    return "redirect:/consumer";
  }
}
