import React, { Component } from 'react';
import axios from 'axios';
import './NewPost.css';

class NewPost extends Component {

    
    state = {
        title: '',
        content: '',
        author: 'Dean'
    }
    // baseURL = 'http://localhost:9090/posts' ;
     
    addHandler(){
        const  headers = {"Access-Control-Allow-Origin": "*"};
        axios({
            method : 'post',
            url : 'http://localhost:8080/posts',
            data : {...this.state},
            headers : headers
            })
            .then(response => {
               
    });

    }

   

    render () {
        return (
            <div className="NewPost">
                <h1>Add a Post</h1>
                <label>Title</label>
                <input type="text" value={this.state.title} onChange={(event) => this.setState({title: event.target.value})} />
                <label>Content</label>
                <textarea rows="4" value={this.state.content} onChange={(event) => this.setState({content: event.target.value})} />
                <label>Author</label>
                <select value={this.state.author} onChange={(event) => this.setState({author: event.target.value})}>
                    <option value="Dean">Dean</option>
                    <option value="Zaineh">Zaineh</option>
                    <option value="Yasmeen">Yasmeen</option>
                </select>
                <button onClick={()=>{this.addHandler()}}>Add Post</button>
            </div>
        );
    }
}

export default NewPost;