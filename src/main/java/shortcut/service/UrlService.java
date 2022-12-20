package shortcut.service;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import shortcut.model.Url;
import shortcut.repostitory.UrlRepository;

@Service
@AllArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    public void save(Url url) {
        urlRepository.save(url);
    }

    public Url findByUniqueCode( String code) {
        return urlRepository.findByUniqueCode(code);
    };
}
