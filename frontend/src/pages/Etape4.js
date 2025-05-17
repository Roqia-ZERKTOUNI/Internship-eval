// src/components/Etape4.jsx
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Etape4() {
  const navigate = useNavigate();

  const [analyseFonctionnementEntreprise, setAnalyseFonctionnementEntreprise] = useState("");
  const [analyseDemarcheProjet, setAnalyseDemarcheProjet] = useState("");
  const [comprehensionPolitique, setComprehensionPolitique] = useState("");
  const [rechercheSelectionInfo, setRechercheSelectionInfo] = useState("");
  const [noteEntreprise, setNoteEntreprise] = useState("");
  const [analyseConceptionPreliminaire, setAnalyseConceptionPreliminaire] = useState("");

  const appreciationIdTuteur = 2;
  const appreciationIdPeriode = 1;
  const niveaux = ["NA", "DEBUTANT", "AUTONOME", "AUTONOME_PLUS"];

  const handleNext = () => {
    const payload = {
      intituleEntreprise: "ANALYSER_DEMARCHE_PROJET",
      appreciationIdTuteur,
      appreciationIdPeriode,
      analyseFonctionnementEntreprise,
      analyseDemarcheProjet,
      comprehensionPolitiqueEnvironnementale: comprehensionPolitique,
      rechercheEtSelectionInformation: rechercheSelectionInfo,
      noteEntreprise: Number(noteEntreprise),
      analyseConceptionPreliminaire, // on garde pour étape 5
    };
    sessionStorage.setItem("etape4Data", JSON.stringify(payload));
    navigate("/inscription/etape5", {
      state: { analyseConceptionPreliminaire },
    });
  };

  return (
    <div className="min-h-screen bg-gray-100 flex justify-center py-10">
      <form
        onSubmit={(e) => { e.preventDefault(); handleNext(); }}
        className="max-w-5xl w-[98%] bg-white p-6 rounded shadow"
      >
        {/* Compétences entreprise */}
        <section className="border border-gray-300 rounded-lg my-6">
          <div className="bg-gray-100 px-4 py-2 font-semibold">
            * Compétences liées à l'entreprise
          </div>
          <div className="overflow-x-auto">
          <table className="min-w-[800px] w-full table-fixed">
            <thead className="bg-gray-50">
              <tr>
                <th className="w-1/2 px-6 py-3 text-left">Intitulé</th>
                {niveaux.map((n) => (
                  <th key={n} className="px-6 py-3 text-center">{n.replace("_PLUS", " +")}</th>
                ))}
              </tr>
            </thead>
            <tbody className="divide-y divide-gray-180">
              {[
                { label: `Analyser le fonctionnement de l'entreprise d'accueil`, state: analyseFonctionnementEntreprise, setter: setAnalyseFonctionnementEntreprise },
                { label: 'Analyser la démarche projet et structurer un projet', state: analyseDemarcheProjet, setter: setAnalyseDemarcheProjet },
                { label: `Comprendre la politique environnementale de l'entreprise`, state: comprehensionPolitique, setter: setComprehensionPolitique },
                { label: `Rechercher et sélectionner l'information nécessaire`, state: rechercheSelectionInfo, setter: setRechercheSelectionInfo },
              ].map((item, idx) => (
                <tr key={idx}>
                  <td className="px-6 py-4">{item.label}</td>
                  {niveaux.map((n) => (
                    <td key={n} className="px-6 py-4 text-center">
                      <input
                        type="radio"
                        name={`ent${idx + 1}`}
                        value={n}
                        checked={item.state === n}
                        onChange={(e) => item.setter(e.target.value)}
                        className="form-radio h-4 w-4"
                      />
                    </td>
                  ))}
                </tr>
              ))}
            </tbody>
          </table>
          </div>
          <div className="px-4 py-4">
            <label className="block font-medium mb-2">* Note (sur 20)</label>
            <input
              type="number"
              min="0"
              max="20"
              value={noteEntreprise}
              onChange={(e) => setNoteEntreprise(e.target.value)}
              className="block w-32 border rounded"
            />
          </div>
        </section>

        {/* Compétence scientifique (pour étape 5) */}
        <section className="border border-gray-300 rounded-lg my-6">
          <div className="bg-gray-100 px-4 py-2 font-semibold">
            * Compétences scientifiques et techniques
          </div>
          <div className="overflow-x-auto">
          <table className="min-w-[800px] w-full table-fixed">
            <thead className="bg-gray-50">
              <tr>
                <th className="px-6 py-3 text-left">Intitulé</th>
                {niveaux.map((n) => (
                  <th key={n} className="px-6 py-3 text-center">{n.replace("_PLUS", " +")}</th>
                ))}
              </tr>
            </thead>
            <tbody className="divide-y divide-gray-200">
              <tr>
                <td className="px-6 py-4">
                  Conception préliminaire de produits/services/processus/usages
                </td>
                {niveaux.map((n) => (
                  <td key={n} className="px-6 py-4 text-center">
                    <input
                      type="radio"
                      name="sci01"
                      value={n}
                      checked={analyseConceptionPreliminaire === n}
                      onChange={(e) => setAnalyseConceptionPreliminaire(e.target.value)}
                      className="form-radio h-4 w-4"
                    />
                  </td>
                ))}
              </tr>
            </tbody>
          </table>
          </div>
        </section>

        {/* Bouton */}
        <div className="flex justify-end mt-6">
          <button
            type="submit"
            className="px-6 py-2 bg-blue-600 text-white rounded hover:bg-blue-700"
          >
            Suivant →
          </button>
        </div>
      </form>
    </div>
  );
}
