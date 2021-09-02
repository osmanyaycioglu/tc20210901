package com.training.spring.prop;


public class Language {

    private String name;
    private String shortName;
    private String desc;

    public String getName() {
        return this.name;
    }

    public Language setName(final String nameParam) {
        this.name = nameParam;
        return this;
    }

    public String getShortName() {
        return this.shortName;
    }

    public Language setShortName(final String shortNameParam) {
        this.shortName = shortNameParam;
        return this;
    }

    public String getDesc() {
        return this.desc;
    }

    public Language setDesc(final String descParam) {
        this.desc = descParam;
        return this;
    }

    @Override
    public String toString() {
        return "Language [name=" + this.name + ", shortName=" + this.shortName + ", desc=" + this.desc + "]";
    }


}
