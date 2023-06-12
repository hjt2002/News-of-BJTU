package com.example.newsofbjtu.bean;


public class Comment {

  private int cid;
  private int uid;
  private int nid;
  private String text;


  public int getCid() {
    return cid;
  }

  public void setCid(int cid) {
    this.cid = cid;
  }


  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }


  public int getNid() {
    return nid;
  }

  public void setNid(int nid) {
    this.nid = nid;
  }


  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

}
