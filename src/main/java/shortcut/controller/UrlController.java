package shortcut.controller;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shortcut.dto.UrlDTOConvert;
import shortcut.dto.UrlDTOStat;
import shortcut.mapper.CustomerMapperImpl;
import shortcut.model.Url;
import shortcut.service.UrlService;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class UrlController {

    private final UrlService urlService;

    private final CustomerMapperImpl customerMapper;

    @PostMapping("/convert")
    public ResponseEntity<UrlDTOConvert> convert(@RequestBody Url url) {
        url.setKey(RandomStringUtils.randomAscii(6));
        urlService.save(url);
        var convert = customerMapper.convert(url);
        return new ResponseEntity<>(convert, HttpStatus.OK);
    }

    @GetMapping("/redirect/{key}")
    public ResponseEntity<String> redirect(@PathVariable(name = "key") String key) {
        HttpHeaders httpHeaders = new HttpHeaders();
        var url = urlService.findByUniqueCode(key);
        UrlDTOConvert convert = customerMapper.convert(url);
        httpHeaders.set("REDIRECT URL - ", convert.getUrl());
        urlService.updateCount(url.getCount(), url.getId());
        var httpStatus = HttpStatus.valueOf("HTTP CODE - " + HttpStatus.FOUND);
        return new ResponseEntity<String>(httpHeaders, httpStatus);
    }

    @GetMapping("/statistic")
    public ResponseEntity<List<UrlDTOStat>> statistic() {
        List<UrlDTOStat> findAll = urlService.allStatistic();
        return new ResponseEntity<>(findAll, HttpStatus.FOUND);
    }
}
