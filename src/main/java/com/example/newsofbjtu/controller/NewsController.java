package com.example.newsofbjtu.controller;

import com.example.newsofbjtu.bean.News;
import com.example.newsofbjtu.service.NewsService;
import com.example.newsofbjtu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    final
    NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/getNewsByRecommend")
    public JsonResult<List<News>> getNewsByRecommend(@RequestParam String recommend){
        return newsService.getNewsByRecommend(recommend);
    }
    @GetMapping("/getNewsByType")
    public JsonResult<List<News>>getNewsByType(@RequestParam String type){
        return newsService.getNewsByType(type);
    }
    @GetMapping("/getNewsByID")
    public JsonResult<News>getNewsByID(@RequestParam String nid){
        return newsService.getNewsByID(nid);
    }
    @PostMapping("/createNews")
    public JsonResult createNews(@RequestBody Map<String,String> map) throws ParseException {
        String nid = map.get("nid");
        String title = map.get("title");
        String author =  map.get("author");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String tmp = map.get("time"); // 获取时间字符串
//        System.out.println(tmp.getClass());
        Date time = simpleDateFormat.parse(tmp); // 将字符串转换成Date格式
        String picture = map.get("picture");
        String content = map.get("content");
        String type = map.get("type");
        String recommend = map.get("recommend");

        return newsService.createNews(nid,title,author,time,
                picture,content,type,recommend);
    }
}
