package sut.se.g18.Controller;

import sut.se.g18.Entity.*;
import sut.se.g18.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WelfareAndSalaryController{
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private WorkingDateRepositoy workingDateRepositoy;
    @Autowired
    private TypewelfareRepository typewelfareRepository;
    @Autowired
    private WelfareAndSalaryRepository welfareAndSalaryRepository;
    @Autowired
    public WelfareAndSalaryController (CompanyRepository companyRepository, WorkingDateRepositoy workingDateRepositoy, TypewelfareRepository typewelfareRepository, WelfareAndSalaryRepository welfareAndSalaryRepository){
        this.companyRepository = companyRepository;
        this.workingDateRepositoy = workingDateRepositoy;
        this.typewelfareRepository = typewelfareRepository;
        this.welfareAndSalaryRepository = welfareAndSalaryRepository;

    }
    @GetMapping(path = "/typewelfare", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TypewelfareEntity> Typewelfare() {
        return typewelfareRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/welsa", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<WelfareAndSalaryEntity> WelfareAndSalary(){
        return welfareAndSalaryRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping(path = "/welsa/{companySelect}/{workingDate}/{typeWelfare}/{nameWelfare}/{salary}/{detail}/{termcondition}", produces = MediaType.APPLICATION_JSON_VALUE)
    public WelfareAndSalaryEntity addWelsa(WelfareAndSalaryEntity welsa, @PathVariable String companySelect, @PathVariable String workingDate, @PathVariable String typeWelfare,
                                            @PathVariable String nameWelfare, @PathVariable int salary, @PathVariable String detail, @PathVariable String termcondition) {
                                CompanyEntity com = companyRepository.findBycompanyName(companySelect);
                                TypewelfareEntity type = typewelfareRepository.findByTypewelName(typeWelfare);
                                WorkingDateEntity work = workingDateRepositoy.findByTypeworkingDate(workingDate);
                                welsa.setCompany(com);
                                welsa.setTypewelfare(type);
                                welsa.setWorkingdate(work);
                                welsa.setWelsaName(nameWelfare);
                                welsa.setSalary(salary);
                                welsa.setDatail(detail);
                                welsa.setTermCon(termcondition);
                                return welfareAndSalaryRepository.save(welsa);

                        
        }

    
    }
    
