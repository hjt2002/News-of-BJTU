package com.example.newsofbjtu.dao;

import com.example.newsofbjtu.bean.Collection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollectionMapper {
    int createCollection(int uid,int nid);
    List<Collection> getCollection(String uid);
    int deleteCollection(String uid,String nid);
}
