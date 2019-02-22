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
                                  WorkingDateRepositoy workingDateRepositoy, CompanyRepository companyRepository, WelfareAndSalaryRepository welfareAndSalaryRepository) {
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

    @PostMapping(path = "/regi/{titlenameId}/{nametInput}/{phoneInput}/{emailInput}/{addressInput}/{districtInput}/" +
            "{cantonInput}/{provinceInput}/{typeworkingSelect}/{typeworkingDateSelect}/{companySelect}/{WelsaSelect}")
    public MaidRegisterEntity maidRegisterEntity(MaidRegisterEntity maidentity, @PathVariable String titlenameId,
                                                 @PathVariable String nametInput, @PathVariable String phoneInput,
                                                 @PathVariable String emailInput, @PathVariable String addressInput,
                                                 @PathVariable String districtInput, @PathVariable String cantonInput,
                                                 @PathVariable String provinceInput, @PathVariable String typeworkingSelect,
                                                 @PathVariable String typeworkingDateSelect, @PathVariable String companySelect,
                                                 @PathVariable String WelsaSelect) {

        MaidRegisterEntity maidRegisterEntity = new MaidRegisterEntity();
        TitleNameEntity ti = titleNameRepository.findBytitlenameType(titlenameId);
        CompanyEntity companyy = companyRepository.findBycompanyName(companySelect);
        TypeworkingEntity type = typeworkingRepository.findByTypeworking(typeworkingSelect);
        WorkingDateEntity work = workingDateRepositoy.findBytypeworkingDate(typeworkingDateSelect);
        WelfareAndSalaryEntity we = welfareAndSalaryRepository.findBywelsaName(WelsaSelect);

        maidRegisterEntity.setTitleNameEntity(ti);
        maidRegisterEntity.setMaidName(nametInput);
        maidRegisterEntity.setMaidAddress(addressInput);
        maidRegisterEntity.setMaidEmail(emailInput);
        maidRegisterEntity.setMaidPhone(phoneInput);
        maidRegisterEntity.setProvince(provinceInput);
        maidRegisterEntity.setDistrict(districtInput);
        maidRegisterEntity.setCanton(cantonInput);

        maidRegisterEntity.setTypeworkingEntity(type);
        maidRegisterEntity.setWorkingDateEntity(work);
        maidRegisterEntity.setCompanyForMaid(companyy);
        maidRegisterEntity.setWelfareAndSalaryEntity(we);

        return maidRegisterRepository.save(maidRegisterEntity);
    }

    @GetMapping(path = "/wel/{company}/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<WelfareAndSalaryEntity> Wel(@PathVariable String company, @PathVariable String type) {
        CompanyEntity com = companyRepository.findBycompanyName(company);
        WorkingDateEntity work = workingDateRepositoy.findBytypeworkingDate(type);
        return welfareAndSalaryRepository.findByCompanyAndWorkingdate(com, work).stream().collect(Collectors.toList());
    }
}
