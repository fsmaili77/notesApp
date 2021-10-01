

INSERT INTO matiere(matiere_id, nom_matiere) VALUES (20, "Francais");
INSERT INTO matiere(matiere_id, nom_matiere) VALUES (21, "Anglais");
INSERT INTO matiere(matiere_id, nom_matiere) VALUES (22, "Math");

INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id, fk_matiere_id) VALUES (6, 12, 16, 14, 1, 20);
INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id, fk_matiere_id) VALUES (7, 14, 11, 12.5, 1, 21);
INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id, fk_matiere_id) VALUES (8, 18, 15, 16.5, 1, 22);

INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id, fk_matiere_id) VALUES (9, 10, 12, 11, 2, 20);
INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id, fk_matiere_id) VALUES (10, 19, 18, 18.5, 2, 21);
INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id, fk_matiere_id) VALUES (11, 10, 13, 11.5, 2, 22);

INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id, fk_matiere_id) VALUES (12, 17.5, 19, 18, 3, 20);
INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id, fk_matiere_id) VALUES (13, 15, 12, 13.5, 3, 21);
INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id, fk_matiere_id) VALUES (14, 20, 19, 19.5, 3, 22);

INSERT INTO etudiant(etudiant_id, nom, prenom, email) VALUES (1, "Antoine", "Griezman", "antoine@gmail.fr");
INSERT INTO etudiant(etudiant_id, nom, prenom, email) VALUES (2, "Kylian", "Mbappé", "kylian@gmail.fr");
INSERT INTO etudiant(etudiant_id, nom, prenom, email) VALUES (3, "Karim", "Benzema", "karim@gmail.fr");



