package sut.se.g18.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.se.g18.Entity.CompanyEntity;
import sut.se.g18.Entity.CompanyTypeEntity;
import sut.se.g18.Entity.ProvinceEntity;
import sut.se.g18.Repository.CompanyRepository;
import sut.se.g18.Repository.CompanyTypeRepository;
import sut.se.g18.Repository.ProvinceRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController @CrossOrigin(origins = "http://localhost:4200")

public class CompanyController {
    @Autowired
    private CompanyTypeRepository companyTypeRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ProvinceRepository provincRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository, CompanyTypeRepository companyTypeRepository,
                             ProvinceRepository provincRepository) {
        this.companyRepository = companyRepository;
        this.companyTypeRepository = companyTypeRepository;
        this.provincRepository = provincRepository;

    }

    @GetMapping(path = "/companys", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CompanyEntity> Company() {
        return companyRepository.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping(path = "/CompanyType", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CompanyTypeEntity> CompanyType() {
        return companyTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/province", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ProvinceEntity> Provinc() {
        return provincRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/company/{companyName}/{companyType}/{companyPhone}/{companyAddress}/{provincName}")
    public CompanyEntity company(@RequestBody CompanyEntity comp, @PathVariable String companyName, @PathVariable String companyType,
                                 @PathVariable String companyPhone, @PathVariable String companyAddress, @PathVariable String provincName) {
        System.out.println(companyName);
        System.out.println(companyType);
        System.out.println(companyAddress);
        System.out.println(provincName);
        System.out.println(companyPhone);
        CompanyEntity companyEntity = new CompanyEntity();
        CompanyTypeEntity companytype = companyTypeRepository.findBycompanyType(companyType);
        ProvinceEntity provinc = provincRepository.findByprovinceName(provincName);


        companyEntity.setCompanyName(companyName);
        companyEntity.setCompanyTypeEntity(companytype);
        companyEntity.setCompanyAddress(companyAddress);
        companyEntity.setProvinecEntity(provinc);
        companyEntity.setCompanyPhone(companyPhone);


        return companyRepository.save(companyEntity);
    }
}