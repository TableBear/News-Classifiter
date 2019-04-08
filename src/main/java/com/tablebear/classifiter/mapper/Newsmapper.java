package com.tablebear.classifiter.mapper;

import com.tablebear.classifiter.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface Newsmapper {
    @Select("select * from news where cate is null")
    List<News> getNews();

    @Update("update news set cate=#{cate} where nid = #{nid}")
    int updateCate(News news);


}
