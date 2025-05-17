// src/components/Etape1.jsx
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function Etape1() {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    nom: "",
    prenom: "",
    entreprise: "",
    nomT: "",
    prenomT: "",
    dateDebut: "",
    dateFin: "",
    description: "",
    objectif: "",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const payload = {
      nom: formData.nom,
      prenom: formData.prenom,
      entreprise: formData.entreprise,
      nomT: formData.nomT,
      prenomT: formData.prenomT,
      dateDebut: formData.dateDebut,
      dateFin: formData.dateFin,
      description: formData.description,
      objectif: formData.objectif,
      email: null,
      emailT: null,
      institution: null,
    };

    sessionStorage.setItem("etape1Data", JSON.stringify(payload));
    navigate("/inscription/etape2");
  };

  return (
    <div className="min-h-screen bg-gray-100 flex items-center justify-center p-6">
      <form
        className="bg-white shadow-xl w-[90%] p-10 rounded-xl space-y-6"
        onSubmit={handleSubmit}
      >
        <h2 className="text-3xl font-bold text-center mb-8">
          Saisie stage d'étudiant(e)
        </h2>

        {/* Nom + Prénom stagiaire */}
        <div className="flex gap-6">
          <div className="w-1/2">
            <label className="block font-medium mb-1">Nom du stagiaire</label>
            <input
              name="nom"
              type="text"
              required
              value={formData.nom}
              onChange={handleChange}
              className="w-full border-0 border-b-2 border-gray-400 focus:border-blue-600 outline-none p-1"
            />
          </div>
          <div className="w-1/2">
            <label className="block font-medium mb-1">
              Prénom du stagiaire
            </label>
            <input
              name="prenom"
              type="text"
              required
              value={formData.prenom}
              onChange={handleChange}
              className="w-full border-0 border-b-2 border-gray-400 focus:border-blue-600 outline-none p-1"
            />
          </div>
        </div>

        {/* Nom entreprise */}
        <div>
          <label className="block font-medium mb-1">
            Nom de l’entreprise
          </label>
          <input
            name="entreprise"
            type="text"
            required
            value={formData.entreprise}
            onChange={handleChange}
            className="w-full border-0 border-b-2 border-gray-400 focus:border-blue-600 outline-none p-1"
          />
        </div>

        {/* Nom + Prénom tuteur */}
        <div className="flex gap-6">
          <div className="w-1/2">
            <label className="block font-medium mb-1">Nom du tuteur</label>
            <input
              name="nomT"
              type="text"
              required
              value={formData.nomT}
              onChange={handleChange}
              className="w-full border-0 border-b-2 border-gray-400 focus:border-blue-600 outline-none p-1"
            />
          </div>
          <div className="w-1/2">
            <label className="block font-medium mb-1">
              Prénom du tuteur
            </label>
            <input
              name="prenomT"
              type="text"
              required
              value={formData.prenomT}
              onChange={handleChange}
              className="w-full border-0 border-b-2 border-gray-400 focus:border-blue-600 outline-none p-1"
            />
          </div>
        </div>

        {/* Dates */}
        <div className="flex gap-6">
          <div className="w-1/2">
            <label className="block font-medium mb-1">Date début</label>
            <input
              name="dateDebut"
              type="date"
              required
              value={formData.dateDebut}
              onChange={handleChange}
              className="w-full border-0 border-b-2 border-gray-400 focus:border-blue-600 outline-none p-1"
            />
          </div>
          <div className="w-1/2">
            <label className="block font-medium mb-1">Date fin</label>
            <input
              name="dateFin"
              type="date"
              required
              value={formData.dateFin}
              onChange={handleChange}
              className="w-full border-0 border-b-2 border-gray-400 focus:border-blue-600 outline-none p-1"
            />
          </div>
        </div>

        {/* Thème projet */}
        <div>
          <label className="block font-medium mb-2">
            Thème du projet principal
          </label>
          <textarea
            name="description"
            required
            value={formData.description}
            onChange={handleChange}
            className="w-full border border-gray-300 focus:border-blue-500 focus:ring-1 focus:ring-blue-300 rounded-md p-2"
            rows="3"
          />
        </div>

        {/* Objectif */}
        <div>
          <label className="block font-medium mb-2">
            Objectifs assignés à l'étudiant(e)
          </label>
          <textarea
            name="objectif"
            required
            value={formData.objectif}
            onChange={handleChange}
            className="w-full border border-gray-300 focus:border-blue-500 focus:ring-1 focus:ring-blue-300 rounded-md p-2"
            rows="3"
          />
        </div>

        {/* Button */}
        <div className="flex justify-end">
          <button
            type="submit"
            className="bg-blue-600 text-white px-6 py-3 rounded-lg hover:bg-blue-700 text-lg shadow-md transition-all"
          >
            Suivant →
          </button>
        </div>
      </form>
    </div>
  );
}

export default Etape1;
