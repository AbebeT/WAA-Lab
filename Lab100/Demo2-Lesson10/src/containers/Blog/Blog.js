import React, { useState } from "react";
import { useEffect } from "react";
import Posts from "../Posts/Posts";
import Header from "../../components/Header/Header";
import { Link, Redirect, BrowserRouter, Switch, Route } from "react-router-dom";

import Post from "../../components/Post/Post";
import FullPost from "../../components/FullPost/FullPost";
import NewPost from "../../components/NewPost/NewPost";
import "./Blog.css";
import axios from "axios";
import { FetchedPosts } from "../../Store/FetchedPosts";
import Login from "../../components/Login/Login";
import Authenticate from "../../components/Authenticate/Authenticate";

const Blog = () => {
  const [fetchedPosts, setFetchedPosts] = useState([]);
   return (
    
      <FetchedPosts.Provider value={{ fetchedPosts, setFetchedPosts }}>
        <div>
          <section>
            <Header />
          </section>

          <Switch>
            <Route path="/posts" component={Posts} />
            <Route path="/new-post" component={NewPost} />
            <Route path="/signin" component={Login} />
            <Route path="/authenticate" component={Authenticate} />
            <Route path="/posts/:id" component={FullPost} />
            <Redirect from="/" to="/posts" />
            <Redirect exact from="/" to="/posts" />{" "}
            {/* THis will change the url  */}
            {/* <Route render={()=> <h1> Page Not Found</h1>} />  */}
            {/* Also conditional redirect  */}
          </Switch>
        </div>
      </FetchedPosts.Provider>
   
  );
};

export default Blog;
