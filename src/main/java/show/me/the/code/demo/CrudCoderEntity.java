package show.me.the.code.demo;

import show.me.the.code.meta.model.Action;
import show.me.the.code.meta.model.Entity;

@Entity(name = "增删改查机器人",code = "robot", desc = "可以执行'增''删''改''查'的机器人")
public class CrudCoderEntity {

    // 名称，编码，类型，状态，
    // 创建人，创建时间，修改人，修改时间
    // 是否删除，删除人，删除时间
    private String name;
    private String code;
    private String type;
    private String status;
    private String creator;
    private String createTime;
    private String modifier;
    private String modifyTime;
    private String isDeleted;
    private String deleteTime;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    @Action(name = "创建")
    public void create(String name) {
        this.name = name;
        System.out.println("创建了名为 " + name + " 的对象");
    }

    @Action(name = "删除")
    public String delete() {
        String x = "删除了名为 " + name + " 的对象";
        System.out.println(x);
        return x;
    }

    @Action(name = "更新")
    public String update() {
        String x = "更新了名为 " + name + " 的对象";
        System.out.println(x);
        return x;
    }

    @Action(name = "读取")
    public String read(String name) {
        String x = "读取了名为 " + name + " 的对象";
        System.out.println(x);
        return x;
    }

}
