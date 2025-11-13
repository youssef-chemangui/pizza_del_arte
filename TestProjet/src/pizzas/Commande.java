package pizzas;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Représente une commande passée par un client.
 * Une commande contient :
 * - email du client,
 * - pizza concernée,
 * - quantité,
 * - état (créée, validée, traitée),
 * - date/heure.
 */
public class Commande {
  public enum EtatCommande {
    CREEE, VALIDEE, TRAITEE
}

    /** Email du client. */
    private String emailClient;

    /** Pizza commandée. */
    private Pizza pizza;

    /** Quantité commandée. */
    private int quantite;

    /** État de la commande. */
    private EtatCommande etat;

    /** Date et heure de création. */
    private LocalDateTime dateHeure;

    /**
     * Constructeur d'une commande.
     *
     * @param unEmail email du client
     * @param unePizza pizza commandée
     * @param uneQuantite quantité commandée
     */
    public Commande(String unEmail, Pizza unePizza, int uneQuantite) {
        this.emailClient = unEmail;
        this.pizza = unePizza;
        this.quantite = uneQuantite;
        this.etat = EtatCommande.CREEE;
        this.dateHeure = LocalDateTime.now();
    }

    /** @return email du client */
    public String getEmailClient() {
        return emailClient;
    }

    /** @return pizza commandée */
    public Pizza getPizza() {
        return pizza;
    }

    /** @return quantité commandée */
    public int getQuantite() {
        return quantite;
    }

    /** @return état actuel */
    public EtatCommande getEtat() {
        return etat;
    }

    /**
     * Modifie l'état de la commande.
     *
     * @param unEtat nouvel état
     */
    public void setEtat(EtatCommande unEtat) {
        this.etat = unEtat;
    }

    /** @return date/heure */
    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailClient, dateHeure);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) obj;
        return Objects.equals(emailClient, other.emailClient)
                && Objects.equals(dateHeure, other.dateHeure);
    }

    @Override
    public String toString() {
        return "Commande[email=" + emailClient
                + ", pizza=" + pizza.getNom()
                + ", quantite=" + quantite
                + ", etat=" + etat + "]";
    }
}
