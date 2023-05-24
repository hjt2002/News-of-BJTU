package com.example.newsofbjtu.service;

import com.example.newsofbjtu.bean.Collection;
import com.example.newsofbjtu.dao.CollectionMapper;
import com.example.newsofbjtu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionService {
    final
    CollectionMapper collectionMapper;

    public CollectionService(CollectionMapper collectionMapper) {
        this.collectionMapper = collectionMapper;
    }
    public JsonResult createCollection(String uid,String nid){
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
    public JsonResult<Collection>getCollection(String uid){
        Collection collection = collectionMapper.getCollection(uid);
        if(collection!=null){
            return new JsonResult<>(collection);
        }else {
            return new JsonResult<>("0","收藏查询失败");
        }
    }
}
