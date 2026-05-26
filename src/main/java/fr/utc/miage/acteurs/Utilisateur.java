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
import java.util.logging.Logger;

import fr.utc.miage.shares.Action;
import fr.utc.miage.shares.ActionComposee;
import fr.utc.miage.shares.ActionSimple;

public class Utilisateur extends Personne {

    Logger logger = Logger.getLogger(getClass().getName());
    private List<Action> portefeuille;

    public Utilisateur(String n, String p, String email, String password) {
        super(n, p, email, password);
        this.portefeuille = new ArrayList<>();
    }

    public List<Action> getPortefeuille() {
        return portefeuille;
    }

    public void setPortefeuille(List<Action> portefeuille) {
        if (portefeuille == null) {
            throw new IllegalArgumentException("Le portefeuille ne peut être null.");
        }

        this.portefeuille = portefeuille;
    }

    public void consulterPortefeuille() {
        if (portefeuille.isEmpty()) {
            logger.info("Votre portefeuille est vide.");
        } else {
            logger.info("Votre portefeuille contient les actions suivantes :");
            for (Action action : portefeuille) {
                logger.info("- " + action.getLibelle());
            }
        }
    }

    public void acheterAction(Action action) {
        if (action == null) {
            throw new IllegalArgumentException("L'action ne peut être null.");
        }

        portefeuille.add(action);
        logger.info("Vous avez acheté l'action : " + action.getLibelle());
    }

    public void vendreActionSimple (ActionSimple actionSimple) {
        if (actionSimple == null) {
            throw new IllegalArgumentException("L'action à vendre ne peut pas être null.");
        }
        portefeuille.remove(actionSimple);
    }

    public void vendreActionComposee(ActionComposee actionComposee) {
        if (actionComposee == null) {
            throw new IllegalArgumentException("L'action à vendre ne peut pas être null.");
        }
        portefeuille.remove(actionComposee);
    }
}