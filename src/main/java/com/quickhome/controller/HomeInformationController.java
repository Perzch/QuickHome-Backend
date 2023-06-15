package com.quickhome.controller;

import com.quickhome.entity.HomeInformation;
import com.quickhome.service.HomeInfService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("HomeInfCon")
@RequestMapping("/homeInf")
public class HomeInformationController {

    @Autowired
    HomeInfService homeInfSer_zch_hwz_gjc;

    static final Log Logger = LogFactory.getLog(HomeInformationController.class);

    @RequestMapping("/getAllHomeInf")
    @ResponseBody
    public ResponseEntity<List<HomeInformation>> getAllHomeInf() {
        List<HomeInformation> allHomeInformationZchHwzGjc = homeInfSer_zch_hwz_gjc.getAllHomeInformation_zch_hwz_gjc();
        return ResponseEntity.ok(allHomeInformationZchHwzGjc);
    }
//    @RequestMapping
}