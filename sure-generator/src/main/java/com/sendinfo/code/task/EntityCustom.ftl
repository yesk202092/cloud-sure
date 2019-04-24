<?xml version="1.0" encoding="UTF-8" ?>   
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${config.basepkg}.dao.${table.javaName}Mapper">

    <select id="selectPage" resultMap="BaseResultMap">
        <include refid="mybatis.pageStartSQL" />
        <include refid="selectFieldSQL" />
        FROM ${table.name}
        <include refid="page_condition" />
        <include refid="mybatis.pageEndSQL" />
    </select>

    <!-- 查询所有 -->
    <sql id="selectFieldSQL">
        SELECT
        <#list table.columns as column>
            ${column.name} ${column.javaName}<#if column_has_next>,</#if>
        </#list>
    </sql>
    <!-- 分页查询（条件） -->
    <sql id="page_condition">
        <where>
            <#list table.columns as column>
                <#if column.condition>
                    <#if column.javaName != "corpCode" && column.javaName != "corpGroupCode">
                        <if test="entity.${column.javaName} != null<#if column.stringType> and entity.${column.javaName} != ''</#if>">
                            AND ${column.name} = ${"#"}{entity.${column.javaName},jdbcType=${column.jdbcType}}
                        </if>
                    <#else>
                        <if test="${column.javaName} != null<#if column.stringType> and ${column.javaName} != ''</#if>">
                            AND ${column.name} = ${"#"}{${column.javaName},jdbcType=${column.jdbcType}}
                        </if>
                    </#if>
                </#if>
            </#list>
        </where>
    </sql>


</mapper>   
