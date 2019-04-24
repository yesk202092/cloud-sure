package ${config.basepkg}.controller;

import com.sure.BaseController;
import com.sure.DataGrid;
import com.sure.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tk.mybatis.mapper.entity.Example;
import ${config.basepkg}.entity.${table.javaName};
import ${config.basepkg}.biz.${table.javaName}Biz;

/**
* @类名: ${table.comment}Controller
* @描述: ${table.comment}
* @作者:
* @日期: ${config.date}
*/
@Controller
@RequestMapping("${table.javaNameL}")
public class ${table.javaName}Controller extends BaseController
<${table.javaName}Biz, ${table.javaName}> {

/**
* @名称: grid
* @描述: 分页查询
* @作者: yesk
* @参数: @param page
* @参数: @param name
* @参数: @return
* @返回: DataGrid
<UserDetail>
    */
    @RequestMapping(value = "grid",method = RequestMethod.POST)
    @ResponseBody
    public DataGrid<${table.javaName}> page(${table.javaName} ${table.javaNameL}, Page page){
    Params params = Params.create();
    params.add(${table.javaNameL});
    return baseBiz.selectPage("selectPage", params, page);
    }

    /**
    * @名称: list
    * @描述: 进入列表界面
    * @作者: yesk
    * @参数: @return
    * @返回: String
    */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
    return "${config.catalog?replace('.','/')}/${table.javaNameL?lower_case}-list";
    }

    /**
    * @名称: add
    * @描述: 进入添加界面
    * @作者: yesk
    * @参数: @return
    * @返回: String
    */
    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String add(){
    return "${config.catalog?replace('.','/')}/${table.javaNameL?lower_case}-add";
    }

    /**
    * @名称: edit
    * @描述: 进入修改界面
    * @作者: yesk
    * @参数: @param id
    * @参数: @param model
    * @参数: @return
    * @返回: String
    */
    @RequestMapping(value = "edit",method = RequestMethod.GET)
    public String edit(Long id, ModelMap model){
    model.put("${table.javaNameL}", baseBiz.get(id));
    return "${config.catalog?replace('.','/')}/${table.javaNameL?lower_case}-edit";
    }
    }