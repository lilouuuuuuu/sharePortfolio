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

import java.util.ArrayList;
import java.util.List;

import fr.utc.miage.shares.Action;

public class Gestionnaire extends Personne {
    private List<Action> portefeuilleActions;

    public Gestionnaire(String nom, String prenom, String email, String motDePasse) {
        super(nom, prenom, email, motDePasse);
        this.portefeuilleActions = new ArrayList<>();
    }
    
    public List<Action> getPortefeuilleActions() {
        return portefeuilleActions;
    }

    public void setPortefeuilleActions(List<Action> portefeuilleActions) {
        if (portefeuilleActions == null) {
            throw new IllegalArgumentException("Le portefeuille d'actions ne peut pas être null.");
        }
        this.portefeuilleActions = portefeuilleActions;
    }
}
