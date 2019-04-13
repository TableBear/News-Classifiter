package com.tablebear.classifiter.pojo;


public class LowScoreNews {

  private String nid;
  private String abstractTitle;
  private String content;
  private double score;


  public LowScoreNews() {
  }

  public LowScoreNews(String nid, String abstractTitle, String content, double score) {
    this.nid = nid;
    this.abstractTitle = abstractTitle;
    this.content = content;
    this.score = score;
  }

  public String getNid() {
    return nid;
  }

  public void setNid(String nid) {
    this.nid = nid;
  }


  public String getAbstractTitle() {
    return abstractTitle;
  }

  public void setAbstractTitle(String abstractTitle) {
    this.abstractTitle = abstractTitle;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

}
