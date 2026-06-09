import { useState } from "react";
import axios from "axios";

function JobMatchAnalyzer() {

  const [jobDescription, setJobDescription] = useState("");
  const [result, setResult] = useState(null);

  const analyzeMatch = async () => {

    try {

      const response = await axios.post(
  "http://localhost:8080/jobmatch/analyze",
  jobDescription,
  {
    headers: {
      "Content-Type": "text/plain"
    }
  }
);

      setResult(response.data);

    } catch (error) {

      console.error(error);

      alert("Analysis Failed");

    }
  };

  return (
    <div style={{ padding: "20px" }}>

      <h1>Job Match Analyzer</h1>

      <textarea
        rows="10"
        cols="80"
        placeholder="Enter skills separated by commas...
Example:
Java, Spring Boot, AWS, Docker, MySQL"
        value={jobDescription}
        onChange={(e) =>
          setJobDescription(e.target.value)
        }
      />

      <br /><br />

      <button onClick={analyzeMatch}>
        Analyze Match
      </button>

      {result && (

        <div style={{ marginTop: "20px" }}>

          <h2>
            Match Score: {result.matchScore}%
          </h2>

          <h3>Matched Skills</h3>

          <ul>
            {result.matchedSkills.map(
              (skill, index) => (
                <li key={index}>{skill}</li>
              )
            )}
          </ul>

          <h3>Missing Skills</h3>

          <ul>
            {result.missingSkills.map(
              (skill, index) => (
                <li key={index}>{skill}</li>
              )
            )}
          </ul>

        </div>

      )}

    </div>
  );
}

export default JobMatchAnalyzer;