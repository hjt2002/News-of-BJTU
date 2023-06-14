package com.example.newsofbjtu.service;

import com.example.newsofbjtu.bean.Collection;
import com.example.newsofbjtu.bean.News;
import com.example.newsofbjtu.dao.CollectionMapper;
import com.example.newsofbjtu.util.JsonResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionService {
    final
    CollectionMapper collectionMapper;


    public CollectionService(CollectionMapper collectionMapper) {
        this.collectionMapper = collectionMapper;
    }
    public JsonResult createCollection(int uid,int nid){
        if(collectionMapper.createCollection(uid,nid)!=0){
            return new JsonResult("1","收藏成功");
        }else {
            return new JsonResult("0","收藏失败");
        }
    }
    public JsonResult deleteCollection(String uid,String nid){
        if(collectionMapper.deleteCollection(uid,nid)!=0){
            return new JsonResult("1","取消收藏成功");
        }else {
            return new JsonResult("0","取消收藏成功");
        }
    }

    // 获取收藏
    public JsonResult<List<News>>getCollection(String uid){
        List<Collection>list= collectionMapper.getCollection(uid);
        List<News>r_list=new ArrayList<>();
        for (Collection collection : list) {
            //遍历List,根据nid获取新闻
            News news = collectionMapper.getNewsByID(collection.getNid());
            r_list.add(news);
        }
//        System.out.println(r_list.toString());
        if(!list.isEmpty()){
            return new JsonResult<>(r_list);
        }else {
            return new JsonResult<>("0","收藏查询失败");
        }
    }

}
