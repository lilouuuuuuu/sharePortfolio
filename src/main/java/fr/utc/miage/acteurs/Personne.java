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

public class Personne {
    private String nom;
    private String prenom;
    private String email;
    private String password;

    public Personne (String nom, String prenom, String email, String password) {
        if (nom == null || nom.isEmpty() || prenom == null || prenom.isEmpty() || 
        email == null || email.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Les paramètres ne peuvent pas être vides.");
        }

        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setNom(String nom) {
        if (nom == null || nom.isEmpty()) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide.");
        }
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        if (prenom == null || prenom.isEmpty()) {
            throw new IllegalArgumentException("Le prénom ne peut pas être vide.");
        }
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("L'email ne peut pas être vide.");
        }
        this.email = email;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Le mot de passe ne peut pas être vide.");
        }
        this.password = password;
    }

    public void modifierCompte( String nom, String prenom, String email, String password) {
        setNom(nom);
        setPrenom(prenom);
        setEmail(email);
        setPassword(password);
    }

    public void supprimerCompte() {
        this.nom = null;
        this.prenom = null;
        this.email = null;
        this.password = null;
    }
}
