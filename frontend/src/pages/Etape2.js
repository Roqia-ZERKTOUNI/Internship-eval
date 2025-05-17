// src/components/Etape2.jsx
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function Etape2() {
  const [formData, setFormData] = useState({
    activite: "Paresseux",
    ouverture: "Bonne",
    qualite: "Bonne",
    observation: "",
    periode: {
      id: {
        idStage: 1,
        idStagiaire: 1,
      },
      dateDebut: "2025-04-01",
      dateFin: "2025-04-21",
    },
  });

  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const normalizeEnum = (value) => {
    return value
      .normalize("NFD")
      .replace(/[\u0300-\u036f]/g, "")
      .toUpperCase()
      .replace(/\s+/g, "_")
      .replace(/[()]/g, "");
  };

  const handleNext = () => {
    // Normalisation des enums
    const payload = {
      ...formData,
      activite: normalizeEnum(formData.activite),
      ouverture: normalizeEnum(formData.ouverture),
      qualite: normalizeEnum(formData.qualite),
    };

    // Stockage en sessionStorage
    sessionStorage.setItem("etape2Data", JSON.stringify(payload));
    navigate("/inscription/etape3");
  };

  return (
    <div className="min-h-screen bg-gray-100 flex items-center justify-center p-6">
      <form
        className="bg-white shadow-xl w-[90%] p-10 rounded-xl space-y-6"
        onSubmit={(e) => e.preventDefault()}
      >
        <div className="bg-gray-200 p-4 rounded-xl mb-4">
          <h2 className="text-2xl font-bold text-center text-gray-700">
            Appréciation Globale sur Étudiant(e)
          </h2>
        </div>

        {/* Implication */}
        <div className="bg-gray-100 p-4 rounded-lg">
          <label className="block font-semibold mb-2">Implication</label>
          {["Paresseux","Le juste necessaire","Bonne","Très forte","Depasse ses objectifs"].map((label) => (
            <label key={label} className="inline-flex items-center mr-4">
              <input
                type="radio"
                name="activite"
                value={label}
                checked={formData.activite === label}
                onChange={handleChange}
                className="mr-1"
              />
              {label}
            </label>
          ))}
        </div>

        {/* Ouverture */}
        <div className="bg-gray-100 p-4 rounded-lg">
          <label className="block font-semibold mb-2">Ouverture</label>
          {["Isole ou en opposition","Renferme ou obtus","Bonne","Tres bonne","Excellente"].map((label) => (
            <label key={label} className="inline-flex items-center mr-4">
              <input
                type="radio"
                name="ouverture"
                value={label}
                checked={formData.ouverture === label}
                onChange={handleChange}
                className="mr-1"
              />
              {label}
            </label>
          ))}
        </div>

        {/* Qualité */}
        <div className="bg-gray-100 p-4 rounded-lg">
          <label className="block font-semibold mb-2">Qualité</label>
          {["Mediocre","Acceptable","Bonne","Tres bonne","Tres professionnelle"].map((label) => (
            <label key={label} className="inline-flex items-center mr-4">
              <input
                type="radio"
                name="qualite"
                value={label}
                checked={formData.qualite === label}
                onChange={handleChange}
                className="mr-1"
              />
              {label}
            </label>
          ))}
        </div>

        {/* Observation */}
        <div className="bg-gray-100 p-4 rounded-lg">
          <h3 className="text-xl font-semibold mb-2">Observation sur Ensemble de travail Accompli</h3>
          <textarea
            name="observation"
            value={formData.observation}
            onChange={handleChange}
            placeholder="Observation"
            rows="4"
            className="w-full border p-2 rounded"
          />
        </div>

        {/* Bouton */}
        <div className="flex justify-end">
          <button
            type="button"
            onClick={handleNext}
            className="bg-blue-600 text-white p-2 rounded hover:bg-blue-700 w-32"
          >
            Suivant →
          </button>
        </div>
      </form>
    </div>
  );
}

export default Etape2;
