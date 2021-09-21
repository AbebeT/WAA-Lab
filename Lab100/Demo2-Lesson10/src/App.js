import React, { Component } from 'react';
import {BrowserRouter, Link, Redirect} from 'react-router-dom';

import Blog from './containers/Blog/Blog';

const App = () => {

    return (
      <BrowserRouter>
      <div className="App">
        <Blog />
      </div>
      </BrowserRouter>
    );
  }

export default App;
