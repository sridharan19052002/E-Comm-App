import { Link } from "react-router-dom";
import style from "../styles/landingpage.module.css"
const Landingpage = () => {
    return (  
       <div id={style.Landingpage}>

        <Link to="/merchantlogin"><img src="https://cdn-icons-png.flaticon.com/128/3857/3857265.png" alt="" /></Link>
        <Link to="/userlogin"><img src="https://cdn-icons-png.flaticon.com/128/179/179824.png" alt="" /></Link>
        
       </div>
    );
}
 
export default Landingpage;