package com.example.newsofbjtu.dao;

import com.example.newsofbjtu.bean.Collection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollectionMapper {
    int createCollection(String uid,String nid);
    List<Collection> getCollection(String uid);
    int deleteCollection(String uid,String nid);
}
