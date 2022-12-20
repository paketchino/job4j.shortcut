package shortcut.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shortcut.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    @Query("from urls as u where u.uniqueCode =: unique_code")
    Url findByUniqueCode(@Param("unique_code") String key);
}
