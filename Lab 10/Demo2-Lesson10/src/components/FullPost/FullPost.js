import React, { Component } from "react";
import { useState } from "react";
import "./FullPost.css";
import axios from "axios";

const FullPost = (props) => {
  const baseURL = "http://localhost:8080/posts";
  function deleteHandler() {
    console.log("id: " +   props.id);
    const headers = { "Access-Control-Allow-Origin": "*" };
    axios
      .delete(`http://localhost:8080/posts/${props.id}`, { headers })
      .then(() => {
        //   props.history.push("http://localhost:3000/");
        
      });
  }

  let post = <p>Please select a Post!</p>;
  if (props.id != null) {
    post = (
      <div className="FullPost">
        <h1>{props.title}</h1>
        <p>{props.body}</p>
        <div className="Edit">
          <button className="Delete" onClick={deleteHandler}>
            Delete
          </button>
        </div>
      </div>
    );
  }

  return post;
};

export default FullPost;
