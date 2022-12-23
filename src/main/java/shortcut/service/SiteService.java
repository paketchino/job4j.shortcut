package shortcut.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shortcut.model.Site;
import shortcut.repostitory.SiteRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SiteService {

    private final SiteRepository siteRepository;

    public Site save(Site site) {
        return siteRepository.save(site);
    }

    public Optional<Site> findByLogin(String login) {
        return siteRepository.findByLogin(login);
    }
}
