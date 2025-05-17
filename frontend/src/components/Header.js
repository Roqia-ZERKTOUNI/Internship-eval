import React from 'react';
import { useNavigate } from 'react-router-dom';
import { FaGraduationCap } from 'react-icons/fa';

export default function Header() {
    const navigate = useNavigate();

    return (
        <header className="w-full bg-gradient-to-r from-indigo-600 to-blue-600 text-white shadow p-4 flex justify-between items-center">
            <div className="flex items-center gap-3 cursor-pointer" onClick={() => navigate('/')}>
                <FaGraduationCap size={28} />
                <h1 className="text-xl font-bold">Gestion des Stages</h1>
            </div>
            <nav className="space-x-6">
                <button className="hover:underline" onClick={() => navigate('/')}>Tableau de bord</button>
                <button className="hover:underline" onClick={() => navigate('/inscription/etape1')}>Evaluation</button>
            </nav>
        </header>
    );
}
