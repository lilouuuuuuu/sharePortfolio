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

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import fr.utc.miage.shares.Action;
import fr.utc.miage.shares.ActionSimple;

class UtilisateurTest {

    private static final String NOM = "Foo Nom";
    private static final String PRENOM = "Foo Prenom";
    private static final String EMAIL = "ab@gmail.com";
    private static final String PASSWORD = "password";
    private static final String LIBELLE_ACTION = "Action 1";
    private static final String ACTION_SIMPLE = "Action Simple";

    @Test
    void testConstructorWithCorrectParameters() {
        assertDoesNotThrow(() -> new Utilisateur(NOM, PRENOM, EMAIL, PASSWORD));
    }

    @Test
    void testGetPortefeuilleActionsWithCorrectParameters() {
        final Utilisateur u = new Utilisateur(NOM, PRENOM, EMAIL, PASSWORD);
        assertDoesNotThrow(u::getPortefeuille);
    }

    @Test
    void testSetPortefeuilleActionsWithCorrectParameters() {
        final Utilisateur u = new Utilisateur(NOM, PRENOM, EMAIL, PASSWORD);
        assertDoesNotThrow(() -> u.setPortefeuille(List.of()));
    }

    @Test
    void testSetPortefeuilleActionsWithNullParameter() {
        final Utilisateur u = new Utilisateur(NOM, PRENOM, EMAIL, PASSWORD);
        assertThrows(IllegalArgumentException.class, () -> u.setPortefeuille(null));
    }

    @Test
    void testConsulterPortefeuilleWithEmptyPortefeuille() {
        final Utilisateur u = new Utilisateur(NOM, PRENOM, EMAIL, PASSWORD);
        final List<Action> emptyPortefeuille = new ArrayList<>();
        u.setPortefeuille(emptyPortefeuille);
        assertDoesNotThrow(u::consulterPortefeuille);
    }

    @Test
    void testConsulterPortefeuilleWithNonEmptyPortefeuille() {
        final Utilisateur u = new Utilisateur(NOM, PRENOM, EMAIL, PASSWORD);
        final ActionSimple action = new ActionSimple(LIBELLE_ACTION);
        final List<Action> portefeuille = List.of(action);
        u.setPortefeuille(portefeuille);
        assertDoesNotThrow(u::consulterPortefeuille);
    }

    @Test
    void testAcheterActionWithCorrectParameters() {
        final Utilisateur u = new Utilisateur(NOM, PRENOM, EMAIL, PASSWORD);
        final ActionSimple action = new ActionSimple(LIBELLE_ACTION);
        assertAll("Acheter Action with correct parameters",
                () -> assertDoesNotThrow(() -> u.acheterAction(action)),
                () -> assertEquals(1, u.getPortefeuille().size()),
                () -> assertEquals(LIBELLE_ACTION, u.getPortefeuille().get(0).getLibelle()));
    }

    @Test
    void testAcheterActionWithNullParameter() {
        final Utilisateur u = new Utilisateur(NOM, PRENOM, EMAIL, PASSWORD);
        assertThrows(IllegalArgumentException.class, () -> u.acheterAction(null));
    void testVendreActionSimpleWithNullParameter() {
        final Utilisateur u = new Utilisateur(NOM, PRENOM, EMAIL, PASSWORD);
        assertThrows(IllegalArgumentException.class, () -> u.vendreActionSimple(null));
    }

    @Test
    void testVendreActionNotInPortefeuille() {
        final Utilisateur u = new Utilisateur(NOM, PRENOM, EMAIL, PASSWORD);
        ActionSimple actionSimple = new ActionSimple(ACTION_SIMPLE);
        assertDoesNotThrow(() -> u.vendreActionSimple(actionSimple));
    }

    @Test
    void testVendreActionSimpleWithCorrectParameter() {
        final Utilisateur u = new Utilisateur(NOM, PRENOM, EMAIL, PASSWORD);
        ActionSimple actionSimple = new ActionSimple(ACTION_SIMPLE);
        u.getPortefeuille().add(actionSimple);
        assertDoesNotThrow(() -> u.vendreActionSimple(actionSimple));
    }
}
