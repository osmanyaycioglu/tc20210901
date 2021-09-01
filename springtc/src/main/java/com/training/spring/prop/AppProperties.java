package com.training.spring.prop;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.prop")
public class AppProperties {

    private String                language;
    private int                   count;
    private List<String>          languageList;
    private Map<String, String>   languageDescription;
    private Language              currentLanguage;
    private Map<String, Language> languageMap;

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(final String languageParam) {
        this.language = languageParam;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(final int countParam) {
        this.count = countParam;
    }

    public List<String> getLanguageList() {
        return this.languageList;
    }

    public void setLanguageList(final List<String> languageListParam) {
        this.languageList = languageListParam;
    }

    public Map<String, String> getLanguageDescription() {
        return this.languageDescription;
    }

    public void setLanguageDescription(final Map<String, String> languageDescriptionParam) {
        this.languageDescription = languageDescriptionParam;
    }

    public Language getCurrentLanguage() {
        return this.currentLanguage;
    }

    public void setCurrentLanguage(final Language currentLanguageParam) {
        this.currentLanguage = currentLanguageParam;
    }

    public Map<String, Language> getLanguageMap() {
        return this.languageMap;
    }

    public void setLanguageMap(final Map<String, Language> languageMapParam) {
        this.languageMap = languageMapParam;
    }

    @Override
    public String toString() {
        return "AppProperties [language="
               + this.language
               + ", count="
               + this.count
               + ", languageList="
               + this.languageList
               + ", languageDescription="
               + this.languageDescription
               + ", currentLanguage="
               + this.currentLanguage
               + ", languageMap="
               + this.languageMap
               + "]";
    }


}
