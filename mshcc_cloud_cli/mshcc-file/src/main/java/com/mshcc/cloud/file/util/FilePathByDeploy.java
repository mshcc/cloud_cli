package com.mshcc.cloud.file.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author mshcc
 * @Date 2021/1/13 9:12
 * @Description TODO
 */

@ConfigurationProperties(prefix = "file.path")
@Component
public class FilePathByDeploy {

    private String ROOT_PATH;

    private String IMAGE_PATH;

    private String MARKDOWN_PATH;

    private String OTHERS_PATH;

    public void setROOT_PATH(String ROOT_PATH) {
        if (ROOT_PATH == null) {
            throw new NullPointerException("ROOT_PATH不能为空");
        }
        this.ROOT_PATH = ROOT_PATH;
        File file = new File(this.ROOT_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public void setIMAGE_PATH(String IMAGE_PATH) {
        if (IMAGE_PATH == null) {
            throw new NullPointerException("IMAGE_PATH不能为空");
        }
        this.IMAGE_PATH = IMAGE_PATH;
        File imageFile = new File(this.ROOT_PATH, this.IMAGE_PATH);
        if (!imageFile.exists()) {
            imageFile.mkdirs();
        }
    }

    public void setMARKDOWN_PATH(String MARKDOWN_PATH) {
        if (MARKDOWN_PATH == null) {
            throw new NullPointerException("MARKDOWN_PATH不能为空");
        }
        this.MARKDOWN_PATH = MARKDOWN_PATH;
        File markdownFile = new File(this.ROOT_PATH, this.MARKDOWN_PATH);
        if (!markdownFile.exists()) {
            markdownFile.mkdirs();
        }
    }

    public void setOTHERS_PATH(String OTHERS_PATH) {
        if (OTHERS_PATH == null) {
            throw new NullPointerException("OTHER_PATH不能为空");
        }
        this.OTHERS_PATH = OTHERS_PATH;
        File otherFile = new File(this.ROOT_PATH, this.OTHERS_PATH);
        if (!otherFile.exists()) {
            otherFile.mkdirs();
        }
    }

    public String getROOT_PATH() {
        return ROOT_PATH;
    }

    public String getIMAGE_PATH() {
        return IMAGE_PATH;
    }

    public String getMARKDOWN_PATH() {
        return MARKDOWN_PATH;
    }

    public String getOTHERS_PATH() {
        return OTHERS_PATH;
    }

    public FilePathByDeploy(String ROOT_PATH, String IMAGE_PATH, String MARKDOWN_PATH, String OTHERS_PATH) {
        this.ROOT_PATH = ROOT_PATH;
        this.IMAGE_PATH = IMAGE_PATH;
        this.MARKDOWN_PATH = MARKDOWN_PATH;
        this.OTHERS_PATH = OTHERS_PATH;
    }

    public FilePathByDeploy() {
    }

}