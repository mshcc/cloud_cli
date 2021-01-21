package com.mshcc.cloud.file.controller;

import com.mshcc.cloud.file.dto.GiftDTO;
import com.mshcc.cloud.file.util.FilePathByDeploy;
import com.mshcc.cloud.file.util.UUIDGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Objects;

/**
 * @author mshcc
 * @Date 2021/1/12 17:01
 * @Description TODO
 */
@RestController
@Api(tags = "测试文件传输")
public class TestUpload {
    @Autowired
    private FilePathByDeploy filePathByDeploy;

    @PostMapping("upload")
    @ApiOperation("测试文件上传")
    public String upLoadPics(@ApiParam(value = "图片", required = true) @RequestParam("files") MultipartFile[] files) throws IOException {
        for (MultipartFile file : files) {
            String[] info = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
            String tail = info[info.length - 1];
            file.transferTo(new File(filePathByDeploy.getROOT_PATH() + "\\" + filePathByDeploy.getIMAGE_PATH() + "\\" + UUIDGenerator.uuidGenerator(tail)));
        }
        return "{\n\t\"status\":200,\n\t\"msg\": \"图片上传成功\",\n\t\"data\": {\n\n\t\t}\n}";
    }

    @ApiOperation("测试图片显示")
    @GetMapping("showFirstPic")
    public String showPics(HttpServletResponse response) {
        File file = new File(filePathByDeploy.getROOT_PATH() + "\\" + filePathByDeploy.getIMAGE_PATH());
        File[] files = file.listFiles();
        if (files.length <= 0) {
            return "{\n\t\"status\":200,\n\t\"msg\": \"图片库没有图片\",\n\t\"data\": {\n\n\t\t}\n}";
        }
        file = files[0];
        try (InputStream is = new FileInputStream(file);
             OutputStream os = response.getOutputStream();) {
            byte[] buffer = new byte[1024];
            while (is.read(buffer) != -1) {
                os.write(buffer);
            }
            os.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return "{\n\t\"status\":200,\n\t\"msg\": \"图片查看成功\",\n\t\"data\": {\n\n\t\t}\n}";
    }

    @ApiOperation("测试带图片多参上传")
    @PostMapping("uploadGift")
    public String up(@RequestParam MultipartFile[] files,GiftDTO name) throws IOException {
        System.out.println(name);
        for (MultipartFile file : files) {
            String[] info = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
            String tail = info[info.length - 1];
            file.transferTo(new File(filePathByDeploy.getROOT_PATH() + "\\" + filePathByDeploy.getIMAGE_PATH() + "\\" + UUIDGenerator.uuidGenerator(tail)));
        }
        return "{\n\t\"status\":200,\n\t\"msg\": \"添加成功\",\n\t\"data\": {\n\n\t\t}\n}";
    }
}