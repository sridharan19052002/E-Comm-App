import {BrowserRouter,Routes,Route} from "react-router-dom"
import 'bootstrap/dist/css/bootstrap.min.css';
import Landingpage from "./commponent/Landingpage";
import Merchantlogin from "./commponent/Merchantlogin";
import Userlogin from "./commponent/Userlogin";
import Merchantsignup from "./commponent/Merchantsignup";
import Usersignup from "./commponent/Usersignup";
import Merchanthome from "./commponent/Merchanthome";
import Error from "./commponent/Error";
import ProtectRouting from "./commponent/ProtectRouting";
import Userhomepage from "./commponent/Userhomepage";
import ProtectRouting_u from "./commponent/ProtectRouting_u";
const App = () => {
    return (  
       <BrowserRouter>
            <Routes>
                <Route path="/" element={<Landingpage/>}></Route>
                 <Route path="/*" element={<Error/>}/>
                <Route path="/merchantlogin" element={<Merchantlogin/>} ></Route>
                <Route path="/userlogin" element={<Userlogin/>}></Route>
                <Route path="/merchantsignup" element={<Merchantsignup/>} />
                <Route path="/usersignup" element={<Usersignup/>} />
                <Route path="/merchanthome/*" element={<ProtectRouting Child={Merchanthome} />} />
                <Route path="/userhomepage/*" element={<ProtectRouting_u Child={Userhomepage}/>}/>
            </Routes>
       </BrowserRouter>
    );
}
 
export default App;