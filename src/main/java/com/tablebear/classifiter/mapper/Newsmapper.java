package com.tablebear.classifiter.mapper;

import com.tablebear.classifiter.pojo.LowScoreNews;
import com.tablebear.classifiter.pojo.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Newsmapper {
    @Select("select * from news where cate is null")
    List<News> getNewsCateIsNull();

    @Select("select * from news")
    List<News> getAllNews();

    @Update("update news set cate=#{cate} where nid = #{nid}")
    int updateCate(News news);

    @Delete("DELETE FROM news WHERE title IN (SELECT * FROM (SELECT title FROM news GROUP BY title HAVING COUNT(title) > 1) t1) AND nid NOT IN (SELECT * FROM (SELECT MIN(nid) FROM news GROUP BY title HAVING COUNT(title) > 1) t2)")
    int deleteDuplicate();

    @Insert("insert into low_score_news values(#{nid},#{abstractTitle},#{content},#{score})")
    int insertIntoLowScoreNews(LowScoreNews lowScoreNews);

}
