package com.quickhome.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Tim-h
 * @description 用于前端获取界面的pojoPage
 * @creatDate 2023/6/21 15:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PojoPageHome {
    private Long page;
    private Long size;
    private List<PojoHome> pojoHome;
}
