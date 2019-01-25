package sut.se.g18.Controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;


import sut.se.g18.Entity.*;
import sut.se.g18.Repository.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import sut.se.g18.Repository.PromotionTypeRepository;

@RestController 
@CrossOrigin(origins = "http://localhost:4200")
public class PromotionController implements CommandLineRunner {
    
    // for promotion
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private PromotionTypeRepository promotionTypeRepository;
    //

    // constuctor promotion
    public PromotionController(CompanyRepository companyRepository , PromotionRepository promotionRepository, PromotionTypeRepository promotionTypeRepository) {
        this.companyRepository = companyRepository;

        this.promotionRepository = promotionRepository;
        this.promotionTypeRepository = promotionTypeRepository;
    }
    //
    // show data
    //@GetMapping(path ="/Maid", produces = MediaType.APPLICATION_JSON_VALUE)
   // public Collection<MaidEntity> maid(){
       // return maidRepository.findAll().stream().collect(Collectors.toList());
   // }

    @GetMapping(path ="/Company", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CompanyEntity> company(){
        return companyRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path ="/PromotionType", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<PromotionTypeEntity> promotionType(){
        return promotionTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    // new company
    
    //

    // new promotion
    @PostMapping("/promotion/{companyName}/{promotionType}/{discount}/{title}/{dateStart}/{dateEnd}")
    public PromotionEntity newPromotion(@RequestBody PromotionEntity newPromotionEntity,
                                                                       @PathVariable String companyName, @PathVariable String promotionType ,
                                                                       @PathVariable int discount,
                                                                       @PathVariable String title , @PathVariable Date dateStart,
                                                                       @PathVariable Date dateEnd) {


        PromotionEntity p = new PromotionEntity();

        CompanyEntity companyEntity = companyRepository.findBycompanyName(companyName);
        PromotionTypeEntity promoType = promotionTypeRepository.findBypromotionType(promotionType);

        p.setCompanyEntity(companyEntity);
        p.setPromotionTypeEntity(promoType);
        p.setDiscount(discount);
        p.setTitle(title);
        p.setDateStart(dateStart);
        p.setDateEnd(dateEnd);


        return promotionRepository.save(p);
    }

    // @GetMapping (path = "/test")
    // public void testInsert(){
    //    // CompanyEntity companyEntity = new CompanyEntity();
    //   //  companyEntity.setCompanyName("TEST1");
    //    // companyRepository.save(companyEntity);



    //     PromotionTypeEntity promotionTypeEntity = new PromotionTypeEntity();
    //     promotionTypeEntity.setPromotionType("ส่วนลด");
    //     promotionTypeRepository.save(promotionTypeEntity);

    // }
    
     @Override
	 public void run(String... arg0) throws Exception{
		//testInsert();
	 }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    
}