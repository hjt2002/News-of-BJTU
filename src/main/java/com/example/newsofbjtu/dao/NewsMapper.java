package com.example.newsofbjtu.dao;

import com.example.newsofbjtu.bean.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface NewsMapper {
    // 根据是否推荐获取新闻
    List<News>getNewsByRecommend(String recommend);
    // 通过新闻类型获取新闻
    List<News>getNewsByType(String type);
    // 通过nid获取新闻
    News getNewsByID(String nid);
    // 添加新闻
    int createNews(String nid, String title, String author, Date time,
                        String picture,String content,String type,String recommend);
    // 删除新闻
    int deleteNews(String nid);
}
