package com.sun.headerMap;

/**
 * create by qiulisun on 2019/1/6.<br>
 */
public class PersonVO {
    private Long headerId;
    private Long lineId;
    private String name;
    private String sex;
    private String age;
    private String lineName;

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    @Override
    public String toString() {
        return "PersonVO{" +
                "headerId=" + headerId +
                ", lineId=" + lineId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", lineName='" + lineName + '\'' +
                '}';
    }
}
