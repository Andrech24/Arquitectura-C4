import { useState } from "react";

function App() {
  const [email, setEmail] = useState("");
  const [ruc, setRuc] = useState("");
  const [placa, setPlaca] = useState("");
  const [resultado, setResultado] = useState(null);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError(null);
    setResultado(null);

    try {
      const res = await fetch("http://localhost:8080/api/consulta", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ email, ruc, placa }),
      });

      if (!res.ok) {
        throw new Error("Error en la consulta");
      }

      const data = await res.json();
      setResultado(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div
      style={{
        maxWidth: 700,
        margin: "0 auto",
        padding: "2rem",
        background: "white",
        marginTop: "2rem",
        borderRadius: "0.75rem",
        boxShadow: "0 10px 30px rgba(0,0,0,0.08)",
      }}
    >
      <h1>SCI-SRI-ANT</h1>
      <p>Consulta de Contribuyente, Vehículo y Puntos de Licencia</p>

      <form onSubmit={handleSubmit} style={{ display: "grid", gap: "1rem", marginTop: "1rem" }}>
        <div>
          <label>Correo electrónico:</label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
            style={{ width: "100%", padding: "0.5rem" }}
          />
        </div>

        <div>
          <label>RUC (Persona natural):</label>
          <input
            type="text"
            value={ruc}
            onChange={(e) => setRuc(e.target.value)}
            required
            style={{ width: "100%", padding: "0.5rem" }}
          />
        </div>

        <div>
          <label>Matrícula del vehículo:</label>
          <input
            type="text"
            value={placa}
            onChange={(e) => setPlaca(e.target.value)}
            required
            style={{ width: "100%", padding: "0.5rem" }}
          />
        </div>

        <button
          type="submit"
          disabled={loading}
          style={{
            padding: "0.75rem 1.5rem",
            borderRadius: "999px",
            border: "none",
            cursor: "pointer",
            fontWeight: 600,
          }}
        >
          {loading ? "Consultando..." : "Consultar"}
        </button>
      </form>

      {error && <p style={{ color: "red", marginTop: "1rem" }}>Error: {error}</p>}

      {resultado && (
        <div style={{ marginTop: "2rem" }}>
          <h2>Resultado</h2>

          <section>
            <h3>Contribuyente</h3>
            <pre>{JSON.stringify(resultado.contribuyente, null, 2)}</pre>
          </section>

          <section>
            <h3>Vehículo</h3>
            <pre>{JSON.stringify(resultado.vehiculo, null, 2)}</pre>
          </section>

          <section>
            <h3>Puntos de licencia</h3>
            <pre>{JSON.stringify(resultado.licencia, null, 2)}</pre>
          </section>
        </div>
      )}
    </div>
  );
}

export default App;
