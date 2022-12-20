package shortcut.controller;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shortcut.dto.UrlDTOConvert;
import shortcut.dto.SiteDTORedirect;
import shortcut.mapper.CustomerMapperImpl;
import shortcut.model.Url;
import shortcut.service.UrlService;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class UrlController {

    private final UrlService urlService;

    private final CustomerMapperImpl customerMapper;

    @PostMapping("/convert")
    public ResponseEntity<UrlDTOConvert> convert(@RequestBody Url url) {
        url.setUniqueCode(RandomStringUtils.randomAscii(6));
        urlService.save(url);
        var convert = customerMapper.convert(url);
        return new ResponseEntity<>(convert, HttpStatus.OK);
    }

    @GetMapping("/redirect/{code}")
    public ResponseEntity<SiteDTORedirect> redirect(@PathVariable(name = "code") String code) {
        var url = urlService.findByUniqueCode(code);
        var redirect= customerMapper.redirect(url);
        return new ResponseEntity<>(redirect, HttpStatus.FOUND);
    }
}
