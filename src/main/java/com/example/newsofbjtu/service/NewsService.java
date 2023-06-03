package com.example.newsofbjtu.service;

import com.example.newsofbjtu.bean.News;
import com.example.newsofbjtu.dao.NewsMapper;
import com.example.newsofbjtu.util.ImageUtil;
import com.example.newsofbjtu.util.JsonResult;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class NewsService {
    final
    NewsMapper newsMapper;
    public NewsService(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }
    public JsonResult<List<News>>getNewsByRecommend(String recommend){
        List<News>list = newsMapper.getNewsByRecommend(recommend);
        if(!list.isEmpty()){
            return new JsonResult<>(list);
        }else {
            return new JsonResult<>("0","推荐新闻查询失败");
        }
    }
    public JsonResult<List<News>>getNewsByType(String type){
        List<News>list = newsMapper.getNewsByType(type);
        if(!list.isEmpty()){
            return new JsonResult<>(list);
        }else {
            return new JsonResult<>("0","该类型新闻查询失败");
        }
    }
    public JsonResult<News>getNewsByID(String nid){
        News news = newsMapper.getNewsByID(nid);
        if(news != null){
            return new JsonResult<>(news);
        }else {
            return new JsonResult<>("0","查询新闻失败");
        }
    }
    public JsonResult createNews(String nid, String title, String author, Date time,
                                 String picture,String content,String type,String recommend) {
        if (newsMapper.createNews(nid, title, author, time,
                picture, content, type, recommend) != 0) {
            return new JsonResult("1", "新闻添加成功");
        } else {
            return new JsonResult("0","新闻添加失败");
        }
    }
    public JsonResult deleteNews(String nid){
        if(newsMapper.deleteNews(nid)!=0){
            return new JsonResult("1","新闻删除成功");
        }else {
            return new JsonResult("0","新闻删除失败");
        }
    }
    public JsonResult<String> getImageByID(String nid) throws IOException {
        // 在数据库中获取该新闻对应的图片路径
        String pictureUrl = newsMapper.getImageByID(nid);
        if(!pictureUrl.isEmpty()){
            Resource resource = new ClassPathResource(pictureUrl);
            String relative_path = resource.getFile().getPath();
            String base64Str = ImageUtil.getImageAsBase64String(relative_path);
            return new JsonResult<>(base64Str);
        }else {
            return new JsonResult<>("0","图片查询失败");
        }
    }
}
