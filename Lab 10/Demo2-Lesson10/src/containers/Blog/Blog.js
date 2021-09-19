import React, { useState } from 'react';
import { useEffect } from 'react';

import Post from '../../components/Post/Post';
import FullPost from '../../components/FullPost/FullPost';
import NewPost from '../../components/NewPost/NewPost';
import './Blog.css';
import axios from 'axios';


const Blog = () => {

     const [posts, setPosts] = useState([]);

     const [selectedId, setSelectedId] = useState( null);

     const [deleteFlag, setDeleteFlag] = useState(0);

     const baseURL = 'http://localhost:8080/posts' ;
     const baseURL2 = 'http://localhost:8080/posts/1' ;
    
    useEffect(() => {
        axios.get(baseURL)
            .then(response => {
                const sposts = response.data.slice(0,5);  // This will get them but take the first 5 then you would have to change the response.data i nthe setPosts
                const updatedPosts = sposts.map(post => {  // This will transform anything before assigning it to the state
                    return {
                        ...post
                       // author: ' Dean'
                    }
                });
                setPosts([...updatedPosts]);
                // setPosts([...response.data]);   // if you dont want to limit
            });
    },[]);

    // useEffect( () => {
    //     axios.post('http://localhost:9090/posts',{})
    //     .then()
    // } , [] )

   function  deletePost(){
    alert("post deleted");
    // axios.delete(baseURL2).then(() => {
    //   alert("post deleted");
      
    // });
}
  function postPost(id){
      alert("post added");
  }

  
    const postSelectedHandler = (id) => {
        setSelectedId(id);
    }


    const postDeleteHandler = () => {
        deletePost();
    }

   

    // We can do this rather than this :: <Post title={{...posts[1]}.title} />
    const rposts = posts.map(post => {
        return <Post 
        key={post.id} 
        title={post.title} 
        content={post.title}
        author={post.author}
        clicked={() => {postSelectedHandler(post.id)}}/>
    });

    // 
    return (
       
        <div>
            <section className="Posts">
                {rposts}
            </section>
            <section>
                <FullPost 
                id={selectedId}
                clickedDelete={() => {postDeleteHandler({...posts[selectedId-1]}.id)}}
                title={{...posts[selectedId-1]}.title}
                body={{...posts[selectedId-1]}.body}
                /> 
                
            </section>
            <section>
                <NewPost 
                clicked = {() => {postPost()}} />
            </section>
        </div>
    );
}


export default Blog;