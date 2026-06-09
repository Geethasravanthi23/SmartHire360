import { useState } from "react";
import axios from "axios";

function ResumeAnalyzer() {

  const [file, setFile] = useState(null);
  const [result, setResult] = useState(null);

  const uploadResume = async () => {

    if (!file) {

      alert("Please select a PDF file");

      return;

    }

    const formData = new FormData();

    formData.append("file", file);

    try {

      await axios.post(
        "http://localhost:8080/files/upload",
        formData
      );

      const response = await axios.post(
        `http://localhost:8080/resumes/analyze?filePath=C:/uploads/${file.name}`
      );

      setResult(response.data);

    } catch (error) {

      console.error(error);

      alert("Upload Failed");

    }

  };

  return (

    <div
      style={{
        padding: "30px",
        maxWidth: "900px",
        margin: "auto"
      }}
    >

      <h1>Resume Analyzer</h1>

      <p>
        Upload your resume and get ATS score,
        detected skills, and improvement suggestions.
      </p>

      <input
        type="file"
        accept=".pdf"
        onChange={(e) =>
          setFile(e.target.files[0])
        }
      />

      <br />
      <br />

      <button
        onClick={uploadResume}
        style={{
          background: "#0d6efd",
          color: "white",
          border: "none",
          padding: "10px 20px",
          borderRadius: "8px",
          cursor: "pointer"
        }}
      >
        Upload & Analyze
      </button>

      {result && (

        <div
          style={{
            marginTop: "30px",
            background: "#fff",
            padding: "20px",
            borderRadius: "12px",
            boxShadow:
              "0 4px 10px rgba(0,0,0,0.08)"
          }}
        >

          <h2>
            ATS Score: {result.score}%
          </h2>

          <hr />

          <h3>✅ Skills Found</h3>

          <ul>

            {result.skills &&
              result.skills.map(
                (skill, index) => (

                  <li key={index}>
                    {skill}
                  </li>

                )
              )}

          </ul>

          <hr />

          <h3>❌ Missing Skills</h3>

          <ul>

            {result.missingSkills &&
              result.missingSkills.map(
                (skill, index) => (

                  <li key={index}>
                    {skill}
                  </li>

                )
              )}

          </ul>

        </div>

      )}

    </div>

  );

}

export default ResumeAnalyzer;