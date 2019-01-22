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

    public MaidRegisterController(MaidRegisterRepository maidRegisterRepository, TitleNameRepository titleNameRepository,
                                  TypeworkingRepository typeworkingRepository, WorkingDateRepositoy workingDateRepositoy){
        this.maidRegisterRepository = maidRegisterRepository;
        this.titleNameRepository = titleNameRepository;
        this.typeworkingRepository = typeworkingRepository;
        this.workingDateRepositoy = workingDateRepositoy;
    }

    @GetMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<MaidRegisterEntity> Register() {
        return maidRegisterRepository.findAll().stream().collect(Collectors.toList());
    }
    /*=======================================================*/
    @GetMapping(path = "/title", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TitleNameEntity> TitleName() {
        return titleNameRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/title-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public TitleNameEntity titleNameFind(@PathVariable("id") Long id) {
        return titleNameRepository.findByTitlenameId(id);
    }
    /*=======================================================*/

    @GetMapping(path = "/typeworking", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TypeworkingEntity> Typeworking() {
        return typeworkingRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/typeworking-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public TypeworkingEntity typeworkingFind(@PathVariable("id") Long id) {
        return typeworkingRepository.findByTypeworkingId(id);
    }
    /*=======================================================*/
    @GetMapping(path = "/workingDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<WorkingDateEntity> WorkingDate() {
        return workingDateRepositoy.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/workingDate-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public WorkingDateEntity workingDateFind(@PathVariable("id") Long id) {
        return workingDateRepositoy.findByTypeworkingDateId(id);
    }
    /*=======================================================*/

    @PostMapping(path = "/regi")
    public MaidRegisterEntity dataRegis(@RequestBody DataRegister dataRegister){

        TitleNameEntity ti =this.titleNameRepository.findByTitlenameId(dataRegister.getTitlenameId());
        TypeworkingEntity typework = this.typeworkingRepository.findByTypeworkingId(dataRegister.getTypeworkingId());
        WorkingDateEntity workdate = this.workingDateRepositoy.findByTypeworkingDateId(dataRegister.getTypeworkingDateId());

        //String maidName,String maidAddress,String maidEmail,String maidPhone,String province,
        //                    String district,String canton,TitleNameEntity titleName,TypeworkingEntity typeworking,
        //                    WorkingDateEntity workingDate
        MaidRegisterEntity re = this.maidRegisterRepository.save(new MaidRegisterEntity(dataRegister.getMaidName(),dataRegister.getMaidAddress()
                ,dataRegister.getMaidEmail(),dataRegister.getMaidPhone(),dataRegister.getProvince(),dataRegister.getDistrict()
                ,dataRegister.getCanton(),ti,typework,workdate));

        return re;
    }

}
