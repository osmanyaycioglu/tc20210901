package com.training.spring.prop;


public class Language {

    private String name;
    private String shortName;
    private String desc;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(final String shortNameParam) {
        this.shortName = shortNameParam;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(final String descParam) {
        this.desc = descParam;
    }

    @Override
    public String toString() {
        return "Language [name=" + this.name + ", shortName=" + this.shortName + ", desc=" + this.desc + "]";
    }


}
