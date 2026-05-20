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
}
