<div class="pd-20">
  <div class="search_buttons">
    <form class="datagrid-search">
      <div class="table_search">
      <#list table.columns as column>
        <#if column.view>
          <input type="text" class="input-text search-input" placeholder="${column.comment}"
                 name="${column.javaName}">
        </#if>
      </#list>
        <button type="submit" class="btn btn-success radius" style="margin-bottom:5px;"> 搜索</button>
      </div>
    </form>
  </div>
  <div style="padding-top:5px;padding-bottom:10px;">
    <span class="btn btn-primary radius datagrid-tool" data-toggle="add">
      <i class="Hui-iconfont">&#xe600;</i> 添加
    </span>
    <span class="btn btn-danger radius datagrid-tool" data-toggle="del">
      <i class="Hui-iconfont">&#xe6e2;</i> 删除
    </span>
  </div>
  <table class="table table-border table-bordered table-hover table-bg table-sort datagrid"
         width="100%"
         action="${"$"}{ctx.contextPath}/${config.prefix}/${table.javaNameL}/grid" keyValue="id">
    <thead>
    <tr class="text-c">
      <th data-options="columnAttr:'checkbox'"></th>
    <#list table.columns as column>
      <#if column.view>
        <th data-options="field:'${column.javaName}',width:100, sortable:true">${column.comment}</th>
      </#if>
    </#list>
      <th data-options="align:'center',columnAttr:'operation',formatterType:'insert'">操作</th>
    </tr>
    </thead>
  </table>
</div>