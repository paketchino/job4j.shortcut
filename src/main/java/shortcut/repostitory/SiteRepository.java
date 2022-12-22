package shortcut.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shortcut.model.Site;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
}
