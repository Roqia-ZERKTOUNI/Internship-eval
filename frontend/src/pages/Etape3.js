// src/components/Etape3.jsx
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function Etape3() {
  const navigate = useNavigate();
  const [noteEntreprise] = useState("");

  const [formData, setFormData] = useState({
    noteEntreprise: Number(noteEntreprise),
    analyseSynthese: "",
    proposerMethodesAxes: "",
    faireAdhererActeurs: "",
    autoEvaluation: "",
    identifierProblemesComplexes: "",
    appreciationIdTuteur: 2,
    appreciationIdPeriode: 1,
  });

  const niveaux = ["NA", "DEBUTANT", "AUTONOME", "AUTONOME_PLUS"];

  const handleRadioChange = (competenceName, niveau) => {
    setFormData((prev) => ({ ...prev, [competenceName]: niveau }));
  };

  const handleNoteChange = (e) => {
    const note = parseInt(e.target.value, 10);
    setFormData((prev) => ({ ...prev, note: isNaN(note) ? 0 : note }));
  };

  const handleNext = () => {
    sessionStorage.setItem("etape3Data", JSON.stringify(formData));
    navigate("/inscription/etape4");
  };

  return (
    <div className="min-h-screen bg-gray-100 p-8">
      <div className="max-w-5xl mx-auto bg-white rounded-lg shadow-md p-6">
        <h1 className="text-2xl font-bold mb-6">EVALUATIONS DES COMPETENCES DE L’ETUDIANT(E)</h1>

        <div className="mb-8 space-y-2 text-sm">
          <p><strong>NA :</strong> Non applicable - Compétence non appliquée</p>
          <p><strong>DEBUTANT :</strong> Applique avec aide</p>
          <p><strong>AUTONOME :</strong> Applique de manière autonome</p>
          <p><strong>AUTONOME + :</strong> Résout des problèmes, s’adapte</p>
        </div>

        <form onSubmit={(e) => e.preventDefault()}>
          <h2 className="font-bold mb-4">*Compétences liées à l’individu</h2>

          <table className="w-full mb-8 border border-gray-200">
            <thead>
              <tr className="bg-gray-100">
                <th className="text-left p-2">Compétence</th>
                {niveaux.map((niveau) => (
                  <th key={niveau} className="text-center p-2">{niveau}</th>
                ))}
              </tr>
            </thead>
            <tbody>
              {[
                { label: "Être capable d’analyse et de synthèse", name: "analyseSynthese" },
                { label: "Proposer des méthodes ou axes d'amélioration", name: "proposerMethodesAxes" },
                { label: "Faire adhérer les acteurs", name: "faireAdhererActeurs" },
                { label: "Faire une auto-évaluation", name: "autoEvaluation" },
                { label: "Identifier les problèmes complexes", name: "identifierProblemesComplexes" },
              ].map(({ label, name }) => (
                <tr key={name} className="border-t border-gray-200">
                  <td className="p-2">{label}</td>
                  {niveaux.map((niveau) => (
                    <td key={niveau} className="text-center p-2">
                      <input
                        type="radio"
                        name={name}
                        value={niveau}
                        checked={formData[name] === niveau}
                        onChange={() => handleRadioChange(name, niveau)}
                        className="form-radio"
                      />
                    </td>
                  ))}
                </tr>
              ))}
            </tbody>
          </table>

          <div className="mb-6">
            <label className="font-bold">Note sur 20 :</label>
            <div className="flex items-center gap-2 mt-2">
              <input
                type="number"
                min="0"
                max="20"
                value={formData.note}
                onChange={handleNoteChange}
                className="w-20 px-2 py-1 border rounded"
              />
              <span>/ 20</span>
            </div>
          </div>

          <div className="flex justify-end">
            <button
              type="button"
              onClick={handleNext}
              className="bg-blue-600 text-white px-6 py-2 rounded hover:bg-blue-700"
            >
              Suivant →
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Etape3;
