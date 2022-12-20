package shortcut.controller;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shortcut.dto.RegistrationDTO;
import shortcut.mapper.CustomerMapperImpl;
import shortcut.model.Site;
import shortcut.service.SiteService;

@RestController
@RequestMapping("/shortcuts")
@AllArgsConstructor
public class SiteController {

    private final SiteService siteService;

    private final CustomerMapperImpl customerMapper;

    @PostMapping("/registration")
    public ResponseEntity<RegistrationDTO> signUp(@RequestBody Site site) {
        site.setLogin(RandomStringUtils.randomAscii(8));
        site.setPassword(RandomStringUtils.randomAscii(8));
        site.setRegistration(true);
        siteService.save(site);
        return new ResponseEntity<>(customerMapper.registrationDTO(site), HttpStatus.CREATED);
    }

}
