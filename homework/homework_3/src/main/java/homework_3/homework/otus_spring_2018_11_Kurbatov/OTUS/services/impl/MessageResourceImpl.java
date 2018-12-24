package homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS.services.impl;

import homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS.configs.YamlProperies;
import homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS.services.MessageResource;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageResourceImpl implements MessageResource {

    private MessageSource ms;
    private Locale locale;

    public MessageResourceImpl(YamlProperies yml){
        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource
                = new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasename(yml.getBaseName());
        reloadableResourceBundleMessageSource.setDefaultEncoding(yml.getLocaleSet());
        this.ms = reloadableResourceBundleMessageSource;
        this.locale = Locale.forLanguageTag(yml.getLocaleSet());
    }

    public String getI18nString(String value) {
        return ms.getMessage(value, null, this.locale);
    }
}
