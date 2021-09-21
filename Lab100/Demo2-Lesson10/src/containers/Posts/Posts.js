import React, { useState, useEffect, useContext } from "react";
import axios from "axios";
import Post from "../../components/Post/Post";
import FullPost from "../../components/FullPost/FullPost";
import { FetchedPosts } from "../../Store/FetchedPosts";
import { Route, Link } from "react-router-dom";

const Posts = (props) => {
  console.log("props " + props.id);
  const [posts, setPosts] = useState([]);
  const baseURL = "http://localhost:8080/posts";
  const [selectedId, setSelectedId] = useState(null);
  const { fetchedPosts, setFetchedPosts } = useContext(FetchedPosts);
  useEffect(() => {
    axios.get(baseURL).then((response) => {
      const sposts = response.data; // This will get them but take the first 5 then you would have to change the response.data i nthe setPosts
      setFetchedPosts(sposts);
      const updatedPosts = sposts.map((post) => {
        return {
          ...post,
        };
      });
      setPosts([...updatedPosts]);
    });
  }, []);

  function deletePost() {
    alert("post deleted");
  }

  function postPost(id) {
    alert("post added");
  }

  const postSelectedHandler = (id) => {
    setSelectedId(id);
  };

  const postDeleteHandler = () => {
    deletePost();
  };

  const rposts = posts.map((post) => {
    return (
      <Link to={props.match.url + "/" + post.id} key={post.id}>
        <Post
          title={post.title}
          author={post.author}
          clicked={() => {
            postSelectedHandler(post.id);
          }}
          id={post.id}
        />
      </Link>
    );
  });

  return (
    <div>
      <section className="Posts">{rposts}</section>
      <section>
        <FullPost id={selectedId} />
      </section>
    </div>
  );
};

export default Posts;
