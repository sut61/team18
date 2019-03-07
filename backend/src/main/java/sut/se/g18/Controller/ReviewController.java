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
    private final TypeReviewRepository typeReviewRepository;
    
    @Autowired
    public ReviewController(ScoreRepository scoreRepository,MaidRegisterRepository maidregisterRepository,ReviewRepository reviewRepository,TypeReviewRepository typeReviewRepository){
        this.maidregisterRepository = maidregisterRepository;
        this.scoreRepository = scoreRepository;
        this.reviewRepository = reviewRepository;
        this.typeReviewRepository = typeReviewRepository;
     
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

    @GetMapping("/TypeReview")
    public Collection<TypeReviewEntity> typeReviewEntities() {
        return typeReviewRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/TypeReview-list/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public TypeReviewEntity typeReviewEntitieFind(@PathVariable("id") Long id) {
        return typeReviewRepository.findBytypereviewId(id);
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

        MaidRegisterEntity med = this.maidregisterRepository.findByMaidId(dataReview.getMaidId());
        ScoreEntity sco = this.scoreRepository.findByscoreId(dataReview.getScoreId());
        TypeReviewEntity ty = this.typeReviewRepository.findBytypereviewId(dataReview.getTypereviewId());

        ReviewEntity revv = this.reviewRepository.save(new ReviewEntity(med,sco,ty,dataReview.getReview(),dataReview.getAdjust()));
    
        return revv;
    }

}
