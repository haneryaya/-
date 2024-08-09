package com.djtu.fywz.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传工具类
 */
public class UploadUtil {
    /*
        这里的字段image必须和上传页面upload.jsp中的image
        <input type="file" name="image" accept="image/*" />一样的名字
    */
    private MultipartFile image;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public MultipartFile getImage() {
        return this.image;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public void setImage(final MultipartFile image) {
        this.image = image;
    }
    //</editor-fold>
}
