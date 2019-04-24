package sure.Enum;

public enum EnumResStatus {
    success(200, "成功，并返回提示信息"),
    successDate(201, "成功，并返回数据"),
    errorNoLogin(400, "登陆超时，请重新登陆"),
    errorNoAuth(401, "没有权限"),
    errorCustom(402, "自定义异常"),
    error(500, "系统错误");

    private Integer code;
    private String desc;

    private EnumResStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
