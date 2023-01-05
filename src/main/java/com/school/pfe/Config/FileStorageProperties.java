package com.school.pfe.Config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
//@NoArgsConstructor
//@AllArgsConstructor
public class FileStorageProperties {
    private String uploadImgTeachersDir;

    private String uploadImgStudentsDir;

    public String getUploadImgTeachersDir() {
        return uploadImgTeachersDir;
    }

    public void setUploadImgTeachersDir(String uploadImgTeachersDir) {
        this.uploadImgTeachersDir = uploadImgTeachersDir;
    }

    public String getUploadImgStudentsDir() {
        return uploadImgStudentsDir;
    }

    public void setUploadImgStudentsDir(String uploadImgStudentsDir) {
        this.uploadImgStudentsDir = uploadImgStudentsDir;
    }
}
