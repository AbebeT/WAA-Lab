import { getDefaultNormalizer } from "@testing-library/react";
import React from "react";
import Student from "../../component/student/student";
import "./students.css";

const Students = () => {     

    const studentsarray = [
      {
          id: "111",
          name: "Meti",
          major: "CS"
      },
      {
          id: "112",
          name: "Tedros",
          major: "CS"
      },
      {
          id: "113",
          name: "Pascal",
          major: "CS"
      }
  ];

  const studentsList =  studentsarray.map(s=> <Student id={s.id} name={s.name} major={s.major}/>);

  return (
    <section>
       <div class="container">{studentsList}</div></section>
  );
    
};

export default Students;
