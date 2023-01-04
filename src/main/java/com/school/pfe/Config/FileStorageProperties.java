package com.school.pfe.Config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
//@NoArgsConstructor
//@AllArgsConstructor
public class FileStorageProperties {
    private String uploadImgdir;

    public String getUploadImgdir() {
        return uploadImgdir;
    }

    public void setUploadImgdir(String fileUploadImgdir) {
        this.uploadImgdir = fileUploadImgdir;
    }
}
