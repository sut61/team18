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
public class MaidRegisterController {
    @Autowired
    private MaidRegisterRepository maidRegisterRepository;
    @Autowired
    private TitleNameRepository titleNameRepository;
    @Autowired
    private TypeworkingRepository typeworkingRepository;
    @Autowired
    private WorkingDateRepositoy workingDateRepositoy;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private WelfareAndSalaryRepository welfareAndSalaryRepository;

    public MaidRegisterController(MaidRegisterRepository maidRegisterRepository,
            TitleNameRepository titleNameRepository, TypeworkingRepository typeworkingRepository,
            WorkingDateRepositoy workingDateRepositoy,CompanyRepository companyRepository,WelfareAndSalaryRepository welfareAndSalaryRepository) {
        this.maidRegisterRepository = maidRegisterRepository;
        this.titleNameRepository = titleNameRepository;
        this.typeworkingRepository = typeworkingRepository;
        this.workingDateRepositoy = workingDateRepositoy;
        this.companyRepository = companyRepository;
        this.welfareAndSalaryRepository = welfareAndSalaryRepository;
    }

    @GetMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<MaidRegisterEntity> Register() {
        return maidRegisterRepository.findAll().stream().collect(Collectors.toList());
    }

   
    /* ======================================================= */
    @GetMapping(path = "/title", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TitleNameEntity> TitleName() {
        return titleNameRepository.findAll().stream().collect(Collectors.toList());
    }

    /* ======================================================= */

    @GetMapping(path = "/typeworking", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TypeworkingEntity> Typeworking() {
        return typeworkingRepository.findAll().stream().collect(Collectors.toList());
    }


    /* ======================================================= */
    @GetMapping(path = "/workingDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<WorkingDateEntity> WorkingDate() {
        return workingDateRepositoy.findAll().stream().collect(Collectors.toList());
    }
/* ======================================================= */
    @GetMapping(path = "/ccompany", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CompanyEntity> Company() {
        return companyRepository.findAll().stream().collect(Collectors.toList());
    }
    /* ======================================================= */
    @GetMapping(path = "/WelfareAndSalary", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<WelfareAndSalaryEntity> WelfareAndSalary() {
        return welfareAndSalaryRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/regi/{titleSelect}/{inputmaidName}/{inputmaidPhone}/{inputmaidEmail}/{inputmaidAddress}/{inputdistrict}/{inputcanton}/{inputprovince}/{typeworkingEntity}/{workingDateEntity}/{companys}/{WelfareAndSalarySelect}")
    public MaidRegisterEntity maidRegisterEntity(MaidRegisterEntity maidentity, @PathVariable String titleSelect,
    @PathVariable String inputmaidName, @PathVariable String inputmaidPhone,
    @PathVariable String inputmaidEmail, @PathVariable String inputmaidAddress,
    @PathVariable String inputdistrict, @PathVariable String inputcanton ,
    @PathVariable String inputprovince, @PathVariable String typeworkingEntity, @PathVariable String workingDateEntity,
    @PathVariable String companys, @PathVariable String WelfareAndSalarySelect) {

        MaidRegisterEntity maidRegisterEntity = new MaidRegisterEntity();
        TitleNameEntity ti = titleNameRepository.findBytitlenameType(titleSelect);
        CompanyEntity companyy = companyRepository.findBycompanyName(companys);
        TypeworkingEntity type = typeworkingRepository.findByTypeworking(typeworkingEntity);
        WorkingDateEntity work = workingDateRepositoy.findBytypeworkingDate(workingDateEntity);
       WelfareAndSalaryEntity we = welfareAndSalaryRepository.findBywelsaName(WelfareAndSalarySelect);

       maidRegisterEntity.setTitleNameEntity(ti);
       maidRegisterEntity.setMaidName(inputmaidName);
       maidRegisterEntity.setMaidAddress(inputmaidAddress);
       maidRegisterEntity.setMaidEmail(inputmaidEmail);
       maidRegisterEntity.setMaidPhone(inputmaidPhone);
       maidRegisterEntity.setProvince(inputprovince);
       maidRegisterEntity.setDistrict(inputdistrict);
       maidRegisterEntity.setCanton(inputcanton);

       maidRegisterEntity.setTypeworkingEntity(type);
       maidRegisterEntity.setWorkingDateEntity(work);
       maidRegisterEntity.setCompanyForMaid(companyy);
       maidRegisterEntity.setWelfareAndSalaryEntity(we);

        return maidRegisterRepository.save(maidRegisterEntity);
    }
    @GetMapping(path = "/wel/{company}/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<WelfareAndSalaryEntity> Wel(@PathVariable String company,@PathVariable String type) {
        CompanyEntity com = companyRepository.findBycompanyName(company);
        WorkingDateEntity work = workingDateRepositoy.findBytypeworkingDate(type);
        return welfareAndSalaryRepository.findByCompanyAndWorkingdate(com,work).stream().collect(Collectors.toList());
    }
}
