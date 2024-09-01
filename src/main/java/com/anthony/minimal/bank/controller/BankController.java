package com.anthony.minimal.bank.controller;

import com.anthony.minimal.bank.domain.Bank;
import com.anthony.minimal.bank.service.BankService;
import com.anthony.minimal.web.controller.DefaultController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bank")
public class BankController extends DefaultController<Bank, BankService> {
}
