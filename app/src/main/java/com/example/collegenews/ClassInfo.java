package com.example.collegenews;


public class ClassInfo {
    private String data;
    private String condition;
    private String need;

    public ClassInfo(String data,String condition,String need) {
        this.data = data;
        this.condition=condition;
        this.need=need;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
