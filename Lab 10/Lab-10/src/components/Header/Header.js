import React from 'react';
import './Header.css';
import { Link, Redirect } from 'react-router-dom';
import 'react-router';

const Header = (props) => {
//   const isAuthenticated = useSelector(state => state.auth.isAuthenticated); // put the name of the slice
//   const dispatch = useDispatch();

//   const logoutHandler = () => {
//     dispatch(authActions.logout());
//     <Redirect to='/login' />;
//   }

  return (
    
    <header className="header">
      
      {true && (<nav>
        <ul>
        <li>
            <Link to="/add-product"> Posts </Link>
          </li>
        <li>
            <Link to="/new-post"> New Post </Link>
          </li>
          <li>
            <Link to="/user"> Sign in </Link>
          </li>
          
          {/* <li>
            <button onClick={logoutHandler}>Logout</button>
          </li> */}
        </ul>
      </nav>)}

    </header>
  );
};

export default Header;
