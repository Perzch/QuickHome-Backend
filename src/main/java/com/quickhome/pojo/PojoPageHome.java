package com.quickhome.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tim-h
 * @description 用于前端获取界面的pojoPage
 * @creatDate 2023/6/21 15:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PojoPageHome {
    private Integer page;
    private Integer size;
    private PojoHome pojoHome;
}
