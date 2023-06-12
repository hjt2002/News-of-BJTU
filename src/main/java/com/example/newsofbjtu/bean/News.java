package com.example.newsofbjtu.bean;


import java.util.Date;

public class News {

  private int nid;
  private String title;
  private String author;
  private Date time;
  private String picture;
  private String content;
  private String type;
  private String recommend;


  public int getNid() {
    return nid;
  }

  public void setNid(int nid) {
    this.nid = nid;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }


  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }


  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getRecommend() {
    return recommend;
  }

  public void setRecommend(String recommend) {
    this.recommend = recommend;
  }

}
