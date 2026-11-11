import { useEffect, useState } from 'react'
import './App.css'

function App() {
  const [pacientes, setPacientes] = useState([])
  const [citas, setCitas] = useState([])

  // se ejecuta una sola vez cuando carga la pantalla
  useEffect(() => {
    fetch('http://localhost:8080/api/pacientes')
      .then(respuesta => respuesta.json())
      .then(datos => {
        console.log(datos)
        setPacientes(datos)
      })

    fetch('http://localhost:8080/api/citas')
      .then(respuesta => respuesta.json())
      .then(datos => {
        console.log(datos)
        setCitas(datos)
      })
  }, [])

  return (
    <div className="contenedor">
      <h1>Clinica</h1>

      <h2>Pacientes registrados</h2>
      {pacientes.length === 0 && <p>No hay pacientes registrados</p>}
      <div className="lista">
        {pacientes.map(paciente => (
          <div className="tarjeta" key={paciente.id}>
            <h3>{paciente.nombre}</h3>
            <p>{paciente.correo}</p>
            <p>Inasistencias: {paciente.contadorInasistencias}</p>
            <p>
              Riesgo: <span className={'etiqueta ' + paciente.nivelRiesgo}>{paciente.nivelRiesgo}</span>
            </p>
          </div>
        ))}
      </div>

      <h2>Citas</h2>
      {citas.length === 0 && <p>No hay citas registradas</p>}
      <div className="lista">
        {citas.map(cita => (
          <div className="tarjeta" key={cita.id}>
            <h3>Cita #{cita.id}</h3>
            <p>Fecha: {cita.fechaHora.replace('T', ' ')}</p>
            <p>Paciente: {cita.idPaciente} - Medico: {cita.idMedico}</p>
            <p>
              Estado: <span className={'etiqueta ' + cita.estado}>{cita.estado}</span>
            </p>
          </div>
        ))}
      </div>
    </div>
  )
}

export default App
