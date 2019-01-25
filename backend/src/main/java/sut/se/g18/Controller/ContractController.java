package sut.se.g18.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.se.g18.Entity.*;
import sut.se.g18.Repository.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContractController {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private MaidSelectRepository maidSelectRepository;
    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AdminAccountRepository adminAccountRepository;
    @Autowired
    private ContractTypeRepository contractTypeRepository;
    @Autowired
    private PaymentStatusRepository paymentStatusRepository;
    @Autowired
    private MaidStatusRepository maidStatusRepository;
    @Autowired
    private MaidRegisterRepository maidRegisterRepository;

    public ContractController(CompanyRepository companyRepository, ContractRepository contractRepository,
                              MaidSelectRepository maidSelectRepository, PromotionRepository promotionRepository,
                              CustomerRepository customerRepository, AdminAccountRepository adminAccountRepository,
                              ContractTypeRepository contractTypeRepository, PaymentStatusRepository paymentStatusRepository,
                              MaidStatusRepository maidStatusRepository, MaidRegisterRepository maidRegisterRepository){
        this.companyRepository = companyRepository;
        this.contractRepository = contractRepository;
        this.maidSelectRepository = maidSelectRepository;
        this.promotionRepository = promotionRepository;
        this.customerRepository = customerRepository;
        this.adminAccountRepository = adminAccountRepository;
        this.contractTypeRepository = contractTypeRepository;
        this.paymentStatusRepository = paymentStatusRepository;
        this.maidStatusRepository = maidStatusRepository;
        this.maidRegisterRepository = maidRegisterRepository;
    }

    @GetMapping(path ="/admin/{adminUsername}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminAccountEntity getAdminAccount(@PathVariable String adminUsername){
        AdminAccountEntity admin = adminAccountRepository.findByadminUsername(adminUsername);
        return admin;
    }

    @GetMapping(path ="/company", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CompanyEntity> getCompany(){
        Collection<CompanyEntity> com = new ArrayList<>();
        Collection<MaidSelectEntity> select = maidSelectRepository.findAll().stream().collect(Collectors.toList());
        MaidRegisterEntity regis = new MaidRegisterEntity();
        MaidStatusEntity status = maidStatusRepository.findBystatus("จอง");
        for(MaidSelectEntity m : select){
            if(m.getStatus()==status){
                regis = m.getMaid();
                com.add(regis.getCompanyForMaid());
            }
        }
        return com.stream().collect(Collectors.toList());
    }

    @GetMapping(path ="/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CustomerEntity> customer(){
        return customerRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path ="/maid", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<MaidSelectEntity> maidSelect(){
        return maidSelectRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path ="/maid/reserve", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<MaidSelectEntity> maidSelectReserve(){
        MaidStatusEntity status = maidStatusRepository.findBystatus("จอง");
        Collection<MaidSelectEntity> maid = maidSelectRepository.findBystatus(status);
        return maid.stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/maid/getdata/{companySelect}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<MaidSelectEntity> getMaidSelect(@PathVariable String companySelect) {
        CompanyEntity company = companyRepository.findBycompanyName(companySelect);
        Collection<MaidRegisterEntity> maid = maidRegisterRepository.findBycompanyForMaid(company);
        MaidStatusEntity status = maidStatusRepository.findBystatus("จอง");
        Collection<MaidSelectEntity> select = new ArrayList<>();
        for(MaidRegisterEntity m : maid){
            if(maidSelectRepository.findBymaid(m).getStatus()==status){
                select.add(maidSelectRepository.findBymaidAndStatus(m,status));
            }
        }
        return select.stream().collect(Collectors.toList());
    }

    @GetMapping(path ="/promotion", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<PromotionEntity> promotion(){
        return promotionRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/promotion/getdata/{companySelect}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<PromotionEntity> getPromotion(@PathVariable String companySelect) {
        CompanyEntity company = companyRepository.findBycompanyName(companySelect);
        Collection<PromotionEntity> P = promotionRepository.findBycompanyEntity(company);
        return P.stream().collect(Collectors.toList());
    }

    @GetMapping(path ="/contractType", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ContractTypeEntity> getContractType(){
        return contractTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path ="/paymentStatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<PaymentStatusEntity> paymentStatus(){
        return paymentStatusRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path ="/contract", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ContractEntity> contract(){
        return contractRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/contract/{companySelect}/{maidSelect}/{contractTypeSelect}/{promotionSelect}/{dateStartInput}/{cost}")
    public ContractEntity newContract(@RequestBody ContractEntity contractEntity, @PathVariable String companySelect,
                                      @PathVariable String maidSelect, @PathVariable String contractTypeSelect,
                                      @PathVariable String promotionSelect, @PathVariable Date dateStartInput,
                                      @PathVariable int cost) {

        CompanyEntity company = companyRepository.findBycompanyName(companySelect);

        MaidRegisterEntity maidName = maidRegisterRepository.findBymaidName(maidSelect);
        MaidStatusEntity maidStatus = maidStatusRepository.findBystatus("ทำสัญญาอยู่");
        MaidSelectEntity maid = maidSelectRepository.findBymaid(maidName);
        maid.setStatus(maidStatus);
        maidSelectRepository.save(maid);
        CustomerEntity customer = maid.getCustomer();
        ContractTypeEntity type = contractTypeRepository.findBycontractType(contractTypeSelect);
        PaymentStatusEntity status = paymentStatusRepository.findBypaymentStatus("ค้างชำระ");
        ContractEntity newContract = new ContractEntity();
        newContract.setCompany(company);
        newContract.setMaid(maid);
        newContract.setContractType(type);
        newContract.setCustomer(customer);
        PromotionEntity promotion = new PromotionEntity();
        if(!(promotionSelect.equals("No Promotion"))){
            promotion = promotionRepository.findBytitle(promotionSelect);
            newContract.setPromotion(promotion);
        }
        newContract.setDateStart(dateStartInput);
        newContract.setStatus(status);
        newContract.setCost(cost);

        return contractRepository.save(newContract);
    }

    @PutMapping("/contract/update/{contractTypeSelect}/{dateStartInput}/{contractId}/{cost}")
    public ContractEntity updateContract(@RequestBody ContractEntity updateContractEntity, @PathVariable String contractTypeSelect,
                                         @PathVariable Date dateStartInput, @PathVariable Long contractId,
                                         @PathVariable int cost) {
        ContractEntity updateContract = contractRepository.getOne(contractId);
        ContractTypeEntity type = contractTypeRepository.findBycontractType(contractTypeSelect);
        updateContract.setContractType(type);
        updateContract.setDateStart(dateStartInput);
        updateContract.setCost(cost);

        return contractRepository.save(updateContract);
    }

    @DeleteMapping("contract/{contractId}")
    public void deleteContract(@PathVariable Long contractId){
        contractRepository.deleteById(contractId);
    }

}
