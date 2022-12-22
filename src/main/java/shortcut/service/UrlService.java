package shortcut.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shortcut.dto.UrlDTOStat;
import shortcut.mapper.CustomerMapperImpl;
import shortcut.model.Url;
import shortcut.repostitory.UrlRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Log4j2
public class UrlService {

    @Autowired
    private final UrlRepository urlRepository;
    private final CustomerMapperImpl customerMapper;

    public void save(Url url) {
        urlRepository.save(url);
    }

    public Url findByUniqueCode(String code) {
        Url url = urlRepository.findByKey(code);
        if (url == null) {
            log.error("Содержимое ключа не найдено");
        }
        return url;
    }

    public Url updateCount(int count, Long id) {
        return urlRepository.updateCount(count, id);
    }

    public List<UrlDTOStat> allStatistic() {
        return urlRepository.allStatistic()
                .stream()
                .map(customerMapper::statistic)
                .collect(Collectors.toList());
    }

    Optional<Url> findById(Long aLong) {
        return urlRepository.findById(aLong);
    }


}
