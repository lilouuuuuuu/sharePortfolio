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


package fr.utc.miage.shares;

import java.util.HashMap;
import java.util.Map;


public class ActionComposee extends Action{
    private Map<Action, Float> actions;

    public ActionComposee(String libelle, HashMap<Action, Float> actions) {
        super(libelle);
        if (actions == null) {
            throw new IllegalArgumentException("La liste d'actions ne peut pas être null.");
        }
        if (!repartitionValide(actions)) {
            throw new IllegalArgumentException("La répartition des actions doit être comprise entre 0 et 100% et doit totaliser 100%.");
        } else {
            this.actions = actions;
        }
    }

    private boolean repartitionValide(HashMap<Action, Float> actions) {
        float total = 0.0f;
        for (Float part : actions.values()) {
            if (part < 0.0f || part > 100.0f) {
                return false;
            }
            total += part;
        }
        return total == 100.0f;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActionComposee other = (ActionComposee) obj;
        return this.getLibelle().equals(other.getLibelle());
    }

    @Override
    public float valeur(Jour j) {
        float valeurTotale = 0.0f;
        for (Map.Entry<Action, Float> entry : actions.entrySet()) {
            Action action = entry.getKey();
            float part = entry.getValue();
            valeurTotale += part * action.valeur(j);
        }
        return valeurTotale;
    }

    @Override
    public int hashCode() {
        return this.getLibelle().hashCode();
    }

    public Map<Action, Float> getActions() {
        return actions;
    }

    public void setActions(Map<Action, Float> actions) {
        if (actions == null) {
            throw new IllegalArgumentException("La liste d'actions ne peut pas être null.");
        }
        this.actions = actions;
    }
}
