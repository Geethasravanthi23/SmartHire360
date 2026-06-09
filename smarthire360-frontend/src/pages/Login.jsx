import { useState } from "react";
import axios from "axios";

function Login() {

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const login = async () => {

    try {

      const response = await axios.post(
        `http://localhost:8080/users/login?email=${email}&password=${password}`
      );

      if (response.data) {

        alert("Login Successful");

        localStorage.setItem(
          "user",
          JSON.stringify(response.data)
        );

      } else {

        alert("Invalid Credentials");

      }

    } catch (error) {

      console.error(error);

      alert("Login Failed");

    }
  };

  return (
    <div style={{ padding: "20px" }}>

      <h1>Login</h1>

      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />

      <br /><br />

      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />

      <br /><br />

      <button onClick={login}>
        Login
      </button>

    </div>
  );
}

export default Login;