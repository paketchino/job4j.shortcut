package shortcut.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shortcut.dto.UrlDTOStat;
import shortcut.mapper.CustomerMapperImpl;
import shortcut.model.Site;
import shortcut.model.Url;
import shortcut.repostitory.UrlRepository;

import java.util.List;
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

    public Optional<Url> findByUniqueCode(String code) {
        return urlRepository.findByKey(code);
    }

    public Url updateCount(int count, Long id) {
        log.info("Обновление счетчика произошло успешно");
        return urlRepository.updateCount(count, id);
    }

    public List<UrlDTOStat> allStatistic() {
        return urlRepository.allStatistic()
                .stream()
                .map(customerMapper::statistic)
                .collect(Collectors.toList());
    }

    public Optional<Url> findById(Long aLong) {
        return urlRepository.findById(aLong);
    }
}
