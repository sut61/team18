package sut.se.g18.Controller;

import org.springframework.web.bind.annotation.*;
import sut.se.g18.Entity.*;
import sut.se.g18.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import java.util.Date;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SelectController {
    @Autowired
    private TypeworkingRepository typeworkingRepository;
    @Autowired
    private WorkingDateRepositoy workingDateRepositoy;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private MaidRegisterRepository maidRegisterRepository;
    @Autowired
    private MaidSelectRepository maidSelectRepository;
    @Autowired
    private MaidStatusRepository maidStatusRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public SelectController(TypeworkingRepository typeworkingRepository, WorkingDateRepositoy workingDateRepositoy,
            CompanyRepository companyRepository, MaidRegisterRepository maidRegisterRepository,
            MaidSelectRepository maidSelectRepository, MaidStatusRepository maidStatusRepository,
            CustomerRepository customerRepository) {
        this.typeworkingRepository = typeworkingRepository;
        this.workingDateRepositoy = workingDateRepositoy;
        this.companyRepository = companyRepository;
        this.maidRegisterRepository = maidRegisterRepository;
        this.maidSelectRepository = maidSelectRepository;
        this.maidStatusRepository = maidStatusRepository;
        this.customerRepository = customerRepository;
    }


    @GetMapping(path = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<MaidStatusEntity> Status() {
        return maidStatusRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/select/{maidEmail}/{companySelect}/{maidselect}/{typeworkingSelect}/{typeworkingDateSelect}/{dateInput}/{workingdayInput}/{mainjobInput}/{secondaryjobInput}/{placeInput}")
    public MaidSelectEntity maidSelectEntity(@PathVariable String maidEmail, @PathVariable String companySelect,
            @PathVariable String maidselect, @PathVariable String typeworkingSelect,
            @PathVariable String typeworkingDateSelect, @PathVariable Date dateInput,  @PathVariable String workingdayInput,
            @PathVariable String mainjobInput, @PathVariable String secondaryjobInput,  @PathVariable String placeInput) {
        MaidSelectEntity maidSelectEntity = new MaidSelectEntity();
        CustomerEntity cus = customerRepository.findBycustomerEmail(maidEmail);
        CompanyEntity company = companyRepository.findBycompanyName(companySelect);
        MaidRegisterEntity maid = maidRegisterRepository.findBymaidName(maidselect);
        TypeworkingEntity type = typeworkingRepository.findByTypeworking(typeworkingSelect);
        WorkingDateEntity work = workingDateRepositoy.findBytypeworkingDate(typeworkingDateSelect);

        MaidStatusEntity status = maidStatusRepository.findBystatus("จอง");
        
        maidSelectEntity.setCustomer(cus);
        maidSelectEntity.setCompanyForMaid(company);
        maidSelectEntity.setMaid(maid);
        maidSelectEntity.setStatus(status);
        maidSelectEntity.setTypeworkingEntity(type);
        maidSelectEntity.setWorkingDateEntity(work);
        maidSelectEntity.setDatepick(dateInput);
        maidSelectEntity.setWorkingday(workingdayInput);
        maidSelectEntity.setMainjob(mainjobInput);
        maidSelectEntity.setSecondaryjob(secondaryjobInput);
        maidSelectEntity.setPlace(placeInput);

        return maidSelectRepository.save(maidSelectEntity);
    }
}
