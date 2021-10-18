package com.flywinter.dao;

import com.flywinter.entity.Blog;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/23 13:57
 * Description:
 */
public interface BlogMapper {
    //插入数据
    int addBlog(Blog blog);
    //查询博客
    List<Blog> queryBlogIF(Map map);
    List<Blog> queryBlogChoose(Map map);
    int updateBlog(Map map);
    //查询第1-2-3行记录的博客
    List<Map> queryBlogForeach(Map map);
}
