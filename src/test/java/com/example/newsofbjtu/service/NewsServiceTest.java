package com.example.newsofbjtu.service;

import com.example.newsofbjtu.dao.NewsMapper;
import com.example.newsofbjtu.util.ImageUtil;
import com.example.newsofbjtu.util.JsonResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NewsServiceTest {

    @Autowired
    NewsService newsService;
    @Autowired
    NewsMapper newsMapper;
    @Test
    void getImageByID() throws IOException {
         int nid = 100001;
        String path = newsMapper.getImageByID(nid);
//        System.out.println(path);
        Resource resource = new ClassPathResource(path);
        System.out.println(resource);
        // 获取相对路径
        String relative_path = resource.getFile().getPath();
//        System.out.println(relative_path);
//        System.out.println(ImageUtil.getImageAsBase64String(relative_path));
        String base64url = ImageUtil.getImageAsBase64String(relative_path);
        // 解码Base64字符串为字节数组
        byte[] imageBytes = Base64.getDecoder().decode(base64url);

        // 将字节数组写入到jpg文件中
        FileOutputStream imageOutFile = new FileOutputStream("output.jpg");
        imageOutFile.write(imageBytes);

        // 关闭流
        imageOutFile.close();
    }

}