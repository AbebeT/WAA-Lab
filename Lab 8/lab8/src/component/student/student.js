import React from "react";
import "./student.css";
import Students from "../students/students";

const Student = (props) => {
  return (
   
      <div class="grid-item">
        <h1>Student</h1>
        <h1>Id: {props.id}</h1>
        <h1>Name: {props.name}</h1>
        <h1>Major: {props.major}</h1>
      </div>
   
  );
};

export default Student;
