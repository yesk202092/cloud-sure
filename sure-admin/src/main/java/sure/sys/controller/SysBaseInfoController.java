package sure.sys.controller;

import com.sure.BaseController;
import com.sure.DataGrid;
import com.sure.page.Page;
import com.sure.page.Params;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tk.mybatis.mapper.entity.Example;
import sure.sys.entity.SysBaseInfo;
import sure.sys.biz.SysBaseInfoBiz;

/**
 * @类名: 系统信息表Controller
 * @描述: 系统信息表
 * @作者:
 * @日期: 2019-04-24 11:00:13
 */
@Controller
@RequestMapping("sysBaseInfo")
public class SysBaseInfoController extends BaseController<SysBaseInfoBiz, SysBaseInfo> {

    /**
     * @名称: grid
     * @描述: 分页查询
     * @作者: yesk
     * @参数: @param page
     * @参数: @param name
     * @参数: @return
     * @返回: DataGrid<UserDetail>
     */
    @RequestMapping(value = "grid", method = RequestMethod.POST)
    @ResponseBody
    public DataGrid<SysBaseInfo> page(SysBaseInfo sysBaseInfo, Page page) {
        Params params = Params.create();
        params.add(sysBaseInfo);
        return baseBiz.selectPage("selectPage", params, page);
    }

    /**
     * @名称: list
     * @描述: 进入列表界面
     * @作者: yesk
     * @参数: @return
     * @返回: String
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {

        return "/manage/sys/sysbaseinfo-list";
    }

    /**
     * @名称: add
     * @描述: 进入添加界面
     * @作者: yesk
     * @参数: @return
     * @返回: String
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)

    public String add() {
        return "/manage/sys/sysbaseinfo-add";
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
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Long id, ModelMap model) {
        model.put("sysBaseInfo", baseBiz.get(id));
        return "/manage/sys/sysbaseinfo-edit";
    }
}