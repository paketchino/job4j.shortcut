package shortcut.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.QueryException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shortcut.dto.UrlDTOConvert;
import shortcut.dto.UrlDTORedirect;
import shortcut.dto.UrlDTOStat;
import shortcut.mapper.CustomerMapperImpl;
import shortcut.model.Url;
import shortcut.service.UrlService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@AllArgsConstructor
@Log4j2
public class UrlController {

    private final UrlService urlService;

    private final ObjectMapper objectMapper;

    private final CustomerMapperImpl customerMapper;

    @PostMapping("/convert")
    public ResponseEntity<UrlDTOConvert> convert(@RequestBody Url url) {
        url.setKey(RandomStringUtils.randomAlphanumeric(6));
        urlService.save(url);
        var convert = customerMapper.convert(url);
        return new ResponseEntity<>(convert, HttpStatus.OK);
    }

    @GetMapping("/redirect/{key}")
    public ResponseEntity<String> redirect(@PathVariable(name = "key") String key) {
        HttpHeaders httpHeaders = new HttpHeaders();
        var url = urlService.findByUniqueCode(key);
        if (!url.isPresent()) {
            throw new NullPointerException("Url by id not found");
        }
        UrlDTORedirect convert = customerMapper.redirect(url.get());
        httpHeaders.set("REDIRECT URL - ", convert.getUrl());
        urlService.updateCount(url.get().getCount(), url.get().getId());
        var httpStatus = HttpStatus.valueOf("HTTP CODE - " + HttpStatus.FOUND);
        return new ResponseEntity<String>(httpHeaders, httpStatus);
    }

    @GetMapping("/statistic")
    public ResponseEntity<List<UrlDTOStat>> statistic() {
        List<UrlDTOStat> findAll = urlService.allStatistic();
        return new ResponseEntity<>(findAll, HttpStatus.FOUND);
    }

    @ExceptionHandler(value = { NullPointerException.class, QueryException.class })
    public void exceptionHandler(Exception e, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(new HashMap<>() { {
            put("message", e.getMessage());
            put("type", e.getClass());
        }}));
        log.error(e.getLocalizedMessage());
    }
}
