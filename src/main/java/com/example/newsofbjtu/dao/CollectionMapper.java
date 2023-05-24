package com.example.newsofbjtu.dao;

import com.example.newsofbjtu.bean.Collection;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollectionMapper {
    int createCollection(String uid,String nid);
    Collection getCollection(String uid);
    int deleteCollection(String uid,String nid);
}
