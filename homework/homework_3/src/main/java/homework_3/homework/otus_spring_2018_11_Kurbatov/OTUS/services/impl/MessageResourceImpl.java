package homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS.services.impl;

import homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS.configs.YamlProperties;
import homework_3.homework.otus_spring_2018_11_Kurbatov.OTUS.services.MessageResource;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageResourceImpl implements MessageResource {

    private MessageSource messageResource;
    private Locale locale;

    public MessageResourceImpl(YamlProperties yml) {
        ReloadableResourceBundleMessageSource ms
                = new ReloadableResourceBundleMessageSource();
        ms.setBasename("classpath:" + yml.getBaseName());
        ms.setDefaultEncoding(yml.getEncodingSet());
        this.messageResource = ms;
        this.locale = Locale.forLanguageTag(yml.getLocaleSet());
    }

    @Override
    public String getI18nString(String value) {
        return messageResource.getMessage(value, null, locale);
    }
}
