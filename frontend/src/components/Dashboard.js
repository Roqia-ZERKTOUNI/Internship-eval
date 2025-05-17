import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {
    BarChart, Bar, XAxis, YAxis, Tooltip, ResponsiveContainer,
    PieChart, Pie, Cell, Legend
} from 'recharts';

export default function Dashboard() {
    const [nombreStagiaires, setNombreStagiaires] = useState(0);
    const [nombreTuteurs, setNombreTuteurs] = useState(0);
    const [nombreEvaluations, setNombreEvaluations] = useState(0);

    const COLORS = ['#3b82f6', '#10b981']; // bleu, vert

    useEffect(() => {
        axios.get('http://localhost:8083/api/statistiques/nombre-stagiaires')
            .then(res => setNombreStagiaires(res.data))
            .catch(err => console.error("Erreur API stagiaires :", err));

        axios.get('http://localhost:8083/api/statistiques/nombre-tuteurs')
            .then(res => setNombreTuteurs(res.data))
            .catch(err => console.error("Erreur API tuteurs :", err));

        axios.get('http://localhost:8083/api/statistiques/nombre-evaluations')
            .then(res => setNombreEvaluations(res.data))
            .catch(err => console.error("Erreur API évaluations :", err));
    }, []);

    const pourcentageData = [
        { name: 'Stagiaires', value: nombreStagiaires },
        { name: 'Tuteurs', value: nombreTuteurs },
    ];

    const sampleStats = [
        { name: 'Stage évalué', value: nombreEvaluations },
        { name: 'Stage non évalué', value: Math.max(nombreStagiaires - nombreEvaluations, 0) },
    ];

    // ✅ Fonction label externe
    const renderLabelOutside = ({ cx, cy, midAngle, outerRadius, percent, index }) => {
        const RADIAN = Math.PI / 180;
        const radius = outerRadius + 20;
        const x = cx + radius * Math.cos(-midAngle * RADIAN);
        const y = cy + radius * Math.sin(-midAngle * RADIAN);

        return (
            <text
                x={x}
                y={y}
                fill={COLORS[index]}
                textAnchor={x > cx ? 'start' : 'end'}
                dominantBaseline="central"
                fontSize={14}
                fontWeight="bold"
            >
                {pourcentageData[index].name} {(percent * 100).toFixed(0)}%
            </text>
        );
    };

    return (
        <main className="flex-1 p-6 bg-gray-100 min-h-screen">
            <h1 className="text-3xl font-bold mb-6">Statistiques</h1>

            <div className="grid grid-cols-3 gap-6 mb-8">
                <div className="p-6 bg-gradient-to-r from-blue-500 to-indigo-600 text-white rounded-2xl shadow-lg hover:scale-105 transition-transform">
                    <h3 className="text-xl font-semibold">Nombre de stagiaire</h3>
                    <p className="text-5xl font-bold mt-2">{nombreStagiaires}</p>
                </div>
                <div className="p-6 bg-gradient-to-r from-blue-500 to-indigo-600 text-white rounded-2xl shadow-lg hover:scale-105 transition-transform">
                    <h3 className="text-xl font-semibold">Nombre de tuteur</h3>
                    <p className="text-5xl font-bold mt-2">{nombreTuteurs}</p>
                </div>
                <div className="p-6 bg-gradient-to-r from-blue-500 to-indigo-600 text-white rounded-2xl shadow-lg hover:scale-105 transition-transform">
                    <h3 className="text-xl font-bold mt-2">Nombre de stage évalué</h3>
                    <p className="text-5xl font-bold mt-2">{nombreEvaluations}</p>
                </div>
            </div>

            <div className="grid grid-cols-2 gap-6 items-center">
                {/* BarChart */}
                <div className="p-6 bg-white rounded-2xl shadow-lg h-[360px] flex flex-col justify-between">
                    <h3 className="text-xl font-medium mb-4">Évaluation</h3>
                    <ResponsiveContainer width="100%" height="80%">
                        <BarChart data={sampleStats}>
                            <XAxis dataKey="name" />
                            <YAxis />
                            <Tooltip />
                            <Bar dataKey="value" fill="#3b82f6" radius={[10, 10, 0, 0]} />
                        </BarChart>
                    </ResponsiveContainer>
                </div>

                {/* PieChart avec labels externes */}
                <div className="p-6 bg-white rounded-2xl shadow-lg h-[360px] flex flex-col justify-between">
                    <h3 className="text-xl font-medium mb-4">Répartition stagiaires vs tuteurs</h3>
                    <ResponsiveContainer width="100%" height="100%">
                        <PieChart>
                            <Pie
                                data={pourcentageData}
                                dataKey="value"
                                nameKey="name"
                                cx="50%"
                                cy="50%"
                                outerRadius={90}
                                labelLine={false}
                                label={renderLabelOutside}
                            >
                                {pourcentageData.map((entry, index) => (
                                    <Cell key={`cell-${index}`} fill={COLORS[index]} />
                                ))}
                            </Pie>
                            <Legend layout="horizontal" verticalAlign="bottom" align="center" />
                        </PieChart>
                    </ResponsiveContainer>
                </div>
            </div>
        </main>
    );
}
