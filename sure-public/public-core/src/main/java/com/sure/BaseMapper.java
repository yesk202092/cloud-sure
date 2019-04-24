package com.sure;

import tk.mybatis.mapper.common.Mapper;

public interface BaseMapper <T> extends Mapper,MyBatiseMapper<T> {
}
