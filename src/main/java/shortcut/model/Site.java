package shortcut.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "sites")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String site;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    private boolean registration;

    @ManyToOne
    @JoinColumn(name = "url_id")
    private Url url;
}
