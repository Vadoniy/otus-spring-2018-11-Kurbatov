package homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "exam")
public class YamlProperties {

    private String fileName;
    private String baseName;
    private String localeSet;
    private String encodingSet;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getLocaleSet() {
        return localeSet;
    }

    public void setLocaleSet(String localeSet) {
        this.localeSet = localeSet;
    }

    public String getEncodingSet() {
        return encodingSet;
    }

    public void setEncodingSet(String encodingSet) {
        this.encodingSet = encodingSet;
    }
}