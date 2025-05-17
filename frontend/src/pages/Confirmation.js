import React from 'react';
import { useNavigate } from 'react-router-dom';

export default function Confirmation() {
  const navigate = useNavigate();
  return (
    <div className="flex flex-col items-center justify-center h-screen bg-gray-50 space-y-4">
      <svg
        xmlns="http://www.w3.org/2000/svg"
        className="w-20 h-20 text-green-500 mb-6 animate-pulse"
        fill="none"
        viewBox="0 0 24 24"
        stroke="currentColor"
        strokeWidth={2}
      >
        <path
          strokeLinecap="round"
          strokeLinejoin="round"
          d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"
        />
      </svg>
      <h1 className="text-2xl font-semibold mb-2">Formulaire rempli avec succès&nbsp;!</h1>
      <p className="text-gray-600">Merci pour votre soumission. Toutes les données ont été enregistrées.</p>
      <button
        onClick={() => navigate('/')}
        className="mt-4 px-6 py-3 bg-blue-600 text-white rounded-lg hover:bg-blue-700 transition"
      >
        Retour à Dashbord
      </button>
    </div>
  );
}
