package cybersecu.api.client;

import cybersecu.api.reduction.Reduction;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
public class Client {

    @Id
    private int id;
    private String login;
    private String passwd;
    private int money;
    private String role;

    @OneToOne
    @JoinColumn(name = "reduction_id")
    private Reduction reduction;
}
