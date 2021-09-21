import React, {useState, useEffect} from "react";
import axios from 'axios'
import Post from '../../components/Post/Post'
import NewPost from '../../components/NewPost/NewPost'
import FullPost from '../../components/FullPost/FullPost'



const Posts = () => {
  const [posts, setPosts] = useState([]);
  const baseURL = "http://localhost:8080/posts";
  const [selectedId, setSelectedId] = useState( null);

  useEffect(() => {
    axios.get(baseURL).then((response) => {
      const sposts = response.data.slice(0, 5); // This will get them but take the first 5 then you would have to change the response.data i nthe setPosts
      const updatedPosts = sposts.map((post) => {
        // This will transform anything before assigning it to the state
        return {
          ...post,
          // author: ' Dean'
        };
      });
      setPosts([...updatedPosts]);
      // setPosts([...response.data]);   // if you dont want to limit
    });
  }, []);

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

  const rposts = posts.map((post) => {
    return (
      <Post
        key={post.id}
        title={post.title}
        content={post.title}
        author={post.author}
        clicked={() => {
          setSelectedId(post.id);
        }}
      />
    );
  });

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

export default Posts;
