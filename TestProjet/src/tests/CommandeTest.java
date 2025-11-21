package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pizzas.Commande;
import pizzas.Pizza;
import pizzas.TypePizza;

public class CommandeTest {

    private Pizza pizza;
    private Commande commande;

    @BeforeEach
    public void setUp() {
        pizza = new Pizza("Margarita", TypePizza.Vegetarienne);
        pizza.setPrixVente(8.50);

        commande = new Commande("client@test.com", pizza, 2);
    }

    @Test
    public void testCreationCommande() {
        assertEquals("client@test.com", commande.getEmailClient());
        assertEquals(pizza, commande.getPizza());
        assertEquals(2, commande.getQuantite());
        assertEquals(Commande.EtatCommande.CREEE, commande.getEtat());
        assertNotNull(commande.getDateHeure());
    }

    @Test
    public void testSetEtat() {
        commande.setEtat(Commande.EtatCommande.VALIDEE);
        assertEquals(Commande.EtatCommande.VALIDEE, commande.getEtat());

        commande.setEtat(Commande.EtatCommande.TRAITEE);
        assertEquals(Commande.EtatCommande.TRAITEE, commande.getEtat());
    }

    @Test
    public void testToString() {
        String txt = commande.toString();
        assertTrue(txt.contains("client@test.com"));
        assertTrue(txt.contains("Margarita"));
        assertTrue(txt.contains("quantite=2"));
        assertTrue(txt.contains("CREEE"));
    }

    @Test
    public void testEquals() throws Exception {
        LocalDateTime date = commande.getDateHeure();

        Commande cmd2 = new Commande("client@test.com", pizza, 2);

        // On force la même date
        Field f = Commande.class.getDeclaredField("dateHeure");
        f.setAccessible(true);
        f.set(cmd2, date);

        assertEquals(commande, cmd2);
        assertEquals(commande.hashCode(), cmd2.hashCode());
    }

    @Test
    public void testNotEquals() {
        Commande autre = new Commande("autre@mail.com", pizza, 2);
        assertNotEquals(commande, autre);
    }
}
