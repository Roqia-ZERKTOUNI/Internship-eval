import React, { useState, useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

export default function Step5EvaluationForm() {
  const navigate = useNavigate();
  const location = useLocation();

  const { analyseConceptionPreliminaire = '' } = location.state || {};

  const [competenceScientifique, setCompetenceScientifique] = useState('');
  const [noteSci, setNoteSci] = useState('');

  // 🟢 Nouvelle section pour compétences métier
  const [competencesMetier, setCompetencesMetier] = useState(
      Array.from({ length: 5 }, () => ({ intitule: '', niveau: '' }))
  );

  useEffect(() => {
    setCompetenceScientifique(analyseConceptionPreliminaire);
  }, [analyseConceptionPreliminaire]);

  const handleCompetenceMetierChange = (index, field, value) => {
    setCompetencesMetier(prev =>
        prev.map((row, i) => (i === index ? { ...row, [field]: value } : row))
    );
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const etape1 = JSON.parse(sessionStorage.getItem("etape1Data"));
    const etape2 = JSON.parse(sessionStorage.getItem("etape2Data"));
    const etape3 = JSON.parse(sessionStorage.getItem("etape3Data"));
    const etape4 = JSON.parse(sessionStorage.getItem("etape4Data"));

    const evaluationGlobale = {
      nomStagiaire: etape1.nom,
      prenomStagiaire: etape1.prenom,
      emailStagiaire: etape1.email || "john@example.com",
      institution: etape1.institution || "FST",

      nomTuteur: etape1.nomT,
      prenomTuteur: etape1.prenomT,
      emailTuteur: etape1.emailT || "tuteur@example.com",
      entreprise: etape1.entreprise,

      dateDebut: etape1.dateDebut,
      dateFin: etape1.dateFin,
      description: etape1.description,
      objectif: etape1.objectif,

      implication: etape2.activite,
      ouverture: etape2.ouverture,
      qualiteProductions: etape2.qualite,
      observations: etape2.observation,

      categories: [
        {
          intitule: "Compétences liées à l’individu",
          note: etape3.note,
          competences: [
            { intitule: "Analyse", niveau: etape3.analyseSynthese },
            { intitule: "Méthodes", niveau: etape3.proposerMethodesAxes },
            { intitule: "Adhésion", niveau: etape3.faireAdhererActeurs },
            { intitule: "Auto-évaluation", niveau: etape3.autoEvaluation },
            { intitule: "Problèmes complexes", niveau: etape3.identifierProblemesComplexes },
          ],
        },
        {
          intitule: "Compétences liées à l’entreprise",
          note: etape4.noteEntreprise,
          competences: [
            { intitule: "Fonctionnement", niveau: etape4.analyseFonctionnementEntreprise },
            { intitule: "Projet", niveau: etape4.analyseDemarcheProjet },
            { intitule: "Environnement", niveau: etape4.comprehensionPolitiqueEnvironnementale },
            { intitule: "Information", niveau: etape4.rechercheEtSelectionInformation },
          ],
        },
        {
          intitule: "Compétences scientifiques",
          note: noteSci,
          competences: [
            { intitule: "Préliminaire", niveau: competenceScientifique },
          ],
        }
      ],
    };

    try {
      const res = await fetch("http://localhost:8083/api/evaluation-globale/save", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(evaluationGlobale),
      });

      if (!res.ok) throw new Error("Échec de l’enregistrement");

      sessionStorage.clear();
      navigate("/confirmation");
    } catch (err) {
      alert("Erreur : " + err.message);
    }
  };

  return (
      <div className="w-[90%] mx-auto p-4 shadow-lg rounded-lg">
        <form className="space-y-6" onSubmit={handleSubmit}>
          {/* Préliminaire scientifique */}
          <div className="bg-gray-100 border-l-4 border-green-500 p-4">
            <p className="font-semibold">Compétence scientifique :</p>
            <p className="ml-4">{competenceScientifique || 'Aucune sélection'}</p>
          </div>

          <div className="bg-gray-100 border-l-4 border-red-500 p-4">
            <label className="block font-semibold mb-2">
              * Note scientifique (sur 20)
            </label>
            <input
                type="number"
                min="0"
                max="20"
                step="0.1"
                value={noteSci}
                onChange={e => setNoteSci(e.target.value)}
                className="w-24 px-2 py-1 border rounded"
            />
          </div>

          {/* 🔵 Compétences spécifiques métier */}
          <div className="bg-gray-50 border p-4 rounded-md">
            <h3 className="text-lg font-bold mb-2">
              Compétences spécifiques métier (à ajouter selon besoin)
            </h3>
            <p className="text-sm mb-4 text-gray-600">
              Évaluez chaque compétence avec un des trois niveaux suivants : <strong>DEBUTANT</strong>, <strong>AUTONOME</strong> ou <strong>AUTONOME +</strong>.
            </p>
            <table className="w-full table-auto border border-gray-300">
              <thead className="bg-gray-200">
              <tr>
                <th className="p-2 text-left">Compétence</th>
                <th className="p-2 text-left">Évaluation</th>
              </tr>
              </thead>
              <tbody>
              {competencesMetier.map((row, index) => (
                  <tr key={index} className="border-t">
                    <td className="p-2">
                      <input
                          type="text"
                          value={row.intitule}
                          onChange={(e) =>
                              handleCompetenceMetierChange(index, "intitule", e.target.value)
                          }
                          className="w-full border rounded px-2 py-1"
                      />
                    </td>
                    <td className="p-2">
                      <select
                          value={row.niveau}
                          onChange={(e) =>
                              handleCompetenceMetierChange(index, "niveau", e.target.value)
                          }
                          className="w-full border rounded px-2 py-1"
                      >
                        <option value="">-- Choisir --</option>
                        <option value="DEBUTANT">DEBUTANT</option>
                        <option value="AUTONOME">AUTONOME</option>
                        <option value="AUTONOME_PLUS">AUTONOME +</option>
                      </select>
                    </td>
                  </tr>
              ))}
              </tbody>
            </table>
          </div>


          <div className="flex justify-between mt-6">
            <button
                type="button"
                onClick={() => navigate(-1)}
                className="px-4 py-2 border rounded"
            >
              Précédent
            </button>
            <button
                type="submit"
                className="px-6 py-2 bg-blue-600 text-white rounded"
            >
              Envoyer
            </button>
          </div>
        </form>
      </div>
  );
}
