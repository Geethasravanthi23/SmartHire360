import { Link, useNavigate } from "react-router-dom";

function Navbar() {

  const navigate = useNavigate();

  const logout = () => {

    localStorage.removeItem("user");

    alert("Logged Out");

    navigate("/login");
  };

  return (
    <div
      style={{
        backgroundColor: "#1976d2",
        padding: "15px"
      }}
    >

      <Link to="/login" style={{ color: "white", marginRight: "20px", textDecoration: "none" }}>
        Login
      </Link>

      <Link to="/register" style={{ color: "white", marginRight: "20px", textDecoration: "none" }}>
        Register
      </Link>

      <Link to="/" style={{ color: "white", marginRight: "20px", textDecoration: "none" }}>
        Dashboard
      </Link>

      <Link to="/resume" style={{ color: "white", marginRight: "20px", textDecoration: "none" }}>
        Resume Analyzer
      </Link>

      <Link to="/jobs" style={{ color: "white", marginRight: "20px", textDecoration: "none" }}>
        Jobs
      </Link>

      <Link to="/applications" style={{ color: "white", marginRight: "20px", textDecoration: "none" }}>
        Applications
      </Link>

      <button
        onClick={logout}
        style={{
          marginLeft: "20px",
          cursor: "pointer"
        }}
      >
        Logout
      </button>

    </div>
  );
}

export default Navbar;