<?xml version="1.0" encoding="UTF-8" ?>   
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${config.basepkg}.dao.impl.${table.javaName}DaoImpl">

	<!-- 插入实体 -->
	<insert id="insert" parameterType="${config.basepkg}.entity.${table.javaName}">
		INSERT INTO ${table.name} (
		<#list table.columns as column>
		   	${column.name}<#if column_has_next>,</#if>
		</#list>
		) VALUES (
		<#list table.columns as column>
		   	${"#"}{${column.javaName},jdbcType=${column.jdbcType}}<#if column_has_next>,</#if>
		</#list>
		)
		<selectKey databaseId="mysql" keyProperty="id" order="AFTER" resultType="long">
			SELECT LAST_INSERT_ID() AS ID
		</selectKey>
		<selectKey databaseId="oracle" keyProperty="id" order="BEFORE" resultType="long">
			SELECT SEQ_${table.name}.nextval as id FROM dual
		</selectKey>
	</insert>

	<!-- 更新实体 -->
	<update id="update" parameterType="${config.basepkg}.entity.${table.javaName}">
		UPDATE ${table.name}
		<set>
		<#list table.columns as column>
		<#if column.name != 'ID'>
			<if test="${column.javaName} != null">
				${column.name} = ${"#"}{${column.javaName},jdbcType=${column.jdbcType}},
			</if>
		</#if>
		</#list>
		</set>
		WHERE ID = ${"#"}{id,jdbcType=INTEGER}
	</update>
	
	<!-- 更新实体 -->
	<update id="updateFields" parameterType="${config.basepkg}.entity.${table.javaName}">
		UPDATE ${table.name}
		<set>
		<#list table.columns as column>
		<#if column.name != 'ID'>
			${column.name} = ${"#"}{${column.javaName},jdbcType=${column.jdbcType}},
		</#if>
		</#list>
		</set>
		WHERE ID = ${"#"}{id,jdbcType=INTEGER}
	</update>

	<!-- 删除实体 -->
	<update id="delete" parameterType="${config.basepkg}.entity.${table.javaName}">
		<#if table.deletedEntity>
		UPDATE ${table.name}
		   SET DELETED     = ${"#"}{deleted,jdbcType=VARCHAR},
		       MODIFY_BY   = ${"#"}{modifyBy,jdbcType=VARCHAR},
		       MODIFY_TIME = ${"#"}{modifyTime,jdbcType=TIMESTAMP}
		 WHERE ID = ${"#"}{id,jdbcType=INTEGER}
		<#else>
		DELETE FROM ${table.name} WHERE ID = ${"#"}{id,jdbcType=INTEGER}
		</#if>
	</update>

	<!-- 查询字段 -->
	<sql id="selectFieldSQL">
		SELECT 
		<#list table.columns as column>
		       ${column.name} ${column.javaName}<#if column_has_next>,</#if>
		</#list>
	</sql>

	<!-- 查询 -->
	<select id="get" parameterType="map" resultType="${config.basepkg}.entity.${table.javaName}">
		<include refid="selectFieldSQL" />
		  FROM ${table.name}
		 WHERE ID = ${"#"}{id,jdbcType=INTEGER}
		 <#if table.deletedEntity>
		   AND DELETED = ${"#"}{deleted,jdbcType=VARCHAR}
		 </#if>
	</select>

	<!-- 查询 -->
	<select id="find" parameterType="${config.basepkg}.entity.${table.javaName}" resultType="${config.basepkg}.entity.${table.javaName}">
		<include refid="selectFieldSQL" />
		  FROM ${table.name}
		<where>
			<if test="id != null">
				AND ID = ${"#"}{id,jdbcType=INTEGER}
			</if>
		<#list table.columns as column>
		<#if column.condition>
			<if test="${column.javaName} != null<#if column.stringType> and ${column.javaName} != ''</#if>">
				AND ${column.name} = ${"#"}{${column.javaName},jdbcType=${column.jdbcType}}
			</if>
		</#if>
		</#list>
		</where>
	</select>

	<!-- 查询所有 -->
	<select id="findAll" parameterType="map" resultType="${config.basepkg}.entity.${table.javaName}">
		<include refid="selectFieldSQL" />
		  FROM ${table.name}
		 <#if table.deletedEntity>
		 WHERE DELETED = ${"#"}{deleted,jdbcType=VARCHAR}
		 </#if>
	</select>

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

	<!-- 分页查询（计数） -->
	<select id="page_count" parameterType="map" resultType="int">
		SELECT count(*)
		  FROM ${table.name}
		<include refid="page_condition" />
	</select>

	<!-- 分页查询（数据） -->
	<select id="page_datas" parameterType="map" resultType="${config.basepkg}.entity.${table.javaName}">
		<include refid="mybatis.pageStartSQL" />
		<include refid="selectFieldSQL" />
		  FROM ${table.name}
		<include refid="page_condition" />
		<include refid="mybatis.pageEndSQL" />
	</select>

</mapper>   
