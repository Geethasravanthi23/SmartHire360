import { useEffect, useState } from "react";
import axios from "axios";

function SkillSuggestions() {

  const [skills, setSkills] = useState([]);

  useEffect(() => {

    axios
      .get("http://localhost:8080/skills")
      .then((response) => {
        setSkills(response.data);
      })
      .catch((error) => {
        console.error(error);
      });

  }, []);

  return (

    <div style={{ padding: "20px" }}>

      <h1>Skill Suggestions</h1>

      <p>
        Recommended skills to improve your profile.
      </p>

      {skills.length > 0 ? (

        skills.map((skill, index) => (

          <div
            key={index}
            style={{
              background: "#fff",
              padding: "15px",
              marginBottom: "15px",
              borderRadius: "10px",
              boxShadow: "0 2px 5px rgba(0,0,0,0.1)"
            }}
          >

            <h3>{skill.skill}</h3>

            <p>
              Learning Path:
              {" "}
              {skill.learningPath}
            </p>

          </div>

        ))

      ) : (

        <p>No suggestions available.</p>

      )}

    </div>

  );

}

export default SkillSuggestions;