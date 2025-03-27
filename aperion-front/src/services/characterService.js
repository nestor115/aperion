import axios from 'axios';

// Asegúrate de que la URL de tu API sea correcta
const API_URL = 'http://localhost:8080/api/characters';

export const createCharacter = async (character) => {
  try {
    // Enviar una solicitud POST con el nuevo personaje
    const response = await axios.post(API_URL, character);
    return response.data; // Devuelve los datos del personaje creado
  } catch (error) {
    console.error('Error al crear el personaje:', error);
    throw error; // Lanza el error si algo falla
  }
};
