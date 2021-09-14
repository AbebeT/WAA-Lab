import { getDefaultNormalizer } from "@testing-library/react";
import React from "react";
import Students from "../../component/students/students";

import "./Dash.css";

const Dashboard = () => {
  return (
    <section>
      <Students />
      <form>
       
        <input type="text" value="" />
      </form>
      <button>Change Name</button>
    </section>
  );
};

export default Dashboard;
