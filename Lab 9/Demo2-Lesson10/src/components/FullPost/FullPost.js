import React, { Component } from 'react';
import {useState} from 'react'
import './FullPost.css';
import axios from 'axios';

const FullPost = (props) => {
    const baseURL = 'http://localhost:9090/posts' ;
    function deleteHandler() {
        const  headers = {"Access-Control-Allow-Origin": "*"};
        axios
        .delete(`${baseURL}/1`)
        .then(()=>{
            alert("Post deleted!");    
        })
        
        
    }
    
        let post = <p>Please select a Post!</p>;
        if(props.id !=null){
            post = (
                <div className="FullPost">
                    <h1>{props.title}</h1>
                    <p>{props.body}</p>
                    <div className="Edit">
                        <button className="Delete" onClick={deleteHandler}>Delete</button>
                    </div>
                </div>
                 );
        }

       
        return post;
    }

export default FullPost;