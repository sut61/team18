package sut.se.g18.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.se.g18.Entity.*;
import sut.se.g18.Repository.*;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ComplaintController {
    
    @Autowired
    private ComplaintTypeRepository complaintTypeRepository;
    
    @Autowired
    private MaidRegisterRepository maidRegisterRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ComplaintRepository complaintRepository;


    public ComplaintController(ComplaintTypeRepository complaintTypeRepository, MaidRegisterRepository maidRegisterRepository, CompanyRepository companyRepository, ComplaintRepository complaintRepository) {
        this.complaintTypeRepository = complaintTypeRepository;
        this.maidRegisterRepository = maidRegisterRepository;
        this.companyRepository = companyRepository;
        this.complaintRepository = complaintRepository;
    }
    

    @GetMapping(path = "/ComplaintType", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ComplaintTypeEntity> complaintType() {
        return complaintTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/Complaint", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ComplaintEntity> complaint() {
        return complaintRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/complaint/{companySelect}/{maidSelect}/{complaintTypeSelect}/{complaintDetail}/{complaintDate}")
    public ComplaintEntity newComplaint(@RequestBody ComplaintEntity complaintEntity, @PathVariable String companySelect,
                                  @PathVariable String maidSelect, @PathVariable String complaintTypeSelect,
                                  @PathVariable String complaintDetail, @PathVariable Date complaintDate) {

        CompanyEntity company = companyRepository.findBycompanyName(companySelect);
        MaidRegisterEntity maidName = maidRegisterRepository.findBymaidName(maidSelect);
        ComplaintTypeEntity comType = complaintTypeRepository.findBycomplaintType(complaintTypeSelect);
       
        ComplaintEntity cpe = new ComplaintEntity();
        cpe.setCompanyEntity(company);
        cpe.setMaid(maidName);
        cpe.setComplaintTypeEntity(comType);
        cpe.setComDetail(complaintDetail);
        cpe.setComplaintDate(complaintDate);
        

        return complaintRepository.save(cpe);
    }
}
