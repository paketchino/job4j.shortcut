package shortcut.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
@Entity(name = "urls")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url", unique = true)
    @NonNull
    private String url;

    @Column(name = "key_code", unique = true)
    private String key;

    @Column(precision = 0)
    private int count;
}
