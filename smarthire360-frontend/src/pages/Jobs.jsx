import { useEffect, useState } from "react";
import axios from "axios";

function Jobs() {

  const [jobs, setJobs] = useState([]);
  const [search, setSearch] = useState("");
  const [location, setLocation] = useState("");

  useEffect(() => {

    axios
      .get("http://localhost:8080/jobs")
      .then((response) => {
        setJobs(response.data);
      })
      .catch((error) => {
        console.error(error);
      });

  }, []);

  const filteredJobs = jobs.filter((job) => {

    const matchesSearch =
      job.title.toLowerCase().includes(search.toLowerCase()) ||
      job.company.toLowerCase().includes(search.toLowerCase());

    const matchesLocation =
      location === "" ||
      job.location === location;

    return matchesSearch && matchesLocation;

  });

  return (

    <div style={{ padding: "30px", background: "#f5f7fb", minHeight: "100vh" }}>

      <h1>Available Jobs</h1>

      <p>
        Total Jobs Found: <strong>{filteredJobs.length}</strong>
      </p>

      <input
        type="text"
        placeholder="Search by Company or Job Title..."
        value={search}
        onChange={(e) => setSearch(e.target.value)}
        style={{
          width: "100%",
          padding: "12px",
          marginBottom: "15px",
          borderRadius: "8px",
          border: "1px solid #ccc"
        }}
      />

      <select
        value={location}
        onChange={(e) => setLocation(e.target.value)}
        style={{
          width: "100%",
          padding: "12px",
          marginBottom: "20px",
          borderRadius: "8px",
          border: "1px solid #ccc"
        }}
      >
        <option value="">All Locations</option>
        <option value="Hyderabad">Hyderabad</option>
        <option value="Bangalore">Bangalore</option>
        <option value="Chennai">Chennai</option>
        <option value="Pan India">Pan India</option>
      </select>

      {filteredJobs.map((job) => (

        <div
          key={job.id}
          style={{
            background: "white",
            padding: "20px",
            marginBottom: "15px",
            borderRadius: "12px",
            boxShadow: "0 4px 10px rgba(0,0,0,0.08)"
          }}
        >

          <h3>{job.title}</h3>

          <p>
            <strong>{job.company}</strong> | {job.location}
          </p>

          <p>{job.description}</p>

          <a
            href={job.applyLink}
            target="_blank"
            rel="noreferrer"
          >
            <button
              style={{
                background: "#0d6efd",
                color: "white",
                border: "none",
                padding: "10px 15px",
                borderRadius: "8px",
                cursor: "pointer"
              }}
            >
              Apply Now
            </button>
          </a>

        </div>

      ))}

    </div>

  );
}

export default Jobs;