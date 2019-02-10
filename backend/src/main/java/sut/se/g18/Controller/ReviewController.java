package sut.se.g18.Controller;

import java.util.Collection;
import java.util.stream.Collectors;

import sut.se.g18.Entity.*;
import sut.se.g18.Repository.*;
import sut.se.g18.Model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ReviewController{
    @Autowired
    private final ScoreRepository scoreRepository;
    @Autowired
    private final MaidRegisterRepository maidregisterRepository;
    @Autowired
    private final ReviewRepository reviewRepository;
    @Autowired
    private final ScoreExpertiseRepository scoreExpertiseRepository;
    @Autowired
    private final ScorePersonalityRepository scorePersonalityRepository;
    @Autowired
    private final ScoreTimeRepository scoreTimeRepository;
    
    @Autowired
    public ReviewController(ScoreRepository scoreRepository,MaidRegisterRepository maidregisterRepository,ReviewRepository reviewRepository
    ,ScoreExpertiseRepository scoreExpertiseRepository,ScorePersonalityRepository scorePersonalityRepository,ScoreTimeRepository scoreTimeRepository){
        this.maidregisterRepository = maidregisterRepository;
        this.scoreRepository = scoreRepository;
        this.reviewRepository = reviewRepository;
        this.scoreExpertiseRepository = scoreExpertiseRepository;
        this.scorePersonalityRepository = scorePersonalityRepository;
        this.scoreTimeRepository = scoreTimeRepository;
    }
    //------------------------------------------
    @GetMapping("/rerere")
    public Collection<ReviewEntity> reviEntities() {
        return reviewRepository.findAll().stream().collect(Collectors.toList());
    }
    
    //-------------------------------------------

    @GetMapping("/Score")
    public Collection<ScoreEntity> scoreEntities() {
        return scoreRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Scoree-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ScoreEntity scoreEntitityFind(@PathVariable("id") Long id) {
        return scoreRepository.findByscoreId(id);
    }
    //---------------------------------------------
    @GetMapping("/ScoreExt")
    public Collection<ScoreExpertiseEntity> scoreExpertiseEntities() {
        return scoreExpertiseRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/ScoreExt-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ScoreExpertiseEntity scoreExpertiseEntitityFind(@PathVariable("id") Long id) {
        return scoreExpertiseRepository.findByscoreExId(id);
    }
    //---------------------------------------------
    @GetMapping("/Scoreper")
    public Collection<ScorePersonalityEntity> scorePersonalityEntities() {
        return scorePersonalityRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Scoreper-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ScorePersonalityEntity ScorePersonalityEntitityFind(@PathVariable("id") Long id) {
        return scorePersonalityRepository.findByscorePerId(id);
    }
    //---------------------------------------------
    @GetMapping("/ScoreTi")
    public Collection<ScoreTimeEntity> scoreTimeEntities() {
        return scoreTimeRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/ScoreTi-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ScoreTimeEntity scoreTimeEntitity(@PathVariable("id") Long id) {
        return scoreTimeRepository.findByscoreTiId(id);
    }
    //---------------------------------------------
    
    @GetMapping("/MMaidRegister")
    public Collection<MaidRegisterEntity> maidregisterEntitys() {
        return maidregisterRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/MMaidRegister-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public MaidRegisterEntity maidregisterEntityFind(@PathVariable("id") Long id) {
        return maidregisterRepository.findByMaidId(id);
    }
    
    

    @PostMapping(path = "/review")
    public ReviewEntity rev(@RequestBody DataReview dataReview){

        ScoreExpertiseEntity se = this.scoreExpertiseRepository.findByscoreExId(dataReview.getScoreExId());
        ScorePersonalityEntity sp = this.scorePersonalityRepository.findByscorePerId(dataReview.getScorePerId());
        ScoreTimeEntity st = this.scoreTimeRepository.findByscoreTiId(dataReview.getScoreTiId());
        MaidRegisterEntity med = this.maidregisterRepository.findByMaidId(dataReview.getMaidId());
        ScoreEntity sco = this.scoreRepository.findByscoreId(dataReview.getScoreId());
        
        ReviewEntity revv = this.reviewRepository.save(new ReviewEntity(med,sco,se,sp,st,dataReview.getReview()));
    
        return revv;
    }

}
