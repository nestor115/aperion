import React, { useState } from 'react';
import { createCharacter } from '../services/characterService';

const CharacterForm = () => {
  // Definir el estado para los campos del personaje
  const [name, setName] = useState('');
  const [level, setLevel] = useState(1);
  const [attributes, setAttributes] = useState({
    strength: 0,
    agility: 0,
    intelligence: 0,
  });

  // Función para manejar el envío del formulario
  const handleSubmit = async (event) => {
    event.preventDefault();

    const newCharacter = {
      name,
      level,
      attributes,
    };

    try {
      const result = await createCharacter(newCharacter);
      console.log('Personaje creado con éxito:', result);
    } catch (error) {
      console.error('Error al crear el personaje:', error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Nombre del personaje:</label>
        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
      </div>
      <div>
        <label>Nivel:</label>
        <input
          type="number"
          value={level}
          onChange={(e) => setLevel(Number(e.target.value))}
        />
      </div>
      <div>
        <label>Atributos:</label>
        <div>
          <label>Fuerza:</label>
          <input
            type="number"
            value={attributes.strength}
            onChange={(e) =>
              setAttributes({ ...attributes, strength: Number(e.target.value) })
            }
          />
        </div>
        <div>
          <label>Agilidad:</label>
          <input
            type="number"
            value={attributes.agility}
            onChange={(e) =>
              setAttributes({ ...attributes, agility: Number(e.target.value) })
            }
          />
        </div>
        <div>
          <label>Inteligencia:</label>
          <input
            type="number"
            value={attributes.intelligence}
            onChange={(e) =>
              setAttributes({
                ...attributes,
                intelligence: Number(e.target.value),
              })
            }
          />
        </div>
      </div>
      <button type="submit">Crear Personaje</button>
    </form>
  );
};

export default CharacterForm;
