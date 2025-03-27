import logo from './logo.svg';
import './App.css';
import CharacterForm from './components/CharacterForm';

function App() {
  return (
    <div className="App">
      <h1>Crear Personaje</h1>
      <CharacterForm /> {/* Llamamos al componente aquí */}
    </div>
  );
}

export default App;
