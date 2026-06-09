import { useEffect, useState } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";

import "./Dashboard.css";
import DashboardChart from "../components/DashboardChart";

import {
  FaBriefcase,
  FaFileAlt,
  FaChartPie,
  FaStar
} from "react-icons/fa";

function Dashboard() {

  const navigate = useNavigate();

  const [stats, setStats] = useState({
    availableJobs: 0,
    applications: 0,
    profileMatch: 0,
    skills: 0
  });

  const [jobs, setJobs] = useState([]);
  const [recentApplications, setRecentApplications] = useState([]);

  const [summary, setSummary] = useState({
    Applied: 0,
    "Interview Scheduled": 0,
    Selected: 0,
    Rejected: 0
  });

  useEffect(() => {

    axios
      .get("http://localhost:8080/dashboard/stats")
      .then((response) => {
        setStats(response.data);
      })
      .catch((error) => {
        console.error(error);
      });

    axios
      .get("http://localhost:8080/jobs")
      .then((response) => {
        setJobs(response.data);
      })
      .catch((error) => {
        console.error(error);
      });

    axios
      .get("http://localhost:8080/applications/recent")
      .then((response) => {
        setRecentApplications(response.data);
      })
      .catch((error) => {
        console.error(error);
      });

    axios
      .get("http://localhost:8080/dashboard/application-summary")
      .then((response) => {
        setSummary(response.data);
      })
      .catch((error) => {
        console.error(error);
      });

  }, []);

  const logout = () => {
    localStorage.removeItem("user");
    navigate("/login");
  };

  return (

    <div className="dashboard-container">

      <div className="sidebar">

        <div className="logo">
          SmartHire360
        </div>

        <ul>

          <li>
            <Link to="/" className="sidebar-link">
              Dashboard
            </Link>
          </li>

          <li>
            <Link to="/profile" className="sidebar-link">
              Profile
            </Link>
          </li>

          <li>
            <Link to="/jobs" className="sidebar-link">
              Jobs
            </Link>
          </li>

          <li>
            <Link to="/applications" className="sidebar-link">
              Applications
            </Link>
          </li>

          <li>
            <Link to="/resume" className="sidebar-link">
              Resume Analyzer
            </Link>
          </li>

          <li>
            <Link to="/jobmatch" className="sidebar-link">
              Job Match Analyzer
            </Link>
          </li>

          <li>
            <Link to="/skills" className="sidebar-link">
              Skill Suggestions
            </Link>
          </li>

          <li
            onClick={logout}
            style={{ cursor: "pointer" }}
          >
            Logout
          </li>

        </ul>

        <div className="profile-box">
          <h4>Geetha Sravanthi</h4>
          <p>Java Full Stack Developer</p>
        </div>

      </div>

      <div className="main-content">

        <div className="welcome">

          <h1>Welcome Back 👋</h1>

          <p>
            Track applications, analyze resumes,
            and discover new opportunities.
          </p>

        </div>

        <div className="stats">

          <div className="card">
            <FaBriefcase size={35} color="#2563eb" />
            <h2>{stats.availableJobs}</h2>
            <p>Available Jobs</p>
          </div>

          <div className="card">
            <FaFileAlt size={35} color="#16a34a" />
            <h2>{stats.applications}</h2>
            <p>Applications</p>
          </div>

          <div className="card">
            <FaChartPie size={35} color="#7c3aed" />
            <h2>{stats.profileMatch}%</h2>
            <p>Profile Match</p>
          </div>

          <div className="card">
            <FaStar size={35} color="#f59e0b" />
            <h2>{stats.skills}</h2>
            <p>Skills</p>
          </div>

        </div>

        <div className="section">

          <h2>Application Summary</h2>

          <DashboardChart summary={summary} />

          <div className="stats">

            <div className="card">
              <h2>{summary.Applied}</h2>
              <p>Applied</p>
            </div>

            <div className="card">
              <h2>{summary["Interview Scheduled"]}</h2>
              <p>Interview Scheduled</p>
            </div>

            <div className="card">
              <h2>{summary.Selected}</h2>
              <p>Selected</p>
            </div>

            <div className="card">
              <h2>{summary.Rejected}</h2>
              <p>Rejected</p>
            </div>

          </div>

        </div>

        <div className="section">

          <h2>Recommended Jobs</h2>

          {jobs.slice(0, 5).map((job) => (

            <div
              key={job.id}
              className="job-item"
            >

              <div>
                <strong>{job.title}</strong>
                <br />
                {job.company} | {job.location}
              </div>

              <a
                href={job.applyLink}
                target="_blank"
                rel="noreferrer"
              >
                <button className="apply-btn">
                  Apply
                </button>
              </a>

            </div>

          ))}

        </div>

        <div className="section">

          <h2>Recent Applications</h2>

          {recentApplications.length > 0 ? (

            recentApplications.map((app) => (

              <p key={app.id}>
                ✓ {app.companyName} - {app.role}
              </p>

            ))

          ) : (

            <p>No recent applications found.</p>

          )}

        </div>

        <div className="section">

          <h2>Quick Actions</h2>

          <div className="quick-actions">

            <Link
              to="/resume"
              className="action-card sidebar-link"
            >
              Resume Analyzer
            </Link>

            <Link
              to="/jobmatch"
              className="action-card sidebar-link"
            >
              Job Match
            </Link>

            <Link
              to="/skills"
              className="action-card sidebar-link"
            >
              Skill Suggestions
            </Link>

            <Link
              to="/jobs"
              className="action-card sidebar-link"
            >
              Browse Jobs
            </Link>

          </div>

        </div>

      </div>

    </div>

  );
}

export default Dashboard;