package sut.se.g18.Controller;

import sut.se.g18.Repository.*;
import org.springframework.http.MediaType;
import sut.se.g18.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import sut.se.g18.Model.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class SelectController {

    @Autowired
    private MaidRegisterRepository maidRegisterRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MaidSelectRepository maidSelectRepository;
    @Autowired
    private MaidStatusRepository maidStatusRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private TypeworkingRepository typeworkingRepository;
    @Autowired
    private WorkingDateRepositoy workingDateRepositoy;

    public SelectController(MaidRegisterRepository maidRegisterRepository, CustomerRepository customerRepository,
            MaidSelectRepository maidSelectRepository, MaidStatusRepository maidStatusRepository,
            CompanyRepository companyRepository, TypeworkingRepository typeworkingRepository,
            WorkingDateRepositoy workingDateRepositoy) {
        this.maidRegisterRepository = maidRegisterRepository;
        this.customerRepository = customerRepository;
        this.maidSelectRepository = maidSelectRepository;
        this.maidStatusRepository = maidStatusRepository;
        this.companyRepository = companyRepository;
        this.typeworkingRepository = typeworkingRepository;
        this.workingDateRepositoy = workingDateRepositoy;

    }



    @GetMapping(path = "/select", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<MaidSelectEntity> Select() {
        return maidSelectRepository.findAll().stream().collect(Collectors.toList());
    }

    /* ======================================================= */
    @GetMapping(path = "/ccustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CustomerEntity> Customer() {
        return customerRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/ccustomer-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public CustomerEntity customerFind(@PathVariable("id") Long id) {
        return customerRepository.findBycustomerId(id);
    }

    /* ======================================================= */

    @GetMapping(path = "/rregister", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<MaidRegisterEntity> Register() {
        return maidRegisterRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/rregister-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public MaidRegisterEntity maidRegisterFind(@PathVariable("id") Long id) {
        return maidRegisterRepository.findByMaidId(id);
    }

    /* ======================================================= */

    @GetMapping(path = "/sstatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<MaidStatusEntity> Status() {
        return maidStatusRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/sstatus-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public MaidStatusEntity maidStatusFind(@PathVariable("id") String status) {
        return maidStatusRepository.findBystatus(status);
    }

    /* ======================================================= */

    @GetMapping(path = "/ccompany", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CompanyEntity> Company() {
        return companyRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/ccompany-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public CompanyEntity companyFind(@PathVariable("id") String companyName) {
        return companyRepository.findBycompanyName(companyName);
    }

    /* ======================================================= */
    @GetMapping(path = "/ttypeworking", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TypeworkingEntity> Typeworking() {
        return typeworkingRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/ttypeworking-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public TypeworkingEntity typeworkingFind(@PathVariable("id") Long id) {
        return typeworkingRepository.findByTypeworkingId(id);
    }

    /* ======================================================= */
    @GetMapping(path = "/wworkingDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<WorkingDateEntity> WorkingDate() {
        return workingDateRepositoy.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/wworkingDate-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public WorkingDateEntity workingDateFind(@PathVariable("id") Long id) {
        return workingDateRepositoy.findByTypeworkingDateId(id);
    }
    /* ======================================================= */

    @PostMapping(path = "/dataSelect")
    public MaidSelectEntity dataSelect(@RequestBody DataSelect dataSelect) {

        CompanyEntity com = this.companyRepository.findBycompanyName(dataSelect.getCompanyName());
        TypeworkingEntity typework = this.typeworkingRepository.findByTypeworkingId(dataSelect.getTypeworkingId());
        WorkingDateEntity workdate = this.workingDateRepositoy
                .findByTypeworkingDateId(dataSelect.getTypeworkingDateId());
        MaidStatusEntity st = this.maidStatusRepository.findBystatus(dataSelect.getStatus());

        MaidSelectEntity sele = this.maidSelectRepository.save(new MaidSelectEntity(dataSelect.getMaidEmail(), com, typework, workdate, st));

        return sele;
    }
}