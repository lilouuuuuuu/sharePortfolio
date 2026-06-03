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

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import fr.utc.miage.shares.Action;
import fr.utc.miage.shares.ActionComposee;
import fr.utc.miage.shares.ActionSimple;
import fr.utc.miage.shares.Jour;

public class GestionnaireTest {

    public static final String NOM = "Dupond";
    public static final String PRENOM = "Jean";
    public static final String EMAIL = "jean.dupond@gmail.com";
    public static final String PASSWORD = "password";
    public static final String LIBELLE_ACTION_SIMPLE = "Action Simple";
    public static final float VALEUR_ACTION = 10.0f;
    public static final float NOUVELLE_VALEUR_ACTION = 15.0f;
    public static final Jour jour = new Jour(2025, 1, 1);
    public static final Jour nextDay = new Jour(2025, 1, 2);


    @Test
    void testConstructorWithCorrectParameters() {
        assertDoesNotThrow(() -> new Gestionnaire(NOM, PRENOM, EMAIL, PASSWORD));
    }

    @Test
    void testGetPortefeuilleActionsWithCorrectParameters() {
        final Gestionnaire gestionnaire = new Gestionnaire(NOM, PRENOM, EMAIL, PASSWORD);
        assertDoesNotThrow(gestionnaire::getPortefeuilleActions);
    }

    @Test
    void testSetPortefeuilleActionsWithCorrectParameters() {
        final Gestionnaire gestionnaire = new Gestionnaire(NOM, PRENOM, EMAIL, PASSWORD);
        assertDoesNotThrow(() -> gestionnaire.setPortefeuilleActions(List.of()));
    }

    @Test
    void testSetPortefeuilleActionsWithNullParameter() {
        final Gestionnaire gestionnaire = new Gestionnaire(NOM, PRENOM, EMAIL, PASSWORD);
        assertThrows(IllegalArgumentException.class, () -> gestionnaire.setPortefeuilleActions(null));
    }

    @Test
    void testMiseAJourActionSimpleWithNullAction() {
        final Gestionnaire gestionnaire = new Gestionnaire(NOM, PRENOM, EMAIL, PASSWORD);
        assertThrows(IllegalArgumentException.class, () -> gestionnaire.miseAJourActionSimple(null, jour, VALEUR_ACTION));
    }

    @Test
    void testMiseAJourActionSimpleWhichIsNotInPortefeuille() {
        final Gestionnaire gestionnaire = new Gestionnaire(NOM, PRENOM, EMAIL, PASSWORD);
        ActionSimple actionSimple = new ActionSimple(LIBELLE_ACTION_SIMPLE);
        assertThrows(IllegalArgumentException.class, () -> gestionnaire.miseAJourActionSimple(actionSimple, jour, VALEUR_ACTION));
    }

    @Test
    void testMiseAJourActionSimpleWithCorrectParameters() {
        final Gestionnaire gestionnaire = new Gestionnaire(NOM, PRENOM, EMAIL, PASSWORD);
        ActionSimple actionSimple = new ActionSimple(LIBELLE_ACTION_SIMPLE);
        actionSimple.enrgCours(jour, VALEUR_ACTION);
        gestionnaire.setPortefeuilleActions(List.of(actionSimple));
        
        gestionnaire.miseAJourActionSimple(actionSimple, nextDay, NOUVELLE_VALEUR_ACTION);

        assertAll(() -> {
            assertEquals(VALEUR_ACTION, actionSimple.valeur(jour));
            assertEquals(NOUVELLE_VALEUR_ACTION, actionSimple.valeur(nextDay));
        });
    }

    @Test
    void testRemoveActionSimpleWithNullParameter() {
        final Gestionnaire gestionnaire = new Gestionnaire(NOM, PRENOM, EMAIL, PASSWORD);
        assertThrows(IllegalArgumentException.class, () -> gestionnaire.removeActionSimple(null));
    }

    @Test
    void testRemoveActionSimpleWithCorrectParameter() {
        final Gestionnaire gestionnaire = new Gestionnaire(NOM, PRENOM, EMAIL, PASSWORD);
        final ActionSimple actionSimple = new ActionSimple("Action Simple");
        gestionnaire.getPortefeuilleActions().add(actionSimple);
        assertDoesNotThrow(() -> gestionnaire.removeActionSimple(actionSimple));
    }   
    
    @Test
    void testRemoveActionComposeeWithNullParameter() {
        final Gestionnaire gestionnaire = new Gestionnaire(NOM, PRENOM, EMAIL, PASSWORD);
        assertThrows(IllegalArgumentException.class, () -> gestionnaire.removeActionComposee(null));
    }

    @Test
    void testRemoveActionComposeeWithCorrectParameter() {
        final Gestionnaire gestionnaire = new Gestionnaire(NOM, PRENOM, EMAIL, PASSWORD);
        final HashMap<Action, Float> actions = new HashMap<>();
        ActionSimple action = new ActionSimple("Action");
        actions.put(action, 100.0f);
        final ActionComposee actionSimple = new ActionComposee("Action Simple", actions);
        gestionnaire.getPortefeuilleActions().add(actionSimple);
        assertDoesNotThrow(() -> gestionnaire.removeActionComposee(actionSimple));
    }
}
