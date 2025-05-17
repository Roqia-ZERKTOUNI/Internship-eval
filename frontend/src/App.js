import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate, useLocation } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import Sidebar from './components/Sidebar';
import Dashboard from './components/Dashboard';
import Etape1 from './pages/Etape1';
import Etape2 from './pages/Etape2';
import Etape3 from './pages/Etape3';
import Etape4 from './pages/Etape4';
import Etape5 from './pages/Etape5';
import Confirmation from './pages/Confirmation';

function App() {
  return (
    <Router>
      <Layout />
    </Router>
  );
}

function Layout() {
  const { pathname } = useLocation();
  const showSidebar = pathname === '/' || pathname.startsWith('/inscription');

  return (
    <div className="flex flex-col min-h-screen">
      <Header />
      <div className="flex flex-1">
        {showSidebar && <Sidebar />}
        <main className="flex-1">
          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path="/inscription/etape1" element={<Etape1 />} />
            <Route path="/inscription/etape2" element={<Etape2 />} />
            <Route path="/inscription/etape3" element={<Etape3 />} />
            <Route path="/inscription/etape4" element={<Etape4 />} />
            <Route path="/inscription/etape5" element={<Etape5 />} />
            <Route path="/confirmation" element={<Confirmation />} />
            <Route path="*" element={<Navigate to="/" replace />} />
          </Routes>
        </main>
      </div>
      <Footer />
    </div>
  );
}

export default App;
