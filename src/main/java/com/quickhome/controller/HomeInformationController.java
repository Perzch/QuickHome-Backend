package com.quickhome.controller;

import com.quickhome.entity.HomeInformation;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.HomeInfService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("HomeInfCon")
@RequestMapping("/homeInf")
public class HomeInformationController {

    @Autowired
    private HomeInfService homeInfSer_zch_hwz_gjc;

    static final Log Logger = LogFactory.getLog(HomeInformationController.class);

    @RequestMapping("/getAllHomeInf")
    @ResponseBody
    public ResponseEntity<?> getAllHomeInf() {
        List<HomeInformation> allHomeInformationZchHwzGjc = homeInfSer_zch_hwz_gjc.getAllHomeInformation_zch_hwz_gjc();
        return ResponseEntity.ok(ResponseResult.ok(allHomeInformationZchHwzGjc));
    }
    @RequestMapping("/getHomeInfById")
    @ResponseBody
    public ResponseEntity<?> getHomeInfById(@RequestBody HomeInformation home, HttpServletRequest req){
        home=homeInfSer_zch_hwz_gjc.getHomeInfByHomeId_zch_hwz_gjc(home.getHomeId_zch_hwz_gjc());
        return ResponseEntity.ok(ResponseResult.ok(home));
    }
}
