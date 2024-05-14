package show.me.the.code.demo;

import show.me.the.code.meta.model.Action;
import show.me.the.code.meta.model.Entity;

@Entity(name = "逻辑机器人", code = "logic_robot", desc = "逻辑机器人实体")
public class LogicRobotEntity {

    // 创建名称，编码，描述，状态字段
    private String name;
    private String code;
    private String description;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Action(name = "如果", code = "if_func", desc = "如果函数")
    public String ifFunc(String condition, String tureValue, String falseValue) {
        String x = "执行如果函数，如果条件为真则：" + tureValue + "为假则：" + falseValue;
        System.out.println(x);
        return x;
    }

}
