package shortcut.mapper;

import org.springframework.stereotype.Component;
import shortcut.dto.*;
import shortcut.model.Site;
import shortcut.model.Url;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public RegistrationDTO registrationDTO(Site site) {
        RegistrationDTO dto = new RegistrationDTO();
        dto.setRegistration(site.isRegistration());
        dto.setLogin(site.getLogin());
        dto.setPassword(site.getPassword());
        return dto;
    }

    @Override
    public UrlDTOConvert convert(Url url) {
        var convert = new UrlDTOConvert();
        convert.setKey(url.getKey());
        return convert;
    }

    @Override
    public UrlDTORedirect redirect(Url url) {
        var redirect = new UrlDTORedirect();
        redirect.setUrl(url.getUrl());
        return redirect;
    }

    @Override
    public UrlDTOStat statistic(Url url) {
        var statistic = new UrlDTOStat();
        statistic.setUrl(url.getUrl());
        statistic.setCount(url.getCount());
        return statistic;
    }
}
