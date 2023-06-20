package com.quickhome.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quickhome.domain.HomeInformation;
import com.quickhome.mapper.HomeInformationMapper;
import com.quickhome.pojo.PojoHomeInf;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.HomeInformationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Max;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
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
        HomeInformation homeInf=HomeInformation.builder().homeType_zch_hwz_gjc(homeType).homeArea_zch_hwz_gjc(area).build();
        PojoHomeInf pojoHomeInf=new PojoHomeInf(homeInf,pageNumber,size);
        List<HomeInformation> allHomeInformationZchHwzGjc = homeInfSer_zch_hwz_gjc.list();
        return ResponseEntity.ok(ResponseResult.ok(allHomeInformationZchHwzGjc));
    }

    @GetMapping("/getHomeInfById")
    @ResponseBody
    public ResponseEntity<?> getHomeInfById(@RequestParam Long id, HttpServletRequest req) {
        return ResponseEntity.ok(ResponseResult.ok(homeInfSer_zch_hwz_gjc.getById(id)));
    }
}
