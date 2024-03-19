import { Link } from "react-router-dom";
import Dropdown from 'react-bootstrap/Dropdown';
const Merchantnavbar = () => {
    return (
        <nav>
            <div className="logo">
                <h1>Shoppercart</h1>
            </div>
            <div className="option">
                <Link to="/merchanthome/productview">View product</Link>
                <Link to="/merchanthome/addproduct">Add product</Link>
                <Link to="/merchanthome/updateproduct">Edit product</Link>
            </div>
            
            <div className="dropdown">
                <Dropdown>
                    <Dropdown.Toggle variant="secondary" id="dropdown-basic">
                        Dropdown Button
                    </Dropdown.Toggle>

                    <Dropdown.Menu>
                        <Dropdown.Item href="/merchanthome/updatemerchant">Update Profile</Dropdown.Item>
                        <Dropdown.Item href="/">Logout</Dropdown.Item>
                        
                    </Dropdown.Menu>
                </Dropdown>
            </div>
        </nav>
    );
}

export default Merchantnavbar;