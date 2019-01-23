package sut.se.g18.Controller;

import sut.se.g18.Entity.*;
import sut.se.g18.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private TypepaymentRepository typepaymentRepository;
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private PaymentStatusRepository paymentStatusRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    public PaymentController (BankRepository bankRepository, PaymentRepository paymentRepository, TypepaymentRepository typepaymentRepository, ContractRepository contractRepository, PaymentStatusRepository paymentStatusRepository, CustomerRepository customerRepository) {
        this.bankRepository = bankRepository;
        this.paymentRepository = paymentRepository;
        this.typepaymentRepository = typepaymentRepository;
        this.contractRepository= contractRepository;
        this.paymentStatusRepository = paymentStatusRepository;
        this.customerRepository = customerRepository;

    }

    @GetMapping(path = "BankEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<BankEntity> Bank() {
        return bankRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/PaymentEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<PaymentEntity> paymentEntities() {
        return paymentRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/TypepaymentEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TypepaymentEntity> typepaymentEntities() {
        return typepaymentRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/contract/{inputEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ContractEntity> contractEntities(@PathVariable String inputEmail) {
        PaymentStatusEntity status = paymentStatusRepository.findBypaymentStatus("ค้างชำระ");
        CustomerEntity customer = customerRepository.findBycustomerEmail(inputEmail);
        return contractRepository.findByCustomerAndStatus(customer, status);
    }
}