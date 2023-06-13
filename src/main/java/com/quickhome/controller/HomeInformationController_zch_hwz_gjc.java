package com.quickhome.controller;

import com.quickhome.entity.HomeInformation_zch_hwz_gjc;
import com.quickhome.service.HomeInfService_zch_hwz_gjc;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("HomeInfCon")
@RequestMapping("/homeInf")
public class HomeInformationController_zch_hwz_gjc {

    @Autowired
    HomeInfService_zch_hwz_gjc homeInfSer_zch_hwz_gjc;

    static final Log Logger= LogFactory.getLog(HomeInformationController_zch_hwz_gjc.class);
    @RequestMapping("/getAllHomeInf")
    @ResponseBody
    public List<HomeInformation_zch_hwz_gjc> getAllHomeInf(){
        List<HomeInformation_zch_hwz_gjc> allHomeInformationZchHwzGjc = homeInfSer_zch_hwz_gjc.getAllHomeInformation_zch_hwz_gjc();
        return allHomeInformationZchHwzGjc;
    }
//    @RequestMapping
}
