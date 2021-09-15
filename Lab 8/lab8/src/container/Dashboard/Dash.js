import { getDefaultNormalizer } from "@testing-library/react";
import Students from "../../component/students/students";
import React, { useState } from 'react';
import "./Dash.css";



const Dashboard = () => {
    const [value, setValue] = useState("")
  return (
    <section>
      <Students name={value}/>
      <form>
        
       
        <input id = "inputName" type="text" />
      </form>
      <button onClick={()=>setValue(document.getElementById("inputName").value)}>Change Name</button>
      
      
    </section>
  );
};

export default Dashboard;
