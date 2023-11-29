package com.quickhome.pojo;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/6/24 11:12
 */

import com.quickhome.domain.AttractionImage;
import com.quickhome.domain.Attractions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PojoAttraction {
    private Long attractionsId;
    List<AttractionImage> attractionImageList;
    private Attractions attractions;
    private Integer collectionCount;
}
