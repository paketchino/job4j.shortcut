package shortcut.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shortcut.model.Url;

import java.util.List;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    @Query("from urls as u where u.key =: key_code")
    Url findByKey(@Param("key_code") String key);

    @Query("update urls as u set u.count =: count + 1 where u.id =: id")
    Url updateCount(@Param("count") int count, @Param("id") Long id);

    @Query("select url, count(count) from urls")
    List<Url> allStatistic();
}
