import React from 'react';

export default function Footer() {
    return (
        <footer className="w-full bg-gray-800 text-gray-200 py-4 text-center text-sm">
            © {new Date().getFullYear()} Projet de gestion des stages – Tous droits réservés.
        </footer>
    );
}
