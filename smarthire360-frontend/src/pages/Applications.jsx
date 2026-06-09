import { useEffect, useState } from "react";
import axios from "axios";

function Profile() {

  const [profile, setProfile] = useState({
    id: "",
    name: "",
    email: "",
    phone: "",
    location: "",
    skills: ""
  });

  useEffect(() => {
    loadProfile();
  }, []);

  const loadProfile = async () => {

    try {

      const response = await axios.get(
        "http://localhost:8080/profile"
      );

      setProfile(response.data);

    } catch (error) {

      console.error(error);

    }

  };

  const saveProfile = async () => {

    try {

      await axios.put(
        "http://localhost:8080/profile",
        profile
      );

      alert("Profile Updated Successfully");

    } catch (error) {

      console.error(error);

      alert("Failed To Update Profile");

    }

  };

  return (

    <div
      style={{
        padding: "30px",
        maxWidth: "800px",
        margin: "auto"
      }}
    >

      <h1>My Profile</h1>

      <input
        type="text"
        placeholder="Name"
        value={profile.name || ""}
        onChange={(e) =>
          setProfile({
            ...profile,
            name: e.target.value
          })
        }
      />

      <br /><br />

      <input
        type="email"
        placeholder="Email"
        value={profile.email || ""}
        onChange={(e) =>
          setProfile({
            ...profile,
            email: e.target.value
          })
        }
      />

      <br /><br />

      <input
        type="text"
        placeholder="Phone"
        value={profile.phone || ""}
        onChange={(e) =>
          setProfile({
            ...profile,
            phone: e.target.value
          })
        }
      />

      <br /><br />

      <input
        type="text"
        placeholder="Location"
        value={profile.location || ""}
        onChange={(e) =>
          setProfile({
            ...profile,
            location: e.target.value
          })
        }
      />

      <br /><br />

      <textarea
        rows="5"
        placeholder="Skills"
        value={profile.skills || ""}
        onChange={(e) =>
          setProfile({
            ...profile,
            skills: e.target.value
          })
        }
      />

      <br /><br />

      <button onClick={saveProfile}>
        Update Profile
      </button>

    </div>

  );

}

export default Profile;