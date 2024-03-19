import { Link } from "react-router-dom";
const Usernav = () => {
    return (
        <div>
            <Link to="updateuser">Edit profile</Link>
            <Link to="/">Logout</Link>
        </div>
      );
}
 
export default Usernav;