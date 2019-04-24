package com.sure;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sure.page.Page;
import com.sure.page.Params;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import sure.Enum.EnumContons;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

public abstract class BaseBiz<M extends BaseMapper<T>, T extends Entity<PK>, PK extends Serializable> {
    @Autowired
    protected M mapper;
    @Autowired
    private SqlSession sqlSession;

    public BaseBiz() {
    }

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    /**
     * 分页查询
     */
    public <E> DataGrid<E> selectPage(String id, Params params, Page page) {
        PageHelper.startPage(page.getPage(), page.getLimit());
        if (page.getSort() != null && !"".equals(page.getSort())) {
            PageHelper.orderBy(page.getSort() + " " + page.getOrder());
        }

        List<E> list = this.sqlSession.selectList(this.buildStatNameById(id), params);
        PageInfo<E> pageInfo = new PageInfo(list);
        return new DataGrid(pageInfo.getList(), (int)pageInfo.getTotal(), pageInfo.getPages());
    }

    /**
     * list根据实体类查询
     */
    public List<T> list(T entity) {
        return this.mapper.select(entity);
    }

    /**
     * 根据实体类查询数据
     */
    public Long selectCount(T entity) {
        return new Long((long) this.mapper.selectCount(entity));
    }

    /**
     * 插入数据
     */
    public void insert(T entity) {
        this.mapper.insert(entity);
    }

    /**
     * 批量插入
     */
    public void saveAll(List<T> list) {
        list.forEach((obj) -> {
            this.mapper.insert(obj);
        });
    }

    /**
     *
     * */
    public T get(Long id) {
        return mapper.selectById(id);
    }
    /**
     * 保存
     */
    public T save(T entity) {
        this.mapper.insert(entity);
        return entity;
    }

    /**
     * 查所有数据
     */
    public List<T> selectAll() {
        return this.mapper.selectAll();
    }

    public void insertSelective(T entity) {
        this.mapper.insertSelective(entity);
    }

    /**
     * 逻辑删除
     */
    public void delete(T entity) {
        entity.setDeleted(EnumContons.TRUE.value);
        this.update(entity);
    }

    /**
     * 批量逻辑删除
     */
    public void deleteAll(List<T> list) {
        list.forEach((obj) -> {
            obj.setDeleted(EnumContons.TRUE.value);
            this.update(obj);
        });
    }

    /**
     * 物理删除
     */
    public void deleteTrue(PK id) {
        this.mapper.deleteByPrimaryKey(id);
    }

    /**
     * 单条更新
     */
    public void update(T entity) {
        this.mapper.updateByPrimaryKey(entity);
    }

    public void updateSelectiveById(T entity) {
        this.mapper.updateByPrimaryKeySelective(entity);
    }

    protected String buildStatNameById(String id) {
        String namespace = this.getClass().getName().replace("biz.", "dao.").replace("Biz", "Mapper");
        return namespace + "." + id;
    }

    protected String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}
