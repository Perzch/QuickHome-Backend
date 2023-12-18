package com.quickhome.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PJFile {
    Long attractionId;
    Long userId;
    Long homeId;
    MultipartFile file;
}
