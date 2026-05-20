/*
 * Copyright 2025 David Navarre &lt;David.Navarre at irit.fr&gt;.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.utc.miage.acteurs;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.utc.miage.acteurs.Personne;
import fr.utc.miage.acteurs.Utilisateur;

class UtilisateurTest {

    private static final String FOO_NOM = "Foo Nom";
    private static final String FOO_PRENOM = "Foo Prenom";
    private static final String FOO_EMAIL = "ab@gmail.com";
    private static final String FOO_PASSWORD = "password";

    @Test
    void testConstructorWithCorrectParameters() {
        assertDoesNotThrow(() -> new Utilisateur(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD));
    }

    @Test
    void testgetNomWithCorrectParameters() {
        final Utilisateur u = new Utilisateur(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        final String result = u.getNom();

        assertEquals(FOO_NOM, result);
    }

    @Test
    void testgetPrenomWithCorrectParameters() {
        final Utilisateur u = new Utilisateur(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        final String result = u.getPrenom();

        assertEquals(FOO_PRENOM, result);
    }

    @Test
    void testgetEmailWithCorrectParameters() {
        final Utilisateur u = new Utilisateur(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        final String result = u.getEmail();

        assertEquals(FOO_EMAIL, result);
    }

    @Test
    void testgetPasswordWithCorrectParameters() {
        final Utilisateur u = new Utilisateur(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        final String result = u.getPassword();

        assertEquals(FOO_PASSWORD, result);
    }

    @Test
    void testsetNomWithCorrectParameters() {
        final Utilisateur u = new Utilisateur(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        final String newNom = "New Nom";
        u.setNom(newNom);
        final String result = u.getNom();
        assertEquals(newNom, result);
    }

    @Test
    void testsetPrenomWithCorrectParameters() {
        final Utilisateur u = new Utilisateur(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        final String newPrenom = "New Prenom";
        u.setPrenom(newPrenom);
        final String result = u.getPrenom();
        assertEquals(newPrenom, result);
    }

    @Test
    void testsetEmailWithCorrectParameters() {
        final Utilisateur u = new Utilisateur(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        final String newEmail = "cd@gmail.fr";
        u.setEmail(newEmail);
        final String result = u.getEmail();
        assertEquals(newEmail, result);
    }

    @Test
    void testsetPasswordWithCorrectParameters() {
        final Utilisateur u = new Utilisateur(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        final String newPassword = "NewPAss";
        u.setPassword(newPassword);
        final String result = u.getPassword();
        assertEquals(newPassword, result);
    }

}
