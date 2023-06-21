package com.quickhome.controller;

import com.quickhome.request.ResponseResult;
import com.quickhome.domain.HomeInformation;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.quickhome.service.HomeInformationService;

import java.util.List;

@Controller("HomeInfCon")
@RequestMapping("/homeInf")
public class HomeInformationController {

    @Autowired
    private HomeInformationService homeInfSer_zch_hwz_gjc;
    static final Log Logger = LogFactory.getLog(HomeInformationController.class);

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<?> getAllHomeInf(@RequestParam(required = false, defaultValue = "all") String homeType,
                                           @RequestParam(required = false, defaultValue = "0.0") double area,
                                           @RequestParam(defaultValue = "1") int pageNumber,
                                           @RequestParam(required = false, defaultValue = "5") int size,
                                           HttpServletRequest req) {
        List<HomeInformation> allHomeInformationZchHwzGjc = homeInfSer_zch_hwz_gjc.list();
        return ResponseEntity.ok(ResponseResult.ok(allHomeInformationZchHwzGjc));
    }

    @GetMapping("/getHomeInfById")
    @ResponseBody
    public ResponseEntity<?> getHomeInfById(@RequestParam Long id, HttpServletRequest req) {
        return ResponseEntity.ok(ResponseResult.ok(homeInfSer_zch_hwz_gjc.getById(id)));
    }
}
