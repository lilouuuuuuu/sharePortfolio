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

public class Utilisateur extends Personne {

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
}