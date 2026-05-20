/*
 * Copyright 2025 David Navarre &lt;David.Navarre at irit.fr&gt;.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package fr.utc.miage.acteurs;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PersonneTest {
    private static final String FOO_NOM = "Foo Nom";
    private static final String FOO_PRENOM = "Foo Prenom";
    private static final String FOO_EMAIL = "ab@gmail.com";
    private static final String FOO_PASSWORD = "password";
    private static final String EMPTY_STRING = "";

    @Test
    void testConstructorWithCorrectParameters() {
        assertDoesNotThrow(() -> new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD));
    }

    @Test
    void testConstructorWithNullParameters() {
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> new Personne(null, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD));
            assertThrows(IllegalArgumentException.class, () -> new Personne(FOO_NOM, null, FOO_EMAIL, FOO_PASSWORD));
            assertThrows(IllegalArgumentException.class, () -> new Personne(FOO_NOM, FOO_PRENOM, null, FOO_PASSWORD));
            assertThrows(IllegalArgumentException.class, () -> new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, null));
        });
    }

    @Test
    void testConstructorWithEmptyParameters() {
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> new Personne(EMPTY_STRING, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD));
            assertThrows(IllegalArgumentException.class, () -> new Personne(FOO_NOM, EMPTY_STRING, FOO_EMAIL, FOO_PASSWORD));
            assertThrows(IllegalArgumentException.class, () -> new Personne(FOO_NOM, FOO_PRENOM, EMPTY_STRING, FOO_PASSWORD));
            assertThrows(IllegalArgumentException.class, () -> new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, EMPTY_STRING));
        });
    }

    @Test
    void testSetNomWithNullParameter() {
        final Personne personne = new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        assertThrows(IllegalArgumentException.class, () -> personne.setNom(null));
    }

    @Test
    void testSetPrenomWithNullParameter() {
        final Personne personne = new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        assertThrows(IllegalArgumentException.class, () -> personne.setPrenom(null));
    }

    @Test
    void testSetEmailWithNullParameter() {
        final Personne personne = new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        assertThrows(IllegalArgumentException.class, () -> personne.setEmail(null));
    }

    @Test
    void testSetPasswordWithNullParameter() {
        final Personne personne = new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        assertThrows(IllegalArgumentException.class, () -> personne.setPassword(null));
    }

    @Test
    void testSetNomWithEmptyParameter() {
        final Personne personne = new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        assertThrows(IllegalArgumentException.class, () -> personne.setNom(EMPTY_STRING));
    }

    @Test
    void testSetPrenomWithEmptyParameter() {
        final Personne personne = new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        assertThrows(IllegalArgumentException.class, () -> personne.setPrenom(EMPTY_STRING));
    }

    @Test
    void testSetEmailWithEmptyParameter() {
        final Personne personne = new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        assertThrows(IllegalArgumentException.class, () -> personne.setEmail(EMPTY_STRING));
    }

    @Test
    void testSetPasswordWithEmptyParameter() {
        final Personne personne = new Personne(FOO_NOM, FOO_PRENOM, FOO_EMAIL, FOO_PASSWORD);
        assertThrows(IllegalArgumentException.class, () -> personne.setPassword(EMPTY_STRING));
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
