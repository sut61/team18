package sut.se.g18.Controller;

import java.util.Collection;
import java.util.stream.Collectors;

import sut.se.g18.Entity.*;
import sut.se.g18.Repository.*;
import sut.se.g18.Model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class LendEquipmentController<lendEquipments>{
    @Autowired
    private final CleaningEquipmentRepository cleaningEquipmentRepository;
    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final ElectricalEquipmentRepository electricalEquipmentRepository;
    @Autowired
    private final LendEquipmentRepository lendEquipmentRepository;
    @Autowired
    private final MaidRegisterRepository maidregisterRepository;

    @Autowired
    public LendEquipmentController(CleaningEquipmentRepository cleaningEquipmentRepository,CustomerRepository customerRepository,ElectricalEquipmentRepository electricalEquipmentRepository,LendEquipmentRepository lendEquipmentRepository,MaidRegisterRepository maidregisterRepository){

        this.cleaningEquipmentRepository = cleaningEquipmentRepository;
        this.customerRepository = customerRepository;
        this.electricalEquipmentRepository = electricalEquipmentRepository;
        this.lendEquipmentRepository = lendEquipmentRepository;
        this.maidregisterRepository = maidregisterRepository;


    }
    @GetMapping("/CleaningEquipment")
    public Collection<CleaningEquipmentEntity> cleaningEquipmentEntitys() {
        return cleaningEquipmentRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/CleaningEquipment-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public CleaningEquipmentEntity cleaningEquipmentEntityFind(@PathVariable("id") Long id) {
        return cleaningEquipmentRepository.findBycleaningId(id);
    }

    //----------------------------------------------------------------------------------------------

    @GetMapping("/Customer")
    public Collection<CustomerEntity> customerEntitys() {
        return customerRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Customer-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public CustomerEntity customerEntityFind(@PathVariable("id") Long id) {
        return customerRepository.findBycustomerId(id);
    }
    //----------------------------------------------------------------------------------------------

    @GetMapping("/ElectricalEquipment")
    public Collection<ElectricalEquipmentEntity> electricalEquipmentEntitys() {
        return electricalEquipmentRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/ElectricalEquipment-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ElectricalEquipmentEntity electricalEquipmentEntityFind(@PathVariable("id") Long id) {
        return electricalEquipmentRepository.findByelectricId(id);
    }

    //---------------------------------------------------------------------------------------------

    @GetMapping("/LendEquipment")
    public Collection<LendEquipmentEntity> lendEquipmentEntitys() {
        return lendEquipmentRepository.findAll().stream().collect(Collectors.toList());
    }
    
    //---------------------------------------------------------------------------------------------

    @GetMapping("/Register")
    public Collection<MaidRegisterEntity> maidregisterEntitys() {
        return maidregisterRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/Register-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public MaidRegisterEntity maidregisterEntityFind(@PathVariable("id") Long id) {
        return maidregisterRepository.findByMaidId(id);
    }

    @PostMapping(path = "/datalend")
    public LendEquipmentEntity name(@RequestBody DataLendEquipment dataLendEquipment){

        CleaningEquipmentEntity clean = this.cleaningEquipmentRepository.findBycleaningId(dataLendEquipment.getCleaningId());
        CustomerEntity cuss = this.customerRepository.findBycustomerId(dataLendEquipment.getCustomerId());
        ElectricalEquipmentEntity elec = this.electricalEquipmentRepository.findByelectricId(dataLendEquipment.getElectricId());
        MaidRegisterEntity med = this.maidregisterRepository.findByMaidId(dataLendEquipment.getMaidId());
        System.out.print(dataLendEquipment.getLendData());
       
        LendEquipmentEntity le = this.lendEquipmentRepository.save(new LendEquipmentEntity(dataLendEquipment.getLendData(),clean, elec, cuss, med));
    
        return le;
    }

    
    

}