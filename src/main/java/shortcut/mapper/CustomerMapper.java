package shortcut.mapper;

import shortcut.dto.*;
import shortcut.model.Site;
import shortcut.model.Url;

public interface CustomerMapper {

    RegistrationDTO registrationDTO(Site site);

    UrlDTOConvert convert(Url url);

    UrlDTORedirect redirect(Url url);

    UrlDTOStat statistic(Url url);

}
