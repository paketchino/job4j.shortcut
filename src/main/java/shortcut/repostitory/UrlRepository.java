package shortcut.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shortcut.model.Url;

import java.util.List;
import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    @Query("from urls as u where u.key =: key")
    Url findByKey(@Param("key_code") String key);

    @Transactional
    @Query("update urls as u set u.count =: count + 1 where u.id =: id")
    @Modifying
    Url updateCount(@Param("count") int count, @Param("id") Long id);

    @Query("from urls")
    List<Url> allStatistic();

    @Query("from urls as u where u.id =:id")
    Optional<Url> findById(@Param("id") Long id);

}
