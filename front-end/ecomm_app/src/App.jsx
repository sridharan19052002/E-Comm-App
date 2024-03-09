import {BrowserRouter,Routes,Route} from "react-router-dom"
import 'bootstrap/dist/css/bootstrap.min.css';
import Landingpage from "./commponent/Landingpage";
import Merchantlogin from "./commponent/Merchantlogin";
import Userlogin from "./commponent/Userlogin";
import Merchantsignup from "./commponent/Merchantsignup";
import Usersignup from "./commponent/Usersignup";
import Merchantlanding from "./commponent/Merchantlanding";
import Userlanding from "./commponent/Userlanding";
const App = () => {
    return (  
       <BrowserRouter>
            <Routes>
                <Route path="/" element={<Landingpage/>}></Route>
                <Route path="/merchantlogin" element={<Merchantlogin/>} ></Route>
                <Route path="/userlogin" element={<Userlogin/>}></Route>
                <Route path="/merchantsignup" element={<Merchantsignup/>} />
                <Route path="/usersignup" element={<Usersignup/>} />
                <Route path="/merchantlanding" element={<Merchantlanding/>} />
                <Route path="/userlanding" element={<Userlanding/>} />
            </Routes>
       </BrowserRouter>
    );
}
 
export default App;