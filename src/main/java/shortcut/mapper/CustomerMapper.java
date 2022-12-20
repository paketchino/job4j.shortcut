package shortcut.mapper;

import shortcut.dto.RegistrationDTO;
import shortcut.dto.UrlDTOConvert;
import shortcut.dto.SiteDTORedirect;
import shortcut.model.Site;
import shortcut.model.Url;

public interface CustomerMapper {

    RegistrationDTO registrationDTO(Site site);

    UrlDTOConvert convert(Url url);

    SiteDTORedirect redirect(Url url);

}
