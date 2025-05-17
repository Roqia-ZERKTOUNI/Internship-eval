import React from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import { FaTachometerAlt, FaUserPlus } from 'react-icons/fa';

export default function Sidebar() {
    const navigate = useNavigate();
    const location = useLocation();

    return (
        <aside className="w-64 bg-white h-screen shadow-md flex flex-col p-6 space-y-4">
            <h2 className="text-xl font-bold text-gray-800 mb-4">📋 Menu</h2>

            <button
                onClick={() => navigate('/')}
                className={`flex items-center gap-3 px-4 py-2 rounded-lg ${
                    location.pathname === '/' ? 'bg-blue-600 text-white' : 'bg-gray-100 text-gray-800'
                } hover:bg-blue-100 transition`}
            >
                <FaTachometerAlt />
                Tableau de bord
            </button>

            <button
                onClick={() => navigate('/inscription/etape1')}
                className={`flex items-center gap-3 px-4 py-2 rounded-lg ${
                    location.pathname.startsWith('/inscription') ? 'bg-green-600 text-white' : 'bg-gray-100 text-gray-800'
                } hover:bg-green-100 transition`}
            >
                <FaUserPlus />
                Evaluation
            </button>
        </aside>
    );
}
