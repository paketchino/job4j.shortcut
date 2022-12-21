package shortcut.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shortcut.dto.UrlDTOStat;
import shortcut.mapper.CustomerMapperImpl;
import shortcut.model.Url;
import shortcut.repostitory.UrlRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;
    private final CustomerMapperImpl customerMapper;

    public void save(Url url) {
        urlRepository.save(url);
    }

    public Url findByUniqueCode(String code) {
        return urlRepository.findByKey(code);
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
}
