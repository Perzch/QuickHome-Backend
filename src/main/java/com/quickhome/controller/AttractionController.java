package com.quickhome.controller;

import com.quickhome.domain.AttractionImage;
import com.quickhome.domain.Attractions;
import com.quickhome.pojo.PojoAttraction;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.AttractionImageService;
import com.quickhome.service.AttractionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("AttractionCon")
@RequestMapping("/Attraction")
public class AttractionController {
    @Autowired
    private AttractionsService attractionsService;

    @Autowired
    private AttractionImageService attractionImageService;
    @GetMapping("/getAttractionListByCollectionCount")
    @ResponseBody
    public ResponseEntity<?> getAttractionListOrderByCollectionCount() {
        List<PojoAttraction> pojoAttractionList = attractionsService.getAttractionListOrderByCollectionCount();
        for (PojoAttraction pojoAttraction : pojoAttractionList) {
            Attractions attractions = attractionsService.getById(pojoAttraction.getAttractionsId_zch_hwz_gjc());
            pojoAttraction.setAttractions(attractions);
            List<AttractionImage> attractionImageList = attractionImageService.getAttractionImageListById(pojoAttraction.getAttractionsId_zch_hwz_gjc());
            pojoAttraction.setAttractionImageList(attractionImageList);
        }
        return ResponseEntity.ok(ResponseResult.ok(pojoAttractionList));
    }
}
