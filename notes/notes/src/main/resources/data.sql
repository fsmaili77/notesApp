INSERT INTO classe(classes_id, nom_classe, periode, fk_matiere_id) VALUES (13, "TroisiemeA", "1ère Trimestre", 7);
INSERT INTO classe(classes_id, nom_classe, periode, fk_matiere_id) VALUES (14, "TroisiemeB", "2ème Trimestre", 7);
INSERT INTO classe(classes_id, nom_classe, periode, fk_matiere_id) VALUES (15, "TroisiemeC", "3ème Trimestre", 7);

INSERT INTO matiere(matiere_id, nom_matiere, fk_note_id) VALUES (11, "Francais", 7);
INSERT INTO matiere(matiere_id, nom_matiere, fk_note_id) VALUES (12, "Anglais", 8);

INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id) VALUES (6, 18, 14, 16, 1);
INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id) VALUES (7, 11, 11, 11, 1);
INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id) VALUES (8, 12, 16, 14, 2);
INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id) VALUES (9, 17, 13, 15, 3);
INSERT INTO notes(note_id, note_ecrit, note_oral, note_moyenne, fk_etudiant_id) VALUES (10, 16, 18, 17, 3);

INSERT INTO etudiant(etudiant_id, nom, prenom, email) VALUES (1, "Antoine", "Griezman", "antoine@gmail.fr");
INSERT INTO etudiant(etudiant_id, nom, prenom, email) VALUES (2, "Kylian", "Mbappé", "kylian@gmail.fr");
INSERT INTO etudiant(etudiant_id, nom, prenom, email) VALUES (3, "Karim", "Benzema", "karim@gmail.fr");
INSERT INTO etudiant(etudiant_id, nom, prenom, email) VALUES (4, "Pavard", "Benjamin", "pavard@hotmail.fr")


