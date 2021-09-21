import React, { useContext } from "react";
import "./Header.css";
import { Link, Redirect, BrowserRouter } from "react-router-dom";

const Header = (props) => {
  return (
    <div id="navContainer" className="header">
      <section id="postSection">
        <Link to="/posts"> Posts</Link>
      </section>
      <section id="newPostSection">
        <Link to="/new-post"> New Posts </Link>
      </section>
      <section id="signinSection">
        <Link to="/signin"> Sign In </Link>
      </section>
    </div>
  );
};

export default Header;
