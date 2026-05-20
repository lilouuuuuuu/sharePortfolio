package fr.utc.miage.acteurs;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonneTest {
    private static final String FOO_NOM = "Foo Nom";
    private static final String FOO_PRENOM = "Foo Prenom";
    private static final String FOO_EMAIL = "ab@gmail.com";
    private static final String FOO_PASSWORD = "password";

    @Test
    void testConstructorWithCorrectParameters() {
        assertDoesNotThrow(() -> new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD));
    }

    @Test
    void testgetNomWithCorrectParameters() {
        final Personne personne = new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        final String result = personne.getNom();

        assertEquals(FOO_NOM, result);
    }

    @Test
    void testgetPrenomWithCorrectParameters() {
        final Personne personne = new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        final String result = personne.getPrenom();

        assertEquals(FOO_PRENOM, result);
    }

    @Test
    void testgetEmailWithCorrectParameters() {
        final Personne personne = new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        final String result = personne.getEmail();

        assertEquals(FOO_EMAIL, result);
    }

    @Test
    void testgetPasswordWithCorrectParameters() {
        final Personne personne = new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        final String result = personne.getPassword();

        assertEquals(FOO_PASSWORD, result);
    }

    @Test
    void testsetNomWithCorrectParameters() {
        final Personne personne = new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        final String newNom = "New Nom";
        personne.setNom(newNom);
        final String result = personne.getNom();
        assertEquals(newNom, result);
    }

    @Test
    void testsetPrenomWithCorrectParameters() {
        final Personne personne = new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        final String newPrenom = "New Prenom";
        personne.setPrenom(newPrenom);
        final String result = personne.getPrenom();
        assertEquals(newPrenom, result);
    }

    @Test
    void testsetEmailWithCorrectParameters() {
        final Personne personne = new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        final String newEmail= "cd@gmail.fr";
        personne.setEmail(newEmail);
        final String result = personne.getEmail();
        assertEquals(newEmail, result);
    }

    @Test
    void testsetPasswordWithCorrectParameters() {
        final Personne personne = new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        final String newPassword = "NewPAss";
        personne.setPassword(newPassword);
        final String result = personne.getPassword();
        assertEquals(newPassword, result);
    }
}
