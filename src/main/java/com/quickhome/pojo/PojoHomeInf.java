package com.quickhome.pojo;

import com.quickhome.domain.HomeInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PojoHomeInf {
    private HomeInformation homeInformation;
    private int page;
    private int size;
}
