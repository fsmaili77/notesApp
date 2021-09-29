

INSERT INTO matiere(matiere_id, nom_matiere) VALUES (11, "Francais");
INSERT INTO matiere(matiere_id, nom_matiere) VALUES (12, "Anglais");

INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id, fk_matiere_id) VALUES (6, 18, 14, 16, 1, 11);
INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id, fk_matiere_id) VALUES (7, 11, 11, 11, 1, 12);
INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id, fk_matiere_id) VALUES (8, 12, 16, 14, 2, 12);
INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id, fk_matiere_id) VALUES (9, 17, 13, 15, 3, 11);
INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id, fk_matiere_id) VALUES (10, 16, 18, 17, 4, 11);

INSERT INTO etudiant(etudiant_id, nom, prenom, email) VALUES (1, "Antoine", "Griezman", "antoine@gmail.fr");
INSERT INTO etudiant(etudiant_id, nom, prenom, email) VALUES (2, "Kylian", "Mbappé", "kylian@gmail.fr");
INSERT INTO etudiant(etudiant_id, nom, prenom, email) VALUES (3, "Karim", "Benzema", "karim@gmail.fr");
INSERT INTO etudiant(etudiant_id, nom, prenom, email) VALUES (4, "Pavard", "Benjamin", "pavard@hotmail.fr")


