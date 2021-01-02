package cybersecu.api.reduction;

import cybersecu.api.client.Client;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Reduction {

    @Id
    private int id;
    private int percent;
    private int numberOfUse = 2;

    @OneToOne
    private Client client;

}
