package com.quickhome;

import com.quickhome.domain.HomeInformation;
import com.quickhome.mapper.HomeInformationMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class QuickHomeSpringBootApplicationTests {
    @Autowired
    HomeInformationMapper homeInformationMapper;

    @Test
    void contextLoads() {
        List<HomeInformation> homeInformations = homeInformationMapper.selectList(null);
        System.out.println(homeInformations);
    }

}
