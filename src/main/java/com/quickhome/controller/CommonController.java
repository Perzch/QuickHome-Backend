package com.quickhome.controller;

import com.quickhome.request.ResponseResult;
import com.quickhome.util.MinioUtil;
import com.quickhome.util.TencentCOSUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Controller
@Transactional
public class CommonController {

    @Autowired
    private TencentCOSUtils tencentCOSUtils;

    @Autowired
    private MinioUtil minioUtil;

    @SneakyThrows
    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<ResponseResult<?>> upload(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String newFileName = System.currentTimeMillis() + '.' + fileName.substring(fileName.lastIndexOf("."));
        String contentType = file.getContentType();
        minioUtil.uploadFile(file, newFileName, contentType);
        return ResponseEntity.ok(ResponseResult.ok(minioUtil.getBucketName() + "/" + newFileName));
    }

    /**
     * 保存上传的文件
     *
     * @param file   上传的文件
     */
    private String saveUploadedFile(MultipartFile file) throws Exception {
//        获取微秒级时间戳
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
//        获取文件的后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        return tencentCOSUtils.upload(file, timestamp + suffix, "");
    }
}
