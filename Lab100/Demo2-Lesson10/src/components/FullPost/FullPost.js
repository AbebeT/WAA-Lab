import React, { useContext } from "react";
import { useState } from "react";
import "./FullPost.css";
import axios from "axios";
import {FetchedPosts} from '../../Store/FetchedPosts'

const FullPost = (props) => {
  
  const baseURL = "http://localhost:8080/posts";
  const { fetchedPosts, setFetchedPosts } = useContext(FetchedPosts);
  
  function deleteHandler() {
    console.log("props body " + fetchedPosts.length);
    console.log("id: " +   props.id);
    const headers = { "Access-Control-Allow-Origin": "*" };
    axios
      .delete(`http://localhost:8080/posts/${props.id}`, { headers })
      .then(() => {
        props.history.push('/'); 
        //   props.history.push("http://localhost:3000/");
        
      });
     
  }

  let post = <p>Please select a Post!</p>;
  if (props.id != null) {
    post = (
     
      <div className="FullPost">
        <h1>{fetchedPosts.filter(p=> p.id===props.id)[0].title}</h1>
        <p>{fetchedPosts.filter(p=> p.id===props.id)[0].content}</p>
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
