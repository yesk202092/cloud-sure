package com.sure;

import com.sure.MybatisProvider.MybatisSelectProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface MyBatiseMapper<T> {
    @SelectProvider(
            type = MybatisSelectProvider.class,
            method = "dynamicSQL"
    )
    T selectById(Object var1);

    @SelectProvider(
            type = MybatisSelectProvider.class,
            method = "dynamicSQL"
    )
    List<T> selectTotal();
}
