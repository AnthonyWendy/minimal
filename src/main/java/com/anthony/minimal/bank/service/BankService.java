package com.anthony.minimal.bank.service;


import com.anthony.minimal.bank.domain.Bank;
import com.anthony.minimal.bank.domain.repository.BankRepository;
import com.anthony.minimal.web.service.DefaultService;
import org.springframework.stereotype.Service;

@Service
public class BankService extends DefaultService<Bank, BankRepository> {
}
