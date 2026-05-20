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

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GestionnaireTest {

    public static final String NOM = "Dupond";
    public static final String PRENOM = "Jean";
    public static final String EMAIL = "jean.dupond@gmail.com";
    public static final String PASSWORD = "password";

    @Test
    void testConstructorWithCorrectParameters() {
        assertDoesNotThrow(() -> new Gestionnaire(NOM, PRENOM, EMAIL, PASSWORD));
    }

    @Test
    void testConstructorWithNullParameters() {
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> new Gestionnaire(null, PRENOM, EMAIL, PASSWORD));
            assertThrows(IllegalArgumentException.class, () -> new Gestionnaire(NOM, null, EMAIL, PASSWORD));
            assertThrows(IllegalArgumentException.class, () -> new Gestionnaire(NOM, PRENOM, null, PASSWORD));
            assertThrows(IllegalArgumentException.class, () -> new Gestionnaire(NOM, PRENOM, EMAIL, null));
        });
    }

    @Test
    void testConstructorWithEmptyParameters() {
        assertAll(() -> {
            assertThrows(IllegalArgumentException.class, () -> new Gestionnaire("", PRENOM, EMAIL, PASSWORD));
            assertThrows(IllegalArgumentException.class, () -> new Gestionnaire(NOM, "", EMAIL, PASSWORD));
            assertThrows(IllegalArgumentException.class, () -> new Gestionnaire(NOM, PRENOM, "", PASSWORD));
            assertThrows(IllegalArgumentException.class, () -> new Gestionnaire(NOM, PRENOM, EMAIL, ""));
        });
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
}
