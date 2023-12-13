package com.quickhome.util;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/12/13 8:20
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "tencent.cos")
public class TencentCOSproperties {
    private String rootSrc ;
    private String bucketAddr;
    private String SecretId;
    private String SecretKey;
    private String bucketName;
}
