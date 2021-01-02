package cybersecu.api.client;

import cybersecu.api.commande.Commande;
import cybersecu.api.commande.CommandeRepository;
import cybersecu.api.exception.NoExistingCommandException;
import cybersecu.api.exception.NotEnoughMoneyException;
import cybersecu.api.reduction.Reduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CommandeRepository commandeRepository;

    @GetMapping("find-by-login/{login}")
    public Optional<Client> getClientByLogin(@PathVariable("login") String lastname) {
        return clientRepository.findByLogin(lastname);
    }

    @PostMapping("{clientId}/buy-command")
    public ResponseEntity<Client> clientBuyProduct(@PathVariable("clientId") int clientId) throws NoExistingCommandException, NotEnoughMoneyException {
        Client client = clientRepository.findById(clientId).get();
        Boolean isThereCommande = commandeRepository.findById(1).isPresent();
        if (!isThereCommande || commandeRepository.findById(1).get().getArticles().isEmpty()) {
            throw new NoExistingCommandException("Aucune commande n'a encore été créée.");
        }
        Commande commande = commandeRepository.findById(1).get();
        Reduction clientReduction = client.getReduction();
        float reduction = clientReduction.getNumberOfUse() > 0 ? (100f - clientReduction.getPercent()) / 100f : 1f;
        int totalPrice = Math.round((float) commande.getTotalPrice() * reduction);
        if (client.getMoney() >= totalPrice) {
            client.setMoney(client.getMoney() - totalPrice);
            commande.setTotalPrice(0);
            commande.resetMap();
            if (clientReduction.getNumberOfUse() != 0) {
                clientReduction.setNumberOfUse(clientReduction.getNumberOfUse() - 1);
            }
        } else {
            throw new NotEnoughMoneyException("Le client n'a pas assez d'argent pour payer la commande.");
        }
        commandeRepository.save(commande);

        final Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok(updatedClient);
    }

}
