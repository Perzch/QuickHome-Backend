package com.quickhome.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tim-h
 * @description 回传的用户类
 * @creatDate 2023/7/31 16:56
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PJUser {
    String token;
    Long userId;
}
